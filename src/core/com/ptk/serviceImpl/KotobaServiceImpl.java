package core.com.ptk.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.KotobaDao;
import core.com.ptk.DaoImpl.KotobaDaoImpl;
import core.com.ptk.entity.Kotoba;
import core.com.ptk.service.KotobaService;

public class KotobaServiceImpl extends CommonServiceImpl implements KotobaService{

	public KotobaServiceImpl() {
		super();
	}
	KotobaDao kotobaDao = new KotobaDaoImpl(con);
	public void addKotoba(Kotoba kotoba) {
		kotobaDao.insert(kotoba);
	}
	public List<Kotoba> getByLesson(int[] lessons) {

		List<Kotoba> result  = new ArrayList<>();
		for (int i = 0; i < lessons.length; i++){
			List<Kotoba> kotobai = kotobaDao.getByLesson(lessons[i]);
			result = appendList(result, kotobai);
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public Kotoba getByJp(String jp) {
		Kotoba kotoba = kotobaDao.getByJp(jp);
		return kotoba;
	}
	private List<Kotoba> appendList(List<Kotoba> list1, List<Kotoba> list2) {
		List<Kotoba> result = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++)
			result.add(list1.get(i));
		for (int i = 0; i < list2.size(); i++)
			result.add(list2.get(i));
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int insert(Kotoba kotoba) {
		int result = kotobaDao.insert(kotoba);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
