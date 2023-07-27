package com.team.dashuaibackend.service;

import com.team.dashuaibackend.model.domain.Niao;
import com.team.dashuaibackend.model.domain.Yao;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author admin
* @description 针对表【yao(药品)】的数据库操作Service
* @createDate 2023-07-27 18:27:38
*/
public interface YaoService extends IService<Yao> {
    Yao addYao(String yao_name,long id);
}
