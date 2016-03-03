package com.lovematch.match.controller.admin.competition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.Product;
import com.lovematch.match.service.competition.CompetitionService;
import com.lovematch.match.service.product.ProductService;
import com.lovematch.match.util.MyUtil;

@Controller
public class CompetitionController {
	@Autowired
	private CompetitionService competitionService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/admin/competition/list")
	public String showCompetitionInfoList(Model model,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		Page<Competition> page = competitionService.findPageOrderById(pageNumber, GlobalDefs.PAGESIZE, "desc");
		model.addAttribute("page", page);
		return "admin.competition.list";
	}
	
	@RequestMapping(value = "/admin/competition/{type}/list")
	public String showCompetitionInfoListByType(Model model, @PathVariable String type,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		Page<Competition> page = competitionService.findPageByType(type, pageNumber, pageSize);
		model.addAttribute("page", page);
		return "admin.competition.list";
	} 

	@RequestMapping(value = "/admin/competition/new")
	public String showConpetitionAddPage() {
		return "admin.competition.add";
	}

	@RequestMapping(value = "/admin/competition/edit/{id}")
	public String showConpetitionEditPage(Model model, @PathVariable Long id) {
		try {
			if (id != null) {
				Competition competition = competitionService.find(id);
				model.addAttribute("competition", competition);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "admin.competition.edit";
	}

	@RequestMapping(value = "/admin/competition/view/{id}")
	public String showConpetitionViewPage(Model model, @PathVariable Long id) {
		Competition competition = competitionService.find(id);
		model.addAttribute("competition", competition);
		List<Product> products = productService.findAllByCompetition(competition);
		model.addAttribute("products", products);
		return "admin.competition.view";
	}

	@RequestMapping(value = "/admin/competition/add")
	public String showCompetitionDetail(Model model, MultipartHttpServletRequest request, HttpSession session,
			@RequestParam("competition_id") Long id, @RequestParam("description") String description,
			@RequestParam("title") String title, @RequestParam("type") String type,@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,@RequestParam("enrollLinke") String enrollLinke, 
			@RequestParam("webUrl") String webUrl,@RequestParam("competitionStartDate") String competitionStartDate) {
		Competition competition;
		if (id != null) {
			competition = competitionService.find(id);
		} else {
			competition = new Competition();
		}
		competition.setDescription(description);
		competition.setTitle(title);
		competition.setType(type);
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date sDate = formatter.parse(startDate);
			Date eDate = formatter.parse(endDate);
			Date csDate = formatter.parse(competitionStartDate);
			competition.setStartDate(sDate);
			competition.setEndDate(eDate);
			competition.setCompetitionStartDate(csDate);
		} catch (Exception e) {
			e.printStackTrace();
			competition.setStartDate(new Date());
			competition.setEndDate(new Date());
		}
		competition.setEnrollLinke(enrollLinke);
		competition.setOfficialWebsite(webUrl);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		competition.setPostDate(date);
		competition = competitionService.create(competition);
		try {
			MultipartFile file = request.getFile("coverFile");
			if (!file.isEmpty()) {
				String savePath = MyUtil.operatThePreviewPhoto(file, "competition", session, competition.getId());
				competition.setPicPath(savePath);
				competitionService.update(competition);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// model.addAttribute("competition", competition);
		return "redirect:/admin/competition/list";
	}

	@RequestMapping(value = "/admin/competition/destory", method = RequestMethod.POST)
	public String showCompetitionDetail(@RequestParam("id") Long id) {
		try {
			Competition competition = competitionService.find(id);
			List<Product> products = productService.findAllByCompetition(competition);
			for(Product product : products){
				productService.delete(product.getId());
			}
			competitionService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// model.addAttribute("competition", competition);
		return "redirect:/admin/competition/list";
	}

}
