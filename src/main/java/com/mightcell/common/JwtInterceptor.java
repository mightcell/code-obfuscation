package com.mightcell.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mightcell.entity.User;
import com.mightcell.exception.CodeException;
import com.mightcell.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * @author 修雯天
 */
@Slf4j
@Component
@AllArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {

    private final UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        // 校验token是否为空
        if (StringUtils.isNotBlank(token)) {
            token = request.getParameter("token");
        }
        // 开始token验证
        if (StringUtils.isBlank(token)) {
            throw new CodeException("无token，请重新登录");
        }
        // 获取token中的uid
        String uid;
        User user;
        try {
            uid = JWT.decode(token).getAudience().get(0);
            // 根据uid查询数据库用户实体
            user = userService.getById(Integer.parseInt(uid));
        } catch (Exception e) {
            String errorMessage = "token验证失败，请重新登录";
            log.error(errorMessage + ", token=" + token, e);
            throw new CodeException(errorMessage);
        }
        if (Objects.isNull(user)) {
            throw new CodeException("用户不存在，请重新登录");
        }
        try {
            // 加签验证token
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new CodeException("token验证失败，请重新登录");
        }
        return true;
    }
}
