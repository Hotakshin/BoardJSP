package com.yedam.common;

public class CartVO {

	private String userId ;
	private String itemCode;
	private int qty;
	private String itemName;
	private String item_Image;
	private int price;
	private int saleprice;
	private String itemDESC;
	private int likeit;
	private String sale;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItem_Image() {
		return item_Image;
	}
	public void setItem_Image(String item_Image) {
		this.item_Image = item_Image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public String getItemDESC() {
		return itemDESC;
	}
	public void setItemDESC(String itemDESC) {
		this.itemDESC = itemDESC;
	}
	public int getLikeit() {
		return likeit;
	}
	public void setLikeit(int likeit) {
		this.likeit = likeit;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	
	
}
