package popup.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import popup.model.vo.Popup;

public class PopupDao {
	
	public PopupDao() {}
	
public ArrayList<Popup> listPopup(String searchTitle,int currentPage, int limit, Connection conn) {
		ArrayList<Popup> pArr = new ArrayList<Popup>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		String query = "";
		if(searchTitle != null) {
		query = "select * "
				+ "from (select rownum rnum, popup_no, popup_name, popup_link, popup_x, popup_y, popup_width, popup_height, popup_date, popup_enddate, popup_imagepath, popup_explan "
				+ "from (select * from tb_popup where popup_name like ? order by popup_no desc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		}else {
			query = "select * "
					+ "from (select rownum rnum, popup_no, popup_name, popup_link, popup_x, popup_y, popup_width, popup_height, popup_date, popup_enddate, popup_imagepath, popup_explan "
					+ "from (select * from tb_popup order by popup_no desc)) "
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
				Popup popup = new Popup();
				
				popup.setPopupNo(rset.getInt("popup_no"));
				popup.setPopupName(rset.getString("popup_name"));
				popup.setPopupLink(rset.getString("popup_link"));
				popup.setPopupX(rset.getInt("popup_x"));
				popup.setPopupY(rset.getInt("popup_y"));
				popup.setPopupWidth(rset.getInt("popup_width"));
				popup.setPopupHeight(rset.getInt("popup_height"));
				popup.setPopupDate(rset.getDate("popup_date"));
				popup.setPopupEndDate(rset.getDate("popup_enddate"));
				popup.setPopupImagePath(rset.getString("popup_imagepath"));
				popup.setPopupExplan(rset.getString("popup_explan"));
				
				pArr.add(popup);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pArr;
	}

	public int updatePopup(Connection conn, Popup popup) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deletePopup(Connection conn, int popupNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_popup where popup_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, popupNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertPopup(Connection conn, Popup popup) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into tb_popup values (sq_popupno.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'admin01')";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, popup.getPopupName());
			pstmt.setString(2, popup.getPopupImagePath());
			pstmt.setInt(3, popup.getPopupX());
			pstmt.setInt(4, popup.getPopupY());
			pstmt.setInt(5, popup.getPopupWidth());
			pstmt.setInt(6, popup.getPopupHeight());
			pstmt.setDate(7, popup.getPopupDate());
			pstmt.setDate(8, popup.getPopupEndDate());
			pstmt.setString(9, popup.getPopupImagePath());
			pstmt.setString(10, popup.getPopupExplan());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Popup selectPopup(Connection conn, int popupNo) {
		Popup popup= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_popup where popup_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, popupNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				popup = new Popup();
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return popup;
	}

	public int AllSearchListCount(String searchTitle, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		if(searchTitle != null) {
			query = "select count(*) from tb_popup where popup_name like ?";
		}else {
			query = "select count(*) from tb_popup";
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

	public Popup selectPDetail(int popupNo, Connection conn) {
		Popup popup = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_popup where popup_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, popupNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				popup = new Popup();
				
				popup.setPopupNo(popupNo);
				popup.setPopupName(rset.getString("popup_name"));
				popup.setPopupLink(rset.getString("popup_link"));
				popup.setPopupX(rset.getInt("popup_x"));
				popup.setPopupY(rset.getInt("popup_y"));
				popup.setPopupWidth(rset.getInt("popup_width"));
				popup.setPopupHeight(rset.getInt("popup_height"));
				popup.setPopupDate(rset.getDate("popup_date"));
				popup.setPopupEndDate(rset.getDate("popup_enddate"));
				popup.setPopupImagePath(rset.getString("popup_imagepath"));
				popup.setPopupExplan(rset.getString("popup_explan"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return popup;
	}

	public int addReadCount(int popupNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_popup set popup_count = popup_count + 1 where popup_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, popupNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int popupBack(int popupNo, Connection conn) {
		int popupBack = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query ="select popup_no from tb_popup where popup_no in (select max(popup_no) from tb_popup where popup_no < ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, popupNo);
			
			rset = pstmt.executeQuery();
			 if(rset.next()) {
				 popupBack = rset.getInt(1);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return popupBack;
	}

	public int popupNext(int popupNo, Connection conn) {
		int popupNext = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="select popup_no from tb_popup where popup_no in (select min(popup_no) from tb_popup where popup_no > ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, popupNo);
			
			rset = pstmt.executeQuery();
			 if(rset.next()) {
				 popupNext = rset.getInt(1);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return popupNext;
	}

	public int popupMin(Connection conn) {
		int popupMin = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query ="select min(popup_no) from tb_popup";
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			 if(rset.next()) {
				 popupMin = rset.getInt(1);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return popupMin;
	}
}
