package com.bie.po;

import java.io.Serializable;
import java.util.Date;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:13:38
 * @Description: 日志实体类
 */
public class JxcLog implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer logId;//日志编号

    private String logName;//日志名称

    private Date logTime;//日志时间

    private String logStatus;//日志状态

    private String logExtend;//日志扩展

    private String logContent;//日志内容

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    public String getLogExtend() {
        return logExtend;
    }

    public void setLogExtend(String logExtend) {
        this.logExtend = logExtend;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

	@Override
	public String toString() {
		return "JxcLog [logId=" + logId + ", logName=" + logName + ", logTime=" + logTime + ", logStatus=" + logStatus
				+ ", logExtend=" + logExtend + ", logContent=" + logContent + "]";
	}
    
    
}