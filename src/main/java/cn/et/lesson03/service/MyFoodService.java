package cn.et.lesson03.service;

import cn.et.lesson03.entity.Food;
import cn.et.lesson03.utils.PageTools;

public interface MyFoodService {
	public PageTools queryFood(String foodname,Integer page,Integer rows);
	public void deleteFood(String foodid);
	public void saveFood(Food food);
	public void updateFood(Food food);
}
