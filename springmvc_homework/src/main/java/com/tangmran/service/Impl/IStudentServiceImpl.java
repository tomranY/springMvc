package com.tangmran.service.Impl;

import com.tangmran.mapper.StudentMapper;
import com.tangmran.pojo.Student;
import com.tangmran.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2023-02-28
 * @note
 */
@Service
public class IStudentServiceImpl implements IStudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Student> selectAll() {
        return this.studentMapper.selectAll();
    }

    @Override
    public void updateStudentById(Student student) {
        this.studentMapper.updateStudentById(student);
    }

    @Override
    public void deleteStudentByID(Long id) {
        this.studentMapper.deleteStudentByID(id);
    }

    @Override
    public void addStudent(Student student) {
        this.studentMapper.addStudent(student);
    }

    @Override
    public Student selectOne(Long id) {
        return this.studentMapper.selectOne(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        try {
            if (student.getId() == null) {
                this.studentMapper.addStudent(student);
            } else {
                this.studentMapper.updateStudentById(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
