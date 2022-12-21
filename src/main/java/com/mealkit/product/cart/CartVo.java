package com.mealkit.product.cart;

import java.util.List;

public class CartVo {
	
	//장바구니 번호
	private int cart_no;
	
	//상품번호(상품 이름으로 표시)
	private int product_number;
	
	//상품 수량
	private int product_stock;
	
	//상품 가격
	private int product_price;
	
	//배송비
	private int add_charge;
	
	//장바구니 총 금액
	private int cart_total;
	
	//멤버 아이디
	private String member_id;
	
	//상품 이름
	private String product_name;
	
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	
	@Override
	public String toString() {
		return "CartVo [cart_no=" + cart_no + ", product_number=" + product_number + ", product_stock=" + product_stock
				+ ", product_price=" + product_price + ", add_charge=" + add_charge + ", cart_total=" + cart_total
				+ ", member_id=" + member_id + ", product_name=" + product_name + "]";
	}

	public CartVo() {}
	
	public CartVo(int cart_no, int product_number, int product_stock, 
			int add_charge, int cart_total, String member_id, String product_name) {
		this.cart_no = cart_no;
		this.product_number = product_number;
		this.product_stock = product_stock;
		this.add_charge = add_charge;
		this.cart_total = cart_total;
		this.member_id = member_id;
		this.product_name = product_name;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getProduct_number() {
		return product_number;
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getAdd_charge() {
		return add_charge;
	}

	public void setAdd_charge(int add_charge) {
		this.add_charge = add_charge;
	}

	public int getCart_total() {
		return cart_total;
	}

	public void setCart_total(int cart_total) {
		this.cart_total = cart_total;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

}
