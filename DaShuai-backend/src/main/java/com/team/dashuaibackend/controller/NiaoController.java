package com.team.dashuaibackend.controller;

import com.team.dashuaibackend.model.domain.Niao;
import com.team.dashuaibackend.model.domain.request.AddNiaoRequest;
import com.team.dashuaibackend.service.NiaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/niao")
public class NiaoController {
    @Resource
    private NiaoService niaoService;
    @PostMapping("/addNiao")
    public Niao addNiao(@RequestBody AddNiaoRequest addNiaoRequest, HttpServletRequest request)
    {
        if(request==null)
        {
            return null;
        }
        double niao_amount = addNiaoRequest.getNiao_amount();
        double yali=addNiaoRequest.getYali();
        int hurt=addNiaoRequest.getHurt();

        //少一步判断
        Niao niao= niaoService.addNiao(niao_amount, yali, hurt,request);
        return niao;
    }
}
