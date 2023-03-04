package com.tangmran.controller;

import com.tangmran.user.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 唐梦然
 * @date 2022/11/7
 * @note
 */
@Controller
public class HelloController {
  @RequestMapping("/login")
  public String login(String username,String password,Model model,HttpSession session) {
    model.addAttribute("username",username);
    session.setAttribute("user",username);
    if ("tmr".equals(username)&&"123456".equals(password)){
      return "upload";
    }else {
      return "forward:login.jsp";
    }
  }

 /* @RequestMapping("/login")
  public String login2(User user, Model model, HttpSession session) {
    model.addAttribute("username",user.getUsername());
    session.setAttribute("user",user.getUsername());
    model.addAttribute("errorMsg","密码或账户错误，请重新输入");
    try{
      if (user.getUsername().equals("tomran")&&user.getPassword().equals("123456")){
        return "upload";
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    return "forward:login.jsp";
  }*/
}



