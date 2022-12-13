package com.mat.menu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.mat.util.JDBCUtil;

public class MenuDAO {

	public static final String url = "jdbc:oracle:thin:@172.30.1.100:1521:XE";
	public static final String uid = "mat";
	public static final String upw = "mat";

	private static MenuDAO instance = new MenuDAO();
	
	private MenuDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("Driver class load error");
		}
	}
	
	public static MenuDAO getInstance() {
		return instance;
	}
	
	
	//가게 모든 메뉴 불러오는 메서드
	public ArrayList<MenuVO> getMenu(String storeNum) {

		ArrayList<MenuVO> list = new ArrayList<>();

		String sql = "select * from menu where storeNum = " + storeNum;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int menuNum = rs.getInt("menuNum");
				int locationType = rs.getInt("locationType");
				int storeNum2 = rs.getInt("storeNum");
				String menuName = rs.getString("menuName");
				int price = rs.getInt("price");
				
				MenuVO vo = new MenuVO(menuNum, locationType, storeNum2, menuName,price);
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
