package com.team.dashuaibackend.service;

import com.team.dashuaibackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author admin
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-07-27 09:19:02
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏,保护用户信息
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);
}
