package qna.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import qna.model.dao.QnaDao;
import qna.model.vo.Qna;

import static common.JDBCTemplate.*;
public class QnaService {
	private QnaDao qdao = new QnaDao();
	
	public QnaService() {}
	
	public ArrayList<Qna> searchAllList(String searchTitle, String qOption, int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Qna> qList = qdao.searchAllList(searchTitle, qOption, currentPage, limit, conn);
		close(conn);
		return qList;
	}
	
	public Qna qnaDetail(int qnaNo) {
		Connection conn = getConnection();
		Qna qna = qdao.qnaDetail(qnaNo, conn);
		close(conn);
		return qna;
	}
	
	public int insertQnaWrite(Qna qna) {}
	
	public int insertAnswerWrite(Qna qna) {
		Connection conn = getConnection();
		int aInsert = qdao.insertAnswerWrite(qna, conn);
		if(aInsert > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return aInsert;
	}
	
	public int qnaUpdate(Qna qna) {}
	
	public int answerUpdate(Qna qna) {
		Connection conn = getConnection();
		int result = qdao.answerUpdate(qna, conn);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int qnaDelete(int qnaNo) {}
	
	public int allSearchListCount(String searchTitle, String qOption) {
		Connection conn = getConnection();
		int result = qdao.allsearchListCount(searchTitle, qOption, conn);
		close(conn);
		return result;
	}
	
	public void addReadCount(int qnaNo) {}

	public void qnaUpdateStatus(int qnaNo) {
		Connection conn = getConnection();
		int result = qdao.qnaUpdateStatus(qnaNo, conn);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}
	
}
