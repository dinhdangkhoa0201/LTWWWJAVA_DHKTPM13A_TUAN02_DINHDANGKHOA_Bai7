package fit.se.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fit.se.entities.SinhVien;

public class SinhVienDAO {
	private EntityManager em;
	public SinhVienDAO() {
		em = SinhVienEntityManager.getInstance().getEntityManager();
	}
	
	public boolean addSinhVien(SinhVien sinhVien) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(sinhVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public boolean deleteSinhVien(SinhVien sinhVien) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(SinhVien.class, sinhVien.getMaSV()));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public boolean updateSinhVien(SinhVien sinhVien) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(sinhVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public SinhVien getSinhVien(String id) {
		return em.find(SinhVien.class, id);
	}
	
	public List<SinhVien> getSinhViens(){
		List<SinhVien> sinhViens = new ArrayList<SinhVien>();
		List<?> temp = em.createNativeQuery("db.sinhviens.find({})", SinhVien.class).getResultList();
		temp.forEach(x -> {
			SinhVien sinhVien = (SinhVien) x;
			sinhViens.add(sinhVien);
		});
		return sinhViens;
	}
}
