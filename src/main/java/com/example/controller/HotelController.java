package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

/**
 * ホテル価格検索を制御するコントローラー.
 * @author tanaami
 *
 */
@Controller
@RequestMapping("/ex02")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	/**
	 * ホテル検索画面.
	 * @return ホテル検索画面に遷移する
	 */
	@RequestMapping("")
	public String index() {
    	return "hotel/hotel";

	}
	
	/**
	 * 検索結果を呼び出すメソッド
	 * @param form リクエストパラメータを受け取るフォーム
	 * @param model リクエストスコープ
	 * @return　検索結果画面
	 */
	@RequestMapping("/showList")
   public String showList(HotelForm form, Model model){
		//System.out.println(form.getPrice());
		List<Hotel> list = hotelService.hotel(form.getPrice());
		
		//System.out.println(list);
		model.addAttribute("list", list);
		return "hotel/hotel";
	}
	
}


