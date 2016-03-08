package com.lovematch.match.controller.front.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovematch.match.beans.RaceDistance;
import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.Product;
import com.lovematch.match.service.competition.CompetitionService;
import com.lovematch.match.service.product.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CompetitionPageController {
	@Autowired
	private CompetitionService competitionService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/competitions/view/{id}")
	public String showCompetitionsDetail(@PathVariable Long id, Model model) {
		Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
		model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
		
		Competition competition = competitionService.find(id);
		
		// for distance
		RaceDistance raceDistance = new RaceDistance();
		String distance = competition.getDistance();
		String[] distanceArray = distance.split("&");
		List<String> distanceList = Arrays.asList(distanceArray);
		List<String> otherDistanceList= new ArrayList<String>();
		List<String> dcList = new ArrayList<String>();
		for(String dis : distanceList){
			if(dis.equals("wholeMarathon")){
				raceDistance.setWholeMarathon("wholeMarathon");
			}
			else if(dis.equals("halfMarathon")){
				raceDistance.setHalfMarathon("halfMarathon");
			}
			else if(dis!=null && !dis.isEmpty()){
				raceDistance.setOtherDistance("otherDistance");
				otherDistanceList.add(dis);
				raceDistance.setOtherDistanceList(otherDistanceList);
			}
		}
		
		// for door close
		String doorClose = competition.getDoorClose();
		String[] doorCloseArray = doorClose.split("&");
		List<String> doorCloseList = Arrays.asList(doorCloseArray);
		for(String dc : doorCloseList){
			if(dc!=null && !dc.isEmpty()){
				dcList.add(dc);
			}
		}
		model.addAttribute("competition", competition);
		model.addAttribute("raceDistance", raceDistance);
		model.addAttribute("otherDistance",raceDistance.getOtherDistanceList());
		model.addAttribute("doorCloseList", dcList);
		
		List<Product> products = productService.findAllByCompetition(competition);
		model.addAttribute("competition", competition);
		model.addAttribute("products", products);
		return "competition.view";
	}

	@RequestMapping(value = "/product/view/{id}")
	public String showProductDetail(@PathVariable Long id, Model model) {
		Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
		model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
		
		Product product = productService.find(id);
		model.addAttribute("product", product);
		return "product.view";
	}

}
