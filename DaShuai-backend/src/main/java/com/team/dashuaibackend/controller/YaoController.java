package com.team.dashuaibackend.controller;
import com.team.dashuaibackend.model.domain.Yao;
import com.team.dashuaibackend.model.domain.request.AddYaoRequest;
import com.team.dashuaibackend.service.YaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/yao")
public class YaoController {
    @Resource
    private YaoService yaoService;
    @PostMapping("/addYao")
    public Yao addNiao(@RequestBody AddYaoRequest request)
    {
        if(request==null)
        {
            return null;
        }
        String yao_name = request.getYao_name();
        long id=3L;
        //少一步判断
        Yao yao= yaoService.addYao(yao_name,id);
        return yao;
    }
}
