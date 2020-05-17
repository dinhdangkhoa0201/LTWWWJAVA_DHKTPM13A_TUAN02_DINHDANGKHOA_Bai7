package fit.se.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SinhVienEntityManager {
	private static SinhVienEntityManager instance = null;
	private EntityManager em;
	
	public SinhVienEntityManager() {
		em = Persistence.createEntityManagerFactory("LTWWWJAVA_DHKTPM13A_TUAN01_DINHDANGKHOA_Bai7").createEntityManager();
	}
	
	public synchronized static SinhVienEntityManager getInstance() {
		if(instance == null)
			instance = new SinhVienEntityManager();
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public static void main(String[] args) {
		new SinhVienEntityManager();
	}
}
