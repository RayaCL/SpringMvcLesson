package cn.etspringmvc.lesson01.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {
	public Integer getTableListCount(String name);
	public abstract List<Map<String, Object>> getFood(String name,int startIndex,int length);

	/**
	 * 添加菜品
	 */
	public abstract void saveFood(String foodname, String price,
			String introduce,String imageurl);

	/**
	 * 删除菜品
	 * @param foodId
	 */
	public abstract void deleteFood(String foodId);

	/**
	 * 修改菜品
	 */
	public abstract void updateFood(String foodid, String foodname,
			String price, String introduce, String path);
	
	public Map<String, Object> findById(String foodid);
}