package com.Transaction.Entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ProductTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String title;
	
	private double price;
	
	@Lob
	private String description;
	
	private String category;
	
	private String image;
	
	private boolean sold;
	
	private OffsetDateTime dateOfSale;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public OffsetDateTime getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(OffsetDateTime dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	@Override
	public String toString() {
		return "ProductTransaction [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", category=" + category + ", image=" + image + ", sold=" + sold + ", dateOfSale=" + dateOfSale + "]";
	}
	
	
}
