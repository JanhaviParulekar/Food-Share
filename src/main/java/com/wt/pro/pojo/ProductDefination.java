package com.wt.pro.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_def")
public class ProductDefination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId",unique=true, nullable = false)
	private long productId;
	
	@Column(name="productName",unique=true,nullable=false)
	private String productName;
	
	@Column(name="category")
	private String category;
	
	@Column(name="catersTo")
	private String catersTo;
	
	@Column(name="unit")
	private String unit;
	
	public ProductDefination()
	{
		
	}
	
	public ProductDefination(String productName)
	{
		this.productName=productName;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCatersTo() {
		return catersTo;
	}

	public void setCatersTo(String catersTo) {
		this.catersTo = catersTo;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
}
