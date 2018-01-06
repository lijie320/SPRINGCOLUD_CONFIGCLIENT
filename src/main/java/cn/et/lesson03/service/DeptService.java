package cn.et.lesson03.service;

import java.util.List;

import cn.et.lesson03.entity.Emp;
import cn.et.lesson03.entity.Food;
import cn.et.lesson03.entity.TreeNode;
import cn.et.lesson03.utils.PageTools;

public interface DeptService {
	public List<TreeNode> queryDeptNode(Integer pid);
	public List<Emp>queryEmp(Integer id);
	public PageTools queryEmp(Integer id,String ename,Integer page,Integer rows);
	public void deleteEmp(String id);
	public void saveEmp(Emp emp);
	public void updateEmp(Emp emp);
}