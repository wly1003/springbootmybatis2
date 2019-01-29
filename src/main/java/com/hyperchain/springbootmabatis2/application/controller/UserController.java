package com.hyperchain.springbootmabatis2.application.controller;

import com.hyperchain.springbootmabatis2.application.entity.UserEntity;
import com.hyperchain.springbootmabatis2.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;
    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }

    private static final String USER_LIST = "UserList";
    private static final String USER_LIST2 = "UserList2";
    private static final String USER_FORM = "UserForm";
    private static final String REDIRECT_TO_USER_LIST = "redirect:/user";

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String showAll(ModelMap map){
        map.addAttribute("UserList",userService.showAll());
        return USER_LIST;
    }
    @RequestMapping(value="/selectByName/{userName}",method=RequestMethod.GET)
    public String selectByUserName(@PathVariable String userName, ModelMap map){
        if(userService.selectByName(userName)==null) {
            return "传值未成功!";
        } else {
            map.addAttribute("UserList2",userService.selectByName(userName));
            return USER_LIST2;
        }
    }
    @RequestMapping(value="/selectByID/{userId}",method=RequestMethod.GET)
    public String selectByID(@PathVariable String userId, ModelMap map){

        if(userService.selectByID(userId)==null) {
            return "传值未成功!";
        } else {
            map.addAttribute("UserList2",userService.selectByID(userId));
            return USER_LIST2;
        }
    }
    /**
     * 获取创建UserForm表单
     * @param map
     * @return
     */
    @RequestMapping(value="/addUser",method=RequestMethod.GET)
    public String createUserForm(ModelMap map) {
        map.addAttribute("user", new UserEntity());
        map.addAttribute("action", "addUser");
        return USER_FORM;
    }
    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String postUser(@ModelAttribute UserEntity user) {
        userService.addUser(user);
        return REDIRECT_TO_USER_LIST;
    }
    @RequestMapping(value="/updateByID/{userId}",method=RequestMethod.GET)
    public String getByUserID(@PathVariable String userId, ModelMap map) {
        if(userService.selectByID(userId)==null) {
            return "传值未成功！";
        }
        else
        {	map.addAttribute("user",userService.selectByID(userId));
            map.addAttribute("action","updateByID");
            return USER_FORM;
        }
    }
    @RequestMapping(value="/updateByID",method=RequestMethod.POST)
    public String putByUserID(@ModelAttribute UserEntity user) {
        userService.updateByUserID(user);
        return REDIRECT_TO_USER_LIST;
    }
    @RequestMapping(value="/deleteByID/{userId}",method=RequestMethod.GET)
    public String deleteUserByID(@PathVariable String userId) {
        userService.deleteByUserID(userId);
        return REDIRECT_TO_USER_LIST;
    }

}
