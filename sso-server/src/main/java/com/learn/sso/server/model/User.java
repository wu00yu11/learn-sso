package com.learn.sso.server.model;

import lombok.Data;

/**
 * @author wu00y
 */
@Data
public class User {
    private Long   id;
    private String name;
    private String addr;
    private Integer age;
    private Integer sex;
}
