package com.bvgol.springbootjapiDocs.vo;

import io.github.yedaxia.apidocs.Ignore;
import io.github.yedaxia.apidocs.RapMock;

/**
 * @author yeguozhong yedaxia.github.com
 */
public class SimpleUser {

    @RapMock(value="@ID")
    private String userId; //用户id

    @RapMock("@NAME")
    private String userName; //用户名

    @Ignore
    private String ignore; //忽略字段

    @Ignore
    private SimpleUser friend; //忽略字段

    public SimpleUser getFriend() {
        return friend;
    }

    public void setFriend(SimpleUser friend) {
        this.friend = friend;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}