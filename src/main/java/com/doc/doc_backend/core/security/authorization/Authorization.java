package com.doc.doc_backend.core.security.authorization;

import com.doc.doc_backend.core.security.roles.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class Authorization {

    public Authorization(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.POST, EndPoints.COMMENTS_ALL_END_POINTS).hasAnyAuthority(Role.USER_ROLE);
        http.authorizeRequests().antMatchers(HttpMethod.POST, EndPoints.DISLIKES_ALL_END_POINTS).hasAnyAuthority(Role.USER_ROLE);
        http.authorizeRequests().antMatchers(HttpMethod.POST, EndPoints.LIKES_ALL_END_POINTS).hasAnyAuthority(Role.USER_ROLE);
        http.authorizeRequests().antMatchers(HttpMethod.POST, EndPoints.NEWS_FILES_ALL_END_POINTS).hasAnyAuthority(Role.USER_ROLE);
        http.authorizeRequests().antMatchers(HttpMethod.POST, EndPoints.USERS_ALL_END_POINTS).hasAnyAuthority(Role.USER_ROLE);
        http.authorizeRequests().antMatchers(HttpMethod.POST, EndPoints.NEWS_ALL_END_POINTS).hasAnyAuthority(Role.USER_ROLE);
    }
}
