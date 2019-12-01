package com.daoyuan.study.data.desensitization.author;

/**
 * 各系统自定义的用户权限,根据用户权限判断是否能够进行解密查看
 */
public interface UserAuthorityService {

    boolean hashAuthor();

}
