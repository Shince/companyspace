package com.lovematch.match.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovematch.match.controller.beans.UserInfo;
import com.lovematch.match.controller.common.defs.GlobalDefs;
import com.lovematch.match.jpa.entity.User;
import com.lovematch.match.service.user.UserService;
import com.lovematch.match.util.ajax.AjaxValidationEngine;
import com.lovematch.match.util.ajax.ValidationResponse;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/loginpage" ,method = RequestMethod.GET)
	public String showLogin(HttpSession session){
		UserInfo userInfo = (UserInfo) session.getAttribute(GlobalDefs.SESSION_USER_INFO);
		if(userInfo == null){
			return "login";
		}else{
			return "redirect:/admin";
		}
		
	}
	
	
	@RequestMapping(value="/signin" ,method = RequestMethod.POST)
	public String signin(@Valid LoginForm loginForm, BindingResult result,HttpSession session){
		if (result.hasErrors()) {
			logger.info("LoginForm Validation Failed " + result);
			return "redirect:/";
		} else {
			String name = loginForm.getName();
			String pwd = loginForm.getPassword();
			User user = userService.findByNameAndPwd(name, pwd);
			boolean succeed = user != null;

			if(succeed){
				UserInfo userInfo = new UserInfo(user);
				session.setAttribute(GlobalDefs.SESSION_USER_INFO, userInfo);
				return "redirect:/admin";
			}else{
				return "redirect:/";
			}
			
		}
	}
	
	@RequestMapping(value = "/signout", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String signout(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		session.removeAttribute(GlobalDefs.SESSION_USER_INFO);
		session.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public @ResponseBody String checkEmailAndPsw(HttpServletResponse response,
			LoginForm loginForm) throws Exception {
		String name = loginForm.getName();
		String pwd = loginForm.getPassword();

		User user = userService.findByNameAndPwd(name, pwd);
		boolean succeed = user != null;
		Integer num = 1;
		if (succeed == false) {
			num = 0;
		}

		String number = num.toString();
		return number;
	}
	
	@RequestMapping(value = "/checkEmailAndPassword", method = RequestMethod.POST)
	public @ResponseBody
	ValidationResponse processFormAjaxJson(@Valid LoginForm loginForm,
			BindingResult result, HttpSession session) {
		return AjaxValidationEngine.process(result);
	}
	
}
