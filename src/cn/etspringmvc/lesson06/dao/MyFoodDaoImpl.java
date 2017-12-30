package cn.etspringmvc.lesson06.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyFoodDaoImpl {
	@Autowired
	JdbcTemplate jdbc;
	public List<Map<String, Object>> queryAllFood(String foodname){
		return jdbc.queryForList("select * from food where foodname like '%"+foodname+"%'");
	}
	public void deleteFood(String foodid){
		jdbc.execute("delete from food where foodid="+foodid);
	}
	public void saveFood(String foodname,String price){
		jdbc.execute("INSERT INTO food VALUES((SELECT MAX(foodid)+1 FROM food f) ,'"+foodname+"','"+price+"','','')");
	}
	public void updateFood(String foodid,String foodname,String price){
		String sql = "update food set foodname='"+foodname+"',price='"+price+"' where foodid="+foodid;
		System.out.println(sql);
		jdbc.execute(sql);
		
	}
}
