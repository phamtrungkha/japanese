package core.com.ptk.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.KanjiDao;
import core.com.ptk.Dao.KanjiRootDao;
import core.com.ptk.DaoImpl.KanjiDaoImpl;
import core.com.ptk.DaoImpl.KanjiRootDaoImpl;
import core.com.ptk.entity.Kanji;
import core.com.ptk.entity.KanjiRoot;
import core.com.ptk.service.KanjiRootService;

public class KanjiRootServiceImpl extends CommonServiceImpl implements  KanjiRootService{

	KanjiRootDao kanjiRootDao = new KanjiRootDaoImpl(con);
	
	public int insert(KanjiRoot kanjiRoot) {
		int row = 0;
		row = kanjiRootDao.insert(kanjiRoot);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	public KanjiRoot getByKanji(String kanji) {
		KanjiRoot kanjiRoot = kanjiRootDao.getByKanji(kanji);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kanjiRoot;
	}
	
	public int addKanjiRoot(KanjiRoot kanjiRoot) {
		int result = kanjiRootDao.insert(kanjiRoot);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private List<KanjiRoot> appendList(List<KanjiRoot> list1, List<KanjiRoot> list2) {
		List<KanjiRoot> result = new ArrayList<>();
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
	
	public List<KanjiRoot> getByLevels(int[] levels) {

		List<KanjiRoot> result  = new ArrayList<>();
		for (int i = 0; i < levels.length; i++){
			List<KanjiRoot> kanjiRooti = kanjiRootDao.getByLevel(levels[i]);
			result = appendList(result, kanjiRooti);
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
