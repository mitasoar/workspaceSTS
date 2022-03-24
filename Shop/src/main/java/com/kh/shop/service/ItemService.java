package com.kh.shop.service;

import java.util.List;

import com.kh.shop.vo.CategoryVO;
import com.kh.shop.vo.ImageVO;
import com.kh.shop.vo.ItemVO;

public interface ItemService {
	
	// 도서 목록 조회
	List<ItemVO> selectItemList();
	
	// 카테고리 목록 조회
	List<CategoryVO> selectCategoryList();
	
	// 도서 등록
	void insertItem(ItemVO item);
	
	// 도서 이미지 등록
	void insertImages(ImageVO image);

	// 도서 조회
	ItemVO selectItemOne(String itemCode);
	
}
