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
public class ProductController {
	private final ProductService proService;
	private final CategoryService catService;

	public ProductController(ProductService proService, CategoryService catService) {
		this.proService = proService;
		this.catService = catService;
	}
	 @RequestMapping("/products/new")
	    public String newProduct(@ModelAttribute("product") Product product) {
	        return "/newProduct.jsp";
	    }
	  @RequestMapping(value="/products/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) { 
			if (result.hasErrors()) {
	    		 return "/newProduct.jsp";
	        } else {
	            proService.saveProduct(product);
	            return "redirect:/";
	        }
		}
	  @RequestMapping("/")
	    public String index(Model model) {
		  List<Product> products = proService.allProducts();
		  List<Category> categories = catService.allCategories();
		  model.addAttribute("products", products);
		  model.addAttribute("categories", categories);
	        return "/index.jsp";
	    }
	  @RequestMapping("/products/{id}")
	  public String productList(@PathVariable("id") Long id, Model model) {
		  Product product = proService.findProduct(id);
		  List<Category> cats = catService.allCategories();
		  model.addAttribute("product", product);
		  model.addAttribute("categories", cats);
		  return "/products.jsp";
	  }
	  @RequestMapping("/products")
	  public String productCats(@RequestParam(value="product") Product product, @RequestParam("categories") Category cat, Model model) {
		  product.getCategories().add(cat);
		  proService.saveProduct(product);
		  return "redirect:/";
	  }

}
