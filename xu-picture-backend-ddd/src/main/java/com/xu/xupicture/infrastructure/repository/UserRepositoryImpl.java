package com.xu.xupicture.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.xupicture.domain.user.entity.User;
import com.xu.xupicture.domain.user.repository.UserRepository;
import com.xu.xupicture.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-10
 * 用户仓储实现
 */
@Service
public class UserRepositoryImpl extends ServiceImpl<UserMapper, User> implements UserRepository {
}
