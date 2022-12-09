package com.mat.store.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mat.util.JDBCUtil;

public class StoreDAO {

	//현재의 객체만 만들어지도록 Singleton 형식으로 설계

	//1. 나 자신의 객체를 생성해서 1개로 제한한다.
	private static StoreDAO instance = new StoreDAO();

	//2. 직접 객체를 생성할 수 없도록 생성자에 private 선언
	private StoreDAO() {
		//드라이버 클래스 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("Driver class load error");
		}
	}

	//3. 외부에서 객체 생성을 요구할 때 getter 메서드를 통해 1번의 객체를 반환
	public static StoreDAO getInstance() {
		return instance;
	}

	//4. 필요한 데이터베이스 변수 선언
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String uid = "Matzip";
	public static final String upw = "Matzip";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;


	//지역(중구) 선택 메서드
	public ArrayList<StoreVO> selectJg() {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from STORE where locationType = 1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				int storeNum = rs.getInt("storeNum");
				int locationType = rs.getInt("locationType");
				String storeName = rs.getString("storeName");
				String storeAddress = rs.getString("storeAddress");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String contact = rs.getString("contact");
				String category = rs.getString("category");
				int priceRangeType = rs.getInt("priceRangeType");
				
				StoreVO vo = new StoreVO(storeNum, locationType, storeName,
						storeAddress, repMenu, price, contact, category, priceRangeType);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}


	//지역(중구) 선택 메서드
	public ArrayList<StoreVO> selectGn() {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from STORE where locationType = 2";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String storeName = rs.getString("storeName");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String category = rs.getString("category");

				StoreVO vo = new StoreVO(storeName, repMenu, price, category);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}


	//지역(중구)-카테고리 선택 메서드
	public ArrayList<StoreVO> selectJgC(String ctgy) {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from store where locationType = 1"
				+ " and category = '" + ctgy + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String storeName = rs.getString("storeName");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String category = rs.getString("category");

				StoreVO vo = new StoreVO(storeName, repMenu, price, category);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}


	//지역(강남)-카테고리 선택 메서드
	public ArrayList<StoreVO> selectGnC(String ctgy) {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from store where locationType = 2"
				+ " and category = '" + ctgy + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String storeName = rs.getString("storeName");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String category = rs.getString("category");

				StoreVO vo = new StoreVO(storeName, repMenu, price, category);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}


	//지역(중구)-가격대 선택 메서드
	public ArrayList<StoreVO> selectJgP(int PriceRangeType) {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from store where locationType = 1"
				+ " and priceRangeType = " + PriceRangeType;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String storeName = rs.getString("storeName");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String category = rs.getString("category");

				StoreVO vo = new StoreVO(storeName, repMenu, price, category);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}


	//지역(강남)-가격대 선택 메서드
	public ArrayList<StoreVO> selectGnPrice(int PriceRangeType) {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from store where locationType = 2"
				+ " and priceRangeType = " + PriceRangeType;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String storeName = rs.getString("storeName");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String category = rs.getString("category");

				StoreVO vo = new StoreVO(storeName, repMenu, price, category);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}
	
	
	//지역(중구)-카테고리&가격대 선택 메서드
	public ArrayList<StoreVO> selectJgCP(String ctgy, int priceRangeType) {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from store where locationType = 1\n"
				+ "and priceRangeType = " + priceRangeType +
				" and category = '" + ctgy + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String storeName = rs.getString("storeName");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String category = rs.getString("category");

				StoreVO vo = new StoreVO(storeName, repMenu, price, category);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}
	
	
	//지역(강남)-카테고리&가격대 선택 메서드
	public ArrayList<StoreVO> selectGnCP(String ctgy, int priceRangeType) {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from store where locationType = 2\n"
				+ "and priceRangeType = " + priceRangeType +
				" and category = '" + ctgy + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String storeName = rs.getString("storeName");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String category = rs.getString("category");

				StoreVO vo = new StoreVO(storeName, repMenu, price, category);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}
	
	
	//가게 상세정보 리스트 저장 메서드
	public ArrayList<StoreVO> selectStore(String name) {

		ArrayList<StoreVO> list = new ArrayList<>();

		String sql = "select * from STORE where storeName = '" + name + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				String storeName = rs.getString("storeName");
				String repMenu = rs.getString("repMenu");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String storeAddress = rs.getString("storeAddress");
				String contact = rs.getString("contact");

				StoreVO vo = new StoreVO(storeName, storeAddress, repMenu, price, category, contact);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}


	//Insert Method
	public int insert(String storeName, String repMenu, int price, String category) {

		int result = 0;

		String sql = "insert into favorites values(seq_favorites.nextval, ?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, storeName);
			pstmt.setString(2, repMenu);
			pstmt.setInt(3, price);
			pstmt.setString(4, category);

			result = pstmt.executeUpdate();

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

		return result;
	}

}


