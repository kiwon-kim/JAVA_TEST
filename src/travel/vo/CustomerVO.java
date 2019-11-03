package travel.vo;

public class CustomerVO {
	/*
	 * custid number, cname varchar2(20), address varchar2(50), phone number, pwd
	 * number, CONSTRAINT customer_custid_pk primary key(custid)
	 */
   private int custid;
   private String cname;
   private String address;
   private int phone;
   private int pwd;
   
public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public int getPwd() {
	return pwd;
}
public void setPwd(int pwd) {
	this.pwd = pwd;
}
   
}
