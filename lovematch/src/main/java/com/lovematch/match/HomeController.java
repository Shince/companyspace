package com.lovematch.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lovematch.match.beans.RaceDistance;
import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.Product;
import com.lovematch.match.jpa.entity.SharingInfo;
import com.lovematch.match.jpa.entity.WebCont;
import com.lovematch.match.jpa.entity.WebNews;
import com.lovematch.match.service.competition.CompetitionService;
import com.lovematch.match.service.news.WebNewsService;
import com.lovematch.match.service.product.ProductService;
import com.lovematch.match.service.sharinginfo.SharingInfoService;
import com.lovematch.match.service.webcont.WebContService;
import com.lovematch.match.util.MyUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private WebNewsService newsService;
	@Autowired
	private WebContService contService;
	@Autowired
	private CompetitionService competitionService;
	@Autowired
	private SharingInfoService sharingInfoService;
	@Autowired
	private ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String jumpTohome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "redirect:/competitions/all/list";
	}
 
	@RequestMapping(value = "/competitions/{type}/list", method = RequestMethod.GET)
	public String homePage(Locale locale, Model model, @PathVariable String type,
			@RequestParam(value = "order", defaultValue = "desc") String order,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		Page<SharingInfo> sharinginfo = sharingInfoService.findPageOrderByDate(0, 10, null);
		model.addAttribute("sharingInfo", sharinginfo.getContent());
		Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
		model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
		Page<Competition> page;
		if (order!=null && "asc".equals(order)){
			page = competitionService.findPageByTypeAsc(type, pageNumber, pageSize);
		}else{
			page = competitionService.findPageByType(type, pageNumber, pageSize);
		}
		
		model.addAttribute("page", page);
		return "home";
	}

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
		Page<SharingInfo> sharinginfo = sharingInfoService.findPageOrderByDate(0, 10, null);
		model.addAttribute("sharingInfo", sharinginfo.getContent());
		Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
		model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
		
		Product product = productService.find(id);
		model.addAttribute("product", product);
		return "product.view";
	}

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

	@RequestMapping(value = "/news/list")
	public String showNews(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model model) {

		Page<WebNews> page = newsService.findNewsPage(pageNumber, pageSize);
		model.addAttribute("page", page);
		return "news.list";
	}

	@RequestMapping(value = "/news/view/{id}")
	public String showNews(@PathVariable Long id, Model model) {
		WebNews news = newsService.find(id);
		model.addAttribute("news", news);
		return "news.view";
	}

	@RequestMapping(value = "/cont/{type}/list")
	public String showCont(@PathVariable String type,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model model) {

		Page<WebCont> page = contService.findWebContPageByType(type, pageNumber, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("webInfoType", MyUtil.WebContStatusMap().get(type));
		model.addAttribute("type", type);
		return "cont.list";
	}

	@RequestMapping(value = "/cont/{type}/view/{id}")
	public String showContDetail(@PathVariable String type, @PathVariable Long id, Model model) {
		WebCont cont = contService.find(id);
		model.addAttribute("cont", cont);
		model.addAttribute("webInfoType", MyUtil.WebContStatusMap().get(type));
		return "cont.view";
	}

}
