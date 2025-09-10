package com.xu.xupicture.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.xupicture.domain.space.entity.SpaceUser;
import com.xu.xupicture.domain.space.repository.SpaceUserRepository;
import com.xu.xupicture.infrastructure.mapper.SpaceUserMapper;
import org.springframework.stereotype.Service;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-10
 */
@Service
public class SpaceUserRepositoryImpl extends ServiceImpl<SpaceUserMapper, SpaceUser> implements SpaceUserRepository {
}
