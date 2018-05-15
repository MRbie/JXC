package com.bie.po;

import java.io.Serializable;
/***
 * 
 * @author 别先生
 *
 */
public class JxcDatadictionary implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer datadictionaryId;//数据字典编号
	
	//datadictionaryField datadictionaryValue datadictionaryText
	//datadictionaryExtend datadictionaryDesc datadictionaryName
    private String datadictionaryCode;//数据字典字段

    //private String datadictionaryValue;//数据字典值

    //private String datadictionaryText;//数据字典文本描述

    private String datadictionaryExtend;//数据字典扩展

    private String datadictionaryDesc;//数据字典描述
    
    private String datadictionaryName;//数据字典名称
    
    public Integer getDatadictionaryId() {
        return datadictionaryId;
    }

    public void setDatadictionaryId(Integer datadictionaryId) {
        this.datadictionaryId = datadictionaryId;
    }


    /*public String getDatadictionaryValue() {
        return datadictionaryValue;
    }

    public void setDatadictionaryValue(String datadictionaryValue) {
        this.datadictionaryValue = datadictionaryValue;
    }

    public String getDatadictionaryText() {
        return datadictionaryText;
    }

    public void setDatadictionaryText(String datadictionaryText) {
        this.datadictionaryText = datadictionaryText;
    }*/

    public String getDatadictionaryCode() {
		return datadictionaryCode;
	}

	public void setDatadictionaryCode(String datadictionaryCode) {
		this.datadictionaryCode = datadictionaryCode;
	}

	public String getDatadictionaryExtend() {
        return datadictionaryExtend;
    }

    public void setDatadictionaryExtend(String datadictionaryExtend) {
        this.datadictionaryExtend = datadictionaryExtend;
    }

	public String getDatadictionaryDesc() {
		return datadictionaryDesc;
	}

	public void setDatadictionaryDesc(String datadictionaryDesc) {
		this.datadictionaryDesc = datadictionaryDesc;
	}

	public String getDatadictionaryName() {
		return datadictionaryName;
	}

	public void setDatadictionaryName(String datadictionaryName) {
		this.datadictionaryName = datadictionaryName;
	}

	@Override
	public String toString() {
		return "JxcDatadictionary [datadictionaryId=" + datadictionaryId + ", datadictionaryField="
				+ datadictionaryCode + ", datadictionaryExtend=" + datadictionaryExtend + ", datadictionaryDesc="
				+ datadictionaryDesc + ", datadictionaryName=" + datadictionaryName + "]";
	}

	
    
    
}