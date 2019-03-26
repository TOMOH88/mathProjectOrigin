package qna.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import qna.model.vo.Qna;

import static common.JDBCTemplate.*;
public class QnaDao {
	public QnaDao() {}
	
	public ArrayList<Qna> searchAllList(String searchTitle, String qOption, int currentPage, int limit, Connection conn){
		ArrayList<Qna> qList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startPage = (currentPage - 1) * limit +1;
		int endPage = startPage + limit - 1;
		
		String query = "";
		if(qOption.equals("qTitle")) {
			query = "select * " + 
					"from (select rownum rnum, qna_no, qna_title, qna_content, qna_date, original_qname, rename_qname, parent_no, answer_ref,qna_level, qna_index, qna_status, user_id, admin_id " + 
					"from (select * from tb_qna where qna_title like ? order by parent_no desc, answer_ref asc,qna_level asc, qna_index asc)) " + 
					"where rnum >= ? and rnum <= ?";
		}else if(qOption.equals("qTContent")) {
			query = "select * " + 
					"from (select rownum rnum, qna_no, qna_title, qna_content, qna_date, original_qname, rename_qname, parent_no, answer_ref,qna_level, qna_index, qna_status, user_id, admin_id " + 
					"from (select * from tb_qna where qna_title like ? or qna_content like ? order by parent_no desc, answer_ref asc,qna_level asc, qna_index asc)) " + 
					"where rnum >= ? and rnum <= ?";
		}else if(qOption.equals("qUserId")) {
			query = "select * " + 
					"from (select rownum rnum, qna_no, qna_title, qna_content, qna_date, original_qname, rename_qname, parent_no, answer_ref,qna_level, qna_index, qna_status, user_id, admin_id " + 
					"from (select * from tb_qna where user_id like ? order by parent_no desc, answer_ref asc,qna_level asc, qna_index asc)) " + 
					"where rnum >= ? and rnum <= ?";
		}else {
			query = "select * " + 
					"from (select rownum rnum, qna_no, qna_title, qna_content, qna_date, original_qname, rename_qname, parent_no, answer_ref,qna_level, qna_index, qna_status, user_id, admin_id " + 
					"from (select * from tb_qna order by parent_no desc, answer_ref asc,qna_level asc, qna_index asc)) " + 
					"where rnum >= ? and rnum <= ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(qOption.equals("qTitle")) {
				pstmt.setString(1, "%"+searchTitle+"%");
				pstmt.setInt(2, startPage);
				pstmt.setInt(3, endPage);
			}else if(qOption.equals("qTContent")) {
				pstmt.setString(1, "%"+searchTitle+"%");
				pstmt.setString(2, "%"+searchTitle+"%");
				pstmt.setInt(3, startPage);
				pstmt.setInt(4, endPage);
			}else if(qOption.equals("qUserId")) {
				pstmt.setString(1, "%"+searchTitle+"%");
				pstmt.setInt(2, startPage);
				pstmt.setInt(3, endPage);
			}else {
				pstmt.setInt(1, startPage);
				pstmt.setInt(2, endPage);
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Qna qna = new Qna();
				
				qna.setQnaNo(rset.getInt("qna_no"));
				qna.setQnaTitle(rset.getString("qna_title"));
				qna.setQnaContent(rset.getString("qna_content"));
				qna.setQnaDate(rset.getDate("qna_date"));
				qna.setOriginalQname(rset.getString("original_qname"));
				qna.setRenameQname(rset.getString("rename_qname"));
				qna.setParentNo(rset.getInt("parent_no"));
				qna.setAnswerRef(rset.getInt("answer_ref"));
				qna.setQnaLevel(rset.getInt("qna_level"));
				qna.setQnaIndex(rset.getInt("qna_index"));
				qna.setQnaStatus(rset.getString("qna_status"));
				qna.setUserId(rset.getString("user_id"));
				qna.setAdminId(rset.getString("admin_id"));

				qList.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return qList;
	}
	
	public Qna qnaDetail(int qnaNo, Connection conn) {
		Qna qna = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_qna where qna_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				qna = new Qna();
				
				qna.setQnaNo(rset.getInt("qna_no"));
				qna.setQnaTitle(rset.getString("qna_title"));
				qna.setQnaContent(rset.getString("qna_content"));
				qna.setQnaDate(rset.getDate("qna_date"));
				qna.setOriginalQname(rset.getString("original_qname"));
				qna.setRenameQname(rset.getString("rename_qname"));
				qna.setParentNo(rset.getInt("parent_no"));
				qna.setAnswerRef(rset.getInt("answer_ref"));
				qna.setQnaLevel(rset.getInt("qna_level"));
				qna.setQnaIndex(rset.getInt("qna_index"));
				qna.setQnaStatus(rset.getString("qna_status"));
				qna.setUserId(rset.getString("user_id"));
				qna.setAdminId(rset.getString("admin_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return qna;
	}
	
	public int insertQnaWrite(Qna qna, Connection conn) {}
	
	public int insertAnswerWrite(Qna qna, Connection conn) {
		int aInsert = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_qna values (sq_qnano.nextval,?,?,default,?,?,?,sq_qnano.currval,1,1,'Y',?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qna.getQnaTitle());
			pstmt.setString(2, qna.getQnaContent());
			pstmt.setString(3, qna.getOriginalQname());
			pstmt.setString(4, qna.getRenameQname());
			pstmt.setInt(5, qna.getParentNo());
			pstmt.setString(6, qna.getUserId());
			pstmt.setString(7, qna.getAdminId());
			
			aInsert = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return aInsert;
	}
	
	public int qnaUpdate(Qna qna, Connection conn) {}
	
	public int answerUpdate(Qna qna, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_qna set qna_title = ?, qna_content = ?, original_qname = ?, rename_qname = ?, admin_id = ? where qna_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qna.getQnaTitle());
			pstmt.setString(2, qna.getQnaContent());
			pstmt.setString(3, qna.getOriginalQname());
			pstmt.setString(4, qna.getRenameQname());
			pstmt.setString(5, qna.getAdminId());
			pstmt.setInt(6, qna.getQnaNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int qnaDelete(int qnaNo, Connection conn) {}
	
	public int allsearchListCount(String searchTitle, String qOption, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "";
		if(qOption.equals("qTitle")) {
			query = "select count(*) from tb_qna where qna_title like ?";
		}else if(qOption.equals("qTContent")) {
			query = "select count(*) from tb_qna where qna_title like ? or qna_content like ?";
		}else if(qOption.equals("qUserId")) {
			query = "select count(*) from tb_qna where user_id like ?";
		}else {
			query = "select count(*) from tb_qna";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(qOption.equals("qTitle")) {
				pstmt.setString(1, "%"+searchTitle+"%");
			}else if(qOption.equals("qTContent")) {
				pstmt.setString(1, "%"+searchTitle+"%");
				pstmt.setString(2, "%"+searchTitle+"%");
			}else if(qOption.equals("qUserId")) {
				pstmt.setString(1, "%"+searchTitle+"%");
			}
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public void addReadCount(int qnaNo, Connection conn) {}

	public int qnaUpdateStatus(int qnaNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_qna set qna_status = ? where qna_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setInt(2, qnaNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
