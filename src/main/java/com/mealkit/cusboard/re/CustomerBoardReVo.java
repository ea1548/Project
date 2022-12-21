package com.mealkit.cusboard.re;

import java.util.Date;

public class CustomerBoardReVo {

	private int cus_no;
	private String cus_reply_content;
	private Date cus_reply;
	private int customer_reply_no;
	
	
	
	@Override
	public String toString() {
		return "CustomerBoardReVo [cus_no=" + cus_no + ", cus_reply_content=" + cus_reply_content + ", cus_reply="
				+ cus_reply + ", customer_reply_no=" + customer_reply_no + "]";
	}

	public int getCus_no() {
		return cus_no;
	}

	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}

	public String getCus_reply_content() {
		return cus_reply_content;
	}

	public void setCus_reply_content(String cus_reply_content) {
		this.cus_reply_content = cus_reply_content;
	}

	public Date getCus_reply() {
		return cus_reply;
	}

	public void setCus_reply(Date cus_reply) {
		this.cus_reply = cus_reply;
	}

	public int getCustomer_reply_no() {
		return customer_reply_no;
	}

	public void setCustomer_reply_no(int customer_reply_no) {
		this.customer_reply_no = customer_reply_no;
	}

	public CustomerBoardReVo() {}

	public CustomerBoardReVo(int cus_no, String cus_reply_content, Date cus_reply, int customer_reply_no) {
		super();
		this.cus_no = cus_no;
		this.cus_reply_content = cus_reply_content;
		this.cus_reply = cus_reply;
		this.customer_reply_no = customer_reply_no;
	}
	
}
