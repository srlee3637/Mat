package com.mat.category.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mat.category.model.CategoryDAO;

public class CategoryDAO {
	
	//현재의 객체만 만들어지도록 Singleton 형식으로 설계

	//1. 나 자신의 객체를 생성해서 1개로 제한한다.
	private static CategoryDAO instance = new CategoryDAO();

	//2. 직접 객체를 생성할 수 없도록 생성자에 private 선언
	private CategoryDAO() {
		//드라이버 클래스 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("Driver class load error");
		}
	}

	//3. 외부에서 객체 생성을 요구할 때 getter 메서드를 통해 1번의 객체를 반환
	public static CategoryDAO getInstance() {
		return instance;
	}

	//4. 필요한 데이터베이스 변수 선언
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String uid = "jsp";
	public static final String upw = "jsp";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
}
