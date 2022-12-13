package com.mat.orderDetail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mat.util.JDBCUtil;

public class OrderDetailDAO {
	
	private static OrderDetailDAO instance = new OrderDetailDAO();

	private OrderDetailDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("Driver class load error");
		}
	}

	public static OrderDetailDAO getInstance() {
		return instance;
	}

	public static final String url = "jdbc:oracle:thin:@172.30.1.100:1521:XE";
	public static final String uid = "mat";
	public static final String upw = "mat";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	//OrderDetail Insert Method
	public int insertOrderDetail(String orderNum, String id, String storeNum, String storeName, String menuNum, String menuName, String price, String menuQuantity) {

		int result = 0;
		
		String sql = "insert into ORDERDETAIL values(orderDetail_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, orderNum);
			pstmt.setString(2, id);
			pstmt.setString(3, storeName);
			pstmt.setString(4, menuNum);
			pstmt.setString(5, menuName);
			pstmt.setString(6, price);
			pstmt.setString(7, menuQuantity);
			pstmt.setString(8, storeNum);
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return result;
	}
	
	
	//특정 OrderNum 주문 정보 list 저장 메서드
	public ArrayList<OrderDetailVO> getList(String orderNum) {

		ArrayList<OrderDetailVO> list = new ArrayList<>();

		String sql = "select * from ORDERDETAIL where orderNum = " + orderNum;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				String orderDetailNum = rs.getString("orderDetailNum");
				String id = rs.getString("id");
				String storeNum = rs.getString("storeNum");
				String storeName = rs.getString("storeName");
				String menuNum = rs.getString("menuNum");
				String menuName = rs.getString("menuName");
				String price = rs.getString("price");
				String menuQuantity = rs.getString("menuQuantity");
				Timestamp orderDate = rs.getTimestamp("orderDate");
				
				OrderDetailVO vo = new OrderDetailVO(orderDetailNum, orderNum, id, storeNum,
						storeName, menuNum, menuName, price, menuQuantity, orderDate);
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
