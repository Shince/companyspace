package com.lovematch.match.controller.admin.support;

import java.io.File;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lovematch.match.controller.common.defs.GlobalDefs;
import com.lovematch.match.jpa.entity.Support;
import com.lovematch.match.service.support.SupportService;
import com.lovematch.match.util.fileupload.FileUtil;



@Controller
public class SupportDetailController {

	@Autowired
	private SupportService supportService;
	private static final long MAX_FILE_SIZE_2M = 2*1024*1024;
	private static final String default_logo = "/resources/img/avatar/avatar128.png";
	
	@RequestMapping(value="/admin/support/new", method = RequestMethod.POST)
	public String createActivity(MultipartHttpServletRequest request,@Valid SupportForm supportForm, 
			BindingResult result,HttpSession session,RedirectAttributes redirectAttributes) throws Exception{
		if(result.hasErrors()){
			return "redirect:/admin/support/create";
		}else{
			MultipartFile file = request.getFile("supportFile");
			Support support = new Support();
			support.setName(supportForm.getName());
			support.setUrl(supportForm.getUrl());
			support = supportService.create(support);

			if(!file.isEmpty()){
				if(file.getSize()>MAX_FILE_SIZE_2M){
					redirectAttributes.addFlashAttribute("errorMsg", "图片不得大于2M");
					return "redirect:/admin/upport/create";
				}else{	
					String fileName = file.getOriginalFilename();
					String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
					String path = session.getServletContext().getRealPath("/")+"/resources/attached/support/"+support.getId();
					FileUtil.createRealPath(path, session);
					String previewFile = path+File.separator+"small"+"."+fileExtension;
					File saveDest = new File(path + File.separator + fileName);
					file.transferTo(saveDest);
					FileUtil.getPreviewImage(saveDest, new File(previewFile), fileExtension
							,GlobalDefs.PHOTO_WIDTH,GlobalDefs.PHOTO_HEIGHT);
					String savePath = "/resources/attached/support/"+support.getId()+"/small"+"."+fileExtension;
					support.setLogoPath(savePath);
					supportService.update(support);
				}						
			}else{
				support.setLogoPath(default_logo);
				supportService.update(support);
			}
			return "redirect:/admin/support/list";
		}
	}
	
	@RequestMapping(value="/admin/support/edit", method = RequestMethod.POST)
	public String editActivity(MultipartHttpServletRequest request,@Valid SupportForm supportForm, BindingResult result,
			HttpSession session,RedirectAttributes redirectAttributes,@RequestParam("support_id") Long id) throws Exception{
		if(result.hasErrors()){
			return "redirect:/admin/support/edit/"+id;
		}else{
			Support support = supportService.find(id);
			support.setName(supportForm.getName());
			support.setUrl(supportForm.getUrl());
			support = supportService.update(support);
			MultipartFile file = request.getFile("supportFile");
			if(!file.isEmpty()){
				if(file.getSize()>MAX_FILE_SIZE_2M){
					redirectAttributes.addFlashAttribute("errorMsg", "图片不得大于2M");
					return "redirect:/admin/support/edit/"+id;
				}else{	
					String fileName = file.getOriginalFilename();
					String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
					String path = session.getServletContext().getRealPath("/")+"/resources/attached/support/"+support.getId();
					FileUtil.createRealPath(path, session);
					String previewFile = path+File.separator+"small"+"."+fileExtension;
					File saveDest = new File(path + File.separator + fileName);
					file.transferTo(saveDest);
					FileUtil.getPreviewImage(saveDest, new File(previewFile), fileExtension
							,GlobalDefs.PHOTO_WIDTH,GlobalDefs.PHOTO_HEIGHT);
					String savePath = "/resources/attached/support/"+support.getId()+"/small"+"."+fileExtension;
					support.setLogoPath(savePath);
					supportService.update(support);
				}			
			}
			return "redirect:/admin/support/list";
		}
	}
	
	@RequestMapping(value="/admin/support/destory", method = RequestMethod.POST)
	public String destoryActivity(HttpSession session,@RequestParam("support_id") Long id){
			supportService.delete(id);
			return "redirect:/admin/support/list";

		
	}
}
