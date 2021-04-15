package com.cloud.vongadmin.service.impl;

import com.cloud.vongadmin.entity.vongCover;
import com.cloud.vongadmin.mapper.VongCoverMapper;
import com.cloud.vongadmin.service.VongCoverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VongCoverServiceImpl implements VongCoverService {

    @Resource
    private VongCoverMapper vongCoverMapper;

    @Override
    public List<vongCover> selectAll() {
        return vongCoverMapper.selectList(null);
    }
}
