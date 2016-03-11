package core.com.ptk.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.TypewordDao;
import core.com.ptk.DaoImpl.TypewordDaoImpl;
import core.com.ptk.entity.Typeword;
import core.com.ptk.service.TypewordService;

public class TypewordServiceImpl extends CommonServiceImpl implements TypewordService{
	
	public TypewordServiceImpl() {
		super();
	}
	private TypewordDao typeword = new TypewordDaoImpl(con);

	public List<Typeword> getAll() {
		List<Typeword> result = new ArrayList<>();
		
		result = typeword.getAll();
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Typeword getById(int id) {
		Typeword result = typeword.getById(id);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void getTypewordList(List<Integer> typewordList, String typewordName) {
		int twId = typeword.getByName(typewordName).getId();
		typewordList.add(twId);
		List<Typeword> child = typeword.getByParent(twId);
		for (int i = 0; i < child.size(); i++){
			getTypewordList(typewordList, child.get(i).getName());
		}
		return;
	}
	
}
