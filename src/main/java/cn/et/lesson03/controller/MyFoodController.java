package cn.et.lesson03.controller;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.et.lesson03.entity.Food;
import cn.et.lesson03.entity.Result;
import cn.et.lesson03.service.MyFoodService;
import cn.et.lesson03.utils.PageTools;

@RestController
public class MyFoodController {
	
	@Autowired
    MyFoodService my;
	
	@RequestMapping(value="/myQueryFood",method={RequestMethod.GET})
	public PageTools queryFoodList(String foodname,Integer page,Integer rows) throws Exception{
		return my.queryFood(foodname,page,rows);
	}
	
	@RequestMapping(value="/food/{foodid}",method={RequestMethod.DELETE})
	public Result deleteFood(@PathVariable String foodid) throws IOException{
		String[] foodid1=foodid.split(",");
		Result r = new Result();
		r.setCode(1);
		
		try {
			for (int i = 0; i < foodid1.length; i++) {
				my.deleteFood(foodid1[i]);
			}
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.PUT)
	public Result updateFood(@PathVariable String foodid,Food food) throws IOException{
		food.setFoodid(Integer.parseInt(foodid));
		Result r = new Result();
		r.setCode(1);
		try {
			my.updateFood(food);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e.getMessage());
		}
		return r;
	}
	
	@RequestMapping(value="/MySaveFood",method=RequestMethod.POST)
	public Result saveFood(Food food,MultipartFile myImage) throws IOException{
		Result r = new Result();
		r.setCode(1);
		try {
			String fileName = myImage.getOriginalFilename();
			File destFile = new File("D:\\image\\"+fileName);
			myImage.transferTo(destFile);
			my.saveFood(food);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e.getMessage());
		}
		return r;
	}
}
