package com.kh.shop.vo;

public class BuyItemVO {
	private String buyNum, memId, itemCode, itemCnt, buyPrice, buyDate, orderNum, cartNum, beforeDate, afterDate, rn;
	private MemberVO member;
	private CartVO cart;
	private PagingVO paging;
	
	public BuyItemVO() {
		super();
	}
	
	public BuyItemVO(String memId, String itemCode, String itemCnt, String buyPrice, String orderNum, String cartNum) {
		super();
		this.memId = memId;
		this.itemCode = itemCode;
		this.itemCnt = itemCnt;
		this.buyPrice = buyPrice;
		this.orderNum = orderNum;
		this.cartNum = cartNum;
	}

	public BuyItemVO(String itemCode, String itemCnt, String buyPrice, String cartNum) {
		super();
		this.itemCode = itemCode;
		this.itemCnt = itemCnt;
		this.buyPrice = buyPrice;
		this.cartNum = cartNum;
	}

	public BuyItemVO(String buyNum, String memId, String itemCode, String itemCnt, String buyPrice, String buyDate,
			String orderNum) {
		super();
		this.buyNum = buyNum;
		this.memId = memId;
		this.itemCode = itemCode;
		this.itemCnt = itemCnt;
		this.buyPrice = buyPrice;
		this.buyDate = buyDate;
		this.orderNum = orderNum;
	}

	public PagingVO getPaging() {
		return paging;
	}

	public void setPaging(PagingVO paging) {
		this.paging = paging;
	}
	
	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public CartVO getCart() {
		return cart;
	}

	public void setCart(CartVO cart) {
		this.cart = cart;
	}

	public String getBeforeDate() {
		return beforeDate;
	}

	public void setBeforeDate(String beforeDate) {
		this.beforeDate = beforeDate;
	}

	public String getAfterDate() {
		return afterDate;
	}

	public void setAfterDate(String afterDate) {
		this.afterDate = afterDate;
	}

	public String getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(String buyNum) {
		this.buyNum = buyNum;
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

	public String getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getCartNum() {
		return cartNum;
	}

	public void setCartNum(String cartNum) {
		this.cartNum = cartNum;
	}

	@Override
	public String toString() {
		return "BuyItemVO [buyNum=" + buyNum + ", memId=" + memId + ", itemCode=" + itemCode + ", itemCnt=" + itemCnt
				+ ", buyPrice=" + buyPrice + ", buyDate=" + buyDate + ", orderNum=" + orderNum + ", cartNum=" + cartNum
				+ ", beforeDate=" + beforeDate + ", afterDate=" + afterDate + "]";
	}
	
}
