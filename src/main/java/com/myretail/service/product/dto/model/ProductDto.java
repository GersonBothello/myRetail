package com.myretail.service.product.dto.model;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
	
	private int productId;
	private String productName;
		
	private ProductPriceEntity currentPrice;
	
	public ProductDto() {
		super();
		
	}

	public ProductDto(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
		
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Valid
	public ProductPriceEntity getCurrentPrice() {
		return currentPrice;
	}


	public void setCurrentPrice(ProductPriceEntity currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", currentPrice=" + currentPrice
				+ "]";
	}
	
}
