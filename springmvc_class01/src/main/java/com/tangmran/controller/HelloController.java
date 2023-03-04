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
  // 提供方法处理请求，在浏览器地址栏输入如下 localhost/hello，就会执行下面的方法
  @RequestMapping("/hello")
  public void hello() {
    System.out.println("老师正在游泳");
  }

  @RequestMapping("/school")
  public ModelAndView school() {
    // 通过创建这个类对象，告诉 Spring MVC 找什么视图文件， 往作用域或者说往模型中存入什么数据
    ModelAndView mv = new ModelAndView();
    // 往作用域或者模型中存入数据
    mv.addObject("msg", "这真的是一个school！！！");
    // 找视图
    mv.setViewName("school");
    return mv;
  }

  @RequestMapping("/resp2")
  public String resp2(Model model) {
// 往作用域或者模型中存入数据
    model.addAttribute("msg", "方法返回类型是 String");
    // 返回视图名
    return "resp2";
  }

  @RequestMapping("/employee")
  public String employee(Model model) {
    model.addAttribute("name","20");
    model.addAttribute("salary","2w");
    model.addAttribute("address","成都");
    return "employee";
  }

  @RequestMapping("/resp")
  // 此时请求参数为 name，而形参名为 username
  public ModelAndView resp(@RequestParam("username")String name, int age) {
    System.out.println("name:"+name);
    System.out.println("age:"+age);
    return null;
  }

  @RequestMapping("/save")
  public String save(Model model) {
    model.addAttribute("name","20");
    model.addAttribute("salary","2w");
    model.addAttribute("address","成都");
    return "welcome";
  }
  //处理自定义类  /resp3?username=张三&password=12345&id=1
  @RequestMapping("/resp3")
  public ModelAndView resp3(User user) {
    System.out.println(user);
    return null;
  }
  //处理日期格式参数  /resp4?date=2020-05-19
  @RequestMapping("/resp4")
  public ModelAndView resp4(@DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
    System.out.println(date);
    return null;
  }
/*  @RequestMapping("/login")
  public String login(String username,String password,Model model,HttpSession session) {
    model.addAttribute("username",username);
    session.setAttribute("user",username);
    if ("tmr".equals(username)&&"123456".equals(password)){
      return "success";
    }else {
      return "forward:login.jsp";
    }
  }*/
  /*@RequestMapping("/login")
  public String login2(User user,Model model) {
    model.addAttribute("username",user.getUsername());
    if (user.getUsername().equals("tomran")&&user.getPassword().equals("123456")){
      return "login";
    }else {
      model.addAttribute("errorMsg","密码或账户错误，请重新输入");
      return "forward:login.jsp";
    }
  }*/
  @RequestMapping("/login")
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
  }
  @RequestMapping("/success")
  public String success() {
    return "success";
  }
}



