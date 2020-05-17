package fit.se.main;

import fit.se.dao.SinhVienDAO;
import fit.se.entities.SinhVien;

public class MainTest {
	public static void main(String[] args) {
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		sinhVienDAO.addSinhVien(new SinhVien("17080051", "Dinh Dang Khoa", "Nam", "0398122553", "TPHCM"));
		System.out.println(sinhVienDAO.getSinhViens());
	}
}
