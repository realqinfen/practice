package com.practice.service;

import com.practice.vo.TokenVO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/***
 * @Description 防重复提交用到的token;token的数量以及token的销毁机制。
 * 数量决定了能同时发起交易的数量，所以token的数量最好能够覆盖所有关键交易同时发起来的数量。
 * token的销毁决定了使用token的正常顺序。
 * @Author fen.qin  11:59 2020/4/14
 **/
public interface TokenManageService {
    /**
     * @Description 生产一个token，如果token数量大于设定的最大数量，则先删除最早的一个token
     * @Author fen.qin  9:37 2020/4/15
     **/
    TokenVO newToken(HttpServletRequest request);

    /***
     * @Description 从session中获取token；key-sessionKey，value-token
     * @Author fen.qin  9:40 2020/4/15
     **/
    Map<String,TokenVO> getTokens(HttpServletRequest request);

    /***
     * @Description 删除最早的token
     * @Author fen.qin  9:42 2020/4/15
     **/
    void removeOldestToken(HttpServletRequest request);
}
