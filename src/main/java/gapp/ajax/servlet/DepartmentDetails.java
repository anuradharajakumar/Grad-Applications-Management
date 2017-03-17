package gapp.ajax.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import gapp.model.Department;
import gapp.model.dao.DepartmentDao;

/**
 * Servlet implementation class DepartmentDetails
 */
@WebServlet("/DepartmentDetails")
public class DepartmentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Autowired
	private DepartmentDao departmentDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	public DepartmentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("You are in get method");
		System.out.println("Before parsing " + request.getParameter("id"));
		Integer id = Integer.parseInt(request.getParameter("id").toString());

		System.out.println("ID is " + id);
		
		response.sendRedirect("DepartmentDetail.html?id="+id);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
