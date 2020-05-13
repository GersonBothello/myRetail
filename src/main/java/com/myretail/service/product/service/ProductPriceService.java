package com.myretail.service.product.service;

import com.myretail.service.product.dto.model.ProductPriceEntity;


/**
 * This is an interface for the product price. 
 * It exposes the CRUD method for the entity.   
 * 
 * @author Gerson Bothello
 *
 */
public interface ProductPriceService {
	
	/**
	 * Get the Price date for the product ID.
	 * 
	 * @param The Product ID for which you want the pricing data. 
	 * @return The price entity object with the Data.  
	 */
	ProductPriceEntity findById(int productId);
		
	
	/**
	 * Update the price data for a product.
	 * 
	 * @param The entity object with the modified data. The product ID is required. 
	 * @return The entity object with the modified data. Returns a null if no data was changed.   
	 */
	ProductPriceEntity update(ProductPriceEntity data);
		
}
