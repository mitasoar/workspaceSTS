package com.kh.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.shop.service.ItemService;
import com.kh.shop.vo.ItemVO;
import com.kh.shop.vo.PagingVO;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource(name="itemService")
	private ItemService itemService;
	
	/*
	 * @GetMapping("/itemList") public String itemList(String cateType, HttpSession
	 * session, Model model) { if (session.getAttribute("categoryList") == null) {
	 * session.setAttribute("categoryList", itemService.selectCategoryList()); }
	 * 
	 * if (cateType == null) { session.removeAttribute("cateType"); } else {
	 * session.setAttribute("cateType", cateType); }
	 * 
	 * if (session.getMaxInactiveInterval() > -1) {
	 * session.setMaxInactiveInterval(-1); }
	 * 
	 * model.addAttribute("itemList", itemService.selectItemList(cateType == null ?
	 * "" : cateType));
	 * 
	 * return "item/item_list"; }
	 */
	
	@GetMapping("/itemList")
	public String itemList(String cateType, String nowPage, HttpSession session, Model model) {
		if (session.getAttribute("categoryList") == null) {
			session.setAttribute("categoryList", itemService.selectCategoryList());
		} 
		
		if (cateType != null && cateType.equals("all")) {
			session.removeAttribute("cateType");
			cateType = null;
		} else if (cateType != null) {
			session.setAttribute("cateType", cateType);
		} else if (cateType == null && session.getAttribute("cateType") != null) {
			cateType = (String)session.getAttribute("cateType");
		} 
		
		if (session.getMaxInactiveInterval() > -1) {
			session.setMaxInactiveInterval(-1);
		}
		
		int total = itemService.countItem(cateType);
		
		if (nowPage == null) {
			nowPage = "1";
		}
		
		PagingVO paging = new PagingVO(total, Integer.parseInt(nowPage), 6, cateType);
		
		model.addAttribute("paging", paging);
		model.addAttribute("itemList", itemService.selectItemListPaging(paging));
		
		return "item/item_list";
	}
	
	@GetMapping("/itemDetail")
	public String itemDetail(String itemCode, Model model) {
		model.addAttribute("item", itemService.selectItemOne(itemCode));
		return "item/item_detail";
	}

}
