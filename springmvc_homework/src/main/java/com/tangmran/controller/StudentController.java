package com.tangmran.controller;

import com.tangmran.pojo.Student;
import com.tangmran.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 唐梦然
 * @date 2023-02-28
 * @note
 */
@Controller
@RequestMapping("/student")
public class StudentController {
  @Autowired
  private IStudentService studentService;

  @RequestMapping("/select")
  public String selectAllStudent(Model model){
    model.addAttribute("allStudents", studentService.selectAll());
    return "/student/list";
  }
  @RequestMapping("/input")
  public String input(Model model,Long id){
    model.addAttribute("student",studentService.selectOne(id));
    return "student/input";
  }
  @RequestMapping("/saveOrUpdate")
  public String saveOrUpdate(Student student) {
    studentService.saveOrUpdate(student);
    return "redirect:/student/select";
  }
  @RequestMapping("/delete")
  public String deleteStudentById(Long id) {
    this.studentService.deleteStudentByID(id);
    return "redirect:/student/select";
  }
}
