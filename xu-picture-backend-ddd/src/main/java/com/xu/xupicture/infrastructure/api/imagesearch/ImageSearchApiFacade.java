package com.xu.xupicture.infrastructure.api.imagesearch;

import com.xu.xupicture.infrastructure.api.imagesearch.model.ImageSearchResult;
import com.xu.xupicture.infrastructure.api.imagesearch.sub.GetImageFirstUrlApi;
import com.xu.xupicture.infrastructure.api.imagesearch.sub.GetImageListApi;
import com.xu.xupicture.infrastructure.api.imagesearch.sub.GetImagePageUrlApi;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-08
 */
@Slf4j
public class ImageSearchApiFacade {

    /**
     * 搜索图片
     *
     * @param imageUrl
     * @return
     */
    public static List<ImageSearchResult> searchImage(String imageUrl) {
        String imagePageUrl = GetImagePageUrlApi.getImagePageUrl(imageUrl);
        String imageFirstUrl = GetImageFirstUrlApi.getImageFirstUrl(imagePageUrl);
        List<ImageSearchResult> imageList = GetImageListApi.getImageList(imageFirstUrl);
        return imageList;
    }

    public static void main(String[] args) {
        // 测试以图搜图功能
        String imageUrl = "https://ts1.tc.mm.bing.net/th/id/OIP-C.WW2bLLs8aml7zDyJuuIVzAHaE7?r=0&rs=1&pid=ImgDetMain&o=7&rm=3";
        List<ImageSearchResult> resultList = searchImage(imageUrl);
        System.out.println("结果列表" + resultList);
    }
}

