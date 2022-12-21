package com.mealkit.member;

import java.sql.Date;

public class MemberVo {

	private String member_id;
	private String member_pwd;
	private String member_npwd;
	private String member_name;
	private String member_email;
	private String member_phone;
	private int member_role;
	private Date member_insertdate;
	
	
	@Override
	public String toString() {
		return "MemberVo [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", member_email=" + member_email + ", member_phone=" + member_phone + ", member_role=" + member_role
				+ ", member_insertdate=" + member_insertdate + "]";
	}
	
	public MemberVo() {}
	
	public MemberVo(String member_id, String member_pwd, String member_npwd,  String member_name, String member_email, String member_phone,
			int member_role, Date member_insertdate) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_npwd = member_npwd;
		this.member_name = member_name;
		this.member_email = member_email;
		this.member_phone = member_phone;
		this.member_role = member_role;
		this.member_insertdate = member_insertdate;
	}

	public String getMember_id() {
		return member_id;
	}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public int getMember_role() {
		return member_role;
	}
	public void setMember_role(int member_role) {
		this.member_role = member_role;
	}
	public Date getMember_insertdate() {
		return member_insertdate;
	}
	public void setMember_insertdate(Date member_insertdate) {
		this.member_insertdate = member_insertdate;
	}

	public String getMember_npwd() {
		return member_npwd;
	}

	public void setMember_npwd(String member_npwd) {
		this.member_npwd = member_npwd;
	}

}
