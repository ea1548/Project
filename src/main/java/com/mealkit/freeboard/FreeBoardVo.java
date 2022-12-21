package com.mealkit.freeboard;

import java.sql.Date;

public class FreeBoardVo {
 
	private int free_no;
	private String member_id;
	private String free_board_title;
	private String free_board_content;
	private Date free_board_date;
	
	public FreeBoardVo() {}
	

	public FreeBoardVo(int free_no, String member_id, String free_board_title, String free_board_content,Date free_board_date ) {
		super();
		this.free_no = free_no;
		this.member_id = member_id;
		this.free_board_title = free_board_title;
		this.free_board_content = free_board_content;
		this.free_board_date = free_board_date;
		
	}
	
	@Override
	public String toString() {
		return "FreeBoardVo [free_no=" + free_no + ", member_id=" + member_id + ", free_board_title=" + free_board_title
				+ ", free_board_content=" + free_board_content + ", free_board_date=" + free_board_date + "]";
	}
	public int getFree_no() {
		return free_no;
	}
	public void setFree_no(int free_no) {
		this.free_no = free_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getFree_board_title() {
		return free_board_title;
	}
	public void setFree_board_title(String free_board_title) {
		this.free_board_title = free_board_title;
	}
	public String getFree_board_content() {
		return free_board_content;
	}
	public void setFree_board_content(String free_board_content) {
		this.free_board_content = free_board_content;
	}
	public Date getFree_board_date() {
		return free_board_date;
	}
	public void setFree_board_date(Date free_board_date) {
		this.free_board_date = free_board_date;
	}
}
