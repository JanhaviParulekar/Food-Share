package com.wt.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wt.pro.dao.ProductDAO;
import com.wt.pro.exception.ProductException;
import com.wt.pro.pojo.ProductDefination;
import com.wt.pro.validator.ProductValidator;


@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	@Qualifier("productValidator")
	ProductValidator productValidator;
	
	@Autowired
	@Qualifier("productDao")
	ProductDAO productDAO;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(productValidator);
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") ProductDefination product, BindingResult result) throws Exception {
		
		productValidator.validate(product, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("add-product", "product", product);
		}

		try {				
			product = productDAO.create(product);
		} catch (ProductException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while creating a product");
		}
		return new ModelAndView("product-success", "product", product);
		
	}

	@RequestMapping(value="/product/add", method = RequestMethod.GET)
	public ModelAndView initializeForm() throws Exception {			
		return new ModelAndView("add-product", "product", new ProductDefination());
	}



}
