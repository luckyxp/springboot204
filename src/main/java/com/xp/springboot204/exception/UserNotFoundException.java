package com.xp.springboot204.exception;

import org.springframework.stereotype.Component;

/**
 * @author Climb.Xu
 * @date 2020/4/27 20:58
 */
@Component
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("用户不存在");
    }
}
