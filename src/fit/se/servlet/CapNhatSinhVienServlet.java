package fit.se.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.dao.SinhVienDAO;
import fit.se.entities.SinhVien;

@WebServlet(urlPatterns = {"/CapNhatSinhVien"})
public class CapNhatSinhVienServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("maSV");
		String hoTen = req.getParameter("hoTen");
		String gioiTinh = req.getParameter("gioiTinh");
		String soDT = req.getParameter("soDT");
		String diaChi = req.getParameter("diaChi");
		
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		if(sinhVienDAO.updateSinhVien(new SinhVien(id, hoTen, gioiTinh, soDT, diaChi)) == true) {
			resp.sendRedirect("DanhSachSinhVien");
		}
	}
}
