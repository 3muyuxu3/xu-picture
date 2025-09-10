package com.xu.xupicture.interfaces.controller;

import com.xu.xupicture.infrastructure.common.BaseResponse;
import com.xu.xupicture.infrastructure.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-05
 */
@RestController
@RequestMapping("/")
public class MainController {

    /**
     * 健康检查
     */
    @GetMapping("/health")
    public BaseResponse<String> health() {
        return ResultUtils.success("ok");
    }
}
