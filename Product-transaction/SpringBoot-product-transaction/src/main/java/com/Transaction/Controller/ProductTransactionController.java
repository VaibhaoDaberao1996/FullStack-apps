package com.Transaction.Controller;

import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Transaction.Entity.ProductTransaction;
import com.Transaction.Entity.StatisticsResponse;
import com.Transaction.Service.ProductTransactionService;

@RestController
@RequestMapping("/api/productsTransactions")
public class ProductTransactionController {
	
	@Autowired
	private ProductTransactionService productTransactionService;

	//Fetch and save the data from third party API url
	@GetMapping("/initialize")
	public ResponseEntity<String> initializeProductTransaction(){
	String intializeTransactionData = productTransactionService.intializeTransactionData();
	 return ResponseEntity.ok(intializeTransactionData);
		
	}
	
	@GetMapping("/getAll")
    public ResponseEntity<Page<ProductTransaction>> getAllTransactions(
        @RequestParam(value = "search", required = false) String search,
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "per_page", defaultValue = "10") int perPage
    ) {
        // Call service to get the paginated transactions with optional search
        Page<ProductTransaction> result =productTransactionService.getProdTransactions(search, page, perPage);
        return ResponseEntity.ok(result);
    }
	
	@GetMapping("/getStatistics")
    public ResponseEntity<StatisticsResponse> getStatistics(
            @RequestParam(value = "month") String month) {
         // Parse the month string to a Month enum
		System.out.println(month);
        Month monthEnum = Month.valueOf(month.toUpperCase());
        System.out.println(monthEnum);
        StatisticsResponse statistics = productTransactionService.calculateStatistics(monthEnum);
        return ResponseEntity.ok(statistics);
    }
}
