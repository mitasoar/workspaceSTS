package com.kh.shop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.shop.service.ItemService;
import com.kh.shop.vo.ItemVO;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource(name="itemService")
	private ItemService itemService;
	
	@GetMapping("/itemList")
	public String itemList() {
		return "item/item_list";
	}
	
	@PostMapping("/insertItem")
	public String insertItem(ItemVO item) {
		itemService.insertItem(item);
		return "redirect:/item/itemList";
	}
}
