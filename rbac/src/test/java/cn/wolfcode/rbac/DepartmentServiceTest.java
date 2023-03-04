package cn.wolfcode.rbac;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/17
 * @note
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceTest {
    @Autowired
    IDepartmentService IDepartmentService;
    //查询所有部门
    @Test
    public void selectAllTest() {
        List<Department> list = IDepartmentService.selectAll();
        //list.forEach(department -> System.out.println(department));
        list.forEach(System.out::println);
    }
    //增加部门
    @Test
    public void addDepartmentTest(){
        /*Department department = new Department(null, "学习部", "Learning Department");
        IDepartmentService.addDepartment(department);*/
    }
    //删除部门
    @Test
    public void deleteDepartmentByIdTest(){
        IDepartmentService.deleteDepartmentById(29L);
    }
    //查询一个
    @Test
    public void selectOneTest(){
        Department department = IDepartmentService.selectOne(26L);
        System.out.println(department);
    }
    //分页查询
    @Test
    public void selectPage(){
        /*PageInfo<Department> pageInfo = IDepartmentService.selectPage(2,4);
        System.out.println(pageInfo);*/
        /*
         * PageInfo{
         * pageNum=2, pageSize=3, size=3, startRow=4, endRow=6, total=10, pages=4,
         * list=Page{count=true, pageNum=2, pageSize=3, startRow=3, endRow=6, total=10, pages=4, reasonable=false, pageSizeZero=false}
         * [
         * Department(id=5, name=财务部, sn=Finance Department),
         * Department(id=6, name=技术部, sn=Technolog Department ),
         * Department(id=22, name=学习部, sn=Learning Department)
         * ],
         * prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true,
         * navigatePages=2,navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]
         * }
         */
    }

}
