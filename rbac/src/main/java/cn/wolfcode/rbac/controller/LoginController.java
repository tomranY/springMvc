package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 唐梦然
 * @date 2022/11/27
 * @note
 */
@Controller
public class LoginController {
  @Autowired
  private IEmployeeService employeeService;
  @RequestMapping("/login")
  public String login(String username, String password, Model model, HttpSession session) {
    session.setAttribute("username",username);
    try {
      if (this.employeeService.login(username,password)){
        return "redirect:/department/list";
      }else {
        return "forward:login.jsp";
      }
    }catch (Exception e){
      System.out.println(e);
      model.addAttribute("errorMsg", "账号身份或密码错误");
      return "forward:login.jsp";
    }
  }
}
