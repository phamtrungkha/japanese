package core.com.ptk.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.KanjiRootDao;
import core.com.ptk.Dao.KanjiDao;
import core.com.ptk.entity.KanjiRoot;
import core.com.ptk.entity.Kanji;
import core.com.ptk.entity.Typeword;

public class KanjiRootDaoImpl extends CommonDaoImpl implements KanjiRootDao {

	private static final String SELECT_BY_LEVEL = "SELECT * FROM kanji_root WHERE level = ?";
	private static final String SELECT_BY_KANJI = "SELECT * FROM kanji_root WHERE kanji = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM kanji_root WHERE id = ?";
	Connection con = null;
	public KanjiRootDaoImpl(Connection conn) {
		con = conn;
	}

	private final String INSERT = "INSERT INTO kanji_root(kanji, hantu, amon, amkun, mota, level) VALUES(?,?,?,?,?,?)";
	@Override
	public List<KanjiRoot> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(KanjiRoot kanjiRoot) {
		int result = 0;
		if (isExistInDB(kanjiRoot))
			return 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT);
			preparedStatement.setString(1, kanjiRoot.getKanji());
			preparedStatement.setString(2, kanjiRoot.getHanTu());
			preparedStatement.setString(3, kanjiRoot.getAmOn());
			preparedStatement.setString(4, kanjiRoot.getAmKun());
			preparedStatement.setString(5, kanjiRoot.getMoTa());
			preparedStatement.setInt(6, kanjiRoot.getLevel());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private boolean isExistInDB(KanjiRoot kanjiRoot) {
		boolean result = false;
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_KANJI);
			pstm.setString(1, kanjiRoot.getKanji());
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
	public int update(KanjiRoot kanjiRoot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KanjiRoot kanjiRoot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public KanjiRoot getByKanji(String kanji) {
		KanjiRoot result = null;
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_KANJI);
			pstm.setString(1, kanji);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()){
				result = new KanjiRoot();
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
	
	@Override
	public List<KanjiRoot> getByLevel(int level) {
		List<KanjiRoot> result = new ArrayList<>();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_LEVEL);
			pstm.setInt(1, level);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				KanjiRoot kanjiRoot = new KanjiRoot();
				kanjiRoot.setId(rs.getInt(1));
				kanjiRoot.setKanji(rs.getString(2));
				kanjiRoot.setHanTu(rs.getString(3));
				kanjiRoot.setAmOn(rs.getString(4));
				kanjiRoot.setAmKun(rs.getString(5));
				kanjiRoot.setMoTa(rs.getString(6));
				kanjiRoot.setLevel(level);
				result.add(kanjiRoot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
