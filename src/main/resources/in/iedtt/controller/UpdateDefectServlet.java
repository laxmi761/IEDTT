package in.iedtt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.DefectCommentDao;
import in.iedtt.dao.DefectDao;
import in.iedtt.entity.DefectComment;
import in.iedtt.entity.Response;

/**
 * Servlet implementation class UpdateDefectServlet
 */
public class UpdateDefectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDefectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DefectDao defectDao = new DefectDao();
		DefectCommentDao commentDao = new DefectCommentDao();
		String id = request.getParameter("defectId");
		int defectId = Integer.valueOf(id);
		Response defectByIdResponse = defectDao.getDefectById(defectId);
		request.getSession().setAttribute("response", defectByIdResponse);
		List<DefectComment> commentsByDefectId = commentDao.getCommentsByDefectId(defectId);
		request.getSession().setAttribute("commentsByDefectId", commentsByDefectId);
		request.getRequestDispatcher("./editDefect.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
