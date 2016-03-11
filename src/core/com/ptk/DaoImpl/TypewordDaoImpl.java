package core.com.ptk.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.TypewordDao;
import core.com.ptk.entity.Typeword;

public class TypewordDaoImpl extends CommonDaoImpl implements TypewordDao{
	
	private final String SELECT_ALL = "SELECT * FROM typeword";
	private final String SELECT_BY_ID = "SELECT * FROM typeword WHERE id = ?";
	private final String SELECT_BY_PARENT = "SELECT * FROM typeword WHERE parent = ?";
	private final String SELECT_BY_NAME = "SELECT * FROM typeword WHERE name = ?";

	Connection con = null;
	public TypewordDaoImpl(Connection conn) {
		con = conn;
	}
	
	@Override
	public List<Typeword> getAll() {
		List<Typeword> result = new ArrayList<>();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstm.executeQuery();
		//	rs.next();
			while (rs.next()){
				Typeword tw = new Typeword();
				tw.setId(rs.getInt(1));
				tw.setName(rs.getString(2));
				tw.setDescribe(rs.getString(3));
				tw.setParent(getById(rs.getInt(4)));
				result.add(tw);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Typeword getById(int id) {
		
		Typeword result = null;
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_ID);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				result = new Typeword();
				result.setId(rs.getInt(1));
				result.setName(rs.getString(2));
				result.setDescribe(rs.getString(3));
				result.setParent(getById(rs.getInt(4)));
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insert(Typeword object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Typeword object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Typeword object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Typeword getByName(String name) {
		Typeword result = null;
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_NAME);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()){
				result = new Typeword();
				result.setId(rs.getInt(1));
				result.setName(rs.getString(2));
				result.setDescribe(rs.getString(3));
				result.setParent(getById(rs.getInt(4)));
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Typeword> getByParent(int parent) {
		List<Typeword> result = new ArrayList<>();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_PARENT);
			pstm.setInt(1, parent);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				Typeword tw = new Typeword();
				tw.setId(rs.getInt(1));
				tw.setName(rs.getString(2));
				tw.setDescribe(rs.getString(3));
				tw.setParent(getById(rs.getInt(4)));
				result.add(tw);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
