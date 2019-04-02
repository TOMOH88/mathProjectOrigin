package course.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import course.model.vo.Book;
import course.model.vo.Course;
import course.model.vo.Member;
import course.model.vo.Semester;

import static common.JDBCTemplate.*;

public class CourseDao {

	public ArrayList<Course> courseAllList(int currentPage, int limit, String sOption, String bOption, Connection conn) {
		ArrayList<Course> cList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startPage = (currentPage - 1 ) * limit + 1;
		int endPage = startPage + limit - 1;

		String query = "";
		if(sOption != "" && bOption != "") {
			query = "select * " + 
					"from (select rownum rnum, course_no, course_title, course_content, course_date, book_no, semester_no " + 
					"from (select * from tb_course where course_no in (" + 
					"select course_no from tb_book " + 
					"join tb_semester using(semester_no) " + 
					"join tb_course using (semester_no, book_no) " + 
					"where semester_name = ? and book_name = ?) " + 
					"order by course_no desc)) " + 
					"where rnum >= ? and rnum <= ?";
		}else {
			query = "select * " + 
				"from (select rownum rnum, course_no, course_title, course_content, course_date, book_no, semester_no " + 
				"from (select * from tb_course order by course_no desc)) " + 
				"where rnum >= ? and rnum <= ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(sOption != "" && bOption != "") {
				pstmt.setString(1, sOption);
				pstmt.setString(2, bOption);
				pstmt.setInt(3, startPage);
				pstmt.setInt(4, endPage);
			}else {
				pstmt.setInt(1, startPage);
				pstmt.setInt(2, endPage);
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Course course = new Course();
				
				course.setCourseNo(rset.getInt("course_no"));
				course.setCourseTitle(rset.getString("course_title"));
				course.setCourseContent(rset.getString("course_content"));
				course.setCourseDate(rset.getDate("course_date"));
				course.setBookNo(rset.getInt("book_no"));
				course.setSemesterNo(rset.getInt("semester_no"));
				
				cList.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cList;
	}

	public int allListCount(String sOption, String bOption, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "";
		if(sOption != "" && bOption != "") {		
			query = "select count(*) from tb_course where course_no in (select course_no from tb_book " + 
					"join tb_semester using(semester_no) " + 
					"join tb_course using (semester_no, book_no) " + 
					"where semester_name = ? and book_name = ?)";
		}else {
			query = "select count(*) from tb_course";
		}
		try {
			pstmt = conn.prepareStatement(query);
			if(sOption != "" && bOption != "") {
				pstmt.setString(1, sOption);
				pstmt.setString(2, bOption);
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

	public ArrayList<Semester> semList(Connection conn) {
		ArrayList<Semester> semList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_semester";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Semester sem = new Semester();
				sem.setSemesterNo(rset.getInt("semester_no"));
				sem.setSemesterName(rset.getString("semester_name"));
				semList.add(sem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return semList;
	}

	public ArrayList<Book> bookList(Connection conn) {
		ArrayList<Book> bList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select distinct book_name from tb_book";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookName(rset.getString("book_name"));
				
				bList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return bList;
	}

	public int courseWrite(Connection conn,Course course, String sOption, String bOption) {
		int result = 0;
		PreparedStatement pstmt = null;
		String option = "["+sOption+bOption+"] ";
		String query = "insert into tb_course values(" + 
					"sq_cono.nextval, ?, ?, default,(select book_no from tb_book join tb_semester using(semester_no) where semester_name = ? and book_name = ?)," + 
					"(select semester_no from tb_semester where semester_name = ?) " + 
					")";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, option+course.getCourseTitle());
			pstmt.setString(2, course.getCourseContent());
			pstmt.setString(3, sOption);
			pstmt.setString(4, bOption);
			pstmt.setString(5, sOption);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Course courseDetail(int courseNo, Connection conn) {
		Course course = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select *  from tb_course where course_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, courseNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				course = new Course();
				course.setCourseNo(courseNo);
				course.setCourseTitle(rset.getString("course_title"));
				course.setCourseContent(rset.getString("course_content"));
				course.setCourseDate(rset.getDate("course_date"));
				course.setBookNo(rset.getInt("book_no"));
				course.setSemesterNo(rset.getInt("semester_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return course;
	}

	public int courseDelete(int courseNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_course where course_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, courseNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int courseUpdate(Course course, String sOption, String bOption, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String option = "["+sOption+bOption+"] ";
		String query = "update tb_course set course_title = ?, course_content = ?, semester_no = (select semester_no from tb_semester where semester_name = ?), "
				+ "book_no = (select book_no from (select book_no from tb_book where semester_no = (select semester_no from tb_semester where semester_name = ?) and book_name = ?)) "
				+ " where course_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, option+course.getCourseTitle());
			pstmt.setString(2, course.getCourseContent());
			pstmt.setString(3, sOption);
			pstmt.setString(4, sOption);
			pstmt.setString(5, bOption);
			pstmt.setInt(6, course.getCourseNo());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member userMember(String userId, Connection conn) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select  *  from tb_user where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				
				member.setUserId(rset.getString("user_id"));
				member.setUserPwd(rset.getString("user_pwd"));
				member.setUserName(rset.getString("user_name"));
				member.setPhone(rset.getString("phone"));
				member.setRegistDate(rset.getDate("regist_date"));
				member.setLastModified(rset.getDate("lastmodified"));
				member.setmemberLevel(rset.getString("member_level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}


	public String selectSName(int courseNo, Connection conn) {
		String sName = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select semester_name " + 
				"from tb_semester " + 
				"where semester_no = (select semester_no " + 
				"                               from tb_course " + 
				"                               where course_no = ?) "; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, courseNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				sName = rset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return sName;
	}

	public String selectBName(int courseNo, Connection conn) {
		String bName = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select book_name " + 
				"from tb_book " + 
				"where book_no = (select book_no " + 
				"                               from tb_course " + 
				"                               where course_no = ?) "; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, courseNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bName = rset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bName;
	}

}
