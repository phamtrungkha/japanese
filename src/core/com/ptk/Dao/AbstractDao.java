package core.com.ptk.Dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<T extends Serializable> {

	List<T> getAll();
	int insert(T object);
	int update(T object);
	int delete(T object);
}
