package cn.qxb.ymcc.web.controller;

import cn.qxb.ymcc.service.IEmployeeService;
import cn.qxb.ymcc.domain.Employee;
import cn.qxb.query.EmployeeQuery;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public IEmployeeService employeeService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody Employee employee){
        if(employee.getId()!=null){
            employeeService.updateById(employee);
        }else{
            employeeService.insert(employee);
        }
        return JSONResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return JSONResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(employeeService.selectById(id));
    }

    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JSONResult list(){
        return JSONResult.success(employeeService.selectList(null));
    }

    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public JSONResult page(@RequestBody EmployeeQuery query){
        Page<Employee> page = new Page<Employee>(query.getPage(),query.getRows());
        page = employeeService.selectPage(page);
        return JSONResult.success(new PageList<Employee>(page.getTotal(),page.getRecords()));
    }
}
