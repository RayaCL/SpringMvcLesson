package cn.etspringmvc.lesson01.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.etspringmvc.lesson01.service.FoodService;
import cn.etspringmvc.lesson01.utils.PageTools;

@Controller
public class FoodController {
	@Autowired
	FoodService service;
	@RequestMapping(value="/showFood",method=RequestMethod.GET)
	public String queryFood(String foodname,Integer curPage,Model model){
		if(curPage==null){
			curPage=1;
		}
		PageTools list=service.getFood(foodname,curPage);
		model.addAttribute("foodlist", list);
		return "/detail/foodList.jsp";
	}
	
	@RequestMapping(value="/food/{foodId}",method=RequestMethod.GET)
	public String queryFoodById(@PathVariable String foodId,Model model){
		model.addAttribute("myFood", service.findById(foodId));
		return "/detail/detail.ftl";
	}
	@RequestMapping(value="/food/{foodId}",method=RequestMethod.POST)
	public String updateFood(@PathVariable String foodId,String foodName,String price,String introduce,MultipartFile imageUrl, Model model) throws IllegalStateException, IOException{
		model.addAttribute("myFood", service.findById(foodId));
		//获取文件名 
		String fileName="/"+imageUrl.getOriginalFilename();
		String absPath="F:\\myjavaEE\\.metadata\\.me_tcat\\webapps\\SpringMvcLesson\\images";
		imageUrl.transferTo(new File(absPath+fileName));
		service.updateFood(foodId, foodName, price, introduce, fileName);
		return queryFood(null,1,model);
	}
	
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public  ResponseEntity<byte[]> updateFood(String imagePath) throws IllegalStateException, IOException{
		String absPath="F:\\myjavaEE\\.metadata\\.me_tcat\\webapps\\SpringMvcLesson\\images"+imagePath;
		String fileName=imagePath;
       //需要下载的目标文件
       File file=new File(absPath);
       //设置响应头
       HttpHeaders hh=new HttpHeaders();
       //设置下载的文件的名称
       hh.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
       //读取目标文件为二进制数组
       byte[] fileByte=FileCopyUtils.copyToByteArray(file);
       //构建ResponseEntity对象
       ResponseEntity<byte[]> re=new ResponseEntity<byte[]>(fileByte, hh, HttpStatus.CREATED);
       return re;

	}
	@RequestMapping(value="/food",method=RequestMethod.POST)
	public String saveFood(String foodName,String price,String introduce,MultipartFile imageUrl,Model model) throws IllegalStateException, IOException{
		String fileName="/"+imageUrl.getOriginalFilename();
		String absPath="F:\\myjavaEE\\.metadata\\.me_tcat\\webapps\\SpringMvcLesson\\images";
		imageUrl.transferTo(new File(absPath+fileName));
		service.saveFood(foodName, price, introduce,fileName);
		return queryFood(null,1,model);
	}
	@RequestMapping(value="/food",method=RequestMethod.GET)
	public String deleteFood(String foodId,Model model) throws IllegalStateException, IOException{
		service.deleteFood(foodId);
		
		return queryFood(null,1,model);
	}
}
