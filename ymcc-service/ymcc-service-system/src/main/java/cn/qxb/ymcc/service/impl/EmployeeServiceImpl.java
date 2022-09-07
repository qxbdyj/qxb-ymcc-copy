package cn.qxb.ymcc.service.impl;

import cn.qxb.ymcc.domain.Employee;
import cn.qxb.ymcc.mapper.EmployeeMapper;
import cn.qxb.ymcc.service.IEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Qxb
 * @since 2022-09-07
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
