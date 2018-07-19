package com.wt.pro.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.wt.pro.exception.ProductException;
import com.wt.pro.pojo.ProductDefination;

public class ProductDAO extends DAO{
	
	public ProductDefination get(String productName) throws ProductException
	{
		try {
            begin();
            Query q=getSession().createQuery("from product_def where productName= :productName");
            q.setString("productName",productName);
            ProductDefination product=(ProductDefination)q.uniqueResult();
            commit();
            return product;
        } catch (HibernateException e) {
            rollback();
            throw new ProductException("Could not obtain the named product " + productName + " " + e.getMessage());
        }
	}
	
    public List<ProductDefination> list() throws ProductException {
        try {
            begin();
            Query q = getSession().createQuery("from product_def");
            List<ProductDefination> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new ProductException("Could not list the Products", e);
        }
    }

    public ProductDefination create(ProductDefination product) throws ProductException {
        try {
            begin();
            ProductDefination pd = new ProductDefination(product.getProductName());
            pd.setCategory(product.getCategory());
            pd.setCatersTo(product.getCatersTo());
            pd.setUnit(product.getUnit());
            getSession().save(pd);
            commit();
            return pd;
        } catch (HibernateException e) {
            rollback();
            throw new ProductException("Exception while creating Product: " + e.getMessage());
        }
    }
    
    public void update(ProductDefination productDefination) throws ProductException {
        try {
            begin();
            getSession().update(productDefination);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new ProductException("Could not save the product", e);
        }
    }

    public void delete(ProductDefination productDefination) throws ProductException {
        try {
            begin();
            getSession().delete(productDefination);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new ProductException("Could not delete the product", e);
        }
    }



}
