package cn.wolfcode.rbac.mapper;

        import cn.wolfcode.rbac.domain.Department;

        import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/16
 * @note
 */
public interface DepartmentMapper {
    /**
     * 查询所有
     *
     * @param department
     * @return 整体部门
     */
    List<Department> selectAll();

    /**
     * 新增部门
     *
     * @param department
     * @return
     */
    void addDepartment(Department department);

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    void deleteDepartmentById(Long id);

    /**
     * 修改部门
     *
     * @param department
     * @return 修改后的部门信息
     */
    void updateDepartmentByID(Department department);

    /**
     * 查询一个部门
     *
     * @param id
     * @return 该部门
     */
    Department selectOne(Long id);
}
