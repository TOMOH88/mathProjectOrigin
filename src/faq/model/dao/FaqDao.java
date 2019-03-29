package faq.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import faq.model.vo.Faq;
import static common.JDBCTemplate.*;
public class FaqDao {
	
	public FaqDao() {}
	
	public ArrayList<Faq> searchAllList(String searchTitle, String fOption, int currentPage, int limit, Connection conn) {
		ArrayList<Faq> fList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startPage = (currentPage - 1 ) * limit + 1;
		int endPage = startPage + limit - 1;
		
		String query = "";
		if(fOption.equals("fTitle")) {
			query ="select * " + 
					"from (select rownum rnum, faq_no, question_content, answer_content, faq_date, admin_id " + 
					"from (select * from tb_faq where question_content like ? order by faq_no desc)) " + 
					"where rnum >= ? and rnum <= ?";
		}else if(fOption.equals("fTContent")) {
			query ="select * " + 
					"from (select rownum rnum, faq_no, question_content, answer_content, faq_date, admin_id " + 
					"from (select * from tb_faq where question_content like ? or answer_content like ? order by faq_no desc)) " + 
					"where rnum >= ? and rnum <= ?";
		}else {
			query ="select * " + 
					"from (select rownum rnum, faq_no, question_content, answer_content, faq_date, admin_id " + 
					"from (select * from tb_faq order by faq_no desc)) " + 
					"where rnum >= ? and rnum <= ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(fOption.equals("fTitle")) {
				pstmt.setString(1, "%" + searchTitle + "%");
				pstmt.setInt(2, startPage);
				pstmt.setInt(3, endPage);
			}else if(fOption.equals("fTContent")) {
				pstmt.setString(1, "%" + searchTitle + "%");
				pstmt.setString(2, "%" + searchTitle + "%");
				pstmt.setInt(3, startPage);
				pstmt.setInt(4, endPage);
			}else {
				pstmt.setInt(1, startPage);
				pstmt.setInt(2, endPage);
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Faq faq = new Faq();
				
				faq.setFaqNo(rset.getInt("faq_no"));
				faq.setQuestionContent(rset.getString("question_content"));
				faq.setAnswerContent(rset.getString("answer_content"));
				faq.setFaqDate(rset.getDate("faq_date"));
				faq.setAdminId(rset.getString("admin_id"));
				
				fList.add(faq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return fList;	
	}
	
	public Faq faqDetail(int faqNo, Connection conn) {
		Faq faq = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select *  from tb_faq where faq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, faqNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				faq = new Faq();
				faq.setFaqNo(faqNo);
				faq.setQuestionContent(rset.getString("question_content"));
				faq.setAnswerContent(rset.getString("answer_content"));
				faq.setFaqDate(rset.getDate("faq_date"));
				faq.setAdminId(rset.getString("admin_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return faq;
	}
	
	public int insertFaqWrite(Faq faq, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_faq values (sq_faqno.nextval, ?, ?, default, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, faq.getQuestionContent());
			pstmt.setString(2, faq.getAnswerContent());
			pstmt.setString(3, faq.getAdminId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int faqUpdate(Faq faq, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_faq set question_content = ?, answer_content = ? where faq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, faq.getQuestionContent());
			pstmt.setString(2, faq.getAnswerContent());
			pstmt.setInt(3, faq.getFaqNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int faqDelete(int faqNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_faq where faq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, faqNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int allSearchListCount(String searchTitle, String fOption, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "";
		if(fOption.equals("fTitle")) {
			query = "select count(*) from tb_faq where question_content like ?";
		}else if(fOption.equals("fTContent")) {
			query = "select count(*) from tb_faq where question_content like ? or answer_content like ?";
		}else {
			query = "select count(*) from tb_faq";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(fOption.equals("fTitle")) {
				pstmt.setString(1, "%"+searchTitle+"%");
			}else if(fOption.equals("fTContent")) {
				pstmt.setString(1, "%"+searchTitle+"%");
				pstmt.setString(2, "%"+searchTitle+"%");
			}
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int faqBack(int faqNo, Connection conn) {
		int faqBack = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select faq_no from tb_faq where faq_no in (select max(faq_no) from tb_faq where faq_no < ?)";
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, faqNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				faqBack = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return faqBack;
	}

	public int faqNext(int faqNo, Connection conn) {
		int faqNext = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select faq_no from tb_faq where faq_no in (select min(faq_no) from tb_faq where faq_no > ?)";
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, faqNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				faqNext = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return faqNext;
	}

	public int faqMin(Connection conn) {
		int faqMin = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select min(faq_no) from tb_faq";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				faqMin = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return faqMin;
	}
	
}
