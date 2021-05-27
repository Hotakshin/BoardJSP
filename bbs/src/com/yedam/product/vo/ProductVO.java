package com.yedam.product.vo;

public class ProductVO {
   private String itemCode;
   private String itemName;
   private String itemImage;
   private int price;
   private String itemDesc;
   private int likeIt;
   private String sale;
   private int salePrice;

   public String getItemCode() {
      return itemCode;
   }

   public void setItemCode(String itemCode) {
      this.itemCode = itemCode;
   }

   public String getItemName() {
      return itemName;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   public String getItemImage() {
      return itemImage;
   }

   public void setItemImage(String itemImage) {
      this.itemImage = itemImage;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getItemDesc() {
      return itemDesc;
   }

   public void setItemDesc(String itemDesc) {
      this.itemDesc = itemDesc;
   }

   public int getLikeIt() {
      return likeIt;
   }

   public void setLikeIt(int likeIt) {
      this.likeIt = likeIt;
   }

   public String getSale() {
      return sale;
   }

   public void setSale(String sale) {
      this.sale = sale;
   }

   public int getSalePrice() {
      return salePrice;
   }

   public void setSalePrice(int salePrice) {
      this.salePrice = salePrice;
   }
}