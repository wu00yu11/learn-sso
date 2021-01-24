package com.learn.sso.server.model;

import lombok.Data;

/**
 * @author wu00y
 */
@Data
public class Account {
    private Long id;
    private Long userId;
    private String accountName;
    private String accountNo;
}
