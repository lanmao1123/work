package com.team.dashuaibackend.controller;
import com.team.dashuaibackend.model.domain.User;
import com.team.dashuaibackend.model.domain.request.UserLoginRequest;
import com.team.dashuaibackend.model.domain.request.UserRegisterRequest;
import com.team.dashuaibackend.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.team.dashuaibackend.contant.UserConstant.USER_LOGIN_STATE;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 用户注册接口
     */
    @Resource
    private UserService userService;
    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest)
    {
        if(userRegisterRequest==null)
        {
            return null;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword=userRegisterRequest.getUserPassword();
        String checkPassword=userRegisterRequest.getCheckPassword();
        if(StringUtils.isAnyBlank(userPassword,checkPassword,userAccount))
        {
            return null;
        }
        long result = userService.userRegister(userAccount,userPassword,checkPassword);
        return result;
    }
    @GetMapping("/current")
    public User getCurrentUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null) {
            return null;
        }
        long userId = currentUser.getId();
        // TODO 校验用户是否合法
        User user = userService.getById(userId);
        User safetyUser = userService.getSafetyUser(user);
        return safetyUser;
    }
    /**
     * 用户登录接口
     */
    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request)
    {
        if(userLoginRequest == null)
        {
            return null;
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword= userLoginRequest.getUserPassword();
        if(StringUtils.isAnyBlank(userPassword,userAccount))
        {
            return null;
        }
        User user = userService.userLogin(userAccount, userPassword,request);
        return userService.getSafetyUser(user);
    }


}
