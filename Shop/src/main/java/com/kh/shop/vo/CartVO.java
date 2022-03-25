package com.kh.shop.vo;

import java.util.Objects;

public class CartVO {
	private String cartNum, memId, itemCode, itemCnt, createDate, totalPrice;
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

	@Override
	public int hashCode() {
		return Objects.hash(cartNum, createDate, itemCnt, itemCode, memId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartVO other = (CartVO) obj;
		return Objects.equals(cartNum, other.cartNum) && Objects.equals(createDate, other.createDate)
				&& Objects.equals(itemCnt, other.itemCnt) && Objects.equals(itemCode, other.itemCode)
				&& Objects.equals(memId, other.memId);
	}

	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", memId=" + memId + ", itemCode=" + itemCode + ", itemCnt=" + itemCnt
				+ ", createDate=" + createDate + "]";
	}
	
}
