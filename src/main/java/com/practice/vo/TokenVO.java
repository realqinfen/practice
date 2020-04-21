package com.practice.vo;

import java.io.Serializable;
import java.util.Date;

public class TokenVO implements Serializable {
    private String tokenID;
    private Date tokenCreateTime;
    public static final String TOKEN_ID = "_token_id";//session中的tokenID

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    public Date getTokenCreateTime() {
        if (tokenCreateTime == null) {
            tokenCreateTime = new Date();
        }
        return (Date) this.tokenCreateTime.clone();
    }

    public void setTokenCreateTime(Date tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }
}
