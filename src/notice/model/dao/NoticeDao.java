package notice.model.dao;

import java.sql.*;
import java.util.ArrayList;

import notice.model.vo.Notice;

import static common.JDBCTemplate.*;
public class NoticeDao {
	public NoticeDao() {}

	public ArrayList<Notice> searchAllList(String searchTitle,int currentPage, int limit, Connection conn) {
		ArrayList<Notice> nsList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		String query = "";
		if(searchTitle != null) {
		query = "select * "
				+ "from (select rownum rnum, notice_no, notice_title, notice_content, notice_date, notice_count, original_filename, rename_filename, writer_name "
				+ "from (select * from tb_notice where notice_title like ? order by notice_no desc)) "
				+ "where rnum >= ? and rnum <= ?";
		}else {
			query = "select * "
					+ "from (select rownum rnum, notice_no, notice_title, notice_content, notice_date, notice_count, original_filename, rename_filename, writer_name "
					+ "from (select * from tb_notice order by notice_no desc)) "
					+ "where rnum >= ? and rnum <= ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(searchTitle != null) {
				pstmt.setString(1, "%"+searchTitle+"%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
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

	public int AllSearchListCount(String searchTitle, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		if(searchTitle != null) {
			query = "select count(*) from tb_notice where notice_title like ?";
		}else {
			query = "select count(*) from tb_notice";
		}
		try {
			pstmt = conn.prepareStatement(query);
			if(searchTitle != null) {
				pstmt.setString(1, "%" + searchTitle + "%");
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

	public ArrayList<Notice> searchTitleNotice(String searchTitle, int currentPage, int limit, Connection conn) {
		ArrayList<Notice> nList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		String query = "select * "
				+ "from (select rownum rnum, notice_no, notice_title, notice_content, notice_date, notice_count, original_filename, rename_filename, writer_name "
				+ "from (select * from tb_notice where notice_title like ? order by notice_no desc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchTitle+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
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
				
				nList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return nList;
	}

	public int titleListCount(String searchTitle, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_notice where notice_title like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchTitle+"%");
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
	
}
