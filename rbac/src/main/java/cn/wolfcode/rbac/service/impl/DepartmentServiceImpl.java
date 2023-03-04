package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.mapper.DepartmentMapper;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 唐梦然
 * @date 2022/11/17
 * @note
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        this.departmentMapper.deleteDepartmentById(id);
    }

    @Override
    public Department selectOne(Long id) {
        return departmentMapper.selectOne(id);
    }

    @Override
    public PageInfo<Department> selectPage(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
        List<Department> departments = departmentMapper.selectAll();
        return new PageInfo<>(departments);
    }

    @Override
    public void saveOrUpdate(Department department) {
        try {
            if (department.getId() == null) {
                this.departmentMapper.addDepartment(department);
            } else {
                this.departmentMapper.updateDepartmentByID(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String error(Department department) {
        List<Department> departments = this.departmentMapper.selectAll();
        List<String> departments1 = new ArrayList<>();
        for (Department d : departments) {
            departments1.add(d.getName());
        }
        Set<String> permissionIdsAfter = new HashSet<>(departments1);
        List<String> department1 = new ArrayList<>();
        department1.add(department.getName());
        Set<String> permissionIdsBefore = new HashSet<>(department1);
        List<String> before_after = new ArrayList<>(SetUtils.difference(permissionIdsBefore, permissionIdsAfter));
        System.out.println("***************************************");
        System.out.println(before_after);
        try {
            return before_after.get(0);
        } catch (Exception e) {
            System.out.println(e);
            return "null";
        }
    }


}
