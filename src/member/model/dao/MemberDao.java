package member.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import member.model.vo.Member;
import member.model.vo.Semester;

public class MemberDao {

	public Member loginMember(Connection conn, String userId, String password) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="select * from tb_user where user_id = ? and user_pwd = ?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			rset= pstmt.executeQuery();
			
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

	public int selectCheckId(Connection conn, String userId) {
		int  result = 0;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		String query = "select count(user_id) from tb_user where user_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public int insertMember(Connection conn, Member member) {
		int result=0;
		PreparedStatement pstmt =null;
		String query ="insert into tb_user values(?, ?, ?, ?,sysdate,sysdate,0)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getPhone());
			result =pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
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
		String qurey ="update tb_user set user_pwd =?, phone =?,user_name=?, lastmodified = sysdate where user_id = ?";
		try {
			pstmt= conn.prepareStatement(qurey);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int searchLv(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String qurey ="select member_level from tb_user where user_id = ?";
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
			 result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	public int checkId(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String qurey ="select count(1) from tb_user where user_id = ?";
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, userId);
			rset =pstmt.executeQuery();
			while(rset.next()) {
				 result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> searchEmail(Connection conn, String phone) {
		ArrayList<Member> member = new ArrayList<Member>();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = "select * from tb_user where phone = ?";
		try {
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, phone);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String userId = rset.getString(1);
				String userPwd = rset.getString(2);
				String userName = rset.getString(3);
				String phone2 = rset.getString(4);
				Date registDate = rset.getDate(5);
				Date lastModified = rset.getDate(6);
				String memberLevel = rset.getString(7);
				member.add(new Member(userId, userPwd, userName, phone2, registDate, lastModified, memberLevel));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public ArrayList<Semester> selectMyPermission(Connection conn, String userId) {
		ArrayList<Semester> mylist = new ArrayList<Semester>();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = "select semester_name,user_id from tb_permission "
				+ "join tb_semester using(semester_no) where user_id = ?";
		try {
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String semesterName = rset.getString(1);
				mylist.add(new Semester(userId, semesterName));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mylist;
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

}

