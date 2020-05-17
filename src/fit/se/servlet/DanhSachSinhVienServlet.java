package fit.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.dao.SinhVienDAO;
import fit.se.entities.SinhVien;

@WebServlet(urlPatterns = {"/DanhSachSinhVien"})
public class DanhSachSinhVienServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SinhVienDAO sinhVienDAO = new SinhVienDAO();

		List<SinhVien> danhSachSinhVien = sinhVienDAO.getSinhViens();

		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();

		String html = "<!DOCTYPE html>" + 
				"<html>" + 
				"" + 
				"<head>" + 
				"  <meta charset='UTF-8'>" + 
				"  <meta name='viewport' content='width=device-width, initial-scale=1.0'>" + 
				"  <title>Danh Sách Sinh Viên</title>" + 
				"  <!-- Latest compiled and minified CSS -->" + 
				"  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css'>" + 
				"" + 
				"  <!-- jQuery library -->" + 
				"  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>" + 
				"" + 
				"  <!-- Popper JS -->" + 
				"  <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>" + 
				"" + 
				"  <!-- Latest compiled JavaScript -->" + 
				"  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js'></script>" +
				"	<script type='text/javascript'>" + 
				"		function submitForm(){" + 
				"			var result = confirm('Bạn có chắc chắn khi xoá thông tin này?');" + 
				"			if(result == true){" + 
				"				return true" + 
				"			} else { "+ 
				"				event.stopPropagation(); " +
				"				event.preventDefault();" + 
				"			}" + 
				"		}" + 
				"	</script>" +
				"</head>" + 
				"" + 
				"<body>" + 
				"  <nav class='navbar navbar-expand-sm bg-light navbar-dark border'>" + 
				"    <a href='' class='navbar-brand'>" + 
				"      <img width='300px' src='../img/head-img.png' alt='IUH'>" + 
				"    </a>" + 
				"    <h1 class='align-middle ml-5'>CHƯƠNG TRÌNH QUẢN LÝ THÔNG TIN SINH VIÊN</h1>" + 
				"  </nav>" + 
				"  <div class='row border mt-2'>" + 
				"    <div class='col-lg-3 border'>" +

				"      <ul class='mt-5' style='list-style-type: none;'>" + 
				"        <li><a href='index.html'>Thêm mới SV</a></li>" + 
				"        <li><a href='DanhSachSinhVien'>Danh sách SV </a></li>" + 
				"      </ul>" + 
				"    </div>" + 
				"    <div class='float-none col-lg-8 border'>" + 
				"		<h3>Danh Sách Sinh Viên</h3>" +
				"      <table class='table-bordered w-100 mt-5'>" + 
				"        <tr>" + 
				"          <th>Mã SV</th>" + 
				"          <th>Họ tên</th>" + 
				"          <th>Giới tính</th>" + 
				"          <th>Số điện thoại</th>" + 
				"          <th>Địa chỉ</th>" + 
				"          <th>Cập nhật</th>" + 
				"          <th>Xoá</th>" + 
				"        </tr>";
		for (int i = 0; i < danhSachSinhVien.size(); i++) {
			html += "<tr>"
						+ "<td>" + danhSachSinhVien.get(i).getMaSV()+ "</td>"	
						+ "<td>" + danhSachSinhVien.get(i).getHoTen()+ "</td>"	
						+ "<td>" + danhSachSinhVien.get(i).getGioiTinh()+ "</td>"	
						+ "<td>" + danhSachSinhVien.get(i).getSoDT()+ "</td>"	
						+ "<td>" + danhSachSinhVien.get(i).getDiaChi()+ "</td>"
						+ "<td><a href='FormSinhVien?id=" + danhSachSinhVien.get(i).getMaSV() + "'>Cập nhật</a></td>" 
						+ "<td><a href='XoaSinhVien?id=" + danhSachSinhVien.get(i).getMaSV() + "' onclick='submitForm();'>Xoá</a></td>" 
					+ "</tr>";
		}
		html+=	"      </table>" + 
				"    </div>" + 
				"  </div>" + 
				"  <footer class='border mt-2'>" + 
				"    <h3 style='text-align: center;'><i>Đinh Đăng Khoa - 17080051</i></h3>" + 
				"  </footer>" +
				"</body>" + 
				"" + 
				"</html>";
		out.print(html);
		out.close();
	}
}
