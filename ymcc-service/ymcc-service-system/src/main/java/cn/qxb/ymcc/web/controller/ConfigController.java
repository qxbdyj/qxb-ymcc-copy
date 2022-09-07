package cn.qxb.ymcc.web.controller;

import cn.qxb.ymcc.service.IConfigService;
import cn.qxb.ymcc.domain.Config;
import cn.qxb.query.ConfigQuery;
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
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    public IConfigService configService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody Config config){
        if(config.getId()!=null){
            configService.updateById(config);
        }else{
            configService.insert(config);
        }
        return JSONResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id){
        configService.deleteById(id);
        return JSONResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(configService.selectById(id));
    }

    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JSONResult list(){
        return JSONResult.success(configService.selectList(null));
    }

    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public JSONResult page(@RequestBody ConfigQuery query){
        Page<Config> page = new Page<Config>(query.getPage(),query.getRows());
        page = configService.selectPage(page);
        return JSONResult.success(new PageList<Config>(page.getTotal(),page.getRecords()));
    }
}
