package com.bie.po;

import java.io.Serializable;
import java.util.Date;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:13:46
 * @Description: 菜单实体类
 */
public class JxcMenu implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//构造方法
	public JxcMenu(Integer menuId, String menuName, String menuPath, Integer menuUpid) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPath = menuPath;
		this.menuUpid = menuUpid;
	}
	
	//private Integer mid;//菜单的编号
	//private String mname;//菜单的名称
	//private String murl;//菜单的url
	//private Integer pid;//菜单的父id
	
	private Integer menuId;//菜单编号,菜单的id

    private String menuName;//菜单名称,菜单的描述
    //menuId menuName menuUpid menuPath menuStatus
    //menuIsleaf menuUpdater menuUpdatetime menuExtend
    private Integer menuUpid;//父级菜单编号,菜单的权限代码

    private String menuPath;//菜单路径,菜单的url

    private String menuStatus;//菜单状态

    private String menuIsleaf;//是否存在子节点,是否导航节点。

    private String menuUpdater;//更新人

    private String menuUpdatetime;//更新时间

    private String menuExtend;//菜单扩展

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuUpid() {
        return menuUpid;
    }

    public void setMenuUpid(Integer menuUpid) {
        this.menuUpid = menuUpid;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus;
    }

    public String getMenuIsleaf() {
        return menuIsleaf;
    }

    public void setMenuIsleaf(String menuIsleaf) {
        this.menuIsleaf = menuIsleaf;
    }

    public String getMenuUpdater() {
        return menuUpdater;
    }

    public void setMenuUpdater(String menuUpdater) {
        this.menuUpdater = menuUpdater;
    }

    public String getMenuUpdatetime() {
        return menuUpdatetime;
    }

    public void setMenuUpdatetime(String menuUpdatetime) {
        this.menuUpdatetime = menuUpdatetime;
    }

    public String getMenuExtend() {
        return menuExtend;
    }

    public void setMenuExtend(String menuExtend) {
        this.menuExtend = menuExtend;
    }

	@Override
	public String toString() {
		return "JxcMenu [menuId=" + menuId + ", menuName=" + menuName + ", menuUpid=" + menuUpid + ", menuPath="
				+ menuPath + ", menuStatus=" + menuStatus + ", menuIsleaf=" + menuIsleaf + ", menuUpdater="
				+ menuUpdater + ", menuUpdatetime=" + menuUpdatetime + ", menuExtend=" + menuExtend + "]";
	}
    
	
	
	
	
}