package core.com.ptk.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.KanjiDao;
import core.com.ptk.DaoImpl.KanjiDaoImpl;
import core.com.ptk.entity.Kanji;
import core.com.ptk.service.KanjiService;

public class KanjiServiceImpl extends CommonServiceImpl implements KanjiService{

	public KanjiServiceImpl() {
		super();
	}
	KanjiDao kanjiDao = new KanjiDaoImpl(con);
	public int insert(Kanji kanji) {
		int row = 0;
		row = kanjiDao.insert(kanji);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	// Can xoa
	private List<Kanji> appendList(List<Kanji> list1, List<Kanji> list2) {
		List<Kanji> result = new ArrayList<>();
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
	// Can xoa
	public List<Kanji> getByLevels(int[] levels) {

		List<Kanji> result  = new ArrayList<>();
		for (int i = 0; i < levels.length; i++){
			List<Kanji> kanjii = kanjiDao.getByLevel(levels[i]);
			result = appendList(result, kanjii);
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
