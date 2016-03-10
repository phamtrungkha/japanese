package core.com.ptk.service;

import java.util.List;

import core.com.ptk.entity.Kotoba;

public interface KotobaService {
	List<Kotoba> getByLesson(int[] lessons);
	Kotoba getByJp(String jp);
	int insert(Kotoba kotoba);
}
