package com.practice.service.impl;

import com.practice.service.TokenManageService;
import com.practice.vo.TokenVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class TokenManageServiceImpl implements TokenManageService {
    private static final String SESSION_KEY_OF_TOKEN = "session_key_of_token";

    @Override
    public TokenVO newToken(HttpServletRequest request) {
        return null;
    }

    @Override
    public Map<String, TokenVO> getTokens(HttpServletRequest request) {
        Map<String, TokenVO> tokenInSession = null;
        HttpSession session = request.getSession();
        synchronized (session) {
            tokenInSession = (Map<String, TokenVO>) session.getAttribute(SESSION_KEY_OF_TOKEN);
            if (tokenInSession == null) {
                tokenInSession = new HashMap<String, TokenVO>();
                session.setAttribute(SESSION_KEY_OF_TOKEN, tokenInSession);
            }
        }
        return tokenInSession;
    }

    @Override
    public void removeOldestToken(HttpServletRequest request) {
        List<TokenVO> tokens = new ArrayList<TokenVO>(getTokens(request).values());
        if (!tokens.isEmpty()) {
            TokenVO oldestToken = tokens.get(0);
            for (TokenVO token : tokens) {
                if (token.getTokenCreateTime().before(oldestToken.getTokenCreateTime())) {
                    oldestToken = token;
                    break;
                }
            }
            destroyToken(request,oldestToken.getTokenID());
        }
    }

    private void destroyToken(HttpServletRequest request, String tokenID) {
        //TODO 删除最早的token
    }


}
