package com.kh.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.shop.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource(name="itemService")
	private ItemService itemService;
	
	@GetMapping("/itemList")
	public String itemList(Model model, String cateType, HttpSession session) {
		model.addAttribute("categoryList", itemService.selectCategoryList());
		session.setAttribute("cateType", cateType);
		session.setMaxInactiveInterval(-1);
		return "item/item_list";
	}

}
