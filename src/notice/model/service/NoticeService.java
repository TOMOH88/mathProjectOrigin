package notice.model.service;

import java.sql.*;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

public class NoticeService {
	private NoticeDao ndao = new NoticeDao();
	
	public NoticeService() {}

	public ArrayList<Notice> searchAllList(String searchTitle,int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Notice> nsList = ndao.searchAllList(searchTitle,currentPage, limit,conn);
		close(conn);
		return nsList;
	}

	public Notice selectNDetail(int noticeNo) {
		Connection conn = getConnection();
		Notice notice = ndao.selectNDetail(noticeNo, conn);
		close(conn);
		return notice;
	}

	public int updateNotice(Notice notice) {
		Connection conn = getConnection();
		int result = ndao.updateNotice(notice, conn);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int insertNoticeWrite(Notice notice) {
		Connection conn = getConnection();
		int result = ndao.insertNoticeWrite(notice, conn);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public void addReadCount(int noticeNo) {
		Connection conn = getConnection();
		int result = ndao.addReadCount(noticeNo, conn);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		int result = ndao.noticeDelete(noticeNo, conn);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int AllSearchListCount(String searchTitle) {
		Connection conn = getConnection();
		int result = ndao.AllSearchListCount(searchTitle,conn);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
