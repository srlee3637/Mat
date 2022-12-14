package com.mat.favorite.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mat.util.JDBCUtil;



public class FavoritesDAO {

	
	//1. 나자신의 객체를 생성해서 1개로 제한
		private static FavoritesDAO instance = new FavoritesDAO();
		
		//2. 직접 객체를 생성 할 수 없도록 생성자에 private
		private FavoritesDAO() {
			//드라이버 클래스 로드
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버클래스 로드에러");
			}
			
		}
		
		//3. 외부에서 객체 생성을 요구할 때 getter메서드를 통해 1번의 객체를 반환
		public static FavoritesDAO getInstance() {
			return instance;
		}
		
		//4.필요한 데이터 베이스 변수 선언
		public String URL = "jdbc:oracle:thin:@172.30.1.100:1521:xe";
		public String UID = "mat";
		public String UPW = "mat";
		
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		
		public void insertFavorSub(String storeNum, String storeName, String repMenu, int price,String category, String id){
			String sql = "insert into favorites values(seq_favorites.nextval,?,?,?,?,?,?)";
			
			try {
				conn = DriverManager.getConnection(URL,UID,UPW);
				pstmt = conn.prepareStatement(sql);
				
				
				pstmt.setString(1, storeNum);
				pstmt.setString(2, storeName);
				pstmt.setString(3, repMenu);
				pstmt.setInt(4, price);
				pstmt.setString(5, category);
				pstmt.setString(6, id);
				
				
				
				pstmt.executeUpdate();
				//실행(성공시 1 실패시 0반환) 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public void insertFavorMain(String storeNum, String id) {

			String sql = "select * from store where storeNum= '" + storeNum + "'";

			
			

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				conn = DriverManager.getConnection(URL, UID, UPW);

				pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();

				while(rs.next()) {

					String storeName = rs.getString("storeName");
					String repMenu = rs.getString("repMenu");
					int price = rs.getInt("price");
					String category = rs.getString("category");

					this.insertFavorSub(storeNum, storeName, repMenu, price, category, id);
				}

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				JDBCUtil.close(conn, pstmt, rs);
			}
			
		}
		
		//Delete Method of Favorites
		public int deleteFavor(String storeNum) {

			int result = 0;

			String sql = "delete from favorites where storeNum = '" + storeNum + "'";

			

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				conn = DriverManager.getConnection(URL, UID, UPW);

				pstmt = conn.prepareStatement(sql);

				result = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				JDBCUtil.close(conn, pstmt, rs);

			}

			return result;
		}

		
		
		
		public ArrayList<FavoritesVO> getFavorites(String id) {

			ArrayList<FavoritesVO> list = new ArrayList<>();

			String sql = "select * from favorites where id = ? order by storeName";

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				conn = DriverManager.getConnection(URL, UID, UPW);

				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					int favoritesNum = rs.getInt("favoritesNum");
					String storeNum = rs.getString("storeNum");
					String storeName = rs.getString("storeName");
					String repMenu = rs.getString("repMenu");
					int price = rs.getInt("price");
					String category = rs.getString("category");
					

					FavoritesVO vo = new FavoritesVO(favoritesNum,storeNum,storeName, repMenu, price, category,id);
					list.add(vo);
				}

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return list;
		}
		
		
		public int storeCheck(String storeNum , String id) {
			int result = 0;
			
			String sql = "select count(*) as total from favorites where storeNum=? and  id=?";
		
			try {
				//1.conn 객체
				conn = DriverManager.getConnection(URL,UID,UPW);
				
				//2.pstmt
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1, storeNum);
				pstmt.setString(2, id);
				
				//3.실행
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("total");
				}
				
				
			} catch (Exception e) {
			}finally {
				JDBCUtil.close(conn, pstmt, rs);
			}
			
			return result;
		
		}
	
}