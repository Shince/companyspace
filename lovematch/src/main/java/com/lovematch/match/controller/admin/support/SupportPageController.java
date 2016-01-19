package com.lovematch.match.controller.admin.support;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovematch.match.jpa.entity.Support;
import com.lovematch.match.service.support.SupportService;
import com.lovematch.match.util.ajax.AjaxValidationEngine;
import com.lovematch.match.util.ajax.ValidationResponse;


@Controller
public class SupportPageController {
	
	@Autowired
	private SupportService supportService;
	
	@RequestMapping(value="/admin/support/list")
	public String showAllActivitiesPage(Model model ,@RequestParam(value="pageNumber",defaultValue="0") 
	int pageNumber, @RequestParam(value="pageSize", defaultValue="20") int pageSize){
		
		Page<Support> page = supportService.findAll(pageNumber, pageSize);
		model.addAttribute("page", page);
		return "admin.support.list";
	}
	
	@RequestMapping(value="/admin/support/create")
	public String createNewActivityPage(){
		
		return "admin.support.add";
	}
	
	@RequestMapping(value = "/admin/support/createSupportAjax", method = RequestMethod.POST)
	public @ResponseBody ValidationResponse supportInfoFormAjaxJson(@Valid SupportForm supportForm, BindingResult result) {
		return AjaxValidationEngine.process(result);
	}
	
	@RequestMapping(value="/admin/support/edit/{id}")
	public String editActivityDetailPage(@PathVariable Long id, Model model){
		Support support = supportService.find(id);
		model.addAttribute("support", support);
		
		return "admin.support.edit";
	}
	
	@RequestMapping(value = "/admin/support/edit/updateSupportAjax", method = RequestMethod.POST)
	public @ResponseBody ValidationResponse editSupportInfoFormAjaxJson(@Valid SupportForm supportForm, BindingResult result) {
		return AjaxValidationEngine.process(result);
	}
}
