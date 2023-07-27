package com.team.dashuaibackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.dashuaibackend.model.domain.User;
import com.team.dashuaibackend.service.UserService;
import com.team.dashuaibackend.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.team.dashuaibackend.contant.UserConstant.USER_LOGIN_STATE;
/**
* @author lanmao
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-07-27 09:19:02
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{

    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册功能实现
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        //1.校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return -1;
        }//账号不能小于4位数
        if (userAccount.length() < 4) {
            return -1;
        }//密码不能小于八位数
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }//账号不能含有特殊字符
        String vaildPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(vaildPattern).matcher(userAccount);
        if (matcher.find()) {
            return -1;
        }
        //密码和检验密码相同
        if (!userPassword.equals(checkPassword)) {
            return -1;
        }
        //账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            return -1;
        }
        //插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        boolean saveResult = this.save(user);
        if (!saveResult) {
            return -1;
        }
        return user.getId();
    }

    /**
     * 用户登录功能实现
     *
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        //1.校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        if (userAccount.length() < 4) {
            return null;
        }
        if (userPassword.length() < 8) {
            return null;
        }
        String vaildPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(vaildPattern).matcher(userAccount);
        if (matcher.find()) {
            return null;
        }
        // 查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", userPassword);
        User user = userMapper.selectOne(queryWrapper);
        //用户不存在
        if (user == null) {
            log.info("use login failed,userAccount cannot match password");
            return null;
        }
        //用户脱敏
        User safetyuser = getSafetyUser(user);
        //记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE, safetyuser);

        return safetyuser;
    }
    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    @Override
    public User getSafetyUser(User originUser) {
        if(originUser==null) return null;
        User safetyuser = new User();
        safetyuser.setId(originUser.getId());
        safetyuser.setUsername(originUser.getUsername());
        safetyuser.setUserAccount(originUser.getUserAccount());
        safetyuser.setTouXiang(originUser.getTouXiang());
        safetyuser.setGender(originUser.getGender());
        safetyuser.setPhone(originUser.getPhone());
        safetyuser.setUserStatus(originUser.getUserStatus());
        safetyuser.setCreateTime(originUser.getCreateTime());
        return safetyuser;
    }
}




