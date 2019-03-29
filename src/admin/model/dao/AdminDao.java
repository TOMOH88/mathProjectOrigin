package admin.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.model.vo.Admin;
import admin.model.vo.Semester;
import member.model.vo.Member;

public class AdminDao {
	public Admin loginAdmin(Connection conn, String userId, String password) {
		Admin admin = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="select * from tb_admin where admin_id = ? and admin_pwd = ?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				String adminId = rset.getString(1);
				String adminPwd = rset.getString(2);
				String adminName = rset.getString(3);
				admin = new Admin(adminId, adminPwd, adminName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return admin;
	}
	public Member selectMember(Connection conn, String userId) {
		Member member = new Member();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = "select * from tb_user where user_id = ?";
		try {
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String userPwd = rset.getString(2);
				String userName = rset.getString(3);
				String phone = rset.getString(4);
				Date registDate = rset.getDate(5);
				Date lastModified = rset.getDate(6);
				String memberLevel = rset.getString(7);
				member = new Member(userId, userPwd, userName, phone, registDate, lastModified, memberLevel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public int memberUpdate(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt= null;
		String qurey ="update tb_user set user_pwd =?, phone =?, lastmodified = sysdate where user_id = ?";
		try {
			pstmt= conn.prepareStatement(qurey);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getUserId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectMemberAll(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = "select * from tb_user order by regist_date desc";
		try {
			pstmt  = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String userId = rset.getString(1);
				String userPwd = rset.getString(2);
				String userName = rset.getString(3);
				String phone = rset.getString(4);
				Date registDate = rset.getDate(5);
				Date lastModified = rset.getDate(6);
				String memberLevel = rset.getString(7);
				list.add(new Member(userId, userPwd, userName, phone, registDate, lastModified, memberLevel));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public int levelChange(Connection conn, String userid, int level) {
		int result = 0;
		PreparedStatement pstmt= null;
		String qurey ="update tb_user set MEMBER_LEVEL=? where user_id = ?";
		try {
			pstmt= conn.prepareStatement(qurey);
			pstmt.setInt(1, level);
			pstmt.setString(2, userid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	public int memberPasswordChange(Connection conn, String userId, String pass) {
		int result = 0;
		PreparedStatement pstmt= null;
		String qurey ="update tb_user set USER_PWD=? where user_id = ?";
		try {
			pstmt= conn.prepareStatement(qurey);
			pstmt.setString(1, pass);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int resetPassword(Connection conn, String userId, String hex) {
		int result = 0;
		PreparedStatement pstmt= null;
		String qurey ="update tb_user set USER_PWD=? where user_id = ?";
		try {
			pstmt= conn.prepareStatement(qurey);
			pstmt.setString(1, hex);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int countMember(Connection conn) {
		int result = 0;
		PreparedStatement pstmt= null;
		ResultSet rset= null;
		String qurey ="select count(*) from tb_user";
		try {
			pstmt= conn.prepareStatement(qurey);
			rset = pstmt.executeQuery();
			while(rset.next()){
				result= rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);	
		}
		return result;
	}
	public ArrayList<Semester> selectPermission(Connection conn) {
		ArrayList<Semester> slist = new ArrayList<Semester>();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = "select * from tb_semester";
		try {
			pstmt  = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int semesterNo = rset.getInt(1);
				String semesterName = rset.getString(2);
				slist.add(new Semester(semesterNo, semesterName));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return slist;
	}
	public ArrayList<Semester> selectMyPermission(Connection conn, String userId) {
		ArrayList<Semester> mylist = new ArrayList<Semester>();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = "select semester_name,user_id,semester_no from tb_permission "
				+ "join tb_semester using(semester_no) where user_id = ?";
		try {
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String semesterName = rset.getString(1);
				int semesterNo = rset.getInt(3);
				mylist.add(new Semester(semesterNo, userId, semesterName));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mylist;
	}
	public int addPermission(Connection conn, ArrayList<Semester> addper) {
		int result = 0;
		PreparedStatement pstmt= null;
		String qurey ="insert into tb_permission values(?,?)";
		try {
			for(int i = 0 ; i<addper.size();i++) {
			pstmt= conn.prepareStatement(qurey);
			pstmt.setInt(1, addper.get(i).getSemesterNo());
			pstmt.setString(2, addper.get(i).getUserId());		
			result += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public Semester selectSemesterNo(Connection conn, String semeName) {
		Semester seme = null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = "select * from tb_semester where semester_name = ?";
		try {
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, semeName);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int semesterNo = rset.getInt(1);
				String semesterName = rset.getString(2);
				seme =new Semester(semesterNo, semesterName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return seme;
	}
	public int removePermission(Connection conn, ArrayList<Semester> addper) {
		int result = 0;
		PreparedStatement pstmt= null;
		String qurey ="delete from tb_permission where semester_no =? and USER_ID=?";
		try {
			for(int i = 0 ; i<addper.size();i++) {
			pstmt= conn.prepareStatement(qurey);
			pstmt.setInt(1, addper.get(i).getSemesterNo());
			pstmt.setString(2, addper.get(i).getUserId());		
			result += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int lastModifiedPermission(Connection conn, String userId) {
		
		int result = 0;
		PreparedStatement pstmt= null;
		String qurey ="update tb_user set LASTMODIFIED = sysdate where user_id = ?";
		try {
			
			pstmt= conn.prepareStatement(qurey);
			pstmt.setString(1, userId);		
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int overlapDelete(Connection conn, String semeName, String userId) {
		int result = 0;
		PreparedStatement pstmt= null;
		String qurey ="delete from tb_permission where semester_no = (select semester_no from tb_semester where semester_name = ?) and USER_ID=?";
		try {
			
			pstmt= conn.prepareStatement(qurey);
			pstmt.setString(1, semeName);
			pstmt.setString(2, userId);		
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int allSearchListCount(String searchTitle, String fOption, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "";
		if(fOption.equals("userid")) {
			query = "select count(*) from tb_user where USER_ID like ?";
		}else if(fOption.equals("username")) {
			query = "select count(*) from tb_user where PHONE like ?";
		}else if(fOption.equals("phone")){
			query = "select count(*) from tb_user where USER_NAME like ?";
		}else {
			query = "select count(*) from tb_user";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(fOption.equals("userid")) {
				pstmt.setString(1, "%"+searchTitle+"%");
			}else if(fOption.equals("username")) {
				pstmt.setString(1, "%"+searchTitle+"%");
			}else if(fOption.equals("phone")) {
				pstmt.setString(1, "%"+searchTitle+"%");
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
	public ArrayList<Member> selectMemberAll(String searchTitle, String fOption, int currentPage, int limit,
			Connection conn) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startPage = (currentPage - 1 ) * limit + 1;
		int endPage = startPage + limit - 1;
		
		String query = "";
		if(fOption.equals("userid")) {
			query = "select * " + 
					"from( select rownum rnum, USER_ID, USER_PWD, USER_NAME, PHONE, REGIST_DATE, LASTMODIFIED, MEMBER_LEVEL " + 
					"from( select * from tb_user where user_id like ? order by REGIST_DATE desc))" + 
					"where rnum >= ? and rnum <= ?";
		}else if(fOption.equals("username")) {
			query = "select * " + 
					"from( select rownum rnum, USER_ID, USER_PWD, USER_NAME, PHONE, REGIST_DATE, LASTMODIFIED, MEMBER_LEVEL " + 
					"from( select * from tb_user where user_name like ? order by REGIST_DATE desc))" + 
					"where rnum >= ? and rnum <=?";
		}else if(fOption.equals("phone")) {
			query = "select * " + 
					"from( select rownum rnum, USER_ID, USER_PWD, USER_NAME, PHONE, REGIST_DATE, LASTMODIFIED, MEMBER_LEVEL " + 
					"from( select * from tb_user where phone like ? order by REGIST_DATE desc))" + 
					"where rnum >= ? and rnum <=?";
		}else {
			query = "select * " + 
				"from( select rownum rnum, USER_ID, USER_PWD, USER_NAME, PHONE, REGIST_DATE, LASTMODIFIED, MEMBER_LEVEL " + 
				"from( select * from tb_user order by REGIST_DATE desc))" + 
				"where rnum >= ? and rnum <=?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(fOption.equals("userid")) {
				pstmt.setString(1, "%" + searchTitle + "%");
				pstmt.setInt(2, startPage);
				pstmt.setInt(3, endPage);
			}else if(fOption.equals("username")) {
				pstmt.setString(1, "%" + searchTitle + "%");
				pstmt.setInt(2, startPage);
				pstmt.setInt(3, endPage);
			}else if(fOption.equals("phone")) {
				pstmt.setString(1, "%" + searchTitle + "%");
				pstmt.setInt(2, startPage);
				pstmt.setInt(3, endPage);
			}else {
				pstmt.setInt(1, startPage);
				pstmt.setInt(2, endPage);
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String userId = rset.getString(2);
				String userPwd = rset.getString(3);
				String userName = rset.getString(4);
				String phone = rset.getString(5);
				Date registDate = rset.getDate(6);
				Date lastModified = rset.getDate(7);
				String memberLevel = rset.getString(8);
				list.add(new Member(userId, userPwd, userName, phone, registDate, lastModified, memberLevel));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;	
	}
	}


