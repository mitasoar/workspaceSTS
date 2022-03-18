package com.kh.shop.vo;

import java.util.Objects;

public class CategoryVO {
	private String cateCode, cateName;

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cateCode, cateName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryVO other = (CategoryVO) obj;
		return Objects.equals(cateCode, other.cateCode) && Objects.equals(cateName, other.cateName);
	}

	@Override
	public String toString() {
		return "CategoryVO [cateCode=" + cateCode + ", cateName=" + cateName + "]";
	}
	
}
