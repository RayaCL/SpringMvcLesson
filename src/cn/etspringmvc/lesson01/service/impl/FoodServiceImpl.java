package cn.etspringmvc.lesson01.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.etspringmvc.lesson01.dao.FoodDao;
import cn.etspringmvc.lesson01.service.FoodService;
import cn.etspringmvc.lesson01.utils.PageTools;


@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDao dao;
	
	
	public PageTools getFood(String name,int curPage){
		if(name==null){
			name="";
		}
		int totalCount=dao.getTableListCount(name);
		PageTools pt=new PageTools(curPage,null,totalCount);
		List<Map<String, Object>> list=dao.getFood(name, pt.getStartIndex()-1, pt.getPageCount());
		pt.setData(list);
		return pt;
	}
	
	
	public void saveFood(String foodname, String price,String introduce,String imageurl){
		dao.saveFood(foodname, price, introduce,imageurl);
	}
	
	public void deleteFood(String foodId){
		dao.deleteFood(foodId);
	}
	
	
	public void updateFood(String foodid,String foodname,String price,String introduce,String path){
		dao.updateFood(foodid, foodname, price, introduce, path);
	}


	public Map<String, Object> findById(String foodid) {
		
		return dao.findById(foodid);
	}


	
}
