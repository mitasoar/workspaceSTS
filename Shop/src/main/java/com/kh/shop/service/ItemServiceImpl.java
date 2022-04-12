package com.kh.shop.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.shop.vo.BuyItemVO;
import com.kh.shop.vo.CategoryVO;
import com.kh.shop.vo.ImageVO;
import com.kh.shop.vo.ItemVO;
import com.kh.shop.vo.PagingVO;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private SqlSessionTemplate sqlSession; 

	@Override
	public void insertItem(ItemVO item) {
		sqlSession.insert("itemMapper.insertItem", item);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertItem(ItemVO item, ImageVO image) {
		sqlSession.insert("itemMapper.insertItem", item);
		sqlSession.insert("itemMapper.insertImages", image);
	}
	
	@Override
	public List<CategoryVO> selectCategoryList() {
		return sqlSession.selectList("itemMapper.selectCategoryList");
	}

	@Override
	public List<ItemVO> selectItemList(String cateType) {
		return sqlSession.selectList("itemMapper.selectItemList", cateType);
	}

	@Override
	public ItemVO selectItemOne(String itemCode) {
		return sqlSession.selectOne("itemMapper.selectItemDetail", itemCode);
	}

	@Override
	public List<BuyItemVO> selectBuyList(BuyItemVO buyItem) {
		return sqlSession.selectList("cartMapper.selectBuyList", buyItem);
	}

	@Override
	public List<BuyItemVO> selectOrderInfo(String orderNum) {
		return sqlSession.selectList("cartMapper.selectOrderInfo", orderNum);
	}

	@Override
	public int countItem(String cateType) {
		return sqlSession.selectOne("itemMapper.countItem", cateType);
	}

	@Override
	public List<ItemVO> selectItemListPaging(PagingVO paging) {
		return sqlSession.selectList("itemMapper.selectItemListPaging", paging);
	}

	@Override
	public int countBuyItem(BuyItemVO buyItem) {
		return sqlSession.selectOne("cartMapper.countBuyItem", buyItem);
	}

	@Override
	public List<BuyItemVO> selectBuyItemListPaging(BuyItemVO buyItem) {
		return sqlSession.selectList("cartMapper.selectBuyItemListPaging", buyItem);
	}
	
}
