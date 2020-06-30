package com.sexflag.mypro.pojo;


import java.util.List;

public class SysRole{
    private Integer roleId;

    private String roleName;

    private List<SysPermission> permList;

    public List<SysPermission> getPermList() {
        return permList;
    }
    public void setPermList(List<SysPermission> permList) {
        this.permList = permList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}