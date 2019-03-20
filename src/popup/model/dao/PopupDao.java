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
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertPopup(Connection conn, Popup popup) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Popup selectPopup(Connection conn, int popupNo) {
		// TODO Auto-generated method stub
		return null;
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
}
