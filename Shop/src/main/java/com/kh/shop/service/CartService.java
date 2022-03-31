package com.kh.shop.service;

import java.util.List;

import com.kh.shop.vo.BuyItemVO;
import com.kh.shop.vo.CartVO;

public interface CartService {
	// 장바구니 조회
	List<CartVO> selectCartList(String memId);
	
	// 장바구니 등록
	void insertCart(CartVO cart);
	
	// 장바구니 변경
	void updateCart(CartVO cart);
	
	// 장바구니 삭제
	void deleteCart(String cartNum);
	
	// 장바구니 선택삭제
	void deleteCartList(String[] deleteList);
	
	// 장바구니 구매등록
	void buyItemList(BuyItemVO[] itemList, String[] cartList);

	// 바로구매
	void buyItem(BuyItemVO item);
	
}
