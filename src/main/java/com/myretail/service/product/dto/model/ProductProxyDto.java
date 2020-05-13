package com.myretail.service.product.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductProxyDto {
	
	@JsonProperty("product")
	private ProductDetailsDto product;

	
	public ProductProxyDto() {
		super();
	}

	public ProductProxyDto(ProductDetailsDto product) {
		super();
		this.product = product;
	}

	public ProductDetailsDto getProduct() {
		return product;
	}

	public void setProduct(ProductDetailsDto product) {
		this.product = product;
	}


}
