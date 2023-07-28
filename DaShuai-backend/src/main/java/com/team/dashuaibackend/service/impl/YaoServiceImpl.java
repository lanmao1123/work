package com.team.dashuaibackend.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.dashuaibackend.model.domain.User;
import com.team.dashuaibackend.model.domain.Yao;
import com.team.dashuaibackend.service.YaoService;
import com.team.dashuaibackend.mapper.YaoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.team.dashuaibackend.contant.UserConstant.USER_LOGIN_STATE;

/**
* @author admin
* @description 针对表【yao(药品)】的数据库操作Service实现
* @createDate 2023-07-27 18:27:38
*/
@Service
public class YaoServiceImpl extends ServiceImpl<YaoMapper, Yao>
    implements YaoService{
    @Resource
    private YaoMapper yaoMapper;
    @Override
    public Yao addYao(String yao_name, HttpServletRequest request) {
        Object userobj=request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser=(User) userobj;
        if(currentUser==null)
        {
            return null;
        }
        long userid=currentUser.getId();
        Yao yao = new Yao();
        yao.setYao_name(yao_name);
        yao.setYao_id(userid);
        boolean saveResult = this.save(yao);
        if (!saveResult) {
            return null;
        }
        return yao;
    }
}




