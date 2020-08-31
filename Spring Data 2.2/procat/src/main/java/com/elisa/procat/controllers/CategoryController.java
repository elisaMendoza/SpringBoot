package com.elisa.procat.controllers;
import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.elisa.procat.models.Category;
import com.elisa.procat.models.Product;
import com.elisa.procat.services.CategoryService;
import com.elisa.procat.services.ProductService;

@Controller
public class CategoryController {
	private final CategoryService catService;
	private final ProductService proService;

	public CategoryController(CategoryService catService, ProductService proService) {
		this.catService = catService;
		this.proService = proService;
	}
	@RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "/newCategory.jsp";
    }
  @RequestMapping(value="/categories/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("product") Category category, BindingResult result) { 
		if (result.hasErrors()) {
    		 return "/newCategory.jsp";
        } else {
            catService.saveCategory(category);
            return "redirect:/";
        }
	}
  @RequestMapping("/categories/{id}")
  public String categoryList(@PathVariable("id") Long id, Model model) {
	  Category category = catService.findCategory(id);
	  List<Product> prods = proService.allProducts();
	  model.addAttribute("products", prods);
	  model.addAttribute("category", category);
	  return "/categories.jsp";
  }
  @RequestMapping("/categories")
  public String categoryProds(@RequestParam(value="products") Product product, @RequestParam("category") Category cat, Model model) {
	  cat.getProducts().add(product);
	  catService.saveCategory(cat);
	  return "redirect:/";
  }

}
