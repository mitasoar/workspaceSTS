package com.kh.shop.vo;

import java.util.List;
import java.util.Objects;

public class ItemVO {
	private String itemCode, itemName, itemPrice, itemDetail, itemStock, cateCode, attachedImgName;
	private List<ImageVO> imageList;
	
	public ItemVO() {
		super();
	}
	
	public ItemVO(String itemName, String itemPrice, String itemDetail, String cateCode) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDetail = itemDetail;
		this.cateCode = cateCode;
	}

	public ItemVO(String itemCode, String itemName, String itemPrice, String itemDetail, String itemStock,
			String cateCode) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDetail = itemDetail;
		this.itemStock = itemStock;
		this.cateCode = cateCode;
	}

	public ItemVO(String itemCode, String itemName, String itemPrice, String itemDetail, String itemStock,
			String cateCode, String attachedImgName) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDetail = itemDetail;
		this.itemStock = itemStock;
		this.cateCode = cateCode;
		this.attachedImgName = attachedImgName;
	}

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

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getAttachedImgName() {
		return attachedImgName;
	}

	public void setAttachedImgName(String attachedImgName) {
		this.attachedImgName = attachedImgName;
	}

	public List<ImageVO> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageVO> imageList) {
		this.imageList = imageList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attachedImgName, cateCode, itemCode, itemDetail, itemName, itemPrice, itemStock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVO other = (ItemVO) obj;
		return Objects.equals(attachedImgName, other.attachedImgName) && Objects.equals(cateCode, other.cateCode)
				&& Objects.equals(itemCode, other.itemCode) && Objects.equals(itemDetail, other.itemDetail)
				&& Objects.equals(itemName, other.itemName) && Objects.equals(itemPrice, other.itemPrice)
				&& Objects.equals(itemStock, other.itemStock);
	}

	@Override
	public String toString() {
		return "ItemVO [itemCode=" + itemCode + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemDetail="
				+ itemDetail + ", itemStock=" + itemStock + ", cateCode=" + cateCode + ", attachedImgName=" + attachedImgName
				+ "]";
	}

}
