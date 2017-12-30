package cn.etspringmvc.lesson01.work.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class MyDao {
	/**
	 * ≤È—Ø
	 */
	@Autowired
	JdbcTemplate jdbc;
	public List<Map<String, Object>> query(){
		
		String sql="select * from mymoney";
		List<Map<String, Object>> list=jdbc.queryForList(sql);
		return list;
	}
	public void add(String name,String lostedmoney){
		String sql="insert into mymoney(username,lostedmoney) values ('"+name+"',"+lostedmoney+")";
		
		jdbc.execute(sql);
	}
	public void update(String id,String name,String lostedmoney){
		String sql="update mymoney set username='"+name+"',lostedmoney="+lostedmoney+" where id="+id;
		jdbc.execute(sql);
	}
	public void delete(String id){
		String sql="delete from mymoney where id="+id;
		jdbc.execute(sql);
	}
}
