package com.team.dashuaibackend.service;

import com.team.dashuaibackend.model.domain.Niao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class NiaoServiceTest {
    @Resource
    private NiaoService niaoService;
    @Test
    public void testAddNiao() {
        Niao niao = new Niao();
        niao.setUser_id(2L);
        niao.setNiao_amount(23D);
        niao.setYali(32D);
        niao.setHurt(0);
        boolean result = niaoService.save(niao);
        System.out.println(niao.getId());
        Assertions.assertTrue(result);
    }
}
