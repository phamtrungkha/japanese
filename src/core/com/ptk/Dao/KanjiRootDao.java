package core.com.ptk.Dao;

import java.util.List;

import core.com.ptk.entity.KanjiRoot;
import core.com.ptk.entity.Kotoba;

public interface KanjiRootDao extends AbstractDao<Kotoba>{

	KanjiRoot getByKanji(String kanji);

	KanjiRoot getById(int id);

}
