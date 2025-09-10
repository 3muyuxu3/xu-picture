package com.xu.xupicture.interfaces.assembler;

import cn.hutool.json.JSONUtil;
import com.xu.xupicture.domain.picture.entity.Picture;
import com.xu.xupicture.interfaces.dto.picture.PictureEditRequest;
import com.xu.xupicture.interfaces.dto.picture.PictureUpdateRequest;
import org.springframework.beans.BeanUtils;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-10
 * 图片对象转换
 */
public class PictureAssembler {

    public static Picture toPictureEntity(PictureEditRequest request) {
        Picture picture = new Picture();
        BeanUtils.copyProperties(request, picture);
        // 注意将 list 转为 string
        picture.setTags(JSONUtil.toJsonStr(request.getTags()));
        return picture;
    }

    public static Picture toPictureEntity(PictureUpdateRequest request) {
        Picture picture = new Picture();
        BeanUtils.copyProperties(request, picture);
        // 注意将 list 转为 string
        picture.setTags(JSONUtil.toJsonStr(request.getTags()));
        return picture;
    }
}
