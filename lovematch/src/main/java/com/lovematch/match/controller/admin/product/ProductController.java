package com.lovematch.match.controller.admin.product;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.Product;
import com.lovematch.match.service.competition.CompetitionService;
import com.lovematch.match.service.product.ProductService;
import com.lovematch.match.util.MyUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CompetitionService competitionService;
	
	@RequestMapping(value="/admin/competition/{competition}/product/new")
	public String showProductEditPage(@PathVariable Long competition,Model model){
		model.addAttribute("competition_id", competition);
		return "admin.product.add";
	}
	@RequestMapping(value="/admin/competition/{competition}/product/edit/{id}")
	public String showProductEdit(Model model, @PathVariable Long competition,@PathVariable Long id){
		Product product = productService.find(id);
		model.addAttribute("product", product);
		model.addAttribute("competition_id", competition);
		return "admin.product.edit";
	}
	@RequestMapping(value="/admin/product/add", method=RequestMethod.POST)
	public String showproductAddPage(Model model,MultipartHttpServletRequest request,
			HttpSession session,@RequestParam("id") Long id,
			@RequestParam("competition_id") Long competition_id,
			@RequestParam("description") String description,
			@RequestParam("name") String name){
		Competition competition = competitionService.find(competition_id);
		try {
			Product product;
			if(id != null){
				product = productService.find(id);
			}else{
				product = new Product();
			}
			
			product.setCompetition(competition);
			product.setDescription(description);
			product.setName(name);
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//String date = sdf.format(new Date());
			product = productService.create(product);
			try {
				MultipartFile file = request.getFile("coverFile");
				if (!file.isEmpty()) {
					String savePath = MyUtil.operatThePreviewPhoto(file, "product",
							session, product.getId());
					product.setPhoto_url(savePath);
					productService.update(product);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//model.addAttribute("competition", competition);
		return "redirect:/admin/competition/view/"+competition_id;
	}
	@RequestMapping(value="/admin/competition/{competition_id}/product/destory/{id}")
	public String showCompetitionDetail(@PathVariable Long competition_id,@PathVariable Long id){
		try {
			productService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//model.addAttribute("competition", competition);
		return "redirect:/admin/competition/view/"+competition_id;
	}
}
