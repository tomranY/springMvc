package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.util.FuzzyQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
public interface EmployeeMapper {
    List<Employee> selectAll();

    Employee selectOne(Long id);

    List<Long> selectRoleIdsByEmployeeById(Long id);

    int addEmployee(Employee employee);

    int updateEmployeeById(Employee employee);

    void insertRelation(@Param("employeeId") Long employeeId, @Param("roleIds") List<Long> roleIds);

    void deleteRelation(Long id);

    void deleteRoleIds(@Param("roleIds") List<Long> roleIds, @Param("employeeId") Long employeeId);

    List<Employee> selectForList(FuzzyQuery fuzzyQuery);

    void deleteEmployee(Long id);

    List<Role> selectRolesByEmployeeById(Long id);

    boolean selectIdentity(@Param("username")String username,@Param("password")String password);

}
