package com.Transaction.Service;

import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Transaction.Entity.ProductTransaction;
import com.Transaction.Entity.StatisticsResponse;
import com.Transaction.Repository.ProductTransactionRepository;
import com.Transaction.Utils.ApiService;

@Service
public class ProductTransactionService {

	@Autowired
	private ProductTransactionRepository prodTransactionRepo;

	@Autowired
	private ApiService apiService;

	//Fetch-and-save
	public String intializeTransactionData() {
		//fetching the data from apiService storing in the list
		List<ProductTransaction> productTransaction = apiService.fetchTransaction();
		//this will check the data is already intialize or not bi id
		if (!prodTransactionRepo.existsById(1L)) {
			for (ProductTransaction transaction : productTransaction) {
				prodTransactionRepo.save(transaction);
			}
		} else {
			return "Your Database is already initialize";
		}
		return "Your Database is initialize properly";
	}
	
	//getAllTranasaction
	public Page<ProductTransaction> getProdTransactions(String search, int page, int perPage) {
		 // Create Pageable object for pagination
        Pageable pageable = PageRequest.of(page - 1, perPage);  // Page index starts from 0
        
        // Check if search term is present
        if (search != null && !search.isEmpty()) {
            // Perform search based on title, description, or price
            return prodTransactionRepo.searchTransactions(search, pageable);
        }
        // No search term, return paginated data
        return prodTransactionRepo.findAll(pageable);
	}

	
	//getStatistic
	public StatisticsResponse calculateStatistics(Month month) {
		 List<ProductTransaction> transactions = prodTransactionRepo.findByMonth(month);

	        double totalSaleAmount = 0.0;
	        int totalSoldItems = 0;
	        int totalNotSoldItems = 0;

	        for (ProductTransaction transaction : transactions) {
	            if (transaction.isSold()) {
	                totalSoldItems++;
	                totalSaleAmount += transaction.getPrice();
	            } else {
	                totalNotSoldItems++;
	            }
	        }

	        // Create response object
	        StatisticsResponse response = new StatisticsResponse();
	        response.setTotalSaleAmount(totalSaleAmount);
	        response.setTotalSoldItems(totalSoldItems);
	        response.setTotalNotSoldItems(totalNotSoldItems);
	        
	        return response;
	}
}
