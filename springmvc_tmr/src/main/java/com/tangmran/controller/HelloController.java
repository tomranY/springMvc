package com.tangmran.controller;

import com.tangmran.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * @author 唐梦然
 * @date 2022/11/14
 * @note
 */
@Controller
public class HelloController {
  @RequestMapping("/login")
  public String login2(User user, Model model, HttpSession session) {
    model.addAttribute("email", user.getEmail());
    model.addAttribute("number", user.getNumber());
    session.setAttribute("user",user.getUsername());
    model.addAttribute("errorMsg","密码或账户错误，请重新输入");
    try{
      if (user.getUsername().equals("张三")&&user.getPassword().equals("1234")){
        return "success";
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    return "forward:login.jsp";
  }
}



