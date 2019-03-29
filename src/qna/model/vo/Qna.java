package qna.model.vo;

import java.sql.Date;

public class Qna implements java.io.Serializable{
	private static final long serialVersionUID = 20190318L;
	
	private int qnaNo;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaDate;
	private String originalQname;
	private String renameQname;
	private int parentNo;
	private int answerRef;
	private int qnaLevel;
	private int qnaIndex;
	private String qnaStatus;
	private String userId;
	private String adminId;
	
	public Qna() {}

	public Qna(int qnaNo, String qnaTitle, String qnaContent, Date qnaDate, String originalQname, String renameQname,
			int parentNo, int answerRef, int qnaLevel, int qnaIndex, String qnaStatus, String userId, String adminId) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.originalQname = originalQname;
		this.renameQname = renameQname;
		this.parentNo = parentNo;
		this.answerRef = answerRef;
		this.qnaLevel = qnaLevel;
		this.qnaIndex = qnaIndex;
		this.qnaStatus = qnaStatus;
		this.userId = userId;
		this.adminId = adminId;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getOriginalQname() {
		return originalQname;
	}

	public void setOriginalQname(String originalQname) {
		this.originalQname = originalQname;
	}

	public String getRenameQname() {
		return renameQname;
	}

	public void setRenameQname(String renameQname) {
		this.renameQname = renameQname;
	}

	public int getParentNo() {
		return parentNo;
	}

	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}

	public int getAnswerRef() {
		return answerRef;
	}

	public void setAnswerRef(int answerRef) {
		this.answerRef = answerRef;
	}

	public int getQnaLevel() {
		return qnaLevel;
	}

	public void setQnaLevel(int qnaLevel) {
		this.qnaLevel = qnaLevel;
	}

	public int getQnaIndex() {
		return qnaIndex;
	}

	public void setQnaIndex(int qnaIndex) {
		this.qnaIndex = qnaIndex;
	}

	public String getQnaStatus() {
		return qnaStatus;
	}

	public void setQnaStatus(String qnaStatus) {
		this.qnaStatus = qnaStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return qnaNo + ", " + qnaTitle + ", " + qnaContent + ", " + qnaDate + ", " + originalQname + ", " + renameQname
				+ ", " + parentNo + ", " + answerRef + ", " + qnaLevel + ", " + qnaIndex + ", " + qnaStatus + ", "
				+ userId + ", " + adminId;
	}
	
}
