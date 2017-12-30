package cn.etspringmvc.lesson01.work;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.etspringmvc.lesson01.work.dao.MyDao;

@Controller
public class WorkController {
	@Autowired
	MyDao dao;
	@RequestMapping(value="/mymoney",method=RequestMethod.GET)
	public String index(HttpServletResponse response) throws IOException{
		List<Map<String, Object>> list=dao.query();
		response.getWriter().println("<table>");
		response.getWriter().println("<tr><td>id</td><td>username</td><td>lostedmoney</td></tr>");
		for(Map<String, Object> l:list){
			response.getWriter().println("<tr><td>"+l.get("id")+"</td><td>"+l.get("username")+"</td><td>"+l.get("lostedmoney")+"</td></tr>");
		}
		response.getWriter().println("<table>");
		return null;
	}
	@RequestMapping(value="/mymoney",method=RequestMethod.POST)
	public String addUser(String name,String lostedmoney,HttpServletResponse response) throws IOException{
		dao.add(name, lostedmoney);
		response.getWriter().println(name+"--add success");
		return null;
	}
	@RequestMapping(value="/mymoney/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable(value="id") String userId,String name,String lostedmoney,HttpServletResponse response) throws IOException{
		dao.update(userId, name, lostedmoney);
		response.getWriter().println(userId+"--update success");
		return null;
	}
	@RequestMapping(value="/mymoney/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable(value="id") String userId,HttpServletResponse response) throws IOException{
		dao.delete(userId);
		response.getWriter().println(userId+"--delete success");
		return null;
	}
}
