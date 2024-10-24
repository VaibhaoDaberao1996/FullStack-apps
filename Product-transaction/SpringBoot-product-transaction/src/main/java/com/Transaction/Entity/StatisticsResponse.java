package com.Transaction.Entity;

public class StatisticsResponse {

	private double totalSaleAmount;
	private int totalSoldItems;
	private int totalNotSoldItems;

	
	public double getTotalSaleAmount() {
		return totalSaleAmount;
	}

	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}

	public int getTotalSoldItems() {
		return totalSoldItems;
	}

	public void setTotalSoldItems(int totalSoldItems) {
		this.totalSoldItems = totalSoldItems;
	}

	public int getTotalNotSoldItems() {
		return totalNotSoldItems;
	}

	public void setTotalNotSoldItems(int totalNotSoldItems) {
		this.totalNotSoldItems = totalNotSoldItems;
	}

	@Override
	public String toString() {
		return "StatisticsResponse [totalSaleAmount=" + totalSaleAmount + ", totalSoldItems=" + totalSoldItems
				+ ", totalNotSoldItems=" + totalNotSoldItems + "]";
	}
	
	

}
