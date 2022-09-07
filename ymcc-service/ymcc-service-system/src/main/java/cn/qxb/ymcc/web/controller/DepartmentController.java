package cn.qxb.ymcc.web.controller;

import cn.qxb.ymcc.service.IDepartmentService;
import cn.qxb.ymcc.domain.Department;
import cn.qxb.query.DepartmentQuery;
import cn.qxb.result.JSONResult;
import cn.qxb.result.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName: qxb-ymcc
 * @author: Qxb
 * @since: 2022-09-07
 * @description:
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    public IDepartmentService departmentService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody Department department){
        if(department.getId()!=null){
            departmentService.updateById(department);
        }else{
            departmentService.insert(department);
        }
        return JSONResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id){
        departmentService.deleteById(id);
        return JSONResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(departmentService.selectById(id));
    }

    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JSONResult list(){
        return JSONResult.success(departmentService.selectList(null));
    }

    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public JSONResult page(@RequestBody DepartmentQuery query){
        Page<Department> page = new Page<Department>(query.getPage(),query.getRows());
        page = departmentService.selectPage(page);
        return JSONResult.success(new PageList<Department>(page.getTotal(),page.getRecords()));
    }
}
