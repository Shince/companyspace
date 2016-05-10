package com.lovematch.match;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.SharingInfo;
import com.lovematch.match.jpa.entity.WebCont;
import com.lovematch.match.jpa.entity.WebNews;
import com.lovematch.match.service.competition.CompetitionService;
import com.lovematch.match.service.news.WebNewsService;
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
			@RequestParam(value = "order", defaultValue = "asc") String order,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize
			) {
		Page<SharingInfo> sharinginfo = sharingInfoService.findPageOrderByDate(0, 10, null);
		model.addAttribute("sharingInfo", sharinginfo.getContent());
		Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
		model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
		Page<Competition> page;
		if (order!=null && "desc".equals(order)){
			page = competitionService.findPageActiveByTypeDesc(type, pageNumber, pageSize, new Date());
		}else{
			page = competitionService.findPageActiveByType(type, pageNumber, pageSize, new Date());
		}
		
		model.addAttribute("page", page);
		return "home";
	}
	@RequestMapping(value = "/competitions/{type}/timefilter", method = RequestMethod.GET)
	public String filterCompetitonsByTimeRange(Model model,@PathVariable String type,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "order", defaultValue = "asc") String order,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value="firstDate" ,defaultValue="") String firstDate,
			@RequestParam(value="lastDate" ,defaultValue="") String lastDate){
		Page<SharingInfo> sharinginfo = sharingInfoService.findPageOrderByDate(0, 10, null);
		model.addAttribute("sharingInfo", sharinginfo.getContent());
		Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
		model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
		
		Page<Competition> page;
		firstDate = firstDate.trim();
		lastDate = lastDate.trim();
		if(firstDate == null || firstDate.equals("")){
			firstDate = lastDate;
		}else if(lastDate == null || lastDate.equals("")){
			 lastDate = firstDate;
		}
		if((firstDate != null && !firstDate.equals("")) && (lastDate != null && !lastDate.equals(""))){
			firstDate += " 00:00";
			lastDate += " 23:59";
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				Date fDate = formatter.parse(firstDate);
				Date lDate = formatter.parse(lastDate);
				page = competitionService.findPageByOrderAndFirstDateAndLastDate(pageNumber, pageSize, order, fDate, lDate);
			} catch (Exception e) {
				e.printStackTrace();
				page = competitionService.findPageByTypeDesc(type, pageNumber, pageSize);
			}
		}else{
			page = competitionService.findPageByTypeDesc(type, pageNumber, pageSize);
		}
		model.addAttribute("page", page);
		return "home";
	}
	@RequestMapping(value = "/competitions/search", method = RequestMethod.POST)
	public String search(Locale locale, Model model, @RequestParam(value = "searchFor") String searchFor,
			@RequestParam(value = "order", defaultValue = "asc") String order,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		if(searchFor!=null){
			searchFor = "%"+searchFor+"%";
		}
		Page<SharingInfo> sharinginfo = sharingInfoService.findPageOrderByDate(0, 10, null);
		model.addAttribute("sharingInfo", sharinginfo.getContent());
		Page<Competition> unstartCompetitions = competitionService.findPageByCurrentDate(0, 20, new Date());
		model.addAttribute("unstartCompetitions",unstartCompetitions.getContent());
		Page<Competition> page;
		if (order!=null && "desc".equals(order)){
			page = competitionService.findPageByTitleLikeDesc(searchFor, pageNumber, pageSize);
		}else{
			page = competitionService.findPageByTitleLike(searchFor, pageNumber, pageSize);
		}
		
		model.addAttribute("page", page);
		return "home";
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
