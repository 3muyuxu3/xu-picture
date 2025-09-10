package com.xu.xupicture.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.xupicture.domain.space.entity.Space;
import com.xu.xupicture.domain.space.repository.SpaceRepository;
import com.xu.xupicture.infrastructure.mapper.SpaceMapper;
import org.springframework.stereotype.Service;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-10
 */
@Service
public class SpaceRepositoryImpl extends ServiceImpl<SpaceMapper, Space> implements SpaceRepository {
}
