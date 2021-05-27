package com.ajie.commons.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Getter
@Setter
public class JwtAccount {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String accountName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像链接
     */
    private String headerUrl;

    /**
     * 附加信息，json格式
     */
    private String attach;

    /**
     * 过期信息，禁序列化
     */
    transient private Date expire;

    /**
     * 签名，禁序列化
     */
    transient private String sign;

    public <T> T getAttachObject(Class<T> clazz) {
        if (StringUtils.isBlank(attach)) {
            return (T) null;
        }
        return JSON.parseObject(attach, clazz);
    }

    public static void main(String[] args) {
        JwtAccount dto = new JwtAccount();
        dto.setId(1L);
        dto.setNickName("abc");
        String str = JSON.toJSONString(dto);
        System.out.println(str);
    }

}
