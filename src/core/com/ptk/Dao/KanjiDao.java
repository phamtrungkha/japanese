package core.com.ptk.Dao;

import java.util.List;

import core.com.ptk.entity.Kanji;

public interface KanjiDao extends AbstractDao<Kanji>{

	List<Kanji> getByLevel(int levels);

}
