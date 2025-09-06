package com.xu.xupicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xu.xupicturebackend.model.dto.picture.PictureQueryRequest;
import com.xu.xupicturebackend.model.dto.picture.PictureUploadRequest;
import com.xu.xupicturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.xupicturebackend.model.entity.User;
import com.xu.xupicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author 22746
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-09-06 20:24:29
*/
public interface PictureService extends IService<Picture> {

    /**
     * 数据校验
     *
     * @param picture
     */
    void validPicture(Picture picture);

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    /**
     * 获取图片视图
     *
     * @param picture
     * @param request
     * @return
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 获取图片视图分页
     *
     * @param picturePage
     * @param request
     * @return
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 构造图片查询条件
     *
     * @param pictureQueryRequest
     * @return
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);
}
