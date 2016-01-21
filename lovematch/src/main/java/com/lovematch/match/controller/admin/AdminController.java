package com.lovematch.match.controller.admin;

import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lovematch.match.controller.beans.UserInfo;
import com.lovematch.match.controller.common.defs.GlobalDefs;
import com.lovematch.match.jpa.entity.User;
import com.lovematch.match.service.user.UserService;
import com.lovematch.match.util.ajax.AjaxValidationEngine;
import com.lovematch.match.util.ajax.ValidationResponse;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute(GlobalDefs.SESSION_USER_INFO);

		if (userInfo != null) {
			return "redirect:/admin/admins";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/admin/admins", method = RequestMethod.GET)
	public String superAdmins(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome admin page! the client locale is " + locale.toString());

		UserInfo userInfo = (UserInfo) session.getAttribute(GlobalDefs.SESSION_USER_INFO);
		if (userInfo != null) {
			return "redirect:/admin/competition/list";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/admin/changepsw", method = RequestMethod.GET)
	public String changePwdEdit(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome admin page! the client locale is " + locale.toString());

		UserInfo userInfo = (UserInfo) session.getAttribute(GlobalDefs.SESSION_USER_INFO);
		if (userInfo != null) {
			return "admin.pwd.edit";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/admin/changepsw/edit/edit", method = RequestMethod.POST)
	public String changePsw(@Valid PswForm pswForm, BindingResult validResult, HttpSession session,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttr) {
		logger.info("#### changePsw InfoController ####");

		if (validResult.hasErrors()) {
			logger.info("changePsw Validation Failed " + validResult);
			return "redirect:/admin/changepsw";
		} else {
			logger.info("### changePsw Validation passed. ###");

			UserInfo userInfo = (UserInfo) session.getAttribute(GlobalDefs.SESSION_USER_INFO);
			User user = userService.find(userInfo.getId());
			String password = user.getPsw();
			if (password.equals(pswForm.getOri_psw())) {
				user.setPsw(pswForm.getNew_psw());
				user = userService.update(user);
				userInfo.setUser(user);
				session.setAttribute(GlobalDefs.SESSION_USER_INFO, userInfo);
				String message = "密码修改成功";
				redirectAttr.addFlashAttribute("message", message);
			} else {
				logger.info("original password is not correct. Nothing update.");
			}

			return "redirect:/admin/changepsw";
		}
	}

	@RequestMapping(value = "/admin/pswInfoAJAX", method = RequestMethod.POST)
	public @ResponseBody ValidationResponse pswfurInfoFormAjaxJson(@Valid PswForm pswForm, BindingResult result) {
		return AjaxValidationEngine.process(result);
	}

	@RequestMapping(value = "/admin/pswInfoCheck", method = RequestMethod.POST)
	public void checkEmailAndPsw(HttpServletResponse response, HttpSession session, PswForm pswForm) throws Exception {
		UserInfo userInfo = (UserInfo) session.getAttribute(GlobalDefs.SESSION_USER_INFO);
		PrintWriter out = response.getWriter();
		User user = userInfo.getUser();
		String password = user.getPsw();
		String oriPsw = pswForm.getOri_psw();
		Integer num = 1;
		if (!password.equals(oriPsw)) {
			num = 0;
		}
		String number = num.toString();
		out.write(number);
		out.flush();
		out.close();
	}

}
