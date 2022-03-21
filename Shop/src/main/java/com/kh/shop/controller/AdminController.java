package com.kh.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.shop.service.ItemService;
import com.kh.shop.vo.ItemVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name="itemService")
	private ItemService itemService;
	
	@GetMapping("/regItem")
	public String regItem(Model model, String cateType, HttpSession session) {
		model.addAttribute("categoryList", itemService.selectCategoryList());
		if (cateType != null) {
			session.setAttribute("cateType", cateType);
		}
		return "admin/reg_item";
	}
	
	@PostMapping("/insertItem")
	@ResponseBody
	public void insertItem(ItemVO item) {
		itemService.insertItem(item);
	}
	
	@GetMapping("/editItem")
	public String editItem() {
		return "admin/item_manage";
	}
	
	@GetMapping("/editCate")
	public String editCate() {
		return "admin/category_manage";
	}
	
	@GetMapping("/editMember")
	public String editMember() {
		return "admin/member_manage";
	}
}
