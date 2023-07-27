package com.team.dashuaibackend.service;

import com.team.dashuaibackend.model.domain.Yao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class YaoServiceTest {
    @Resource
    private YaoService yaoService;
    @Test
    public void testAddYao() {
        Yao yao = new Yao();
        yao.setYao_id(2L);
        yao.setYao_name("大帅");
        boolean result = yaoService.save(yao);
        System.out.println(yao.getId());
        Assertions.assertTrue(result);
    }
}
