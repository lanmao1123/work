package com.team.dashuaibackend.service;
import com.baomidou.mybatisplus.extension.service.IService;
import  com.team.dashuaibackend.model.domain.Niao;
import com.team.dashuaibackend.model.domain.Yao;

import javax.servlet.http.HttpServletRequest;

/**
* @author admin
* @description 针对表【niao(用户尿量记录表)】的数据库操作Service
* @createDate 2023-07-27 14:11:58
*/
public interface NiaoService extends IService<Niao> {
    Niao addNiao(double niao_amount,double yali,int hurt,HttpServletRequest request);

}
