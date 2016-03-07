package core.com.ptk.service;

import java.util.List;

import core.com.ptk.entity.Typeword;

public interface TypewordService {
	List<Typeword> getAll();
	Typeword getById(int id);
}
