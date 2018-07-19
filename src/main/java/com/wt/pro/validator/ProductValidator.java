package com.wt.pro.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wt.pro.dao.ProductDAO;
import com.wt.pro.exception.ProductException;
import com.wt.pro.pojo.ProductDefination;

@Component
public class ProductValidator implements Validator{
	
	@Autowired
	@Qualifier("productDao")
	ProductDAO productDAO;
	
	public boolean supports(Class aClass) {
		return ProductDefination.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		ProductDefination newProduct = (ProductDefination) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "error.invalid.product", "Product Required");
		
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
        
	
		try {
			ProductDefination pd = productDAO.get(newProduct.getProductName());
			if(pd !=null)
				errors.rejectValue("productName", "error.invalid.product", "Product already Exists");
			
		} catch (ProductException e) {
			System.err.println("Exception in Product Validator");
		}
		
		
		
	
	}


}
