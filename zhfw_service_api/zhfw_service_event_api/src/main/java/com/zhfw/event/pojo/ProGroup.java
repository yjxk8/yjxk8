package com.zhfw.event.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 事件业务类型基础表
 * **/
@TableName("xxzx.PRO_GROUP")
@KeySequence(value = "PRO_GROUP")
public class ProGroup implements Serializable {

  @TableId(value = "id",type = IdType.INPUT)
  private Integer id;
  private String typeName;
  private String standardCode;
  private String source;
  private String itemIndex;
  private String descn;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }


  public String getStandardCode() {
    return standardCode;
  }

  public void setStandardCode(String standardCode) {
    this.standardCode = standardCode;
  }


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }


  public String getItemIndex() {
    return itemIndex;
  }

  public void setItemIndex(String itemIndex) {
    this.itemIndex = itemIndex;
  }


  public String getDescn() {
    return descn;
  }

  public void setDescn(String descn) {
    this.descn = descn;
  }

}
