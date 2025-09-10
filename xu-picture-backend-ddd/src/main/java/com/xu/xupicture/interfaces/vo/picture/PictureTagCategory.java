package com.xu.xupicture.interfaces.vo.picture;

import lombok.Data;

import java.util.List;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-06
 * 图片标签分类列表视图
 */
@Data
public class PictureTagCategory {

    /**
     * 标签列表
     */
    private List<String> tagList;

    /**
     * 分类列表
     */
    private List<String> categoryList;
}

