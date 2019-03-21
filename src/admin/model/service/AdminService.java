package admin.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.MemberDao;
import admin.model.vo.Admin;
import member.model.vo.Member;

public class AdminService {
	private MemberDao mdao = new MemberDao();
	public Admin loginAdmin(String userId, String password) {
		Connection conn = getConnection();
		Admin admin = mdao.loginAdmin(conn,userId,password);
		close(conn);
		return admin;
	}
	public Member selectMember(String userId) {
		Connection conn = getConnection();
		Member member = mdao.selectMember(conn,userId);
		close(conn);
		return member;
	}
	public int memberUpdate(Member member) {
		Connection conn = getConnection();
		int result = mdao.memberUpdate(conn, member);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public ArrayList<Member> selectMemberAll() {
		Connection conn = getConnection();
		ArrayList<Member>  list = mdao.selectMemberAll(conn);
		close(conn);
		return list;
	}
	public int levelChange(String userid, int level) {
		Connection conn = getConnection();
		int result = mdao.levelChange(conn, userid,level);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
