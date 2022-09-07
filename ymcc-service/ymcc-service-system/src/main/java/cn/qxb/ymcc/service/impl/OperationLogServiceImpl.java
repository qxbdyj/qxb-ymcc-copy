package cn.qxb.ymcc.service.impl;

import cn.qxb.ymcc.domain.OperationLog;
import cn.qxb.ymcc.mapper.OperationLogMapper;
import cn.qxb.ymcc.service.IOperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author Qxb
 * @since 2022-09-07
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {

}
