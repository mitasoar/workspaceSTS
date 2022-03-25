package com.kh.shop.service;

import java.util.List;

import com.kh.shop.vo.CartVO;

public interface CartService {
	// 장바구니 조회
	List<CartVO> selectCartList(String memId);
	
	// 장바구니 등록
	void insertCart(CartVO cart);
}
