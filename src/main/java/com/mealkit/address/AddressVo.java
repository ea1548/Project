package com.mealkit.address;

public class AddressVo {

	private String member_id;
	private String member_address1;
	private String member_address2;
	private String member_address3;
	private int member_address_no;
	
	

	
	@Override
	public String toString() {
		return "AddressVo [member_id=" + member_id + ", member_address1=" + member_address1 + ", member_address2="
				+ member_address2 + ", member_address3=" + member_address3 + ", member_address_no=" + member_address_no
				+ "]";
	}

	public AddressVo() {}
	
	public AddressVo(int member_address_no, String member_id, String member_address1, String member_address2, String member_address3) {
		this.member_address_no = member_address_no;
		this.member_id = member_id;
		this.member_address1 = member_address1;
		this.member_address2 = member_address2;
		this.member_address3 = member_address3;
	}
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public String getMember_address1() {
		return member_address1;
	}
	public void setMember_address1(String member_address1) {
		this.member_address1 = member_address1;
	}
	public String getMember_address2() {
		return member_address2;
	}
	public void setMember_address2(String member_address2) {
		this.member_address2 = member_address2;
	}
	public String getMember_address3() {
		return member_address3;
	}
	public void setMember_address3(String member_address3) {
		this.member_address3 = member_address3;
	}
	
	public int getMember_address_no() {
		return member_address_no;
	}
	public void setMember_address_no(int member_address_no) {
		this.member_address_no = member_address_no;
	}


	
}
