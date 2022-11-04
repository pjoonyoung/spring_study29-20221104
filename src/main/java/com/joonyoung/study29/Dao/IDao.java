package com.joonyoung.study29.Dao;

import java.util.ArrayList;

import com.joonyoung.study29.Dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	
	public void writeDao(String mwriter, String mcontent);
	
	public void deleteDao(String mid);
}
