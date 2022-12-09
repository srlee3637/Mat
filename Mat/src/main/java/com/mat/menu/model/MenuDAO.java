package com.mat.menu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.mat.util.JDBCUtil;

public class MenuDAO {

	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String uid = "Matzip";
	public static final String upw = "Matzip";

	Scanner sc = new Scanner(System.in);
	
	//Select Store Method
	public ArrayList<MenuVO> selectStore(String name) {

		ArrayList<MenuVO> list = new ArrayList<>();

		String sql = "select menuname, m.price from store s\n"
				+ "join menu m on s.locationtype = m.locationtype and s.storenum = m.storenum\n"
				+ "where storename = '" + name + "'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String menuName = rs.getString("menuName");
				int price = rs.getInt("price");
				
				MenuVO vo = new MenuVO(menuName,price);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}
	
}
