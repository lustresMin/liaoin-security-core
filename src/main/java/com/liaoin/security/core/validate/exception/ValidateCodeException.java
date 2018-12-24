package com.liaoin.security.core.validate.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * security授权异常基类
 * @author mc
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
