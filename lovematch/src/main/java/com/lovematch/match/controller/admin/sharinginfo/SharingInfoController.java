package com.lovematch.match.controller.admin.sharinginfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lovematch.match.controller.common.defs.GlobalDefs;
import com.lovematch.match.jpa.entity.SharingInfo;
import com.lovematch.match.service.sharinginfo.SharingInfoService;
import com.lovematch.match.util.MyUtil;

@Controller
public class SharingInfoController {
	@Autowired
	private SharingInfoService sharingInfoService;
	
	@RequestMapping(value="/admin/sharinginfo/list")
	public String showSharingInfoList(Model model,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber){
		Page<SharingInfo> page = sharingInfoService.findPageOrderByDate(pageNumber, GlobalDefs.PAGESIZE, null);
		model.addAttribute("page", page);
		return "admin.sharinginfo.list";
	}
	@RequestMapping(value="/admin/sharinginfo/edit/{id}")
	public String showSharingInfoEditPage(Model model,@PathVariable Long id){
		SharingInfo info = sharingInfoService.find(id);
		model.addAttribute("info", info);
		return "admin.sharinginfo.edit";
	}
	@RequestMapping(value="/admin/sharinginfo/new")
	public String showSharingInfoNewPage(){
		return "admin.sharinginfo.add";
	}
	@RequestMapping(value="/admin/sharinginfo/add")
	public String showSharingInfoDetail(Model model,MultipartHttpServletRequest request,
			HttpSession session,@RequestParam("id") Long id,
			@RequestParam("content") String content,
			@RequestParam("title") String title){
		SharingInfo info;
		if(id != null){ 
			info = sharingInfoService.find(id);
		}else{
			info = new SharingInfo();
		}
		info.setContent(content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		info.setPostDate(date);
		info.setTitle(title);
		info.setType(null);
		info = sharingInfoService.create(info);
		try {
			MultipartFile file = request.getFile("coverFile");
			if (!file.isEmpty()) {
				String savePath = MyUtil.operatThePreviewPhoto(file, "sharinginfo",
						session, info.getId());
				info.setPicPath(savePath);
				sharingInfoService.update(info);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("info", info);
		return "redirect:/admin/sharinginfo/list";
	}
	@RequestMapping(value="/admin/sharinginfo/destory",method = RequestMethod.POST)
	public String showCompetitionDetail(@RequestParam("id") Long id){
		try {
			sharingInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//model.addAttribute("competition", competition);
		return "redirect:/admin/sharinginfo/list";
	}
}
