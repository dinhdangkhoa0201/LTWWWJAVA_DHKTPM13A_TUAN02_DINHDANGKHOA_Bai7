package fit.se.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.dao.SinhVienDAO;
import fit.se.entities.SinhVien;

/**
 * Servlet implementation class ThemSinhVien
 */
public class ThemSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemSinhVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSV = request.getParameter("maSV");
		String hoTen = request.getParameter("hoTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String soDT = request.getParameter("soDT");
		String diaChi = request.getParameter("diaChi");

		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		if(sinhVienDAO.addSinhVien(new SinhVien(maSV, hoTen, gioiTinh, soDT, diaChi)) == true) {
			response.sendRedirect("DanhSachSinhVien");
		}

	}


}
