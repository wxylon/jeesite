/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 标签Controller
 * @author ThinkGem
 * @version 2013-3-23
 */
@Controller
@RequestMapping(value = "${adminPath}/tag")
public class TagController extends BaseController {
	
	/**
	 * 树结构选择标签（treeselect.tag）
	 */
	@RequiresPermissions("user")
	@RequestMapping(value = "treeselect")
	public String treeselect(HttpServletRequest request, ModelMap model) {
		model.put("url", request.getParameter("url")); 	// 树结构数据URL
		model.put("extId", request.getParameter("extId")); // 排除的编号ID
		model.put("checked", request.getParameter("checked")); // 是否可复选
		model.put("selectIds", request.getParameter("selectIds")); // 指定默认选中的ID
		model.put("isAll", request.getParameter("isAll")); 	// 是否读取全部数据，不进行权限过滤
		model.put("module", request.getParameter("module"));	// 过滤栏目模型（仅针对CMS的Category树）
		return "modules/sys/tagTreeselect";
	}
	
	/**
	 * 图标选择标签（iconselect.tag）
	 */
	@RequiresPermissions("user")
	@RequestMapping(value = "iconselect")
	public String iconselect(HttpServletRequest request, ModelMap model) {
		model.put("value", request.getParameter("value"));
		return "modules/sys/tagIconselect";
	}
	
}
