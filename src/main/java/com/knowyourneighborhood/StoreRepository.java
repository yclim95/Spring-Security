package com.knowyourneighborhood;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.knowyourneighborhood.model.Store;


public interface StoreRepository extends CrudRepository<Store,Long>{
	@Query(value = "SELECT c FROM Store c WHERE c.name LIKE '%' || :keyword || '%'"

	+ " OR c.phoneNumber LIKE '%' || :keyword || '%'"
	+ " OR c.localities LIKE '%' || :keyword || '%'")
	public List<Store> search(@Param("keyword") String keyword);
}
