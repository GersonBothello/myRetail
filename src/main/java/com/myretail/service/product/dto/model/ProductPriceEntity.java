package com.myretail.service.product.dto.model;

import java.math.BigDecimal;

import javax.validation.constraints.*;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


/**
 * @author Gerson Bothello
 *
 */
@Table(value="product_price")
public class ProductPriceEntity {

	@PrimaryKey(value="product_id")
	@NotNull
	private int productId;
	
	@Column(value = "current_price")
	private BigDecimal currentPrice;
	
	@Column(value = "currency_code")
	private String currencyCode;
	
		
	public ProductPriceEntity(int productId, BigDecimal currentPrice, String currencyCode) {
		super();
		this.productId = productId;
		this.currentPrice = currentPrice;
		this.currencyCode = currencyCode;
	}

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "ProductPriceEntity [productId=" + productId + ", currentPrice=" + currentPrice + ", currencyCode="
				+ currencyCode + "]";
	}
	
		
	
	
}
