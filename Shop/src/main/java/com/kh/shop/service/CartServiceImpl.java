package com.kh.shop.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.shop.vo.BuyItemVO;
import com.kh.shop.vo.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CartVO> selectCartList(String memId) {
		return sqlSession.selectList("cartMapper.selectCartList", memId);
	}

	@Override
	public void insertCart(CartVO cart) {
		sqlSession.insert("cartMapper.insertCart", cart);
	}

	@Override
	public void deleteCart(String cartNum) {
		sqlSession.delete("cartMapper.deleteCart", cartNum);
	}

	@Override
	public void updateCart(CartVO cart) {
		sqlSession.update("cartMapper.updateCart", cart);
	}

	@Override
	public void deleteCartList(String[] deleteList) {
		sqlSession.delete("cartMapper.deleteCartList", deleteList);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void buyItemList(BuyItemVO[] itemList, String[] cartList) {
		sqlSession.insert("cartMapper.buyItemList", itemList);
		sqlSession.update("cartMapper.updateBuyCart", cartList);
	}

	@Override
	public void buyItem(BuyItemVO item) {
		sqlSession.insert("cartMapper.buyItem", item);
	}

}
