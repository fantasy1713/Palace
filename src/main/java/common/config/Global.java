/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package common.config;

import common.util.NumberUtils;
import common.util.PropertiesLoader;

/**
 * 全局配置类
 * @author ThinkGem
 * @version 2013-03-23
 */
public class Global {
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader;
	
	/**
	 * 系统级管理员路径
	 */
	public static final String ADMIN_PATH = "/admin";
	
	/**
	 * 设置学生教师公共访问路径
	 * 1. 修改本类LEARNING_PATH 常量
	 * 2. 修改 applicationContext-shiro.xml 中的 shiroFilter
	 * 3. 修改 decorators.xml 中的 default
	 * 4. 修改 spring-mvc.xml 中的 mvc:view-controller
	 */
	public static final String LEARNING_PATH = "/learning";
	
	/**
	 * 设置账号管理访问路径
	 * 1. 修改本类 ACCOUNT_PATH 常量
	 * 2. 修改 applicationContext-shiro.xml 中的 shiroFilter?
	 * 3. 修改 decorators.xml 中的 default?
	 * 4. 修改 spring-mvc.xml 中的 mvc:view-controller?
	 */
	public static final String ACCOUNT_PATH = "/account";
	public static final String JSON_ACCOUNT_PATH = "/json/account";

	/**
	 * 设置学生用户访问路径
	 * 1. 修改本类 STUDENT_PATH 常量
	 * 2. 修改 applicationContext-shiro.xml 中的 shiroFilter
	 * 3. 修改 decorators.xml 中的 default
	 * 4. 修改 spring-mvc.xml 中的 mvc:view-controller
	 */
	public static final String STUDENT_PATH = "/student";

	/**
	 * 未登录用户访问路径
	 * 1. 修改本类 COURSE_PATH 常量
	 * 2. 修改 applicationContext-shiro.xml 中的 shiroFilter
	 * 3. 修改 decorators.xml 中的 default
	 * 4. 修改 spring-mvc.xml 中的 mvc:view-controller
	 */
	public static final String COURSE_PATH = "/course";
	/**
	 * 设置课程创建者访问路径
	 * 1. 修改本类 CREATOR_PATH 常量
	 * 2. 修改 applicationContext-shiro.xml 中的 shiroFilter
	 * 3. 修改 decorators.xml 中的 default
	 * 4. 修改 spring-mvc.xml 中的 mvc:view-controller
	 */
	public static final String CREATOR_PATH = "/creator";
	
	/**
	 * 设置访问URL后缀
	 */
	public static final String URL_SUFFIX = ".jsp";
	
	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		if (propertiesLoader == null){
			propertiesLoader = new PropertiesLoader("Global.properties");
		}
		return propertiesLoader.getProperty(key);
	}

	/////////////////////////////////////////////////////////
	
	public static String getAdminPath() {
		return ADMIN_PATH;
	}
	public static String getLearningPath() {
		return LEARNING_PATH;
	}
	public static String getAccountPath() {
		return ACCOUNT_PATH;
	}
	public static String getJsonAccountPath(){
		return JSON_ACCOUNT_PATH;
	}
	public static String getStudentPath() {
		return STUDENT_PATH;
	}
	public static String getCoursePath() {
		return COURSE_PATH;
	}
	public static String getCreatorPath() {
		return CREATOR_PATH;
	}
	public static String getCompanyName() {
		return getConfig("companyName");
	}
	public static String getCompanyEnName() {
		return getConfig("companyEnName");
	}
	public static String getCopyrightYear() {
		return getConfig("copyrightYear");
	}
	
	
	public static String getFileRootPath() {
		return getConfig("FileRootPath");
	}
	public static String getFileTempPath() {
		return getConfig("FileRootPath") + "/temp";
	}
	
	public static String getAllowedExtensionsMedia(){
		return getConfig("AllowedExtensionsMedia");
	}

	public static Long getAttachSize(String key) {
		return Long.parseLong(getConfig(key));
	}
	public static Long getLabTableAttachApply() {
		return Long.parseLong(getConfig("LabTable_Attach_Apply"));
	}
	public static String getLabTableAttachApplyString() {
		Long fileSize = getLabTableAttachApply();
		if (fileSize >= (1024 * 1024 * 1024)) {
			return NumberUtils.getFormatNumber(new Double(fileSize) / (1024 * 1024 * 1024), "0.#") + "GB";
		} else if (fileSize >= (1024 * 1024)) {
			return NumberUtils.getFormatNumber(new Double(fileSize) / (1024 * 1024), "0.#") + "MB";
		} else if (fileSize >= (1024)) {
			return NumberUtils.getFormatNumber(new Double(fileSize) / (1024),  "0.#") + "KB";
		} else {
			return fileSize + "B";
		}
	}
	
	//获取weblib地址，用户名，密码，weblib groupId
	public static String getWeblibUrl(){
		return getConfig("webliburl");
	}
	public static String getWelbibUsername(){
		return getConfig("weblibUsername");
	}
	public static String getWelbibPassword(){
		return getConfig("weblibPasswd");
	}
	public static Integer getWeblibGroupId(){
		return 0;
		//return Integer.parseInt(getConfig("weblibGroupId"));
	} 
	
	/**
	 * 获取lms在weblib中的柜子Id
	 */
	public static Long getLmsGroupId(){
		return Long.parseLong(getConfig("LmsGroupId").trim());
	}
	
	/**
	 * 获取coolview在weblib中柜子的Id
	 */
	public static Long getCoolviewId(){
		return Long.parseLong(getConfig("CoolviewId").trim());
	}
}
