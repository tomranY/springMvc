package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
public interface IPermissionService {
    List<Permission> selectAll();

    /**
     * 分页查询
     *
     * @param pageNum,pageSize 当前页码,展示条数
     * @return 查询的页面信息
     */
    PageInfo<Permission> selectPage(QueryObject queryObject);

    /**
     * 重新登录
     */
    void reload();

    /**
     * 增加权限
     *
     * @param permission 权限
     */
    void addPermission(Permission permission);

    /**
     * 删除权限
     *
     * @param id
     */
    void delete(Long id);
}
