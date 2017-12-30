package cn.etspringmvc.lesson01.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.etspringmvc.lesson01.dao.FoodDao;


@Repository
public class FoodDaoImpl implements FoodDao {
	@Autowired
	JdbcTemplate jdbc;
	/* (non-Javadoc)
	 * @see cn.etspringmvc.lesson01.dao.impl.FoodDao#getFood(java.lang.String)
	 */
	public Integer getTableListCount(String name){
		
		String sql="select count(*) as cr from food where foodname like '%"+name+"%'";
		List<Map<String, Object>> foodList =jdbc.queryForList(sql);
		return Integer.parseInt(foodList.get(0).get("cr").toString());
	}
	public List<Map<String, Object>> getFood(String name,int startIndex,int length){
		
		String sql="select * from food where foodname like '%"+name+"%' limit "+startIndex+","+length;
		List<Map<String, Object>> foodList =jdbc.queryForList(sql);
		return foodList;
	}
	
	/* (non-Javadoc)
	 * @see cn.etspringmvc.lesson01.dao.impl.FoodDao#saveFood(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void saveFood(String foodname, String price,String introduce,String imageurl){
		String sql="insert into food values((select max(foodid)+1 from food f),'"+foodname+"','"+price+"','"+introduce+"','"+imageurl+"')";
		jdbc.execute(sql);
	}
	/* (non-Javadoc)
	 * @see cn.etspringmvc.lesson01.dao.impl.FoodDao#deleteFood(java.lang.String)
	 */
	public void deleteFood(String foodId){
		String sql="delete from food where foodid="+foodId;
		
		jdbc.execute(sql);
	}
	
	/* (non-Javadoc)
	 * @see cn.etspringmvc.lesson01.dao.impl.FoodDao#updateFood(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateFood(String foodid,String foodname,String price,String introduce,String path){
		String sql="update food set foodname='"+foodname+"',price="+price+",desce='"+introduce+"',imageurl='"+path+"' where foodid="+foodid;
		jdbc.execute(sql);
	}

	public Map<String, Object> findById(String foodid) {
		String sql="select * from food where foodid="+foodid;
		System.out.println(sql);
		List<Map<String, Object>> list=jdbc.queryForList(sql);
		return list.get(0);
		
	}
}
