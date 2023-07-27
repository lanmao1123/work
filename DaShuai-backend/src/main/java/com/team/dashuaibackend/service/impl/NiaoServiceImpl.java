package com.team.dashuaibackend.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.dashuaibackend.mapper.NiaoMapper;
import com.team.dashuaibackend.model.domain.Niao;
import com.team.dashuaibackend.service.NiaoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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
    public Niao addNiao(double niao_amount, double yali, int hurt) {
        Niao niao = new Niao();
        niao.setNiao_amount(niao_amount);
        niao.setYali(yali);
        niao.setHurt(hurt);

        niao.setUser_id(3L);
        boolean saveResult = this.save(niao);
        if (!saveResult) {
            return null;
        }
        return niao;
    }

}




