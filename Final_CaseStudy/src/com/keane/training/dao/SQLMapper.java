package com.keane.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.keane.dbfw.ResultMapper;
import com.keane.training.domain.Rented;
import com.keane.training.domain.User;
import com.keane.training.domain.Vehicle;

public class SQLMapper {
	public static final String INSERTUSER="insert into User_194284 values(?,?,?,?,?,?,?)";
	public static final String INSERTVEHICLE="INSERT INTO Vehicle_194284 values(?,?,?,?,?,?)";
	public static final String VEHICLELIST="select * from Vehicle_194284";
	public static final String CHECKLOGIN="select * from User_194284 where rno=? and userid=? and password=?";
	public static final String CHECKLOGIN1="select * from User_194284 WHERE userid=?";
	public static final String FETCHSTATUS="select * from Vehicle_194284 where status='YES'";
	public static final String BOOKEDVEHICLE="select vehicle_no,vehicle_type,vehicle_name,price from Vehicle_194284 where vehicle_no=(select vehicle_no from Rented_194284 where user_id=?)";
	public static final String FETCHVEHICLE="select * from Vehicle_194284 where vehicle_type=?";
	public static final String FETCHDISCOUNT="select vehicle_no,vehicle_type,vehicle_name,price from Vehicle_194284 where discount is not null";
	public static final String FETCHPRICE="select vehicle_no,vehicle_type,vehicle_name,(PRICE-DISCOUNT) as new_price from Vehicle_194284";
	public static final String INSERTRENT="insert into Rented_194284(user_id,vehicle_no) values(?,?)";
	public static final String INSERTFEED="update Rented_194284 set feedback=? where user_id=?";
	public static final String UPDATEDIS="update Vehicle_194284 set discount=? where vehicle_name=?";
	public static final String FETCHRENT="select * from Rented_194284";
	public static final String FETCHRENTBOOK="select user_id,vehicle_no from Rented_194284";
	public static final ResultMapper USERMAPPER=
			new ResultMapper()
		{

		
			public Object mapRow(ResultSet rs) throws SQLException {
			int id=	rs.getInt(1);
			String name=rs.getString(2);
			String city=rs.getString(3);
			String email=rs.getString(4);
			int contact=rs.getInt(5);
			int rno=rs.getInt(6);
			String pwd=rs.getString(7);
			User c=new User(id,name,city,email,contact,rno,pwd);
				return c;
			}//mapRow
			
		};
		public static final ResultMapper VEHICLEMAPPER=new ResultMapper()
				{
			public Object mapRow(ResultSet rs) throws SQLException{
				String vno=rs.getString(1);
				String vtype=rs.getString(2);
				String vname=rs.getString(3);
				int price=rs.getInt(4);
				String status=rs.getString(5);
				int discount=rs.getInt(6);
				Vehicle v=new Vehicle(vno,vtype,vname,price,status,discount);
				return v;
			}
		};
	public static final ResultMapper TYPEMAPPER=new ResultMapper()
						{
						public Object mapRow(ResultSet rs) throws SQLException{
						String vno=rs.getString(1);
						String vtype=rs.getString(2);
						String vname=rs.getString(3);
						int price=rs.getInt(4);
						Vehicle v=new Vehicle(vno,vtype,vname,price);
						return v;
						}
						};
	public static final ResultMapper RENTMAPPER=new ResultMapper()
						{
public Object mapRow(ResultSet rs) throws SQLException{
	int id=rs.getInt(1);
	String vehicleno=rs.getString(2);
	String feedback=rs.getString(3);
	Rented r=new Rented(id,vehicleno,feedback);
	return r;
}
};
	public static final ResultMapper RENTALLMAPPER=new ResultMapper()
								{
		public Object mapRow(ResultSet rs) throws SQLException{
			int id=rs.getInt(1);
			String vehicleno=rs.getString(2);
			Rented r=new Rented(id,vehicleno);
			return r;
		}
	};
							
		
}



