package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.User;

public class RegisterDAO {
	public int registerUser(final User user) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParam(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, user.getUid());
				pStmt.setString(2, user.getName());
				pStmt.setInt(5, user.getContactno());
				pStmt.setString(7, user.getPassword());
				pStmt.setString(3, user.getCity());
				pStmt.setString(4, user.getEmail());
				pStmt.setInt(6, user.getRno());
				
			}
		};

		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SQLMapper.INSERTUSER, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}


	public boolean validateUser(final int uid) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParam(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1,uid);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users = DBHelper.executeSelect(con, SQLMapper.CHECKLOGIN1,
					paramMapper, SQLMapper.USERMAPPER);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);

	}
}
