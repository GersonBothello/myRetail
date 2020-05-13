package com.myretail.service.product.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.myretail.service.product.dto.model.ProductPriceEntity;


/**
 * Makes a connection to a Cassandra database.
 * Provides an interface to perform CRUD operations on the DB objects.
 *   
 * @author Gerson Bothello
 *
 */
@Repository
public interface ProductPriceRepository extends CassandraRepository<ProductPriceEntity, Integer> {
	
}
