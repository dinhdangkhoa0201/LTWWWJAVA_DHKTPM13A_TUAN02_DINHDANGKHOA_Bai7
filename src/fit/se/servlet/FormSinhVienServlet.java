package fit.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.dao.SinhVienDAO;
import fit.se.entities.SinhVien;

@WebServlet(urlPatterns = {"/FormSinhVien"})
public class FormSinhVienServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		SinhVien sinhVien = sinhVienDAO.getSinhVien(id);
		String html = "";
		if(sinhVien != null) {
			html += "<!DOCTYPE html>" + 
					"<html>" + 
					"" + 
					"<head>" + 
					"<meta charset='UTF-8'>" + 
					"<meta name='viewport' content='width=device-width, initial-scale=1.0'>" + 
					"<title>IUH</title>" + 
					"<!-- Latest compiled and minified CSS -->" + 
					"<link rel='stylesheet'" + 
					"	href='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css'>" + 
					"" + 
					"<!-- jQuery library -->" + 
					"<script" + 
					"	src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>" + 
					"" + 
					"<!-- Popper JS -->" + 
					"<script" + 
					"	src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>" + 
					"" + 
					"<!-- Latest compiled JavaScript -->" + 
					"<script" + 
					"	src='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js'></script>" + 
					"	<script type='text/javascript'>" + 
					"		function submitForm(){" + 
					"			var result = confirm('Bạn có chắc chắn khi cập nhật thông tin này?');" + 
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
					"<body class=''>" + 
					"	<nav class='navbar navbar-expand-sm bg-light navbar-dark border'>" + 
					"		<a href='' class='navbar-brand'> <img width='300px'" + 
					"			src='../img/head-img.png' alt='IUH'>" + 
					"		</a>" + 
					"		<h1 class='align-middle ml-5'>CHƯƠNG TRÌNH QUẢN LÝ THÔNG TIN" + 
					"			SINH VIÊN</h1>" + 
					"	</nav>" + 
					"	<div class='row border mt-2'>" + 
					"		<div class='col-lg-3 border'>" + 
					"			<ul style='list-style-type: none;'>" + 
					"				<li><a href='index.html'>Thêm mới SV</a></li>" + 
					"				<li><a href='DanhSachSinhVien'>Danh sách SV</a></li>" + 
					"			</ul>" + 
					"		</div>" + 
					"		<div class='float-none col-lg-8 border'>" + 
					"			<h3>Danh Sách Sinh Viên</h3>" +
					"			<form action='CapNhatSinhVien' method='POST'>" + 
					"				<table class='w-100'>" + 
					"					<tr>" + 
					"						<td>Mã sinh viên:</td>" + 
					"						<td><input class='form-control' type='text' name='maSV' required=\"required\" value='"+sinhVien.getMaSV()+"'></td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td>Họ tên:</td>" + 
					"						<td><input class='form-control' type='text' name='hoTen' required=\"required\" value='"+sinhVien.getHoTen()+"'></td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td>Giới tính:</td>"; 
			if(sinhVien.getGioiTinh().equalsIgnoreCase("Nam")) {
				html +="				<td><input class='form-check-inline' type='radio'" + 
						"							name='gioiTinh' value='Nam' required=\"required\" checked>Name <input" + 
						"							class='form-check-inline' type='radio' name='gioiTinh'" + 
						"							value='Nu' required=\"required\">Nữ" +
						"						</td>";
			} else {
				html +="				<td><input class='form-check-inline' type='radio'" + 
						"							name='gioiTinh' value='Nam' required=\"required\">Name <input" + 
						"							class='form-check-inline' type='radio' name='gioiTinh'" + 
						"							value='Nữ' required=\"required\" checked>Nữ" +
						"						</td>";
			}

			html +="				</tr>" + 
					"					<tr>" + 
					"						<td>Số điện thoại:</td>" + 
					"						<td><input class='form-control' type='tel' name='soDT' required=\"required\" value='"+sinhVien.getSoDT()+"'></td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td>Địa chỉ:</td>" + 
					"						<td><textarea class='form-control' name='diaChi' id=''" + 
					"								cols='30' rows='10' required=\"required\">"+sinhVien.getDiaChi()+"</textarea></td>" + 
					"					</tr>" + 
					"					<tr>" + 
					"						<td></td>" + 
					"						<td><button type='submit' onclick='submitForm()'>Lưu</button></td>" + 
					"					</tr>" + 
					"				</table>" + 
					"			</form>" + 
					"		</div>" + 
					"	</div>" + 
					"	<footer class='border mt-2'>" + 
					"		<h3 style='text-align: center;'>" + 
					"			<i>Đinh Đăng Khoa - 17080051</i>" + 
					"		</h3>" + 
					"	</footer>" + 
					"</body>" + 
					"" + 
					"</html>";
		}
		out.print(html);

	}
}
