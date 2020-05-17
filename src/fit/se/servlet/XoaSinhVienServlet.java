package fit.se.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.dao.SinhVienDAO;
import fit.se.entities.SinhVien;

@WebServlet(urlPatterns = {"/XoaSinhVien"})
public class XoaSinhVienServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		if(sinhVienDAO.deleteSinhVien(new SinhVien(id)) == true) {
			resp.sendRedirect("DanhSachSinhVien");
		} else {
			System.out.println("Xoa ko dc");
		}
	}
}
