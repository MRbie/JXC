package com.bie.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.wuwz.poi.ExcelKit;
import org.wuwz.poi.hanlder.ReadHandler;

import com.bie.po.JxcEmployee;
import com.bie.po.JxcRole;
import com.bie.service.EmployeeService;
import com.bie.service.RoleService;
import com.bie.utils.Constants;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:员工的控制层
 */
@Controller
@RequestMapping(value="/employee")
public class EmployeeAction {

	//注意:实现类不支持jdk的动态代码,只支持接口方式注入。实现类可以使用cglib代码模式。
	//@Resource(name="employeeService")
	@Resource()
	private EmployeeService employeeService;
	@Resource()
	private RoleService employeeRoleService;
	
	//查询员工的方法
	@RequestMapping("/employeeSelect")
	public ModelAndView selectEmployee(JxcEmployee JxcEmployee,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断员工姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeName") && context != null && !"".equals(context)){
			JxcEmployee.setEmployeeName(context);
		}
		//判断员工账号
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeAccount") && context != null && !"".equals(context)){
			JxcEmployee.setEmployeeAccount(context);
		}
		//判断员工类型
		/*if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeType") && context != null && !"".equals(context)){
			JxcEmployee.setEmployeeType(context);
		}*/
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcEmployee> page = null;
		//调用业务逻辑层的方法
		try {
			List<JxcEmployee> resultEmployee = employeeService.selectAll(JxcEmployee);
			//将管理员的信息放入到PageInfo中
			page = new PageInfo<JxcEmployee>(resultEmployee, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemEmployeeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//插入员工的方法
	@RequestMapping("/insertEmployee")
	public ModelAndView insertEmployee(JxcEmployee JxcEmployee,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置员工正常值为3000
		JxcEmployee.setEmployeeStatus(Constants.employeeStatusTrue);
		try {
			boolean flag = employeeService.insert(JxcEmployee);
			//如果返回为true,代表插入操作成功
			if(flag){
				mv.setViewName(Views.systemEmployeeSelect);
			}else{
				//如果插入失败,在员工插入界面提示插入失败
				mv.setViewName(Views.systemEmployeeAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//员工修改的方法employeeUpdate
	@RequestMapping("/employeeUpdate")
	public ModelAndView updateEmployee(JxcEmployee JxcEmployee,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = employeeService.update(JxcEmployee);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到员工管理页面
				mv.setViewName(Views.systemEmployeeSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//员工删除的方法employeeDelete
	@RequestMapping("/employeeDelete")
	public ModelAndView deleteEmployee(JxcEmployee JxcEmployee,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置员工异常值为3001
		JxcEmployee.setEmployeeStatus(Constants.employeeStatusFalse);
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = employeeService.delete(JxcEmployee);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到员工管理页面
				mv.setViewName(Views.systemEmployeeSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//员工查询个人的方法
	@RequestMapping("/queryEmployeeBySingle")
	public ModelAndView queryEmployeeBySingle(JxcEmployee JxcEmployee,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			//查询出角色类型
			List<JxcRole> roleType = employeeRoleService.selectAll(null);
			if(!roleType.isEmpty() && roleType.size() > 0){
				request.setAttribute("employeeRoleType", roleType);
			}
			JxcEmployee resultSingleEmployee = employeeService.select(JxcEmployee);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleEmployee != null && !"".equals(resultSingleEmployee)){
				//设置到域中
				request.setAttribute("resultSingleEmployee", resultSingleEmployee);
			}
			//设置返回页面
			mv.setViewName(Views.systemEmployeeUpdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除员工信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="employeeIds")List<Integer> employeeIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除员工的方法
		try {
			boolean batchDelete = employeeService.deleteList(employeeIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemEmployeeSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	//员工查询个人详细信息的方法
	@RequestMapping("/queryEmployeeDetail")
	public ModelAndView queryEmployeeDetail(JxcEmployee JxcEmployee,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcEmployee queryEmployeeDetail = employeeService.select(JxcEmployee);
			//如果查询的值不为空,就显示在修改页面
			if(queryEmployeeDetail != null && !"".equals(queryEmployeeDetail)){
				//设置到域中
				request.setAttribute("queryEmployeeDetail", queryEmployeeDetail);
				//设置返回页面
				mv.setViewName(Views.systemEmployeeShow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//员工导出到excel的方法
	@RequestMapping(value="/employeeExport",method=RequestMethod.GET)
	public void employeeExport(JxcEmployee JxcEmployee,HttpServletRequest request,HttpServletResponse response){
		//员工导出，先将所有员工信息查询出来
		List<JxcEmployee> employee = new ArrayList<JxcEmployee>();
		try {
			employee = employeeService.selectAll(JxcEmployee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置每个sheet的最大记录数,默认为10000,可不设置
		ExcelKit.$Export(JxcEmployee.class, response)
        .setMaxSheetRecords(500)
        .toExcel(employee, "员工信息");
		
		//导出案例
		/*ExcelKit.$Builder(User.class)
	    .setMaxSheetRecords(10000) //设置每个sheet的最大记录数,默认为10000,可不设置
	    .toExcel(records, "用户数据", new FileOutputStream(new File("c:/test001.xlsx")));*/
	}
	
	//导入excel到员工信息表，employeeImport
	@RequestMapping(value="/employeeImport",method=RequestMethod.POST)
	public ModelAndView employeeImport(HttpServletRequest request,HttpServletResponse response){
		final ModelAndView mv = new ModelAndView();
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			if (!ServletFileUpload.isMultipartContent(request)) {
			    writer.println("Error: enctype!=multipart/form-data");
			    writer.flush();
			    //后期优化的时候可以提示错误信息
			    mv.setViewName("");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 3);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024 * 1024 * 40);
		upload.setSizeMax(1024 * 1024 * 50);
 
		String uploadPath = request.getServletContext().getRealPath("./") + File.separator + "upload";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
		    uploadDir.mkdir();
		}
 
		try {
		    @SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);
 
		    if (formItems != null && formItems.size() > 0) {
		        for (FileItem item : formItems) {
		            if (!item.isFormField()) {
		                String fileName = new File(item.getName()).getName();
		                String filePath = uploadPath + File.separator + fileName;
		                File storeFile = new File(filePath);
		                //System.out.println(filePath);
		                item.write(storeFile);
		                
		                // 执行excel文件导入
		                ExcelKit.$Import().readExcel(storeFile, new ReadHandler() {
							
							@Override
							public void handler(int sheetIndex, int rowIndex, List<String> row) {
								if(rowIndex != 0) { //排除第一行
									JxcEmployee jxcEmployee = new JxcEmployee();
									jxcEmployee.setEmployeeId(Integer.parseInt(row.get(0)));
									jxcEmployee.setRoleId(Integer.parseInt(row.get(1)));
									jxcEmployee.setEmployeeName(row.get(2));
									jxcEmployee.setEmployeeAccount(row.get(3));
									jxcEmployee.setEmployeePassword(row.get(4));
									jxcEmployee.setEmployeeAge(Integer.parseInt(row.get(5)));
									jxcEmployee.setEmployeeSex(row.get(6));
									jxcEmployee.setEmployeeBirthday(row.get(7));
									jxcEmployee.setEmployeeAddress(row.get(8));
									jxcEmployee.setEmployeeStatus(row.get(9));
									jxcEmployee.setEmployeeCode(row.get(10));
									jxcEmployee.setEmployeeCardno(row.get(11));
									jxcEmployee.setEmployeePhone(row.get(12));
									jxcEmployee.setEmployeeEmail(row.get(13));
									//jxcEmployee.setEmployeeType(row.get(13));
									jxcEmployee.setEmployeeUpdater(row.get(14));
									jxcEmployee.setEmployeeUpdatetime(row.get(15));
									jxcEmployee.setEmployeeExtend(row.get(16));
									//插入操作
									try {
										boolean flag = employeeService.insert(jxcEmployee);
										if(flag){
											mv.setViewName(Views.systemEmployeeSelect);
										}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								
							}
						});
		                if(storeFile.exists()) {
		                	storeFile.delete();
		                }
		            }
		        }
		    }
		} catch (Exception ex) {
			writer.println("Error: "+ex.getMessage());
			writer.flush();
		}
		return mv;
	}
	
	//员工excel的模板
	@RequestMapping(value="employeeTemplate",method=RequestMethod.GET)
	public void employeeTemplate(HttpServletRequest request,HttpServletResponse response){
		//关于文件下载时采用文件流输出的方式处理：
	    String bath = request.getSession().getServletContext().getRealPath("");
	    response.setContentType("application/x-download");
	    //下载的文件的物理路径＋文件名
	    String fileDownloadName = bath + request.getParameter("path"); 
	    //给用户提供的下载文件名
	    String fileDisplayName = String.valueOf(System.currentTimeMillis())+fileDownloadName.substring(fileDownloadName.lastIndexOf("."),fileDownloadName.length()); 
	    try {
			fileDisplayName = URLEncoder.encode(fileDisplayName, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	    response.addHeader("Content-Disposition", "attachment;filename=" + fileDisplayName);
	    OutputStream outp = null;
	    FileInputStream in = null;
	    try {
	        outp = response.getOutputStream();
	        in = new FileInputStream(fileDownloadName);
	        byte[] b = new byte[1024];
	        int i = 0;
	        while ((i = in.read(b)) > 0) {
	            outp.write(b, 0, i);
	        }
	        outp.flush();
	    } catch (Exception e) {
	        System.out.println("文件下载失败!");
	        e.printStackTrace();
	    } finally {
	        if (in != null) {
	            try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	            in = null;
	        }
	        if (outp != null) {
	            try {
					outp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	            outp = null;
	        }
	    }
	}
	
	
}
