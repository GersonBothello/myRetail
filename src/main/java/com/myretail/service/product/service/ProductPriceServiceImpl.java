package com.myretail.service.product.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myretail.service.exception.MyRetailExceptionHandler;
import com.myretail.service.product.dto.model.ProductPriceEntity;
import com.myretail.service.product.repository.ProductPriceRepository;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * This class is an implementation for the Product pricing service. It
 * encapsulates all the methods for the Product Price CRUD functionality.
 * 
 * @author Gerson Bothello
 *
 */
@Component
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	private ProductPriceRepository productPriceRepository;

	private Logger logger = LoggerFactory.getLogger(ProductPriceServiceImpl.class);

	/**
	 * Get the pricing data for a product.
	 * 
	 * @param The product ID for which you want to retrieve the pricing data.
	 * @return The ProductPriceEntity object populated with the pricing data for the
	 *         product. Returns a null if no data was found.
	 */
	@Override
	public ProductPriceEntity findById(int productId) {

		try {
			logger.debug("Method Name: 'findById' | Parm (productId): {}", productId);

			Optional<ProductPriceEntity> opt = productPriceRepository.findById(productId);

			if (opt.isPresent()) {
				return opt.get();
			} else {
				return null;
			}
		}

		catch (Exception ex) {
			logger.error("ERROR:", ex);
			return null;
		}

	}

	/**
	 * This method updates the product price data in the database.
	 * 
	 * @param The ProductPriceEntity objects is populated with the data to be
	 *            changed. The Product Id is required.
	 * @return The ProductPriceEntity object with the modified data. Returns a null
	 *         if no data was changed. And returns a HttpStatus of No Content.
	 */
	@Override
	public ProductPriceEntity update(ProductPriceEntity data) {
		try {

			logger.debug("Method Name: 'Update' | Parm (data): {}", data);

			validateBeforeUpdate(data);

			if (productPriceRepository.existsById(data.getProductId())) {
				return productPriceRepository.save(data);
			} else {
				throw new MyRetailExceptionHandler.NoContentException();
			}
		} catch (Exception ex) {
			logger.error("ERROR:", ex);
			return null;
		}
	}

	/**
	 * This method validates the data for the update transaction. *
	 * 
	 * @param The ProductPriceEntity populated with the data to be modified. Throws
	 *            bad request exception when validation fails.
	 */
	public void validateBeforeUpdate(ProductPriceEntity data) {
		if (data.getProductId() <= 0) {
			throw new MyRetailExceptionHandler.BadRequestException("Product ID cannot be 0.");
		} else if (data.getCurrentPrice().compareTo(BigDecimal.valueOf(0)) < 0) {
			throw new MyRetailExceptionHandler.BadRequestException("Price cannot less than 0.");
		} else if (data.getCurrencyCode().isEmpty()) {
			throw new MyRetailExceptionHandler.BadRequestException("Currency code is required.");
		} else if (StringUtils.isBlank(data.getCurrencyCode())) {
			throw new MyRetailExceptionHandler.BadRequestException("Currency code is required.");
		} else if (data.getCurrencyCode().length() < 3 || data.getCurrencyCode().length() > 3) {
			throw new MyRetailExceptionHandler.BadRequestException("Currency code has to be three characters.");
		}

	}

}
