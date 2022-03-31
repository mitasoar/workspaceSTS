package com.kh.shop.vo;

import java.util.Objects;

public class CartVO {
	private String cartNum, memId, itemCode, itemCnt, createDate, totalPrice, isBuy;
	private ItemVO item;
	
	public CartVO() {
		super();
	}
	
	public CartVO(String cartNum, String memId, String itemCode, String itemCnt) {
		super();
		this.cartNum = cartNum;
		this.memId = memId;
		this.itemCode = itemCode;
		this.itemCnt = itemCnt;
	}

	public CartVO(String cartNum, String memId, String itemCode, String itemCnt, String totalPrice) {
		super();
		this.cartNum = cartNum;
		this.memId = memId;
		this.itemCode = itemCode;
		this.itemCnt = itemCnt;
		this.totalPrice = totalPrice;
	}
	
	public CartVO(String cartNum, String memId, String itemCode, String itemCnt, String createDate, String totalPrice,
			String isBuy) {
		super();
		this.cartNum = cartNum;
		this.memId = memId;
		this.itemCode = itemCode;
		this.itemCnt = itemCnt;
		this.createDate = createDate;
		this.totalPrice = totalPrice;
		this.isBuy = isBuy;
	}

	public String getIsBuy() {
		return isBuy;
	}

	public void setIsBuy(String isBuy) {
		this.isBuy = isBuy;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ItemVO getItem() {
		return item;
	}

	public void setItem(ItemVO item) {
		this.item = item;
	}

	public String getCartNum() {
		return cartNum;
	}

	public void setCartNum(String cartNum) {
		this.cartNum = cartNum;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemCnt() {
		return itemCnt;
	}

	public void setItemCnt(String itemCnt) {
		this.itemCnt = itemCnt;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
