package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.util.FuzzyQuery;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
public interface IEmployeeService {
    List<Employee> selectAll();

    PageInfo<Employee> selectPage(QueryObject queryObject);

    Employee selectOne(Long id);

    PageInfo<Employee> selectForList(FuzzyQuery fuzzyQuery, QueryObject queryObject);

    void fuzzyQuery(Model model, FuzzyQuery fuzzyQuery, QueryObject queryObject);

    void saveOrUpdate(Employee employee, List<Long> roleIds);

    void deleteEmployee(Long id);

    /**
     * 根据员工id查询所有角色信息
     *
     * @param id
     */
    List<Role> selectRolesByEmployeeById(Long id);

    Boolean login(String username,String password);
}
