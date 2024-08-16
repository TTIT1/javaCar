package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.useName;

public class DAOuseName implements Daointerface<useName> {
	public static DAOuseName getusename() {
		return new DAOuseName();
	}
	@Override
	public int insert(useName t) {
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO useName (useName) VALUSE (?)";
		try {
			PreparedStatement pre =con.prepareStatement(sql);
			 pre.setNString(1, t.getUseName());
			pre.execute();
			JDBCUtil.closeconnection(con);
			
		} catch (Exception e) {
		e.printStackTrace();
;		}
		return 0;
	}

	@Override
	public int updete(useName t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(useName t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<useName> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public useName selectbyid(useName t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<useName> selectbyCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
