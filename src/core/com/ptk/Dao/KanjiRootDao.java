package core.com.ptk.Dao;

import java.util.List;

import core.com.ptk.entity.KanjiRoot;

public interface KanjiRootDao extends AbstractDao<KanjiRoot>{

	KanjiRoot getByKanji(String kanji);

	KanjiRoot getById(int id);

	List<KanjiRoot> getByLevel(int level);

}
