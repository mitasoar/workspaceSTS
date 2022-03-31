package com.kh.shop.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.shop.service.CartService;
import com.kh.shop.vo.BuyItemVO;
import com.kh.shop.vo.CartVO;
import com.kh.shop.vo.MemberVO;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource(name="cartService")
	private CartService cartService;
	
	@GetMapping("/cartList")
	public String cartList(HttpSession session, Model model) {
		model.addAttribute("cartList", cartService.selectCartList(((MemberVO)session.getAttribute("login")).getMemId()));
		session.setAttribute("cateType", null);
		return "cart/cart_list";
	}
	
	@PostMapping("/insertCart")
	@ResponseBody
	public void insertCart(CartVO cart) {
		cartService.insertCart(cart);
	}
	
	@PostMapping("/updateCart")
	@ResponseBody
	public void updateCart(CartVO cart) {
		cartService.updateCart(cart);
	}
	
	@PostMapping("/deleteCart")
	@ResponseBody
	public void deleteCart(String cartNum) {
		cartService.deleteCart(cartNum);
	}
	
	@PostMapping("/deleteCartList")
	@ResponseBody
	public void deleteCartList(String[] deleteList) {
		cartService.deleteCartList(deleteList);
	}
	
	@PostMapping("/buyItemList")
	@ResponseBody
	public void buyItemList(@RequestBody BuyItemVO[] itemList, HttpSession session) {
		String memId = ((MemberVO)session.getAttribute("login")).getMemId();
		String orderNum = System.currentTimeMillis() + "_" + memId;
		String[] cartList = new String[itemList.length];
		
		for (int i = 0; i < itemList.length; i++) {
			itemList[i].setMemId(memId);
			itemList[i].setOrderNum(orderNum);
			cartList[i] = itemList[i].getCartNum();
		}
		
		cartService.buyItemList(itemList, cartList);
	}
	
	@PostMapping("/buyItem")
	@ResponseBody
	public void buyItem(BuyItemVO item) {
		item.setOrderNum(System.currentTimeMillis() + "_" + item.getMemId());
		cartService.buyItem(item);
	}
	
}
