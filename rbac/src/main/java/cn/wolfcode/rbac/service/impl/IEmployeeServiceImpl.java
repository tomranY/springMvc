package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.mapper.EmployeeMapper;
import cn.wolfcode.rbac.service.IEmployeeService;
import cn.wolfcode.rbac.util.FuzzyQuery;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
@Service
public class IEmployeeServiceImpl implements IEmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectAll() {
        return this.employeeMapper.selectAll();
    }

    @Override
    public PageInfo<Employee> selectPage(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
        List<Employee> employees = this.employeeMapper.selectAll();
        return new PageInfo<>(employees);
    }

    @Override
    public Employee selectOne(Long id) {
        return this.employeeMapper.selectOne(id);
    }

    @Override
    public PageInfo<Employee> selectForList(FuzzyQuery fuzzyQuery, QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
        List<Employee> employees = this.employeeMapper.selectForList(fuzzyQuery);
        return new PageInfo<>(employees);
    }

    @Override
    public void fuzzyQuery(Model model, FuzzyQuery fuzzyQuery, QueryObject queryObject) {
        if (!("null".equals(fuzzyQuery.getKeyword()))) {
            PageInfo<Employee> employeePageInfo = this.selectForList(fuzzyQuery, queryObject);
            model.addAttribute("employees", employeePageInfo.getList());
            model.addAttribute("pageInfo", employeePageInfo);
        } else {
            PageInfo<Employee> pageInfo = this.selectPage(queryObject);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("employees", pageInfo.getList());
        }
    }

    @Override
    public void saveOrUpdate(Employee employee, List<Long> roleIds) {
        try {
            if (employee.getId() == null) {
                this.employeeMapper.addEmployee(employee);
                this.employeeMapper.insertRelation(employee.getId(), roleIds);
            } else {
                this.employeeMapper.updateEmployeeById(employee);
                Set<Long> roleIdsAfter = new HashSet<>(roleIds);
                Set<Long> roleIdsBefore = new HashSet<>(this.employeeMapper.selectRoleIdsByEmployeeById(employee.getId()));
                List<Long> before_after = new ArrayList<>(SetUtils.difference(roleIdsBefore, roleIdsAfter));
                List<Long> after_before = new ArrayList<>(SetUtils.difference(roleIdsAfter, roleIdsBefore));
                try {
                    this.employeeMapper.deleteRoleIds(before_after, employee.getId());
                } catch (Exception e) {
                    System.out.println("此时不需要employeeMapper.deleteRoleIds操作");
                }
                this.employeeMapper.insertRelation(employee.getId(), after_before);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("此时不需要employeeMapper.insertRelation操作");
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        this.employeeMapper.deleteEmployee(id);
        this.employeeMapper.deleteRelation(id);
    }

    @Override
    public List<Role> selectRolesByEmployeeById(Long id) {
        return this.employeeMapper.selectRolesByEmployeeById(id);
    }

    public Boolean login(String username,String password){
        return this.employeeMapper.selectIdentity(username,password);
    }

}
