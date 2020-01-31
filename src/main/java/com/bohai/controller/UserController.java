package com.bohai.controller;

import com.bohai.domain.User;
import com.bohai.domain.VO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFile) throws IOException {

        System.out.println(username);
        for (MultipartFile multipartFile:uploadFile){
            String filename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\data\\tmp\\upload\\"+filename));
        }

    }
    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username,MultipartFile uploadFile,MultipartFile uploadFile2) throws IOException {
        System.out.println(username);

        // 获得上传文件的名称
        String filename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("C:\\data\\tmp\\upload\\"+filename));
        String filename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("C:\\data\\tmp\\upload\\"+filename2));
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId){
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent){
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date){
        System.out.println(date);
    }

    @RequestMapping(value = "/quick17")
    @ResponseBody
    public void save17(@PathVariable(value = "name") String username){
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "bohai") String username){
        System.out.println(username);
    }
    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo){
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs){
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user){
        System.out.println(user);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    // SpringMVC自动将User转换成json格式的字符串
    public User save10(){
        User user = new User();
        user.setUsername("bohai");
        user.setAge(24);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("bohai");
        user.setAge(30);
        // 使用json的转换工具对象转换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8(){
        return "{\"username\":\"bohai\",\"age\":24}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody // 告知SpringMVC框架 不进行视图跳转，直接数据返回
    public String save7(){
        return "hello bohai";
    }
    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("demo string");
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","bohai");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username","bohai");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","boahi22");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","bohai333");
        modelAndView.setViewName("success");
        return modelAndView;
    }



    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("controller save running...");
        return "success";
    }
}
