package com.mealkit.cusboard;

import java.util.Date;

public class CustomerBoardVo {

	private int cus_no;
	private String member_id;
	private String category_code;
	private String cus_board_title;
	private String cus_board_content;
	private Date cus_board_date;
	
	public CustomerBoardVo() {}
	
	public CustomerBoardVo(int cus_no, String member_id, String category_code, String cus_board_title,
			String cus_board_content, Date cus_board_date) {
		super();
		this.cus_no = cus_no;
		this.member_id = member_id;
		this.category_code = category_code;
		this.cus_board_title = cus_board_title;
		this.cus_board_content = cus_board_content;
		this.cus_board_date = cus_board_date;
	}
	
	@Override
	public String toString() {
		return "CustomerBoardVo [cus_no=" + cus_no + ", member_id=" + member_id + ", category_code=" + category_code
				+ ", cus_board_title=" + cus_board_title + ", cus_board_content=" + cus_board_content
				+ ", cus_board_date=" + cus_board_date + "]";
	}
	public int getCus_no() {
		return cus_no;
	}
	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getCus_board_title() {
		return cus_board_title;
	}
	public void setCus_board_title(String cus_board_title) {
		this.cus_board_title = cus_board_title;
	}
	public String getCus_board_content() {
		return cus_board_content;
	}
	public void setCus_board_content(String cus_board_content) {
		this.cus_board_content = cus_board_content;
	}
	public Date getCus_board_date() {
		return cus_board_date;
	}
	public void setCus_board_date(Date cus_board_date) {
		this.cus_board_date = cus_board_date;
	}
	
	

}
