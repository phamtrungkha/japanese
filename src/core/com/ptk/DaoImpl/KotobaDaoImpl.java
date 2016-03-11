package core.com.ptk.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.KotobaDao;
import core.com.ptk.entity.Kotoba;
import core.com.ptk.entity.Typeword;

public class KotobaDaoImpl extends CommonDaoImpl implements KotobaDao {
	
	private static final String SELECT_BY_LESSON = "SELECT * FROM kotoba WHERE lesson = ?";
	private static final String SELECT_BY_JP = "SELECT * FROM kotoba WHERE jp = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM kotoba WHERE id = ?";
	private static final String SELECT_BY_JP_VN = "SELECT * FROM kotoba WHERE jp = ? and vn = ?";
	private static final String SELECT_BY_TYPEWORD = "SELECT * FROM kotoba WHERE typeword = ?";
	Connection con = null;
	public KotobaDaoImpl(Connection conn) {
		con = conn;
	}

	private final String INSERT = "INSERT INTO kotoba(jp, vn, en, typeword, lesson, ignoreword) VALUES(?,?,?,?,?,?)";
	private final String INSERT_FROM_EXCEL = "INSERT INTO kotoba(jp, vn, typeword, lesson, ignoreword) VALUES(?,?,?,?,?)";
	@Override
	public List<Kotoba> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Kotoba kotoba) {
		int result = 0;
		Kotoba a = getByJp(kotoba.getJp());
		if (isExistInDB(kotoba))
			return 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT);
			preparedStatement.setString(1, kotoba.getJp());
			preparedStatement.setString(2, kotoba.getVn());
			preparedStatement.setString(3, kotoba.getEn());
			preparedStatement.setInt(4, kotoba.getTypeword().getId());
			preparedStatement.setInt(5, kotoba.getLesson());
			preparedStatement.setBoolean(6, kotoba.isIgnoreword());
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private boolean isExistInDB(Kotoba kotoba) {
		boolean result = false;
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_JP_VN);
			pstm.setString(1, kotoba.getJp());
			pstm.setString(2, kotoba.getVn());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()){
				result = true;
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Kotoba object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Kotoba object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Kotoba> getByLesson(int lesson) {

		List<Kotoba> result = new ArrayList<>();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_LESSON);
			pstm.setInt(1, lesson);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				Kotoba kotoba = new Kotoba();
				kotoba.setId(rs.getInt(1));
				kotoba.setJp(rs.getString(2));
				kotoba.setVn(rs.getString(3));
				kotoba.setEn(rs.getString(4));
				kotoba.setTypeword((new TypewordDaoImpl(con)).getById(rs.getInt(5)));
				kotoba.setLesson(lesson);
				kotoba.setIgnoreword(rs.getBoolean(7));
				result.add(kotoba);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Kotoba getByJp(String jp) {
		Kotoba result = null;
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_JP);
			pstm.setString(1, jp);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()){
				result = new Kotoba();
				result.setId(rs.getInt(1));
				result.setJp(rs.getString(2));
				result.setVn(rs.getString(3));
				result.setEn(rs.getString(4));
				result.setTypeword((new TypewordDaoImpl(con)).getById(rs.getInt(5)));
				result.setLesson(rs.getInt(6));
				result.setIgnoreword(rs.getBoolean(7));
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Kotoba getById(int id) {
		Kotoba result = new Kotoba();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_ID);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()){
				result.setId(rs.getInt(1));
				result.setJp(rs.getString(2));
				result.setVn(rs.getString(3));
				result.setEn(rs.getString(4));
				result.setTypeword((new TypewordDaoImpl(con)).getById(rs.getInt(5)));
				result.setLesson(rs.getInt(6));
				result.setIgnoreword(rs.getBoolean(7));
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Kotoba> getByTypeword(Integer integer) {
		List<Kotoba> result = new ArrayList<>();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_TYPEWORD);
			pstm.setInt(1, integer);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				Kotoba kotoba = new Kotoba();
				kotoba.setId(rs.getInt(1));
				kotoba.setJp(rs.getString(2));
				kotoba.setVn(rs.getString(3));
				kotoba.setEn(rs.getString(4));
				kotoba.setTypeword((new TypewordDaoImpl(con)).getById(rs.getInt(5)));
				kotoba.setLesson(rs.getInt(6));
				kotoba.setIgnoreword(rs.getBoolean(7));
				result.add(kotoba);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
