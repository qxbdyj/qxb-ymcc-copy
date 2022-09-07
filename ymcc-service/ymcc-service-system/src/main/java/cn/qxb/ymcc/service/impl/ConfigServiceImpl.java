package cn.qxb.ymcc.service.impl;

import cn.qxb.ymcc.domain.Config;
import cn.qxb.ymcc.mapper.ConfigMapper;
import cn.qxb.ymcc.service.IConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author Qxb
 * @since 2022-09-07
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
