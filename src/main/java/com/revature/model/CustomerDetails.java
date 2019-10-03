package com.revature.model;

public class CustomerDetails {
	
	private String username;
	private int cid;
	private String pass;
	private String email;
	private long mobno;
	private long actno;
	private String actype;
	private double balance;
	private String pan;
	private long aadhar;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
	public long getActno() {
		return actno;
	}
	public void setActno(long actno) {
		this.actno = actno;
	}
	public String getActype() {
		return actype;
	}
	public void setActype(String actype) {
		this.actype = actype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	
	@Override
	public String toString() {
		return "CustomerDetails [username=" + username + ", cid=" + cid + ", pass=" + pass + ", email=" + email
				+ ", mobno=" + mobno + ", actno=" + actno + ", actype=" + actype + ", balance=" + balance + ", pan="
				+ pan + ", aadhar=" + aadhar + "]";
	}
	
	
	
	

}
