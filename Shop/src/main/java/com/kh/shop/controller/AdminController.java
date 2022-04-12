package com.kh.shop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;import com.kh.shop.service.CartService;
import com.kh.shop.service.ItemService;
import com.kh.shop.vo.BuyItemVO;
import com.kh.shop.vo.ImageVO;
import com.kh.shop.vo.ItemVO;
import com.kh.shop.vo.PagingVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name="itemService")
	private ItemService itemService;
	
	@GetMapping("/regItem")
	public String regItem(String cateType, HttpSession session) {
		if (backHome(session)) return "redirect:/item/itemList";
		
		if (cateType != null) {
			session.setAttribute("cateType", cateType);
		}
		return "admin/reg_item";
	}
	
	@PostMapping("/insertItem")
	@ResponseBody
	public void insertItem(ItemVO item, MultipartHttpServletRequest multi, HttpSession session) {
		// 이미지를 첨부 할 객체 생성
		ImageVO img= new ImageVO(new ArrayList<>());
		List<ImageVO> list = img.getImgList();
		
		// 이미지 첨부(파일 업로드)
		// 첨부파일이 들어가는 input 태그들의 name 속성 값을 가져온다.
		Iterator<String> inputTagNames = multi.getFileNames();
		
		// 첨부파일이 저장될 위치 지정
		String uploadPath = "C:\\Git\\workspaceSTS\\Shop\\src\\main\\webapp\\resources\\images\\";
		
		// 첨부파일이 들어간 input 태그의 개수만큼 반복
		while (inputTagNames.hasNext()) {
			// "mainImg", "subImg"
			String inputTagName = inputTagNames.next();
			
			if (inputTagName.equals("subImg")) { 	// 다중첨부
				List<MultipartFile> fileList = multi.getFiles(inputTagName);
				
				for (MultipartFile file : fileList) {
					// 첨부 파일이 있을 때
					if (!file.getOriginalFilename().equals("")) {
						// 원본파일명
						String originFileName = file.getOriginalFilename();
						
						// 첨부파일명
						String attachedFileName = System.currentTimeMillis() + "_" + originFileName;
						
						// 파일 업로드
						// 매개변수로 경로 및 파일명을 넣어줌
						try {
							// 서버에 파일 업로드
							file.transferTo(new File(uploadPath + attachedFileName));
							
							// DB에 파일 업로드
							list.add(new ImageVO(originFileName, attachedFileName, "N"));
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			} else { // 단일 첨부
				// name이 "mainImg"인 input 태그의 파일 정보를 가져 옴.
				MultipartFile file = multi.getFile(inputTagName);
				
				// 첨부 파일이 있을 때
				if (!file.getOriginalFilename().equals("")) {
					// 원본파일명
					String originFileName = file.getOriginalFilename();
					
					// 첨부파일명
					String attachedFileName = System.currentTimeMillis() + "_" + originFileName;
					
					// 파일 업로드
					// 매개변수로 경로 및 파일명을 넣어줌
					try {
						// 서버에 파일 업로드
						file.transferTo(new File(uploadPath + attachedFileName));
						
						// DB에 파일 업로드
						list.add(new ImageVO(originFileName, attachedFileName, "Y"));
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		// 상품 정보 INSERT (SHOP_ITEM)
		if (list.size() != 0) {
			itemService.insertItem(item, img);
		} else {
			itemService.insertItem(item);
		}
	}
	
	@GetMapping("/editItem")
	public String editItem(Model model, HttpSession session) {
		if (backHome(session)) return "redirect:/item/itemList";
		model.addAttribute("itemList", itemService.selectItemList(""));
		return "admin/item_manage";
	}
	
	/*
	 * @GetMapping("/buyList") public String buyList(BuyItemVO buyItem, Model model,
	 * HttpSession session) { if (backHome(session)) return
	 * "redirect:/item/itemList";
	 * 
	 * String today = new
	 * SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	 * 
	 * if (buyItem.getBeforeDate() == null || buyItem.getBeforeDate().equals("")) {
	 * buyItem.setBeforeDate(today.substring(0, today.length() - 2) + "01"); } if
	 * (buyItem.getAfterDate() == null || buyItem.getAfterDate().equals("") ) {
	 * buyItem.setAfterDate(today); }
	 * 
	 * model.addAttribute("buyItem", buyItem); model.addAttribute("buyList",
	 * itemService.selectBuyList(buyItem));
	 * 
	 * return "admin/buy_list"; }
	 */
	
	@GetMapping("/buyList")
	public String buyList(BuyItemVO buyItem, String nowPage, Model model, HttpSession session) {
		if (backHome(session)) return "redirect:/item/itemList";
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		if (buyItem.getBeforeDate() == null || buyItem.getBeforeDate().equals("")) {
			buyItem.setBeforeDate(today.substring(0, today.length() - 2) + "01");
		}
		if (buyItem.getAfterDate() == null || buyItem.getAfterDate().equals("") ) {
			buyItem.setAfterDate(today);
		}

		int total = itemService.countBuyItem(buyItem);
		
		if (nowPage == null) {
			nowPage = "1";
		}
		
		buyItem.setPaging(new PagingVO(total, Integer.parseInt(nowPage), 10));
		
		model.addAttribute("buyItem", buyItem);
		model.addAttribute("buyList", itemService.selectBuyItemListPaging(buyItem));
		
		return "admin/buy_list";
	}
	
	@GetMapping("/buyOrderInfo")
	@ResponseBody
	public List<BuyItemVO> buyOrderInfo(String orderNum) {
		return itemService.selectOrderInfo(orderNum);
	}
	
	@GetMapping("/editCate")
	public String editCate(HttpSession session) {
		if (backHome(session)) return "redirect:/item/itemList";
		return "admin/category_manage";
	}
	
	@GetMapping("/editMember")
	public String editMember(HttpSession session) {
		if (backHome(session)) return "redirect:/item/itemList";
		return "admin/member_manage";
	}
	
	boolean backHome(HttpSession session) {
		return session.getAttribute("login") == null ? true : false;
	}
}
