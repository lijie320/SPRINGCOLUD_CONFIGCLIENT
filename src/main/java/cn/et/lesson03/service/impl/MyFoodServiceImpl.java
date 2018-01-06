package cn.et.lesson03.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.et.lesson03.entity.Food;
import cn.et.lesson03.entity.FoodExample;
import cn.et.lesson03.mapper.FoodMapper;
import cn.et.lesson03.service.MyFoodService;
import cn.et.lesson03.utils.PageTools;

@Service
public class MyFoodServiceImpl implements MyFoodService {
	
	@Autowired
	FoodMapper my;

	public PageTools queryFood(String foodname,Integer page,Integer rows) {
		if(foodname==null){
			foodname="";
		}
		FoodExample fe = new FoodExample();
		fe.createCriteria().andFoodnameLike("%"+foodname+"%");
		int total = queryFoodCount(fe);
		PageTools pts = new PageTools(page,total,rows);
		RowBounds rb = new RowBounds(pts.getStartIndex()-1, rows);
		List<Food> foodList = my.selectByExampleWithRowbounds(fe, rb);
		pts.setRows(foodList);
		return pts;
	}
	
	public int queryFoodCount(FoodExample fe){
		int total = (int) my.countByExample(fe);
		return total;
	}

	public void deleteFood(String foodid){
		//FoodExample fe = new FoodExample();
		my.deleteByPrimaryKey(Integer.parseInt(foodid));
	}

	public void saveFood(Food food) {
		my.insert(food);
	}

	public void updateFood(Food food) {
		my.updateByPrimaryKey(food);
		
	}

}
