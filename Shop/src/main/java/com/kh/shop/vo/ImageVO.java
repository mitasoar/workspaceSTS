package com.kh.shop.vo;

import java.util.List;
import java.util.Objects;

public class ImageVO {
	private String imgCode, originImgName, attachedImgName, isMain, itemCode;
	private List<ImageVO> imgList;
	
	public ImageVO() {
		super();
	}
	
	public ImageVO(List<ImageVO> imgList) {
		super();
		this.imgList = imgList;
	}

	public ImageVO(String originImgName, String attachedImgName, String isMain) {
		super();
		this.originImgName = originImgName;
		this.attachedImgName = attachedImgName;
		this.isMain = isMain;
	}
	
	public ImageVO(String originImgName, String attachedImgName, String isMain, String itemCode) {
		super();
		this.originImgName = originImgName;
		this.attachedImgName = attachedImgName;
		this.isMain = isMain;
		this.itemCode = itemCode;
	}
	
	public ImageVO(String imgCode, String originImgName, String attachedImgName, String isMain, String itemCode) {
		super();
		this.imgCode = imgCode;
		this.originImgName = originImgName;
		this.attachedImgName = attachedImgName;
		this.isMain = isMain;
		this.itemCode = itemCode;
	}

	public ImageVO(String originImgName, String attachedImgName, String isMain, String itemCode,
			List<ImageVO> imgList) {
		super();
		this.originImgName = originImgName;
		this.attachedImgName = attachedImgName;
		this.isMain = isMain;
		this.itemCode = itemCode;
		this.imgList = imgList;
	}

	public List<ImageVO> getImgList() {
		return imgList;
	}

	public void setImgList(List<ImageVO> imgList) {
		this.imgList = imgList;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public String getOriginImgName() {
		return originImgName;
	}

	public void setOriginImgName(String originImgName) {
		this.originImgName = originImgName;
	}

	public String getAttachedImgName() {
		return attachedImgName;
	}

	public void setAttachedImgName(String attachedImgName) {
		this.attachedImgName = attachedImgName;
	}

	public String getIsMain() {
		return isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attachedImgName, imgCode, isMain, itemCode, imgList, originImgName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageVO other = (ImageVO) obj;
		return Objects.equals(attachedImgName, other.attachedImgName) && Objects.equals(imgCode, other.imgCode)
				&& Objects.equals(isMain, other.isMain) && Objects.equals(itemCode, other.itemCode)
				&& Objects.equals(imgList, other.imgList) && Objects.equals(originImgName, other.originImgName);
	}

	@Override
	public String toString() {
		return "ImageVO [imgCode=" + imgCode + ", originImgName=" + originImgName + ", attachedImgName="
				+ attachedImgName + ", isMain=" + isMain + ", itemCode=" + itemCode + ", imgList=" + imgList + "]";
	}

}
