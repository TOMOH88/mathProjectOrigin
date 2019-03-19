package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private Date registDate;
	private Date lastModified;
	private int branchNo;
	
	public Member() {}

	public Member(String userId, String userPwd, String userName, String phone, Date registDate, Date lastModified,
			int branchNo) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.registDate = registDate;
		this.lastModified = lastModified;
		this.branchNo = branchNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return userId + ", " + userPwd + ", " + userName + ", " + phone + ", " + registDate + ", " + lastModified + ", "
				+ branchNo;
	}
	
	
}
