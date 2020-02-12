package com.example.form;

/**
 * リクエストパラメータを受け取るフォーム.
 * @author tanaami
 *
 */
public class HotelForm {

	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelForm [price=" + price + "]";
	}

	
}
