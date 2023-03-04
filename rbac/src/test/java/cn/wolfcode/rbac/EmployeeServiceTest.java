package cn.wolfcode.rbac;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.mapper.EmployeeMapper;
import cn.wolfcode.rbac.service.IEmployeeService;
import cn.wolfcode.rbac.service.IRoleService;
import cn.wolfcode.rbac.util.FuzzyQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/21
 * @note
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {
  @Autowired
  IEmployeeService employeeService;
  @Autowired
  IRoleService roleService;
  Role role;
  @Autowired
  EmployeeMapper employeeMapper;
  @Test
  public void selectForListTest(){
    //employeeMapper.deleteRoleIds(Collections.singletonList(1L),21L);
    List<Department> department1 = new ArrayList<>();
    System.out.println(department1);
    if (department1.isEmpty()){
      System.out.println("这是一个null");
    }
    System.out.println(employeeMapper.selectIdentity("admin", "1"));
    //System.out.println(employee.getRoles());
    /*FuzzyQuery query = new FuzzyQuery("赵", null);
    employeeService.selectForList(query);*/

    /*
    DEBUG [main] - ==>  Preparing: select e.id, e.name, e.password, e.email, e.age, e.admin, d.id d_id, d.name d_name, d.sn d_sn from employee e LEFT JOIN department d on e.dept_id = d.id WHERE (e.name like concat("%",? ,"%") or e.email like concat("%",? ,"%"))
    DEBUG [main] - ==> Parameters: 赵(String), 赵(String)
    TRACE [main] - <==    Columns: id, name, password, email, age, admin, d_id, d_name, d_sn
    TRACE [main] - <==        Row: 2, 赵总, 1, zhaoz@wolfcode.cn, 35, 1, 2, 人力资源部, Human Resources Department
    TRACE [main] - <==        Row: 3, 赵一明, c4ca4238a0b923820dcc509a6f75849b, zhaoym@wolfcode.cn, 25, 0, 2, 人力资源部, Human Resources Department
    DEBUG [main] - <==      Total: 2
    */
  }

}
