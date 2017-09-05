package com.example.core;

import com.example.domain.User;
import com.example.util.CommUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    protected Log log = LogFactory.getLog(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException,ServletException {
        User userDetails = (User)authentication.getPrincipal();

        log.info("登录用户user:" + userDetails.getName() + "login"+request.getContextPath());
        log.info("IP:" + CommUtils.getIpAddress(request));
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
