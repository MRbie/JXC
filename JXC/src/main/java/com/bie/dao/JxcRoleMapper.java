package com.bie.dao;

import com.bie.po.JxcRole;
/***
 * 
 * @author 别先生
 * 1:角色的dao层接口
 * 	其它dao层的mapper接口继承此公共的接口.
 * 2:继承工具接口以后可以使用里面的方法,不必再重新写
 */
public interface JxcRoleMapper extends BaseMapper<JxcRole>{
    
}