package com.mealkit.infoboard;

import java.util.Date;

public class InfoBoardVo {

	private int info_no;
	private String member_id;
	private String category_code;
	private String info_board_title;
	private String info_board_content;
	private Date info_board_date;
	
	
	//생성자
	public InfoBoardVo() {}
	
	public InfoBoardVo(int info_no, String member_id, String category_code, String info_board_title,
			String info_board_content, Date info_board_date) {
		super();
		this.info_no = info_no;
		this.member_id = member_id;
		this.category_code = category_code;
		this.info_board_title = info_board_title;
		this.info_board_content = info_board_content;
		this.info_board_date = info_board_date;
	}
	
	// 투스트링
	@Override
	public String toString() {
		return "InfoBoardVo [info_no=" + info_no + ", member_id=" + member_id + ", category_code=" + category_code
				+ ", info_board_title=" + info_board_title + ", info_board_content=" + info_board_content
				+ ", info_board_date=" + info_board_date + "]";
	}
	
	//게터세터
	public int getInfo_no() {
		return info_no;
	}
	public void setInfo_no(int info_no) {
		this.info_no = info_no;
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
	public String getInfo_board_title() {
		return info_board_title;
	}
	public void setInfo_board_title(String info_board_title) {
		this.info_board_title = info_board_title;
	}
	public String getInfo_board_content() {
		return info_board_content;
	}
	public void setInfo_board_content(String info_board_content) {
		this.info_board_content = info_board_content;
	}
	public Date getInfo_board_date() {
		return info_board_date;
	}
	public void setInfo_board_date(Date info_board_date) {
		this.info_board_date = info_board_date;
	}
}
