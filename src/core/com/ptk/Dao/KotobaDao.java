package core.com.ptk.Dao;

import java.util.List;

import core.com.ptk.entity.Kotoba;

public interface KotobaDao extends AbstractDao<Kotoba>{

	List<Kotoba> getByLesson(int i);

	Kotoba getByJp(String jp);

	Kotoba getById(int id);

}
