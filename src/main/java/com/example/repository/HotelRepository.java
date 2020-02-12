package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * Hotelsテーブルを操作するリポジトリ.
 * @author tanaami
 *
 */
@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Hotel> Hotel_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
	    hotel.setNearestStation(rs.getString("nearest_station"));
	    hotel.setPrice(rs.getInt("price"));
	    hotel.setParking(rs.getString("parking"));
	    
	    return hotel;
	};
	
	/**
	 * ホテル全件検索を行うメソッド.
	 * @return　全件ホテル情報
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels;";
		List<Hotel> hotelList = template.query(sql, Hotel_ROW_MAPPER);
		return hotelList;
	}
	
	/**
	 * ホテル価格帯によって検索されるメソッド.
	 * @param price 検索するホテル価格
	 * @return　価格検索された該当するホテル情報
	 */
	public List<Hotel> findByPrice(Integer price) {
		String sql ="SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelPriceList = template.query(sql, param, Hotel_ROW_MAPPER);
		
		return hotelPriceList;
	}
}