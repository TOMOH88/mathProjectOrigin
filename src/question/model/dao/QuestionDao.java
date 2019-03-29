package question.model.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import static common.JDBCTemplate.*;
import question.model.vo.Question;

public class QuestionDao {
	public QuestionDao() {}

	public ArrayList<Question> semesterSelect(Connection conn) {
		ArrayList<Question> list = new ArrayList<Question>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select semester_name from tb_semester order by 1 asc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Question q = new Question();
				q.setSemester(rset.getString("semester_name"));
				
				list.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<Question> bookSelect(Connection conn, String semester) {
		ArrayList<Question> list = new ArrayList<Question>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select book_name from tb_book join tb_semester using(semester_no) where semester_name = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, semester);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Question q = new Question();
				q.setBook(rset.getString("book_name"));
				
				list.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	public ArrayList<Question> chapterSelect(Connection conn, String semester, String book) {
		ArrayList<Question> list = new ArrayList<Question>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select chapter_name from tb_semester join tb_book using(semester_no) join tb_chapter using(book_no) where "
				+ "semester_name = ? and book_name = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, semester);
			pstmt.setString(2, book);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Question q = new Question();
				q.setChapter(rset.getString("chapter_name"));
				
				list.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	public ArrayList<Question> QuestionImgSelect(Connection conn, String semester, String book, String chapter) {
		ArrayList<Question> list = new ArrayList<Question>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select question_img from tb_semester join tb_book using(semester_no) join tb_chapter using(book_no) "
				+ "join tb_question using(chapter_no) where semester_name = ? and book_name = ? and chapter_name = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, semester);
			pstmt.setString(2, book);
			pstmt.setString(3, chapter);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Question q = new Question();
				q.setQuestion(rset.getString("question_img"));
				
				list.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	public int makeSemester(Connection conn, String newSemester) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_semester values (sq_semno.nextval, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newSemester);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int makeBook(Connection conn, String semester, String newBook) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into tb_book values (sq_bkno.nextval, (select semester_no from tb_semester where semester_name = ?), ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, semester);
			pstmt.setString(2, newBook);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int makeChapter(Connection conn, String semester, String book, String newChapter) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into tb_chapter values (sq_chno.nextval, (select book_no from tb_book where book_name = ? and semester_no = (select semester_no from tb_semester where semester_name = ?)), "
				+ "(select semester_no from tb_semester where semester_name = ?), ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book);
			pstmt.setString(2, semester);
			pstmt.setString(3, semester);
			pstmt.setString(4, newChapter);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int uploadImg(Connection conn, String semester, String book, String chapter, String imgName) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into tb_question values (?, (select chapter_no from tb_chapter where chapter_name = ? and book_no = (select book_no from tb_book where book_name = ? and semester_no = (select semester_no from tb_semester where semester_name = ?))), "
				+ "(select book_no from tb_book where book_name = ? and semester_no = (select semester_no from tb_semester where semester_name = ?)), "
				+ "(select semester_no from tb_semester where semester_name = ?))";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, imgName);
			pstmt.setString(2, chapter);
			pstmt.setString(3, book);
			pstmt.setString(4, semester);
			pstmt.setString(5, book);
			pstmt.setString(6, semester);
			pstmt.setString(7, semester);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteSemester(Connection conn, String semester) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from tb_semester where semester_name = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, semester);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBook(Connection conn, String semester, String book) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from tb_book where book_name = ? and semester_no = (select semester_no from tb_semester where semester_name = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book);
			pstmt.setString(2, semester);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteChapter(Connection conn, String semester, String book, String chapter) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from tb_chapter where chapter_name = ? and book_no = (select book_no from tb_book where book_name = ?) and "
				+ "semester_no = (select semester_no from tb_semester where semester_name = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, chapter);
			pstmt.setString(2, book);
			pstmt.setString(3, semester);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteImg(Connection conn, String semester, String book, String chapter, String imgName) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from tb_question where question_img = ? and chapter_no = (select chapter_no from tb_chapter where chapter_name = ? and book_no = (select book_no from tb_book where book_name = ? and semester_no = (select semester_no from tb_semester where semester_name = ?))) "
				+ "and book_no = (select book_no from tb_book where book_name = ? and semester_no = (select semester_no from tb_semester where semester_name = ?)) and "
				+ "semester_no = (select semester_no from tb_semester where semester_name = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, imgName);
			pstmt.setString(2, chapter);
			pstmt.setString(3, book);
			pstmt.setString(4, semester);
			pstmt.setString(5, book);
			pstmt.setString(6, semester);
			pstmt.setString(7, semester);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
