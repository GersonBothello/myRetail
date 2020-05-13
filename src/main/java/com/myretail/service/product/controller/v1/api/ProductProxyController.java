package com.myretail.service.product.controller.v1.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.myretail.service.product.dto.model.ProductProxyDto;

/**
 * Retrieves the Product information for a external service.
 * 
 * @author Gerson Bothello
 *
 */
@FeignClient(name="product-service", url="https://redsky.target.com") 
public interface ProductProxyController {
	
	/**
	 * Gets the product information. 
	 * @param the Product Id
	 * @return A object that maps to the JSON response. 
	 */
	@GetMapping("/v2/pdp/tcin/{id}")
	public ProductProxyDto retrieveProduct(@PathVariable("id")  int id);
	
}
