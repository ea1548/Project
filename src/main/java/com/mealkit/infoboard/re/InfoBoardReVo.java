package com.mealkit.infoboard.re;

import java.util.Date;

public class InfoBoardReVo {

	private int info_no;
	private String info_reply_content;
	private String member_id;
	private Date info_reply;
	private int info_reply_no;
	
	public InfoBoardReVo() {}
	
	public InfoBoardReVo(int info_no, String info_reply_content, String member_id, Date info_reply, int info_reply_no) {
		super();
		this.info_no = info_no;
		this.info_reply_content = info_reply_content;
		this.member_id = member_id;
		this.info_reply = info_reply;
		this.info_reply_no = info_reply_no;
	}
	
	//투스트링
	@Override
	public String toString() {
		return "InfoBoardReVo [info_no=" + info_no + ", info_reply_content=" + info_reply_content + ", member_id="
				+ member_id + ", info_reply=" + info_reply + ", info_reply_no=" + info_reply_no + "]";
	}
	
	//개러새러
	public int getInfo_no() {
		return info_no;
	}
	public void setInfo_no(int info_no) {
		this.info_no = info_no;
	}
	public String getInfo_reply_content() {
		return info_reply_content;
	}
	public void setInfo_reply_content(String info_reply_content) {
		this.info_reply_content = info_reply_content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getInfo_reply() {
		return info_reply;
	}
	public void setInfo_reply(Date info_reply) {
		this.info_reply = info_reply;
	}
	public int getInfo_reply_no() {
		return info_reply_no;
	}
	public void setInfo_reply_no(int info_reply_no) {
		this.info_reply_no = info_reply_no;
	}
	
}
