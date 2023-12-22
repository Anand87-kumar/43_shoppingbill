package com.anand.entity;

import jakarta.persistence.*;

@Entity
public class ShoppingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private double price;
    private int quantity;
    private double totalPriceWithGST;

	/*
	 * @Transient private double totalPriceWithGST; // This field won't be persisted
	 * in the database
	 */
    public ShoppingItem() {
        super();
    }

    public ShoppingItem(Long id, String itemName, double price, int quantity) {
        super();
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.totalPriceWithGST = calculateTotalPriceWithGST();
    }

    // Getters and setters...

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPriceWithGST() {
		return totalPriceWithGST;
	}

	public void setTotalPriceWithGST(double totalPriceWithGST) {
		this.totalPriceWithGST = totalPriceWithGST;
	}
	// Method to calculate total price including GST
    public double calculateTotalPriceWithGST() {
        // Assuming GST is 18% (you can change this value according to your requirement)
        double gstRate = 0.18;
        double totalPrice = this.price * this.quantity;
        return totalPrice + (totalPrice * gstRate);
    }
	@Override
	public String toString() {
		return "ShoppingItem [id=" + id + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity
				+ ", totalPriceWithGST=" + totalPriceWithGST + "]";
	}

	

    
}
