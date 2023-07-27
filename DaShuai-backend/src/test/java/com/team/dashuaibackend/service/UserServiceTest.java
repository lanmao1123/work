package com.team.dashuaibackend.service;

import com.team.dashuaibackend.model.domain.Niao;
import com.team.dashuaibackend.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    //测试ok
    public void testUserRegister()
    {
        String userAccount ="lanmao1121";
        String userPassword="12345678";
        String checkPassword="12345678";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(3,result);
    }
    @Test
    public void testAddUser()
    {
        User user = new User();
        user.setUsername("lanmao11d21");
        user.setUserAccount("lanmao");
        user.setTouXiang("https://pic.code-nav.cn/user_avatar/1601072287388278786/9vqTr3HM-WechatIMG1287.jpeg");
        user.setGender(0);
        user.setUserPassword("12345678");
        user.setPhone("123");
        boolean result=userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }
    @Test
    public void testDeleteUser()
    {
        userService.removeById(4L);
    }
    @Test
    public void testUpdateUser()
    {
        User user = new User();
        user.setUsername("dashuaiye");
        user.setId(1L);


        userService.updateById(user);
    }

}
