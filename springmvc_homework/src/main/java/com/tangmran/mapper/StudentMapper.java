package com.tangmran.mapper;

import com.tangmran.pojo.Student;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2023-02-28
 * @note
 */
public interface StudentMapper {
  List<Student> selectAll();
  void updateStudentById(Student student);
  void deleteStudentByID(Long id);
  void addStudent(Student student);
  Student selectOne(Long id);
}
