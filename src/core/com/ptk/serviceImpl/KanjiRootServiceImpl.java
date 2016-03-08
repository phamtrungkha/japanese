package core.com.ptk.serviceImpl;

import java.sql.SQLException;

import core.com.ptk.Dao.KanjiDao;
import core.com.ptk.Dao.KanjiRootDao;
import core.com.ptk.DaoImpl.KanjiDaoImpl;
import core.com.ptk.DaoImpl.KanjiRootDaoImpl;
import core.com.ptk.entity.KanjiRoot;
import core.com.ptk.service.KanjiRootService;

public class KanjiRootServiceImpl extends CommonServiceImpl implements  KanjiRootService{

	KanjiRootDao kanjiRootDao = new KanjiRootDaoImpl(con);
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

}
