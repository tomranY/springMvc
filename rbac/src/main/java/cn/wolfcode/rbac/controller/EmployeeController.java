package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.service.IEmployeeService;
import cn.wolfcode.rbac.service.IRoleService;
import cn.wolfcode.rbac.util.FuzzyQuery;
import cn.wolfcode.rbac.util.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDepartmentService departmentService;
    @Autowired
    IRoleService roleService;

    //分页查询
    @RequestMapping("/list")
    public String selectPage(Model model, FuzzyQuery fuzzyQuery, QueryObject queryObject) {
        model.addAttribute("departments", this.departmentService.selectAll());
        model.addAttribute("qo", fuzzyQuery);
        //模糊查询
        this.employeeService.fuzzyQuery(model, fuzzyQuery, queryObject);
        return "employee/list";
    }

    //部门编辑请求
    @RequestMapping("/input")
    public String input(Model model, Long id) {
        model.addAttribute("employee", this.employeeService.selectOne(id));
        model.addAttribute("departments", this.departmentService.selectAll());
        model.addAttribute("roles", this.roleService.selectAll());
        return "employee/input";
    }

    //新增or修改  后返回查询
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Employee employee, @RequestParam(value = "roleIds", required = false) List<Long> roleIds) {
        this.employeeService.saveOrUpdate(employee, roleIds);
        return "redirect:/employee/list";
    }

    //删除员工
    @RequestMapping("/delete")
    public String delete(Long id) {
        this.employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }
}
