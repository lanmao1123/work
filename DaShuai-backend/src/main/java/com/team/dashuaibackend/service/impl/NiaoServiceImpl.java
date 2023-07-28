package com.team.dashuaibackend.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.dashuaibackend.mapper.NiaoMapper;
import com.team.dashuaibackend.model.domain.Niao;
import com.team.dashuaibackend.model.domain.User;
import com.team.dashuaibackend.service.NiaoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.team.dashuaibackend.contant.UserConstant.USER_LOGIN_STATE;

/**
* @author admin
* @description 针对表【niao(用户尿量记录表)】的数据库操作Service实现
* @createDate 2023-07-27 14:11:58
*/
@Service
public class
NiaoServiceImpl extends ServiceImpl<NiaoMapper, Niao>
    implements NiaoService{
    @Resource
    private NiaoMapper niaoMapper;

    /**
     * 尿量统计
     */
    @Override
    public Niao addNiao(double niao_amount, double yali, int hurt, HttpServletRequest request) {
        Object userobj=request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser=(User) userobj;
        if(currentUser==null)
        {
            return null;
        }
        long userid=currentUser.getId();
        Niao niao = new Niao();
        niao.setNiao_amount(niao_amount);
        niao.setYali(yali);
        niao.setHurt(hurt);

        niao.setUser_id(userid);
        boolean saveResult = this.save(niao);
        if (!saveResult) {
            return null;
        }
        return niao;
    }

}




