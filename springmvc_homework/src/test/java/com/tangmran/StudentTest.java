package com.tangmran;

import com.tangmran.pojo.Student;
import com.tangmran.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2023-02-28
 * @note
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
    @Autowired
    IStudentService IStudentService;
    @Test
    public void selectStudentTest(){
        List<Student> list = IStudentService.selectAll();
        //list.forEach(student -> System.out.println(student));
        list.forEach(System.out::println);
    }
    @Test
    public void addStudentTest(){
        Student student = new Student("zhangsan",122222L,"计科2006",100L);
        this.IStudentService.addStudent(student);
        System.out.println("增加成功！！！");
    }
    @Test
    public void updateStudentTest(){
        Student student = new Student("zhangsan",122222L,"计科2006",89L);
        this.IStudentService.updateStudentById(student);
        System.out.println("修改成功！！！");

    }
    @Test
    public void deleteStudentByIdTest(){
        this.IStudentService.deleteStudentByID(122222L);
        System.out.println("删除成功！！！");
    }
}
