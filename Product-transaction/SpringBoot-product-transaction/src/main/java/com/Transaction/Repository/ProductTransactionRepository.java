package com.Transaction.Repository;

import java.time.Month;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Transaction.Entity.ProductTransaction;

public interface ProductTransactionRepository extends JpaRepository<ProductTransaction, Long> {
	
	// Custom search query for title, description, or price
	@Query(value = "SELECT * FROM product_transaction p WHERE " +
		       "LOWER(p.title) LIKE LOWER(CONCAT('%', :search, '%')) " +
		       "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :search, '%')) " +
		       "OR CAST(p.price AS CHAR) LIKE CONCAT('%', :search, '%')", nativeQuery = true)
		Page<ProductTransaction> searchTransactions(String search, Pageable pageable);

    // Default findAll method for pagination
    Page<ProductTransaction> findAll(Pageable pageable);

    //Get list on basis on the month
    @Query(value ="SELECT * FROM product_transaction t WHERE " +
            "EXTRACT(MONTH FROM t.date_of_sale) = :month",nativeQuery = true)
     List<ProductTransaction> findByMonth(Month month);

}
