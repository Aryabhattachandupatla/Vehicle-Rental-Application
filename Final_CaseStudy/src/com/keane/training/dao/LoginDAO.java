package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;

public class LoginDAO {
	static Logger log = Logger.getLogger(LoginDAO.class);

	public List validateUser(final int userid,final int rno,final String password) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(2, userid);
					pStmt.setInt(1, rno);
					pStmt.setString(3, password);
				}
			};
			res = DBHelper.executeSelect(con, SQLMapper.CHECKLOGIN,
					paramMapper, SQLMapper.USERMAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}
}
