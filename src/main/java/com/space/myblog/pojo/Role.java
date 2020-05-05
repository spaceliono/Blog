package com.space.myblog.pojo;

public class Role {

    private static final long serialVersionUID = -3572463217368803762L;
    private int id;
    private int uid;
    private String roleName;// 角色名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
