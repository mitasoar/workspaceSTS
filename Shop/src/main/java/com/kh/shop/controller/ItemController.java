package com.kh.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.shop.service.ItemService;
import com.kh.shop.vo.ItemVO;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource(name="itemService")
	private ItemService itemService;
	
	@GetMapping("/itemList")
	public String itemList(String cateType, HttpSession session, Model model) {
		if (session.getAttribute("categoryList") == null) {
			session.setAttribute("categoryList", itemService.selectCategoryList());
		} 
		
		if (cateType == null) {
			session.removeAttribute("cateType");
		} else {
			session.setAttribute("cateType", cateType);
		}
		
		if (session.getMaxInactiveInterval() > -1) {
			session.setMaxInactiveInterval(-1);
		}
		
		model.addAttribute("itemList", itemService.selectItemList());
		
		return "item/item_list";
	}
	
	@GetMapping("/itemDetail")
	public String itemDetail(String itemCode, Model model) {
		model.addAttribute("item", itemService.selectItemOne(itemCode));
		return "item/item_detail";
	}

}
