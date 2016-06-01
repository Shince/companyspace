package com.lovematch.match.controller.admin.competition;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.lovematch.match.beans.RaceDistance;
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
				// for distance
				RaceDistance raceDistance = new RaceDistance();
				String distance = competition.getDistance();
				if (distance != null && !distance.isEmpty()) {
					String[] distanceArray = distance.split("&");
					List<String> distanceList = Arrays.asList(distanceArray);
					List<String> otherDistanceList = new ArrayList<String>();
					for (String dis : distanceList) {
						if (dis.equals("wholeMarathon")) {
							raceDistance.setWholeMarathon("wholeMarathon");
						} else if (dis.equals("halfMarathon")) {
							raceDistance.setHalfMarathon("halfMarathon");
						} else if (dis != null && !dis.isEmpty()) {
							raceDistance.setOtherDistance("otherDistance");
							otherDistanceList.add(dis);
							raceDistance.setOtherDistanceList(otherDistanceList);
						}
					}
				}
				// for door close
				String doorClose = competition.getDoorClose();
				List<String> dcList = new ArrayList<String>();
				List<String> doorCloseList = new ArrayList<String>();
				if (doorClose != null && !doorClose.isEmpty()) {
					String[] doorCloseArray = doorClose.split("&");
					doorCloseList = Arrays.asList(doorCloseArray);
					for (String dc : doorCloseList) {
						if (dc != null && !dc.isEmpty()) {
							dcList.add(dc);
						}
					}
				}
				model.addAttribute("competition", competition);
				model.addAttribute("raceDistance", raceDistance);
				model.addAttribute("otherDistance", raceDistance.getOtherDistanceList());
				model.addAttribute("doorCloseList", dcList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "admin.competition.edit";
	}

	@RequestMapping(value = "/admin/competition/view/{id}")
	public String showConpetitionViewPage(Model model, @PathVariable Long id) {
		Competition competition = competitionService.find(id);
		// for distance
		RaceDistance raceDistance = new RaceDistance();
		String distance = competition.getDistance();
		if (distance != null && !distance.isEmpty()) {
			String[] distanceArray = distance.split("&");
			List<String> distanceList = Arrays.asList(distanceArray);
			List<String> otherDistanceList = new ArrayList<String>();
			for (String dis : distanceList) {
				if (dis.equals("wholeMarathon")) {
					raceDistance.setWholeMarathon("wholeMarathon");
				} else if (dis.equals("halfMarathon")) {
					raceDistance.setHalfMarathon("halfMarathon");
				} else if (dis != null && !dis.isEmpty()) {
					raceDistance.setOtherDistance("otherDistance");
					otherDistanceList.add(dis);
					raceDistance.setOtherDistanceList(otherDistanceList);
				}
			}
		}
		
		// for door close
		String doorClose = competition.getDoorClose();
		List<String> dcList = new ArrayList<String>();
		List<String> doorCloseList = new ArrayList<String>();
		if (doorClose != null && !doorClose.isEmpty()) {
			String[] doorCloseArray = doorClose.split("&");
			doorCloseList = Arrays.asList(doorCloseArray);
			for (String dc : doorCloseList) {
				if (dc != null && !dc.isEmpty()) {
					dcList.add(dc);
				}
			}
		}
		
		model.addAttribute("competition", competition);
		model.addAttribute("raceDistance", raceDistance);
		model.addAttribute("otherDistance", raceDistance.getOtherDistanceList());
		List<Product> products = productService.findAllByCompetition(competition);
		model.addAttribute("products", products);
		return "admin.competition.view";
	}

	@RequestMapping(value = "/admin/competition/add")
	public String showCompetitionDetail(Model model, MultipartHttpServletRequest request, HttpSession session,
			@RequestParam("competition_id") Long id, @RequestParam("description") String description,
			@RequestParam("title") String title, @RequestParam("type") String type,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("enrollLinke") String enrollLinke, @RequestParam("webUrl") String webUrl,
			@RequestParam("competitionStartDate") String competitionStartDate) {
		Competition competition;
		String distance = new String();
		String doorClose = new String();
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
			Date sDate;
			Date eDate;
			Date csDate;
			if(startDate!=null && !startDate.equals("")){
				sDate = formatter.parse(startDate);
			}else{
				sDate=null;
			}
			if(endDate!=null && !endDate.equals("")){
				eDate= formatter.parse(endDate);
			}else{
				eDate=null;
			}
			if(competitionStartDate!=null && !competitionStartDate.equals("")){
				csDate = formatter.parse(competitionStartDate);
			}else{
				csDate=null;
			}
			competition.setStartDate(sDate);
			competition.setEndDate(eDate);
			competition.setCompetitionStartDate(csDate);
		} catch (Exception e) {
			e.printStackTrace();
//			competition.setStartDate(new Date());
//			competition.setEndDate(new Date());
		}
		competition.setEnrollLinke(enrollLinke);
		competition.setOfficialWebsite(webUrl);

		// for distance
		String wholeMarathon = request.getParameter("wholeMarathon");
		String halfMarathon = request.getParameter("halfMarathon");
		String otherDistance = request.getParameter("otherDistance");

		if (wholeMarathon != null && wholeMarathon.equals("wholeMarathon")) {
			distance += wholeMarathon;
			distance += "&";
		}
		if (halfMarathon != null && halfMarathon.equals("halfMarathon")) {
			distance += halfMarathon;
			distance += "&";
		}
		if (otherDistance != null && otherDistance.equals("otherDistance")) {
			for (int i = 0; i != 6; i++) {
				distance += request.getParameter("other" + i);
				distance += "&";
			}
		}

		// for door close;
		for (int i = 0; i != 6; i++) {
			doorClose += request.getParameter("doorClose" + i);
			doorClose += "&";
		}

		// save the distance and the door close
		competition.setDistance(distance);
		competition.setDoorClose(doorClose);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		competition.setPostDate(date);
		competition = competitionService.create(competition);
		try {
			MultipartFile coverFile = request.getFile("coverFile");
			MultipartFile contextfile = request.getFile("contextFile");
			if (!coverFile.isEmpty()) {
				String saveCoverPath = MyUtil.operatThePreviewPhoto(coverFile, "competition", session,
						competition.getId());
				competition.setPicPath(saveCoverPath);
				competitionService.update(competition);
			}
			if (!contextfile.isEmpty()) {
				String saveContextPath = MyUtil.operatThePreviewLargePhoto(contextfile, "competition", session,
						competition.getId());
				competition.setContextPicPath(saveContextPath);
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
			for (Product product : products) {
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
