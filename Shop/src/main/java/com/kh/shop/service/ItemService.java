package com.kh.shop.service;

import java.util.List;

import com.kh.shop.vo.BuyItemVO;
import com.kh.shop.vo.CategoryVO;
import com.kh.shop.vo.ImageVO;
import com.kh.shop.vo.ItemVO;
import com.kh.shop.vo.PagingVO;

public interface ItemService {
	
	// 도서 목록 조회
	List<ItemVO> selectItemList(String cateType);
	
	// 카테고리 목록 조회
	List<CategoryVO> selectCategoryList();
	
	// 도서 등록(이미지 없음)
	void insertItem(ItemVO item);
	
	// 도서 등록(이미지 있음)
	void insertItem(ItemVO item, ImageVO image);
	
	// 도서 조회
	ItemVO selectItemOne(String itemCode);

	// 상품구매 목록 조회
	List<BuyItemVO> selectBuyList(BuyItemVO buyItem);

	// 상품구매 상세 조회
	List<BuyItemVO> selectOrderInfo(String orderNum);
	
	// 상품 총 갯수
	int countItem(String cateType);
	
	// 페이징 처리 게시글 조회
	List<ItemVO> selectItemListPaging(PagingVO paging);
	
	// 상품 총 갯수
	int countBuyItem(BuyItemVO buyItem);
	
	// 페이징 처리 게시글 조회
	List<BuyItemVO> selectBuyItemListPaging(BuyItemVO buyItem);
	
}
