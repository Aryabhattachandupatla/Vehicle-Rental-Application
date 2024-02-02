package com.keane.training.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
	import com.keane.dbcon.DBConnectionException;
	import com.keane.dbfw.DBFWException;
	import com.keane.dbfw.ParamMapper;
	import com.keane.dbfw.DBHelper;

import com.keane.training.domain.User;
import com.keane.training.domain.Vehicle;

	public class VehicleDAO {
		static Logger log=Logger.getLogger(Vehicle.class);
		
		//insert
		public static int insertVehicle(final Vehicle v)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper INSERTPVEHICLE=new ParamMapper()
				{

					
					public void mapParam(PreparedStatement preStmt)
							throws SQLException {
						preStmt.setString(1, v.getVno());
						preStmt.setString(2, v.getVtype());
						preStmt.setString(3, v.getVname());
						preStmt.setInt(4,v.getPrice());
						preStmt.setString(5, v.getStatus());
						preStmt.setInt(6, v.getDiscount());
					}
					
				};
				
			result=DBHelper.executeUpdate(con,SQLMapper.INSERTVEHICLE,INSERTPVEHICLE);
				
				
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
			
		}//insert
		public static List getState() throws DBConnectionException,DBFWException
		{
			ConnectionHolder ch=null;
			Connection con=null;
			List result=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				result=DBHelper.executeSelect(con, SQLMapper.FETCHSTATUS, SQLMapper.VEHICLEMAPPER);
			}
			catch(DBConnectionException e)
			{
				throw new DBConnectionException("unable to connect to db");
			}
			finally {
				try {
					if(con!=null)
						con.close();
					
				}catch(SQLException e) {
					
				}
			}
			return result;
			
		}
		/*public static List availableVehicle(final Vehicle v) throws DBFWException,DBConnectionException
		{
			ConnectionHolder ch=null;
			Connection con=null;
			List result=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				result=DBHelper.executeSelect(con,SQLMapper.AVAILABLEVEHICLE,SQLMapper.VEHICLEMAPPER);
			}catch(DBConnectionException e)
			{
				throw new DBConnectionException("Unable to connect to db");
			}
			finally {
				try {
					if(con!=null)
						con.close();
				}catch(SQLException e)
				{
					
				}
			
		}
			return result;
		

	}*/
		public static List getVehicles() throws DBFWException,DBConnectionException
		{
			List vehicles=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				vehicles=DBHelper.executeSelect(con,SQLMapper.VEHICLELIST,SQLMapper.VEHICLEMAPPER);
			}catch (DBConnectionException e)
			{
				throw new DBConnectionException("Unable to connect to db");
			}
			finally {
				try {
					
				if(con!=null)
					con.close();
			}catch(SQLException e)
			{
				
			}
			
		}
		return vehicles;
	}
		public static List getVeh(final String vehicle_type) throws DBFWException 
		{
			List vehicle=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				final ParamMapper VEHICLEPMAPPER=new ParamMapper()
						{
					public void mapParam(PreparedStatement preStmt) throws SQLException{
						preStmt.setString(1, vehicle_type);
					}
				};
				vehicle=DBHelper.executeSelect(con,SQLMapper.FETCHVEHICLE,VEHICLEPMAPPER,SQLMapper.VEHICLEMAPPER);
			}catch (DBConnectionException e)
			{
				e.printStackTrace();
			}
		
		
		return vehicle;
	}
		public static List bookedVehicles(final int uid) throws DBFWException,DBConnectionException
		{
			List user=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				final ParamMapper VEHICLEPMAPPER=new ParamMapper()
						{
					public void mapParam(PreparedStatement preStmt) throws SQLException{
						preStmt.setInt(1,uid);
					}
				};
				user=DBHelper.executeSelect(con,SQLMapper.BOOKEDVEHICLE,VEHICLEPMAPPER,SQLMapper.TYPEMAPPER);
			}catch (DBConnectionException e)
			{
				throw new DBConnectionException("Unable to connect to db");
			}
			finally {
				try {
					
				if(con!=null)
					con.close();
			}catch(SQLException e)
			{
				
			}
			
		}
		return user;
	}
		public static List getDiscount() throws DBFWException,DBConnectionException
		{
			List vehicles=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				vehicles=DBHelper.executeSelect(con,SQLMapper.FETCHDISCOUNT,SQLMapper.TYPEMAPPER);
			}catch (DBConnectionException e)
			{
				throw new DBConnectionException("Unable to connect to db");
			}
			finally {
				try {
					
				if(con!=null)
					con.close();
			}catch(SQLException e)
			{
				
			}
			
		}
		return vehicles;}
		public static List getPrice() throws DBFWException,DBConnectionException
		{
			List vehicles=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				vehicles=DBHelper.executeSelect(con,SQLMapper.FETCHPRICE,SQLMapper.TYPEMAPPER);
			}catch (DBConnectionException e)
			{
				throw new DBConnectionException("Unable to connect to db");
			}
			finally {
				try {
					
				if(con!=null)
					con.close();
			}catch(SQLException e)
			{
				
			}
			
		}
		return vehicles;
		}
		public static int insertRented(final int id,final String vno) throws DBFWException
		{
			int result=0;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				final ParamMapper INSERTPMAPPER=new ParamMapper()
						{
					public void mapParam(PreparedStatement preStmt)throws SQLException{
						preStmt.setInt(1, id);
						preStmt.setString(2, vno);
					}
						};
						result=DBHelper.executeUpdate(con,SQLMapper.INSERTRENT,INSERTPMAPPER);
			}
			catch (DBConnectionException e)
			{
				e.printStackTrace();
			}
		
		
		return result;
		}
		public static int updateFeedback(final String name,final int id) throws DBFWException
		{
			int result=0;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				final ParamMapper UPDATEPMAPPER=new ParamMapper()
						{
					public void mapParam(PreparedStatement preStmt)throws SQLException{
						preStmt.setString(1, name);
						preStmt.setInt(2, id);
					}
						};
						result=DBHelper.executeUpdate(con,SQLMapper.INSERTFEED,UPDATEPMAPPER);
			}
			catch (DBConnectionException e)
			{
				e.printStackTrace();
			}
		
		
		return result;
		}
		public static int updatedDiscount(final int discount,final String name) throws DBFWException
		{
			int result=0;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				final ParamMapper UPDATEDIS=new ParamMapper()
						{
					public void mapParam(PreparedStatement preStmt)throws SQLException{
						preStmt.setInt(1, discount);
						preStmt.setString(2, name);
					}
						};
						result=DBHelper.executeUpdate(con,SQLMapper.UPDATEDIS,UPDATEDIS);
			}
			catch (DBConnectionException e)
			{
				e.printStackTrace();
			}
		
		
		return result;
		}
		public static List getRented() throws DBFWException,DBConnectionException
		{
			List vehicles=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				vehicles=DBHelper.executeSelect(con,SQLMapper.FETCHRENT,SQLMapper.RENTMAPPER);
			}catch (DBConnectionException e)
			{
				throw new DBConnectionException("Unable to connect to db");
			}
			finally {
				try {
					
				if(con!=null)
					con.close();
			}catch(SQLException e)
			{
				
			}
			
		}
		return vehicles;
		}
		public static List getRentedAll() throws DBFWException,DBConnectionException
		{
			List vehicles=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				vehicles=DBHelper.executeSelect(con,SQLMapper.FETCHRENTBOOK,SQLMapper.RENTALLMAPPER);
			}catch (DBConnectionException e)
			{
				throw new DBConnectionException("Unable to connect to db");
			}
			finally {
				try {
					
				if(con!=null)
					con.close();
			}catch(SQLException e)
			{
				
			}
			
		}
		return vehicles;
		}
}


