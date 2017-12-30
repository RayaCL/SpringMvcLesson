package cn.etspringmvc.lesson06.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.etspringmvc.lesson06.dao.MyFoodDaoImpl;



@Controller
public class MyFoodController {
	@Autowired
	MyFoodDaoImpl mdi;
	/**
	 * 原始的输出json方式
	 * OutPutStream os;
	 * os.write(通过第三方json-lib转换json字符串.getByte())
	 * @param foodname
	 * @param out
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/queryFood",method={RequestMethod.GET,RequestMethod.POST})
	public String queryFood(String foodname,OutputStream out) throws IOException{
		List<Map<String, Object>> list=mdi.queryAllFood(foodname);
		JSONArray arry=JSONArray.fromObject(list);
		String jsonStr=arry.toString();
		out.write(jsonStr.getBytes("UTF-8"));
		return null;
	}
	/**
	 * 直接返回 字符数组 +必须写@ResponseBody
	 * 减少流的输出动作代码
	 * out.write(jsonStr.getBytes("UTF-8"));
	 * @param foodname
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/queryFoodReturn",method={RequestMethod.GET})
	public byte[] queryFoodReturn(String foodname) throws IOException{
		List<Map<String, Object>> list=mdi.queryAllFood(foodname);
		JSONArray arry=JSONArray.fromObject(list);
		String jsonStr=arry.toString();
		System.out.println(jsonStr.getBytes("UTF-8"));
		return jsonStr.getBytes("UTF-8");
	}
	/**
	 * 直接返回对象springmvc自动转换成json
	 * @param foodname
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/queryFoodList",method={RequestMethod.GET})
	public List<Map<String, Object>> queryFoodList(String foodname) throws IOException{
		List<Map<String, Object>> list=mdi.queryAllFood(foodname);
		return list;
	}
	
	@RequestMapping(value="/food/{foodId}",method={RequestMethod.DELETE})
	public String deleteFood(@PathVariable String foodId,OutputStream out) throws IOException{
		try {
			mdi.deleteFood(foodId);
			out.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			out.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	@RequestMapping(value="/food/{foodId}",method=RequestMethod.PUT)
	public String updateFood(@PathVariable String foodId,String foodName,String price,OutputStream out) throws IOException{
		
		try {
			mdi.updateFood(foodId, foodName, price);
			out.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			out.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	@RequestMapping(value="/food",method=RequestMethod.POST)
	public String saveFood(String foodName,String price,OutputStream out) throws IOException{
		try {
			mdi.saveFood(foodName, price);
			out.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			out.write("0".getBytes("UTF-8"));
		}
		return null;
	}
}
