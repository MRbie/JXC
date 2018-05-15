package com.bie.po;

import java.io.Serializable;
/**
 * 
 * @author 别先生
 * 1:数据字典里面的数据
 */
public class JxcDicdata implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer dicdataId;//数据字典数据编号
	
	//dicdataId dicdataName dicdataCode
	//dicdataDesc dicdataExtend
    private String dicdataName;//数据字典数据名称

    private String dicdataCode;//数据字典数据字段名称

    private String dicdataDesc;//数据字典数据描述

    private String dicdataExtend;//数据字典数据扩展

    public Integer getDicdataId() {
        return dicdataId;
    }

    public void setDicdataId(Integer dicdataId) {
        this.dicdataId = dicdataId;
    }

    public String getDicdataName() {
        return dicdataName;
    }

    public void setDicdataName(String dicdataName) {
        this.dicdataName = dicdataName;
    }

    public String getDicdataCode() {
        return dicdataCode;
    }

    public void setDicdataCode(String dicdataCode) {
        this.dicdataCode = dicdataCode;
    }

    public String getDicdataDesc() {
        return dicdataDesc;
    }

    public void setDicdataDesc(String dicdataDesc) {
        this.dicdataDesc = dicdataDesc;
    }

    public String getDicdataExtend() {
        return dicdataExtend;
    }

    public void setDicdataExtend(String dicdataExtend) {
        this.dicdataExtend = dicdataExtend;
    }

	@Override
	public String toString() {
		return "JxcDicdata [dicdataId=" + dicdataId + ", dicdataName=" + dicdataName + ", dicdataCode=" + dicdataCode
				+ ", dicdataDesc=" + dicdataDesc + ", dicdataExtend=" + dicdataExtend + "]";
	}
    
    
}