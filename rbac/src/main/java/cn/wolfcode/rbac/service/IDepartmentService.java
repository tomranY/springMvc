package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/17
 * @note
 */

public interface IDepartmentService {

    /**
     * 查询所有
     *
     * @return 整体部门
     */
    List<Department> selectAll();


    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    void deleteDepartmentById(Long id);

    /**
     * 查询一个部门
     *
     * @param id
     * @return 该部门
     */
    Department selectOne(Long id);

    /**
     * 分页查询
     *
     * @param queryObject
     * @return
     */
    PageInfo<Department> selectPage(QueryObject queryObject);

    /**
     * 增加或修改
     *
     * @param department
     */
    void saveOrUpdate(Department department);

    String error(Department department);

}
