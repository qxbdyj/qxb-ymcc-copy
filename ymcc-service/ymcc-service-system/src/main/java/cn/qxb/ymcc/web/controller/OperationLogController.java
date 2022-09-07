package cn.qxb.ymcc.web.controller;

import cn.qxb.ymcc.service.IOperationLogService;
import cn.qxb.ymcc.domain.OperationLog;
import cn.qxb.query.OperationLogQuery;
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
@RequestMapping("/operationLog")
public class OperationLogController {

    @Autowired
    public IOperationLogService operationLogService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody OperationLog operationLog){
        if(operationLog.getId()!=null){
            operationLogService.updateById(operationLog);
        }else{
            operationLogService.insert(operationLog);
        }
        return JSONResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id){
        operationLogService.deleteById(id);
        return JSONResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(operationLogService.selectById(id));
    }

    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JSONResult list(){
        return JSONResult.success(operationLogService.selectList(null));
    }

    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public JSONResult page(@RequestBody OperationLogQuery query){
        Page<OperationLog> page = new Page<OperationLog>(query.getPage(),query.getRows());
        page = operationLogService.selectPage(page);
        return JSONResult.success(new PageList<OperationLog>(page.getTotal(),page.getRecords()));
    }
}
