package fit.se.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "sinhviens")
public class SinhVien implements Serializable{
	@Id
	private String maSV;
	private String hoTen;
	private String gioiTinh;
	private String soDT;
	private String diaChi;
	
	public SinhVien() {
	}

	public SinhVien(String maSV, String hoTen, String gioiTinh, String soDT, String diaChi) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.diaChi = diaChi;
	}
	
	public SinhVien(String maSV) {
		this(maSV, "", "", "", "");
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSV == null) ? 0 : maSV.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		if (maSV == null) {
			if (other.maSV != null)
				return false;
		} else if (!maSV.equals(other.maSV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", soDT=" + soDT + ", diaChi="
				+ diaChi + "]";
	}
	
	
	
	
	
}
