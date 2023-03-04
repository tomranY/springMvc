package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author 唐梦然
 * @date 2022/11/18
 * @note
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    //分页查询
    @RequestMapping(value = "/list")
    public String selectPage(Model model, QueryObject queryObject) {
        //获取员工分页信息
        PageInfo<Department> pageInfo = departmentService.selectPage(queryObject);
        model.addAttribute("departments", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "department/list";
    }

    //部门编辑请求
    @RequestMapping("/input")
    public String input(Model model, Long id) {
        model.addAttribute("d", this.departmentService.selectOne(id));
        return "department/input";
    }

    //新增or修改部门  后返回查询
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Department department, Model model) {
        model.addAttribute("error", department);
        if ("null".equals(this.departmentService.error(department)) && department.getId() == null) {
            return "common/addError";
        } else {
            this.departmentService.saveOrUpdate(department);
        }
        return "redirect:/department/list";
    }

    //删除部门
    @RequestMapping("/delete")
    public String deleteDepartmentById(Long id) {
        this.departmentService.deleteDepartmentById(id);
        return "redirect:/department/list";
    }


}
