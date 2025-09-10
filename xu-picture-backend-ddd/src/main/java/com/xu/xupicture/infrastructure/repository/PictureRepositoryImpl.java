package com.xu.xupicture.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.xupicture.domain.picture.entity.Picture;
import com.xu.xupicture.domain.picture.repository.PictureRepository;
import com.xu.xupicture.infrastructure.mapper.PictureMapper;
import org.springframework.stereotype.Service;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-10
 * 图片仓储实现类
 */
@Service
public class PictureRepositoryImpl extends ServiceImpl<PictureMapper, Picture> implements PictureRepository {
}
