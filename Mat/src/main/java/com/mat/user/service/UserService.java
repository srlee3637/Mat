package com.mat.user.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.favorite.model.FavoritesVO;
import com.mat.user.model.UserVO;

public interface UserService {
	public int join(HttpServletRequest request, HttpServletResponse response);
	public UserVO login(HttpServletRequest request, HttpServletResponse response);
	public UserVO getInfoUser(HttpServletRequest request, HttpServletResponse response);
	public int updateUser(HttpServletRequest request, HttpServletResponse response);
	public int deleteUser(HttpServletRequest request, HttpServletResponse response);
	public int insertFavor(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<FavoritesVO> getFavorites(HttpServletRequest request, HttpServletResponse response);
	public int deleteFavor(HttpServletRequest request, HttpServletResponse response);
}