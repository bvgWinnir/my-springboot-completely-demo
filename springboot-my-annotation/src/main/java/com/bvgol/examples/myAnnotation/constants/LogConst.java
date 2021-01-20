package com.bvgol.examples.myAnnotation.constants;

public interface LogConst {
    /**
     * 日志类型     * 增 add     * 删 del     * 改 update     * 查 select
     */
    interface LogType {
        String LogType_ADD = "add";
        String LogType_DEL = "del";
        String LogType_UPDATE = "update";
        String LogType_SELECT = "select";
    }

    /**
     * 模块名称常量_评论管理
     */
    interface LogModule {
        /**
         * 用户信息管理
         */
        String LOG_USER_INFO = "userInfo";
    }
}
