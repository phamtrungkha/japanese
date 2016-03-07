package core.com.ptk.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.KanjiDao;
import core.com.ptk.DaoImpl.KanjiDaoImpl;
import core.com.ptk.entity.Kanji;
import core.com.ptk.service.KanjiService;

public class KanjiServiceImpl implements KanjiService{

	KanjiDao kanjiDao = new KanjiDaoImpl();
	public void addKanji(Kanji kanji) {
		kanjiDao.insert(kanji);
	}
	public List<Kanji> getByLesson(int[] levels) {

		List<Kanji> result  = new ArrayList<>();
		for (int i = 0; i < levels.length; i++){
			List<Kanji> kanjii = kanjiDao.getByLevel(levels[i]);
			result = appendList(result, kanjii);
		}
		return result;
	}
	private List<Kanji> appendList(List<Kanji> list1, List<Kanji> list2) {
		List<Kanji> result = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++)
			result.add(list1.get(i));
		for (int i = 0; i < list2.size(); i++)
			result.add(list2.get(i));
		return result;
	}

}
