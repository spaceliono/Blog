package com.space.myblog.pojo;

public class Menu{

    /**
     *
     */
    private static final long serialVersionUID = 4245833784962015367L;
    private int id;
    private int rid;
    private String menuName;//菜单名称
    private String menuUrl;//Controller路径

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getMenuUrl() {
        return menuUrl;
    }
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}