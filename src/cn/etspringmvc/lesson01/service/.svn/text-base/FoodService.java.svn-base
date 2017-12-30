package cn.etspringmvc.lesson01.service;

import java.util.List;
import java.util.Map;

import cn.etspringmvc.lesson01.utils.PageTools;

public interface FoodService {
	
	/**
	 * ²éÑ¯
	 * @param name
	 * @param curPage
	 * @return
	 */
	public abstract PageTools getFood(String name,int curPage);

	/**
	 * Ìí¼Ó
	 * @param foodname
	 * @param price
	 * @param introduce
	 * @param imageurl
	 */
	public abstract void saveFood(String foodname, String price,
			String introduce,String imageurl);

	/**
	 * É¾³ý
	 * @param foodId
	 */
	public abstract void deleteFood(String foodId);

	/**
	 * ÐÞ¸Ä
	 * @param foodid
	 * @param foodname
	 * @param price
	 * @param introduce
	 * @param path
	 */
	public abstract void updateFood(String foodid, String foodname,
			String price, String introduce, String path);

	public Map<String, Object> findById(String foodid);
}