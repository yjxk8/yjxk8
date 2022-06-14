package com.zhfw.event.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 事件业务类型基础明细表
 **/
@TableName("xxzx.PRO_GROUP_ITEM")
@KeySequence(value = "PRO_GROUP_ITEM")
public class ProGroupItem implements Serializable {

    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private String pId;
    private String tId;
    private String itemName;
    private String itemValue;
    private String itemInstruction;
    private String isenabled;
    private String itemIndex;
    private String helpCode;
    private String descn;
    private String auditStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }


    public String getTId() {
        return tId;
    }

    public void setTId(String tId) {
        this.tId = tId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }


    public String getItemInstruction() {
        return itemInstruction;
    }

    public void setItemInstruction(String itemInstruction) {
        this.itemInstruction = itemInstruction;
    }


    public String getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(String itemIndex) {
        this.itemIndex = itemIndex;
    }


    public String getHelpCode() {
        return helpCode;
    }

    public void setHelpCode(String helpCode) {
        this.helpCode = helpCode;
    }


    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }


    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

}
