package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.CustomerDetails;
import com.revature.util.ConnectionUtil;

public class CustomerDAO {

	public static CustomerDetails login(int cstid, String pass) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String sql = "select UserName, Cno, PassWord, Email, MobileNumber,AccountNumber,AccountType,bal,PanNumber,AadharNumber from Customer_Details where Cno= ? and PassWord= ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, cstid);
		pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();

		CustomerDetails det = null;

		if (rs.next()) {

			String username = rs.getString("UserName");
			Integer cid = rs.getInt("Cno");
			String pwd = rs.getString("PassWord");
			String email = rs.getString("Email");
			long mobno = rs.getLong("MobileNumber");
			long actno = rs.getLong("AccountNumber");
			String actype = rs.getString("AccountType");
			double balance = rs.getDouble("bal");
			String pan = rs.getString("PanNumber");
			long aadhar = rs.getLong("AadharNumber");

			det = new CustomerDetails();
			det.setUsername(username);
			det.setCid(cid);
			det.setPass(pwd);
			det.setEmail(email);
			det.setMobno(mobno);
			det.setActno(actno);
			det.setActype(actype);
			det.setBalance(balance);
			det.setPan(pan);
			det.setAadhar(aadhar);

		}
		return det;
	}

}
