package com.lovematch.match.controller.admin.news;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lovematch.match.controller.common.defs.GlobalDefs;
import com.lovematch.match.jpa.entity.WebNews;
import com.lovematch.match.service.news.WebNewsService;
import com.lovematch.match.util.MyUtil;
import com.lovematch.match.util.ajax.AjaxValidationEngine;
import com.lovematch.match.util.ajax.ValidationResponse;
import com.lovematch.match.util.fileupload.FileUtil;

@Controller
public class NewsController {

	@Autowired
	private WebNewsService newsService;

	/* investcompany WebNews */
	@RequestMapping(value = "/admin/news/add")
	public String showAddNewsPage(Model model) {

		return "admin.news.add";
	}

	@RequestMapping(value = "/admin/news/{type}/list")
	public String showNewsListPage(
			@PathVariable String type,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
			Model model) {
		Page<WebNews> page = null;
		if ("all".equals(type)) {
			page = newsService.findNewsPage(pageNumber, pageSize);
		} else {
			page = newsService.findNewsPageByType(pageNumber, pageSize, type);
		}

		model.addAttribute("page", page);
		return "admin.news.list";
	}

	@RequestMapping(value = "/admin/news/new", method = RequestMethod.POST)
	public String addNews(@Valid NewsForm newsForm, BindingResult result,
			HttpSession session, MultipartHttpServletRequest request,
			@RequestParam("type") String type) throws Exception {
		if (result.hasErrors()) {
			return "redirect:/admin/news/add";
		} else {
			WebNews news = new WebNews();
			MyUtil.copyValidBeanToDestBean(newsForm, news);
			news.setDate(new Date());
			news.setType(type);
			news = newsService.create(news);
			MultipartFile file = request.getFile("coverFile");
			if (!file.isEmpty()) {
				String savePath = operatThePreviewPhoto(file, "news", session,
						news.getId());
				news.setPhoto_path(savePath);
				newsService.update(news);
			}
			return "redirect:/admin/news/all/list";
		}
	}

	@RequestMapping(value = "/admin/news/edit/{id}")
	public String editNewsPage(@PathVariable Long id, Model model) {
		WebNews news = newsService.find(id);
		model.addAttribute("news", news);

		return "admin.news.edit";
	}

	@RequestMapping(value = "/admin/news/edit/edit", method = RequestMethod.POST)
	public String editNewsDetail(@Valid NewsForm newsForm,
			BindingResult result, HttpSession session,
			@RequestParam("news_id") Long news_id,
			@RequestParam("type") String type,
			MultipartHttpServletRequest request) throws Exception, IOException {
		if (result.hasErrors()) {
			return "redirect:/admin/news/edit/" + news_id;
		} else {

			try {
				WebNews news = newsService.find(news_id);
				MyUtil.copyValidBeanToDestBean(newsForm, news);
				news.setDate(new Date());
				news.setType(type);
				MultipartFile file = request.getFile("coverFile");
				if (!file.isEmpty()) {
					String savePath = operatThePreviewPhoto(file, "news",
							session, news_id);
					news.setPhoto_path(savePath);

				}
				newsService.update(news);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/admin/news/all/list";
		}
	}

	@RequestMapping(value = "/admin/news/destory", method = RequestMethod.POST)
	public String deleteNews(@RequestParam("news_id") Long news_id) {
		newsService.delete(news_id);
		return "redirect:/admin/news/all/list";
	}

	@RequestMapping(value = "/admin/news/newsInfoAJAX", method = RequestMethod.POST)
	public @ResponseBody
	ValidationResponse newsInfoFormAjaxJson(@Valid NewsForm newsForm,
			BindingResult result) {
		return AjaxValidationEngine.process(result);
	}

	@RequestMapping(value = "/admin/news/editNewsInfoAJAX", method = RequestMethod.POST)
	public @ResponseBody
	ValidationResponse editNewsInfoFormAjaxJson(@Valid NewsForm newsForm,
			BindingResult result) {
		return AjaxValidationEngine.process(result);
	}

	private String operatThePreviewPhoto(MultipartFile file, String type,
			HttpSession session, Long type_id) throws Exception {
		String fileName = file.getOriginalFilename();
		String fileExtension = fileName
				.substring(fileName.lastIndexOf(".") + 1);
		String path = session.getServletContext().getRealPath("/")
				+ "/resources/attached/" + type + "/" + type_id;
		FileUtil.createRealPath(path, session);
		String previewFile = path + File.separator + "small" + "."
				+ fileExtension;
		File saveDest = new File(path + File.separator + fileName);
		file.transferTo(saveDest);
		
		FileUtil.getPreviewImage(saveDest, new File(previewFile),
					fileExtension, GlobalDefs.PHOTO_WIDTH,
					GlobalDefs.PHOTO_HEIGHT);
		
		String savePath = "/resources/attached/" + type + "/" + type_id
				+ "/small" + "." + fileExtension;
		return savePath;
	}
}
