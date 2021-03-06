package core.com.ptk.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.com.ptk.Dao.KanjiDao;
import core.com.ptk.entity.Kanji;
import core.com.ptk.entity.Kotoba;
import core.com.ptk.entity.Typeword;

public class KanjiDaoImpl extends CommonDaoImpl implements KanjiDao {
	
	private static final String SELECT_BY_LEVEL = "SELECT * FROM kanji WHERE level = ?";
	private static final String SELECT_BY_KANJI = "SELECT * FROM kanji WHERE kanji = ?";
	Connection con = null;
	public KanjiDaoImpl(Connection conn) {
		con = conn;
	}

	private final String INSERT = "INSERT INTO kanji(kanji, kotoba_id, kanji_root_id, level) VALUES(?,?,?,?)";
	@Override
	public List<Kanji> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Kanji kanji) {
		int result = 0;
		if (isExistInDB(kanji.getKanji()))
			return 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT);
			preparedStatement.setString(1, kanji.getKanji());
			preparedStatement.setInt(2, kanji.getKotoba().getId());
			preparedStatement.setInt(3, kanji.getKanjiRoot().getId());
			//preparedStatement.setInt(4, kanji.getLevel());		//need change
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private boolean isExistInDB(String kanji) {
		boolean result = false;
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_KANJI);
			pstm.setString(1, kanji);
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
	public int update(Kanji object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Kanji object) {
		// TODO Auto-generated method stub
		return 0;
	}

	// can xoa
	@Override
	public List<Kanji> getByLevel(int level) {
		List<Kanji> result = new ArrayList<>();
		try {
			PreparedStatement pstm = con.prepareStatement(SELECT_BY_LEVEL);
			pstm.setInt(1, level);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				Kanji kanji = new Kanji();
				kanji.setId(rs.getInt(1));
				kanji.setKanji(rs.getString(2));
				kanji.setKotoba((new KotobaDaoImpl(con)).getById(rs.getInt(3)));
				kanji.setKanjiRoot((new KanjiRootDaoImpl(con)).getById(rs.getInt(4)));
				//kanji.setLevel(level);		//need change
				result.add(kanji);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
