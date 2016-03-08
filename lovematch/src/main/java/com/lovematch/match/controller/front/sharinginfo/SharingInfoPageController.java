package com.lovematch.match.controller.front.sharinginfo;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.SharingInfo;
import com.lovematch.match.service.competition.CompetitionService;
import com.lovematch.match.service.sharinginfo.SharingInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SharingInfoPageController {
	@Autowired
	private CompetitionService competitionService;
	@Autowired
	private SharingInfoService sharingInfoService;

	@RequestMapping(value = "/sharinginfo/list")
	public String showSharingInfoPage(Model model,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		try {
			Page<SharingInfo> sharinginfos = sharingInfoService.findPageOrderByDate(0, 10, null);
			model.addAttribute("sharingInfo", sharinginfos.getContent());
			Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
			model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
			
			Page<SharingInfo> page = sharingInfoService.findPageOrderByDate(pageNumber, pageSize, null);
			model.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "sharinginfo.list";
	}

	@RequestMapping(value = "/sharinginfo/view/{id}")
	public String showSharinginfoDetail(@PathVariable Long id, Model model) {
		Page<SharingInfo> sharinginfos = sharingInfoService.findPageOrderByDate(0, 10, null);
		model.addAttribute("sharingInfo", sharinginfos.getContent());
		Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
		model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
		
		SharingInfo sharingInfo = sharingInfoService.find(id);
		model.addAttribute("info", sharingInfo);
		return "sharinginfo.view";
	}

}
