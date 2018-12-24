package com.liaoin.security.core.validate.bean;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
/**
 * @author mc
 * @version 1.0v
 * 图片验证码
 */
@Data
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn){
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
        super(code, expireTime);
        this.image = image;
    }

}
