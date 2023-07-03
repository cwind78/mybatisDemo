package com.mysql.mybatis.test.demo.common.vo;

import org.apache.ibatis.session.RowBounds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"offset", "limit"})
public class PageInfo extends RowBounds {
	  protected Integer page;
	  @Min(1)
	  protected Integer size;
	  protected Long totalCount = -1L; // set이 되지않았다는 의미로 -1

}
