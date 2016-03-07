package core.com.ptk.Dao;

import java.util.List;

import core.com.ptk.entity.Typeword;

public interface TypewordDao extends AbstractDao<Typeword> {

	Typeword getById(int id);
}
