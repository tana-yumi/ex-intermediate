package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル検索結果を操作するサービス.
 * @author tanaami
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
//    public List<Hotel> showAll() {
//    	List<Hotel> hotelList1 = hotelRepository.findAll();
//    	return hotelList1;
//	}
//    public List<Hotel> showSelectPrice(Integer price) {
//    	List<Hotel> hotelList2 = hotelRepository.findByPrice(price);
//    	return hotelList2;
//    }
    
    /**
     * 検索結果によって条件分岐するメソッド
     * @param price　ホテル価格
     * @return　検索された価格に該当するホテル情報
     */
    public List<Hotel> hotel(String price){
    	List<Hotel> hotelList = new ArrayList<>();
    	if(price.equals("")) {
    		hotelList = hotelRepository.findAll();
        	return hotelList;
    	}else {
    		 hotelList = hotelRepository.findByPrice(Integer.parseInt(price));
        	return hotelList;
    	}
    }
	
}
