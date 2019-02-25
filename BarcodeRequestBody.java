package com.projectbarcode.qrecode_gen;

public class BarcodeRequestBody {

	private String Username;
	private String mobileno;
	private String accountType;
	private String AccountNo;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	public BarcodeRequestBody(String username, String mobileno, String accountType, String accountNo) {
		super();
		Username = username;
		this.mobileno = mobileno;
		this.accountType = accountType;
		AccountNo = accountNo;
	}
	public BarcodeRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
