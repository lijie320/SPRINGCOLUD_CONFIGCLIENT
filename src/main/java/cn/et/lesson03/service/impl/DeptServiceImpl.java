package cn.et.lesson03.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.et.lesson03.entity.Dept;
import cn.et.lesson03.entity.DeptExample;
import cn.et.lesson03.entity.Emp;
import cn.et.lesson03.entity.EmpExample;
import cn.et.lesson03.entity.TreeNode;
import cn.et.lesson03.entity.EmpExample.Criteria;
import cn.et.lesson03.mapper.DeptMapper;
import cn.et.lesson03.mapper.EmpMapper;
import cn.et.lesson03.service.DeptService;
import cn.et.lesson03.utils.PageTools;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper dm;
	@Autowired
	EmpMapper em;

	public List<TreeNode> queryDeptNode(Integer pid) {
		DeptExample de= new DeptExample();
		de.createCriteria().andPidEqualTo(pid);
		List<Dept> dept = dm.selectByExample(de);
		List<TreeNode> deptList = new ArrayList<TreeNode>();
		for(Dept d:dept){
			TreeNode tn = new TreeNode();
			tn.setId(d.getId());
			tn.setText(d.getDname());
			if(queryDeptNode(d.getId()).size()==0){
				tn.setState("open");
			}
			deptList.add(tn);
		}
		return deptList;
	}
	
	public List<Emp>queryEmp(Integer id){
		EmpExample ee = new EmpExample();
		if(id!=null)
			ee.createCriteria().andDeptidEqualTo(id);
		return em.selectByExample(ee);
		
	}
	public PageTools queryEmp(Integer id,String ename,Integer page,Integer rows) {
		if (ename == null) {
			ename = "";
		}
		EmpExample ee = new EmpExample();
		Criteria c = ee.createCriteria();
		if (id != null) {
			c.andDeptidEqualTo(id);
		}
		c.andEnameLike("%" + ename + "%");
		int total = queryEmpCount(ee);
		PageTools pts = new PageTools(page, total, rows);
		RowBounds rb = new RowBounds(pts.getStartIndex() - 1, rows);
		List<Emp> empList = em.selectByExampleWithRowbounds(ee, rb);
		pts.setRows(empList);
		return pts;
	}
	public int queryEmpCount(EmpExample ee){
		int total = (int) em.countByExample(ee);
		return total;
	}
	
	public void deleteEmp(String id){
		//FoodExample fe = new FoodExample();
		em.deleteByPrimaryKey(Integer.parseInt(id));
	}

	public void saveEmp(Emp emp) {
		em.insert(emp);
	}

	public void updateEmp(Emp emp) {
		em.updateByPrimaryKey(emp);
		
	}
}
