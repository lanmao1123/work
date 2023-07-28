package com.team.dashuaibackend.controller;
import com.team.dashuaibackend.model.domain.Yao;
import com.team.dashuaibackend.model.domain.request.AddYaoRequest;
import com.team.dashuaibackend.service.YaoService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/yao")
public class YaoController {
    @Resource
    private YaoService yaoService;
    @PostMapping("/addYao")
    public Yao addNiao(@RequestBody AddYaoRequest addYaoRequest, HttpServletRequest request)
    {
        if(request==null)
        {
            return null;
        }
        String yao_name =addYaoRequest.getYao_name();
        //少一步判断
        Yao yao= yaoService.addYao(yao_name,request);
        return yao;
    }
//    @GetMapping("/getUserId")
//    public Long getUserId(HttpServletRequest request) {
//        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
//        User currentUser = (User) userObj;
//        if (currentUser == null) {
//            return null;
//        }
//        long userId = currentUser.getId();
//        // TODO 校验用户是否合法
//        return userId;
//    }
}
