package com.learn.sso.core.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wu00y
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {
    /** 总记录数 */
    private Integer totalRecords;
    /** 总页数 */
    private Integer totalPages;
    /** 当前页 */
    private Integer currentPage;
    /** 每页记录数 */
    private Integer pageSize;
}
