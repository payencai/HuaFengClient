package com.huafeng.client.ui.home.model;

import java.io.Serializable;

/**
 * 作者：凌涛 on 2019/5/5 17:27
 * 邮箱：771548229@qq..com
 */
public class FirstType implements Serializable {

    /**
     * id : 1
     * name : 产品1
     * rank : 1
     * parentId : -1
     * suquence : null
     * childrenNumber : 2
     * productNumber : null
     * gmtCreate : 2019-04-03 15:27:28
     * gmtModified : null
     * isDeleted : 0
     * createBy : null
     * updateBy : null
     * factoryId : 3
     */

    private int id;
    private String name;
    private int rank;
    private int parentId;
    private Object suquence;
    private int childrenNumber;
    private Object productNumber;
    private String gmtCreate;
    private Object gmtModified;
    private int isDeleted;
    private Object createBy;
    private Object updateBy;
    private int factoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Object getSuquence() {
        return suquence;
    }

    public void setSuquence(Object suquence) {
        this.suquence = suquence;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public Object getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Object productNumber) {
        this.productNumber = productNumber;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Object getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Object gmtModified) {
        this.gmtModified = gmtModified;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }
}
