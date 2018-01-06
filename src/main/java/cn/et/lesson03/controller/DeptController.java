package cn.et.lesson03.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.et.lesson03.entity.Emp;
import cn.et.lesson03.entity.Result;
import cn.et.lesson03.entity.TreeNode;
import cn.et.lesson03.service.DeptService;
import cn.et.lesson03.utils.PageTools;

@RestController
public class DeptController {
	
	@Autowired
    DeptService ds;
	
	@RequestMapping(value="/queryDept",method={RequestMethod.POST})
	public List<TreeNode> queryDeptList(Integer id) throws Exception{
		if(id==null){
			id=0;
		}
		return ds.queryDeptNode(id);
	}
	
	
	@RequestMapping(value="/queryEmp")
	public List<Emp> queryEmpList(Integer id) throws Exception{
		return ds.queryEmp(id);
	}
	
	@RequestMapping(value="/myQueryEmp",method={RequestMethod.GET})
	public PageTools queryEpList(Integer id,String ename,Integer page,Integer rows) throws Exception{
		return ds.queryEmp(id,ename,page,rows);
	}
	
	@RequestMapping(value="/emp/{id}",method={RequestMethod.DELETE})
	public Result deleteEmp(@PathVariable String id) throws IOException{
		String[] emp1=id.split(",");
		Result r = new Result();
		r.setCode(1);
		
		try {
			for (int i = 0; i < emp1.length; i++) {
				ds.deleteEmp(emp1[i]);
			}
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
	public Result updateEmp(@PathVariable String id,Emp emp) throws IOException{
		emp.setId(Integer.parseInt(id));
		Result r = new Result();
		r.setCode(1);
		try {
			ds.updateEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e.getMessage());
		}
		return r;
	}
	
	@RequestMapping(value="/MySaveEmp",method=RequestMethod.POST)
	public Result saveEmp(Integer id,Emp emp,MultipartFile myImage) throws IOException{
		Result r = new Result();
		r.setCode(1);
		try {
//			String fileName = myImage.getOriginalFilename();
//			File destFile = new File("D:\\image\\"+fileName);
//			myImage.transferTo(destFile);
			emp.setDeptid(id);
			ds.saveEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e.getMessage());
		}
		return r;
	}
}
