package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.Semester;

/**
 * Servlet implementation class AddPermissionServlet
 */
@WebServlet("/addper")
public class AddPermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPermissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		String per = request.getParameter("per");
		System.out.println(userId+"님의 추가할 권한은 ");
		System.out.println(per);
		String[] str = per.split(" ");
		ArrayList<Semester> addper = new ArrayList<>();
		int result =0;
		if(str[1].equals("모든권한")) {
			addper = new AdminService().selectPermission();
			for(int i = 0 ; i<addper.size();i++) {
				addper.get(i).setUserId(userId);
			}
			for(Semester s:addper) {
				System.out.println(s);
			}
			result = new AdminService().addPermission(addper);
		}else {
		System.out.println(str.length);
		for(int i=1 ; i<str.length;i++) {
			Semester seme = new AdminService().selectSemesterNo(str[i]);
			addper.add(new Semester(seme.getSemesterNo(),userId , seme.getSemesterName()));
		}
		result = new AdminService().addPermission(addper);
		}
		String returnValue=null;
		if(0<result) {
			returnValue="ok";
		}else if(result==0){
			returnValue="dup";
		}

		PrintWriter out = response.getWriter();
		out.append(returnValue);
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
