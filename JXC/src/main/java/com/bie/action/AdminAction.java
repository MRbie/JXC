package com.bie.action;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bie.po.JxcAdmin;
import com.bie.po.JxcDicdata;
import com.bie.po.JxcEmployee;
import com.bie.po.JxcMenu;
import com.bie.service.AdminService;
import com.bie.service.DicDataService;
import com.bie.service.EmployeeService;
import com.bie.utils.AddressUtils;
import com.bie.utils.Constants;
import com.bie.utils.MenuUtils;
import com.bie.utils.SendEmailUtils;
import com.bie.utils.VerifyCodeUtils;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/***
 * 
 * @author 别先生
 * @date 2018年2月23日
 * 管理员的action类 
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

	//添加到Ioc容器
	@Resource
	private AdminService adminService;
	
	@Resource()
	public DicDataService dicDataAdminService;
	@Resource()
	private EmployeeService employeeAdminService;
	
	//添加到Ioc容器中
	//@Autowired
	//private JxcAdmin JxcAdmin;
	
	/*@RequestMapping(value="/login")
	public ModelAndView adminLogin(JxcAdmin jxcAdmin,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//测试获取到的账号和密码
		ModelAndView mv = new ModelAndView();
		System.out.println("账号:"+ jxcAdmin.getAdminAccount()+ " ,密码:" + jxcAdmin.getAdminPassword());
		//第0步,首先判断验证码是否正确
		//获取前台用户填的验证码
		String writeVerifyCode = request.getParameter("verifyCode").toLowerCase();
		//获取到随机产生的验证码
		Object randVerifyCode = session.getAttribute("randVerifyCode");
		JxcAdmin adminLogin = new JxcAdmin();
		System.out.println("输入的验证码:" + writeVerifyCode + ",随机验证码:" +randVerifyCode);
		//首先判断验证码的问题
		if(writeVerifyCode != null && !"".equals(writeVerifyCode) && 
				randVerifyCode != null && !"".equals(randVerifyCode) &&
				writeVerifyCode.equals(randVerifyCode.toString())){
			//如果填写的验证码正确,就进行账号和密码验证
			//第一步,首先判断输入的账号和密码是否为空
			if(jxcAdmin != null && !"".equals(jxcAdmin)){
				try {
					adminLogin = adminService.adminLogin(jxcAdmin);
					//第二步,如果输入的账号和密码不为空,就去数据库进行匹配
					//判断adminLogin是否为空,注意,判断不登录null且不等于空
					if(adminLogin != null && !"".equals(adminLogin)){
						//将返回的账号和密码保存到session中
						session.setAttribute("adminLogin", adminLogin);
						mv.setViewName(Views.systemMainIndex);
					}else{
						//将错误信息对登陆的管理员进行提示
						request.setAttribute("errorMessage", "用户名或密码错误！请重新输入。");
						mv.setViewName(Views.systemMainErrorAccount);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				//如果账号和密码为空,直接返回到登录页面
				mv.setViewName(Views.systemMainLogin);
			}
		}else if(randVerifyCode == null || !writeVerifyCode.equals(randVerifyCode.toString())){
			//如果服务器重启,不产生验证码,那么刷新直接跳转到登录页面
			mv.setViewName(Views.systemMainLogin);
		}else{
			//如果填写的验证码不正确,对用户进行提示操作
			//解决服务器重启,没有验证码的问题乱提示的问题。
			//request.setAttribute("errorVerifyCode", "验证码输入错误！请重新输入。");
			mv.setViewName("main/errorVerifyCode");
		}
		return mv;
	}*/
	
	/*@RequestMapping(value="/login")
	public ModelAndView adminLogin(JxcEmployee jxcEmployee,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//测试获取到的账号和密码
		ModelAndView mv = new ModelAndView();
		//第0步,首先判断验证码是否正确
		//获取前台用户填的验证码
		String writeVerifyCode = request.getParameter("verifyCode").toLowerCase();
		//获取到随机产生的验证码
		Object randVerifyCode = session.getAttribute("randVerifyCode");
		JxcEmployee adminLogin = new JxcEmployee();
		System.out.println("输入的验证码:" + writeVerifyCode + ",随机验证码:" +randVerifyCode);
		//首先判断验证码的问题
		if(writeVerifyCode != null && !"".equals(writeVerifyCode) && 
				randVerifyCode != null && !"".equals(randVerifyCode) &&
				writeVerifyCode.equals(randVerifyCode.toString())){
			//如果填写的验证码正确,就进行账号和密码验证
			//第一步,首先判断输入的账号和密码是否为空
			if(jxcEmployee != null && !"".equals(jxcEmployee)){
				try {
					adminLogin = employeeAdminService.adminLogin(jxcEmployee);
					//第二步,如果输入的账号和密码不为空,就去数据库进行匹配
					//判断adminLogin是否为空,注意,判断不登录null且不等于空
					if(adminLogin != null && !"".equals(adminLogin)){
						//将返回的账号和密码保存到session中
						session.setAttribute("adminLogin", adminLogin);
						mv.setViewName(Views.systemMainIndex);
					}else{
						//将错误信息对登陆的管理员进行提示
						request.setAttribute("errorMessage", "用户名或密码错误！请重新输入。");
						mv.setViewName(Views.systemMainErrorAccount);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				//如果账号和密码为空,直接返回到登录页面
				mv.setViewName(Views.systemMainLogin);
			}
		}else if(randVerifyCode == null || !writeVerifyCode.equals(randVerifyCode.toString())){
			//如果服务器重启,不产生验证码,那么刷新直接跳转到登录页面
			mv.setViewName(Views.systemMainLogin);
		}else{
			//如果填写的验证码不正确,对用户进行提示操作
			//解决服务器重启,没有验证码的问题乱提示的问题。
			//request.setAttribute("errorVerifyCode", "验证码输入错误！请重新输入。");
			mv.setViewName("main/errorVerifyCode");
		}
		return mv;
	}*/
	
	
	//@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request){

		String error=null;
		String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        ModelAndView mav=new ModelAndView("main/login");
        mav.addObject("error", error);
		return mav;
	}
	
	
	//登陆操作
	@RequestMapping(value="/login")
	public ModelAndView adminLogin(JxcEmployee jxcEmployee,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//测试获取到的账号和密码
		ModelAndView mv = new ModelAndView();
		//第0步,首先判断验证码是否正确
		//获取前台用户填的验证码
		String writeVerifyCode = request.getParameter("verifyCode").toLowerCase();
		//获取到随机产生的验证码
		Object randVerifyCode = session.getAttribute("randVerifyCode");
		JxcEmployee adminLogin = new JxcEmployee();
		//System.out.println("输入的验证码:" + writeVerifyCode + ",随机验证码:" +randVerifyCode);
		//首先判断验证码的问题
		if(!(writeVerifyCode != null && !"".equals(writeVerifyCode) && 
				randVerifyCode != null && !"".equals(randVerifyCode) &&
				writeVerifyCode.equals(randVerifyCode.toString()))){
			//如果服务器重启,不产生验证码,那么刷新直接跳转到登录页面
			request.setAttribute("errorVerifyCode", "验证码输入错误,请重新输入。");
			mv.setViewName(Views.systemMainLogin);
		}else{
			//如果填写的验证码正确,就进行账号和密码验证
			//第一步,首先判断输入的账号和密码是否为空
			if(jxcEmployee != null && !"".equals(jxcEmployee)){
				try {
					adminLogin = employeeAdminService.adminLogin(jxcEmployee);
					//第二步,如果输入的账号和密码不为空,就去数据库进行匹配
					//判断adminLogin是否为空,注意,判断不登录null且不等于空
					if(adminLogin != null && !"".equals(adminLogin)){
						//将返回的账号和密码保存到session中
						session.setAttribute("adminLogin", adminLogin);
						//将验证码保存到session中，分别消除
						session.setAttribute("randVerifyCode", randVerifyCode);
						session.setAttribute("writeVerifyCode", writeVerifyCode);
						
						//仓库管理员
						if(Views.systemEmployeeTypeByRoleType_Warehouse.equals(adminLogin.getJxRole().getRoleName())){
							request.setAttribute("mlogin", MenuUtils.warehouseAdmin());
						}
						
						//采购管理员
						if(Views.systemEmployeeTypeByRoleType_Purchaseorder.equals(adminLogin.getJxRole().getRoleName())){
							request.setAttribute("mlogin", MenuUtils.purchaseorderAdmin());
						}
						
						//销售管理员
						if(Views.systemEmployeeTypeByRoleType_Sale.equals(adminLogin.getJxRole().getRoleName())){
							request.setAttribute("mlogin", MenuUtils.saleAdmin());
						}
						
						//高级管理员
						if(Views.systemEmployeeTypeByRoleType_Admin.equals(adminLogin.getJxRole().getRoleName())){
							request.setAttribute("mlogin", 	MenuUtils.admin());
						}
						
						mv.setViewName(Views.systemMainIndex);
					}else{
						//将错误信息对登陆的管理员进行提示
						request.setAttribute("errorAdminMessage", "用户名或密码错误！请重新输入。");
						mv.setViewName(Views.systemMainLogin);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return mv;
	}
	
	//退出功能
	@RequestMapping(value="signOut")
	public ModelAndView signOut(HttpSession session){
		ModelAndView mv = new ModelAndView();
		//注销,清空session内容
		session.invalidate();
		//退出跳转到登录页面
		mv.setViewName(Views.systemMainLogin);
		return mv;
	}
	
	//管理员插入的方法,设置请求方法为post格式
	@RequestMapping(value="adminInsert",method=RequestMethod.POST)
	public ModelAndView insertAdmin(JxcAdmin jxcAdmin,HttpServletRequest request,HttpServletResponse response){
		//插入管理员测试
		//System.out.println("插入管理员:"+ jxcAdmin);
		ModelAndView mv = new ModelAndView();
		//默认管理员状态设置为2000
		jxcAdmin.setAdminStatus(Constants.adminStatusTrue);
		int flag = 0;
		try {
			if(jxcAdmin != null && !"".equals(jxcAdmin)){
				flag = adminService.insertAdmin(jxcAdmin);
				if(flag != 0){
					//如果插入成功就直接跳转到管理员列表页面
					//注意,这里使用重定向,将数据库里面的数据查询一遍显示出来
					//注意,路径问题。
					//mv.setViewName("redirect:/admin/queryAllAdmin.action");
					//mv.setViewName("forward:/admin/queryAllAdmin.action");
					mv.setViewName(Views.systemAdminSelect);
					
				}else{
					//如果插入失败就跳转到插入管理员的页面,并且进行插入失败提示
					mv.setViewName(Views.systemAdminAdd);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	//这里这个方法暂时无用,因为下面使用分页的方法完成这个功能
	//查询所有的管理员的方法
	@RequestMapping(value="queryAllAdmin")
	public ModelAndView selectAllAdmin(JxcAdmin jxcAdmin,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("adminName")
				&& context != null && !"".equals(context)){
			jxcAdmin.setAdminName(context);
		}
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("adminAccount")
				&& context != null && !"".equals(context)){
			jxcAdmin.setAdminAccount(context);
		}
		//将查询条件回显
		request.setAttribute("resultContext", context);
		List<JxcAdmin> listAdmin = new ArrayList<JxcAdmin>();
		//调用业务逻辑层的查询所有的方法
		try {
			//如果查询条件为空,直接查询所有的管理员
			if(jxcAdmin != null && !"".equals(jxcAdmin)){
				listAdmin = adminService.selectAllAdmin(jxcAdmin);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//如果查询返回的值不为空,就放到域中,在页面显示
		if(listAdmin != null && !"".equals(listAdmin)){
			//System.out.println("返回的所有管理员:" + listAdmin);
			//将查询的结果放到request域中,方便页面获取
			request.setAttribute("listAdmin", listAdmin);
		}
		//设置返回的页面
		mv.setViewName(Views.systemAdminList);
		return mv;
	}
	
	//查询个人详细信息
	@RequestMapping(value="queryBySingle",method=RequestMethod.GET)
	public ModelAndView queryBySingle(JxcAdmin jxcAdmin,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			if(jxcAdmin != null && !"".equals(jxcAdmin)){
				JxcAdmin queryBySingleAdmin = adminService.queryBySingle(jxcAdmin);
				//System.out.println("管理员的详细信息:" + queryBySingleAdmin);
				//将查询到的个人信息保存到域中
				request.setAttribute("queryBySingleAdmin", queryBySingleAdmin);
				//跳转到显示管理员详细信息的页面
				mv.setViewName(Views.systemAdminShow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return mv;
	}
	
	//管理员修改的方法,先查询出这个管理员的信息
	@RequestMapping(value="queryAndUpdate",method=RequestMethod.GET)
	public ModelAndView queryAndUpdateAdmin(JxcAdmin jxcAdmin,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcAdmin updateAdmin = new JxcAdmin();
		//修改管理员个人信息，必须先查询出这个人的基本信息
		try {
			updateAdmin = adminService.queryBySingle(jxcAdmin);
			//将查询到的个人信息保存到域中
			request.setAttribute("updateAdmin", updateAdmin);
			//跳转到显示管理员修改信息的页面
			mv.setViewName(Views.systemAdminUpdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//管理员修改的方法
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ModelAndView update(JxcAdmin jxcAdmin,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//修改的时候也给这个人一个默认的正常值
		jxcAdmin.setAdminStatus(Constants.adminStatusTrue);
		try {
			boolean resultAdmin = adminService.updateAdmin(jxcAdmin);
			if(resultAdmin){
				//跳转到显示管理员修改信息的页面
				//mv.setViewName("redirect:/admin/queryAllAdmin.action");
				mv.setViewName(Views.systemAdminSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	//管理员删除的方法，伪删除
	@RequestMapping(value="delete")
	public ModelAndView deleteAdmin(JxcAdmin jxcAdmin,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			//伪删除将管理员的状态设置为2001
			jxcAdmin.setAdminStatus(Constants.adminStatusFalse);
			boolean deleteAdmin = adminService.deleteAdmin(jxcAdmin);
			if(deleteAdmin){
				//如果删除成功就跳转到管理员列表的页面
				//mv.setViewName("redirect:/admin/queryAllAdmin.action");
				mv.setViewName(Views.systemAdminSelect);
			}else{
				//将删除错误信息进行提示
				request.setAttribute("deleteAdminError", "删除管理员错误,请重试......");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//管理员信息分页的功能
	@RequestMapping(value="adminPaging")
	public ModelAndView pagingAdmin(JxcAdmin jxcAdmin,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("adminName")
				&& context != null && !"".equals(context)){
			jxcAdmin.setAdminName(context);
		}
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("adminAccount")
				&& context != null && !"".equals(context)){
			jxcAdmin.setAdminAccount(context);
		}
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据
		PageHelper.startPage(pn,5);
		//查询出所有的管理员信息
		List<JxcAdmin> selectAll = new ArrayList<JxcAdmin>();
		PageInfo<JxcAdmin> page = null;
		try {
			selectAll = adminService.selectAllAdmin(jxcAdmin);
			//将管理员的信息放入到PageInfo中
			page = new PageInfo<JxcAdmin>(selectAll, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将返回的信息放到域中
		request.setAttribute("pageInfo", page);
		mv.setViewName(Views.systemAdminList);
		return mv;
	}
	
	//批量删除管理员信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="adminIds")List<Integer> adminIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除管理员的方法
		try {
			boolean batchDeleteAdmin = adminService.batchDeleteAdmin(adminIds);
			//如果为true代表批量删除成功
			if(batchDeleteAdmin){
				mv.setViewName(Views.systemAdminSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	//登录验证码,无需返回值
	@RequestMapping(value="verificationCode")
	public void loginVerificationCode(HttpServletRequest request,HttpServletResponse response){
		//ModelAndView mv = new ModelAndView();
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
          
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        HttpSession session = request.getSession(true);  
        session.setAttribute("randVerifyCode", verifyCode.toLowerCase());  
        //生成图片  
        int w = 200, h = 40;  
        try {
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//预先将需要查询出的数值查询出来
	@RequestMapping(value="preInsertAdmin")
	public ModelAndView preInsertAdmin(HttpServletRequest request,HttpServletResponse response, Object dicDataService){
		ModelAndView mv = new ModelAndView();
		JxcDicdata jxcDicData = new JxcDicdata();
		jxcDicData.setDicdataCode(Views.systemAdmin_adminType);
		try {
			List<JxcDicdata> preInsertAdmin = dicDataAdminService.preInsertAdmin(jxcDicData);
			if(!preInsertAdmin.isEmpty() && preInsertAdmin.size() >0){
				request.setAttribute("preInsertAdmin", preInsertAdmin);
				mv.setViewName(Views.systemAdminAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//修改密码页面跳转的方法
	@RequestMapping(value="goModifyPassword",method=RequestMethod.GET)
	public ModelAndView goModifyPassword(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String localIp = getLocalIp();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = sdf.format(date);
		//根据外网ip地址获取到国家省份市运营商
		String outerNetIp = AddressUtils.getOuterNetIp();
		//String outerNetIp = "";
		//如果获取到的ip地址不为空,就保存起来
		if(localIp != null && !"".equals(localIp) && !"null".equals(localIp)
				&& outerNetIp != null && !"".equals(outerNetIp) && !"".equals(outerNetIp)){
			request.setAttribute("localIp", localIp);
			request.setAttribute("outerNetIp", outerNetIp);
		}
		request.setAttribute("nowTime", nowTime);
		mv.setViewName(Views.systemEmployeeAdminModifyPassword);
		return mv;
	}
	
	//修改密码的方法
	@RequestMapping(value="modifyPassword",method=RequestMethod.POST)
	public ModelAndView modifyPassword(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv = new ModelAndView();
		//获取到sessin中的值
		JxcEmployee jxcEmployee = (JxcEmployee) session.getAttribute("adminLogin");
		//System.out.println("管理员修改密码:" + jxcEmployee.toString());
		//获取到原密码，新密码和确认密码
		String employeePassword = request.getParameter("employeePassword");
		String newPassword = request.getParameter("newPassword");
		String surePassword = request.getParameter("surePassword");
		//数据回显
		request.setAttribute("employeePassword", employeePassword);
		request.setAttribute("newPassword", newPassword);
		request.setAttribute("surePassword", surePassword);
		//获取本地ip和时间
		String localIp = getLocalIp();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = sdf.format(date);
		//根据外网ip地址获取到国家省份市运营商
		String outerNetIp = AddressUtils.getOuterNetIp();
		//如果获取到的ip地址不为空,就保存起来
		if(localIp != null && !"".equals(localIp)){
			request.setAttribute("nowTime", nowTime);
			request.setAttribute("localIp", localIp);
			request.setAttribute("outerNetIp", outerNetIp);
		}
		//获取到管理员的编号
		//Integer employeeId = jxcEmployee.getEmployeeId();
		try {
			//根据管理员编号查询出管理吗的密码
			JxcEmployee resultPassword = employeeAdminService.select(jxcEmployee);
			//如果输入的密码和返回的密码一致，说明可以修改，如果不一致，提醒原密码不正确
			if(!resultPassword.getEmployeePassword().equals(employeePassword)){
				//如果不登陆，提示
				request.setAttribute("errorPassword", "原密码输入错误！");
				//mv.setViewName(Views.systemEmployeeAdminErrorPassword);
				//return new ModelAndView(Views.systemEmployeeAdminModifyPassword);
			}
			if(!newPassword.equals(surePassword)){
				//如果不登陆，提示
				request.setAttribute("secondPasswordError", "两次输入不一致,请重新输入！");
				//mv.setViewName(Views.systemEmployeeAdminErrorPassword);
				//return new ModelAndView(Views.systemEmployeeAdminModifyPassword);
			}
			//如果满足原密码输入正确且两次输入密码一直，就修改
			if(resultPassword.getEmployeePassword().equals(employeePassword) 
					&& newPassword.equals(surePassword)){
				//将新密码进行修改即可
				jxcEmployee.setEmployeePassword(newPassword);
				//修改密码操作
				boolean modifyPassword = employeeAdminService.modifyPassword(jxcEmployee);
				if(modifyPassword){
					//拼接邮件内容
					String text = "您好,您的密码修改成功。" + "\r" + " 原密码:" + employeePassword + " ,新密码:" + newPassword + "\r" + "  ,请谨记！"
					+ " 修改的时间: " + nowTime + ", 修改的ip主机是: "+  localIp + ", 位置: " + outerNetIp; 
					//如果密码密码修改成功，发送邮件到指定的邮箱
					SendEmailUtils.baseSendMailMessage("管理员密码修改", text, "进销存管理系统");
					request.setAttribute("successPassword", "密码修改成功！");
					//return new ModelAndView(Views.systemEmployeeAdminModifyPassword);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName(Views.systemEmployeeAdminModifyPassword);
		return mv;
	}
	
	
	//获取到本地ip地址,然后方便方法调用,显示在页面上
	/*public String getLocalIp(){
		String localhostIp = null;
		Enumeration<NetworkInterface> allNetInterfaces = null;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements())
		{
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
			System.out.println(netInterface.getName());
			//这里只获取到本地ip地址即可
			//if(netInterface.getName().equals("net1")){
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements())
				{
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address)
					{
						localhostIp = "本机的IP = " + ip.getHostAddress();
						System.out.println("本机的IP = " + ip.getHostAddress());
					} 
				}
			//}else{
				//continue;
			//}
		}
		return localhostIp;
	}
	*/
	
	
	public String getLocalIp(){
		InetAddress ia=null;
		String localname = null;
		String localip = null;
		try {
            ia=InetAddress.getLocalHost();
            localname=ia.getHostName();
            localip=ia.getHostAddress();
            //System.out.println("本机名称是："+ localname);
            //System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return  "主机名称: "+ localname + ",Ip地址: "+ localip;
	}
	
	
	public static void main(String[] args) {
        InetAddress ia=null;
        try {
            ia=InetAddress.getLocalHost();
            
            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	@RequestMapping(value="systemIntroduce")
	public ModelAndView systemIntroduce(){
		ModelAndView mv = new ModelAndView();
		//设置返回路径信息
		mv.setViewName(Views.systemIntroduce);
		
		return mv;
	}
	
	
	
}
