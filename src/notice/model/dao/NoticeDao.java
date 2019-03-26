package notice.model.dao;

import java.sql.*;
import java.util.ArrayList;

import notice.model.vo.Notice;

import static common.JDBCTemplate.*;
public class NoticeDao {
	public NoticeDao() {}

	public ArrayList<Notice> searchAllList(String searchTitle,String nOption,int currentPage, int limit, Connection conn) {
		ArrayList<Notice> nsList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = "";		
		if(nOption.equals("ntitle")) {
			query = "select * "
				+ "from (select rownum rnum, notice_no, notice_title, notice_content, notice_date, notice_count, original_filename, rename_filename, writer_name "
				+ "from (select * from tb_notice where notice_title like ? order by notice_no desc)) "
				+ "where rnum >= ? and rnum <= ?";
		}else if(nOption.equals("ntContent")){
			query = "select * "
					+ "from (select rownum rnum, notice_no, notice_title, notice_content, notice_date, notice_count, original_filename, rename_filename, writer_name "
					+ "from (select * from tb_notice where notice_title like ? or notice_content like ? order by notice_no desc)) "
					+ "where rnum >= ? and rnum <= ?";
		}else {
			query = "select * "
					+ "from (select rownum rnum, notice_no, notice_title, notice_content, notice_date, notice_count, original_filename, rename_filename, writer_name "
					+ "from (select * from tb_notice order by notice_no desc)) "
					+ "where rnum >= ? and rnum <= ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(nOption.equals("ntitle")) {
				pstmt.setString(1, "%"+searchTitle+"%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}else if(nOption.equals("ntContent")){
				pstmt.setString(1, "%"+searchTitle+"%");
				pstmt.setString(2, "%"+searchTitle+"%");
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
			}else {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			}
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("notice_no"));
				notice.setNoticeTitle(rset.getString("notice_title"));
				notice.setNoticeContent(rset.getString("notice_content"));
				notice.setNoticeDate(rset.getDate("notice_date"));
				notice.setNoticeCount(rset.getInt("notice_count"));
				notice.setOriginalFileName(rset.getString("original_filename"));
				notice.setRenameFileName(rset.getString("rename_filename"));
				notice.setWriterName(rset.getString("writer_name"));
				
				nsList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return nsList;
	}
	

	public Notice selectNDetail(int noticeNo, Connection conn) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_notice where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				
				notice.setNoticeNo(noticeNo);
				notice.setNoticeTitle(rset.getString("notice_title"));
				notice.setNoticeContent(rset.getString("notice_content"));
				notice.setNoticeDate(rset.getDate("notice_date"));
				notice.setNoticeCount(rset.getInt("notice_count"));
				notice.setOriginalFileName(rset.getString("original_filename"));
				notice.setRenameFileName(rset.getString("rename_filename"));
				notice.setWriterName(rset.getString("writer_name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

	public int allSearchListCount(String searchTitle,String nOption, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		if(nOption.equals("ntitle")){
			query = "select count(*) from tb_notice where notice_title like ?";
		}else if(nOption.equals("ntContent")) {
			query = "select count(*) from tb_notice where notice_title like ? or notice_content like ?";
		}else {
			query = "select count(*) from tb_notice";
		}
		try {
			pstmt = conn.prepareStatement(query);
			if(nOption.equals("ntitle")) {
				pstmt.setString(1, "%" + searchTitle + "%");
			}else if(nOption.equals("ntContent")) {
				pstmt.setString(1, "%" + searchTitle + "%");
				pstmt.setString(2, "%"+ searchTitle +"%");
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
	
	public int updateNotice(Notice notice, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_notice set notice_title = ?, notice_content = ?, original_filename = ?, rename_filename = ? where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getOriginalFileName());
			pstmt.setString(4, notice.getRenameFileName());
			pstmt.setInt(5, notice.getNoticeNo());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertNoticeWrite(Notice notice, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into tb_notice values (sq_notino.nextval, ?, ?, default, default, ?, ?, 'admin01')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getOriginalFileName());
			pstmt.setString(4, notice.getRenameFileName());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int addReadCount(int noticeNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_notice set notice_count = notice_count + 1 where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int noticeDelete(int noticeNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_notice where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int noticeBack(int noticeNo,Connection conn) {
		int noticeBack = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query ="select notice_no from tb_notice where notice_no in (select max(notice_no) from tb_notice where notice_no < ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			 if(rset.next()) {
				 noticeBack = rset.getInt(1);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noticeBack;
	}

	public int noticeNext(int noticeNo,Connection conn) {
		int noticeNext = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="select notice_no from tb_notice where notice_no in (select min(notice_no) from tb_notice where notice_no > ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			 if(rset.next()) {
				 noticeNext = rset.getInt(1);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noticeNext;
	}

	public int noticeMin(Connection conn) {
		int noticeMin = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query ="select min(notice_no) from tb_notice";
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			 if(rset.next()) {
				 noticeMin = rset.getInt(1);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return noticeMin;
	}

}
