package com.kh.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.shop.service.CartService;
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

}
