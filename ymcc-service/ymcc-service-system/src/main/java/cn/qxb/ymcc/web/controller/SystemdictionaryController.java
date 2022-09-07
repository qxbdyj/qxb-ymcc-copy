package cn.qxb.ymcc.web.controller;

import cn.qxb.ymcc.service.ISystemdictionaryService;
import cn.qxb.ymcc.domain.Systemdictionary;
import cn.qxb.query.SystemdictionaryQuery;
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
@RequestMapping("/systemdictionary")
public class SystemdictionaryController {

    @Autowired
    public ISystemdictionaryService systemdictionaryService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody Systemdictionary systemdictionary){
        if(systemdictionary.getId()!=null){
            systemdictionaryService.updateById(systemdictionary);
        }else{
            systemdictionaryService.insert(systemdictionary);
        }
        return JSONResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id){
        systemdictionaryService.deleteById(id);
        return JSONResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(systemdictionaryService.selectById(id));
    }

    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JSONResult list(){
        return JSONResult.success(systemdictionaryService.selectList(null));
    }

    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public JSONResult page(@RequestBody SystemdictionaryQuery query){
        Page<Systemdictionary> page = new Page<Systemdictionary>(query.getPage(),query.getRows());
        page = systemdictionaryService.selectPage(page);
        return JSONResult.success(new PageList<Systemdictionary>(page.getTotal(),page.getRecords()));
    }
}
