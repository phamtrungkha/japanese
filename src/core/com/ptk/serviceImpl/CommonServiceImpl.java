package core.com.ptk.serviceImpl;

import java.sql.Connection;

import core.com.ptk.DaoImpl.CommonDaoImpl;

public class CommonServiceImpl {

	Connection con = null;
	public CommonServiceImpl() {
		con = (new CommonDaoImpl()).getConnection();
	}
}
