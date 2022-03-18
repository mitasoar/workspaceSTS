package com.kh.shop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.shop.service.ItemService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name="itemService")
	private ItemService itemService;
	
	@GetMapping("/regItem")
	public String regItem(Model model) {
		model.addAttribute("categoryList", itemService.selectCategoryList());
		return "admin/reg_item";
	}
}
