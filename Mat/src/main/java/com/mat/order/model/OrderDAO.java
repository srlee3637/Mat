package com.mat.order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mat.util.JDBCUtil;

public class OrderDAO {
	
	private static OrderDAO instance = new OrderDAO();

	private OrderDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("Driver class load error");
		}
	}

	public static OrderDAO getInstance() {
		return instance;
	}

	public static final String url = "jdbc:oracle:thin:@172.30.1.100:1521:XE";
	public static final String uid = "mat";
	public static final String upw = "mat";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	//Insert Method
	public int insertOrder(String id, String storeNum, String storeName, String menuNum, String menuName, String price, String menuCnt) {

		int result = 0;
		
		String sql = "insert into ORDERS values(orders_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, storeName);
			pstmt.setString(3, menuNum);
			pstmt.setString(4, menuName);
			pstmt.setString(5, price);
			pstmt.setString(6, menuCnt);
			pstmt.setString(7, storeNum);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return result;
	}
	
	
	//getList Method
	public ArrayList<OrderVO> getList(String id) {

		ArrayList<OrderVO> list = new ArrayList<>();

		String sql = "select * from ORDERS  where id = ? order by orderNum desc";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			

			while(rs.next()) {
				
				String orderNum = rs.getString("orderNum");
				
				String storeName = rs.getString("storeName");
				String menuNum = rs.getString("menuNum");
				String menuName = rs.getString("menuName");
				String price = rs.getString("price");
				String menuCnt = rs.getString("menuCnt");
				Timestamp orderDate = rs.getTimestamp("orderDate");
				String storeNum = rs.getString("storeNum");
				
				OrderVO vo = new OrderVO(orderNum, id, storeNum, storeName,
						menuNum, menuName, price, menuCnt, orderDate);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}
	
	
	//????????? orderNum ?????? ?????????
	public String lastOrderNum() {

		String lastOrderNum = "";
		
		String sql = "select max(orderNum) max from ORDERS";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				lastOrderNum = rs.getString("max");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return lastOrderNum;
	}
	
}