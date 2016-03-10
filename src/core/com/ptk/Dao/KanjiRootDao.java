package core.com.ptk.Dao;

import core.com.ptk.entity.KanjiRoot;

public interface KanjiRootDao extends AbstractDao<KanjiRoot>{

	KanjiRoot getByKanji(String kanji);

	KanjiRoot getById(int id);

}
