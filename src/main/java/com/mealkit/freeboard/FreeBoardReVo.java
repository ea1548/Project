package com.mealkit.freeboard;

import java.util.Date;

public class FreeBoardReVo {
	private int free_no;
	private int free_reply_no;
	private String free_reply_content;
	private String member_id;
	private Date free_reply;
	
	public FreeBoardReVo() {}
	
	public FreeBoardReVo(int free_no, int free_reply_no, String free_reply_content, String member_id, Date free_reply) {
		super();
		this.free_no = free_no;
		this.free_reply_no = free_reply_no;
		this.free_reply_content = free_reply_content;
		this.member_id = member_id;
		this.free_reply = free_reply;
	}
	@Override
	public String toString() {
		return "FreeBoardReVo [free_no=" + free_no + ", free_reply_no=" + free_reply_no + ", free_reply_content="
				+ free_reply_content + ", member_id=" + member_id + ", free_reply=" + free_reply + "]";
	}
	public int getFree_no() {
		return free_no;
	}
	public void setFree_no(int free_no) {
		this.free_no = free_no;
	}
	public int getFree_reply_no() {
		return free_reply_no;
	}
	public void setFree_reply_no(int free_reply_no) {
		this.free_reply_no = free_reply_no;
	}
	public String getFree_reply_content() {
		return free_reply_content;
	}
	public void setFree_reply_content(String free_reply_content) {
		this.free_reply_content = free_reply_content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getFree_reply() {
		return free_reply;
	}
	public void setFree_reply(Date free_reply) {
		this.free_reply = free_reply;
	}
	
}
