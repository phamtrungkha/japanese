package core.com.ptk.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.KanjiRootDao;
import core.com.ptk.Dao.KotobaDao;
import core.com.ptk.entity.KanjiRoot;
import core.com.ptk.entity.Kotoba;
import core.com.ptk.entity.Typeword;

public class KanjiRootDaoImpl extends CommonDaoImpl implements KanjiRootDao {
	
	private static final String SELECT_BY_KANJI = "SELECT * FROM kanji_root WHERE kanji = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM kanji_root WHERE id = ?";
	Connection con = null;
	public KanjiRootDaoImpl() {
		con = getConnection();
	}

	private final String INSERT = "INSERT INTO kotoba(jp, vn, en, typeword, lesson, ignoreword) VALUES(?,?,?,?,?,?)";
	@Override
	public List<Kotoba> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Kotoba kotoba) {
		int result = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT);
			preparedStatement.setString(1, kotoba.getJp());
			preparedStatement.setString(2, kotoba.getVn());
			preparedStatement.setString(3, kotoba.getEn());
			preparedStatement.setInt(4, kotoba.getTypeword().getId());
			preparedStatement.setInt(5, kotoba.getLesson());
			preparedStatement.setBoolean(6, kotoba.isIgnoreword());
			result = preparedStatement.executeUpdate();
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
	public KanjiRoot getByKanji(String kanji) {
		KanjiRoot result = new KanjiRoot();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_KANJI);
			pstm.setString(1, kanji);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()){
				result.setId(rs.getInt(1));
				result.setKanji(rs.getString(2));
				result.setHanTu(rs.getString(3));
				result.setAmOn(rs.getString(4));
				result.setAmKun(rs.getString(5));
				result.setMoTa(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public KanjiRoot getById(int id) {
		KanjiRoot result = new KanjiRoot();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_ID);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()){
				result.setId(rs.getInt(1));
				result.setKanji(rs.getString(2));
				result.setHanTu(rs.getString(3));
				result.setAmOn(rs.getString(4));
				result.setAmKun(rs.getString(5));
				result.setMoTa(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
