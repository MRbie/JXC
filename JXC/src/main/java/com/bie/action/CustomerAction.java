package com.bie.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bie.po.JxcCustomer;
import com.bie.service.CustomerService;
import com.bie.utils.Constants;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:客户的控制层
 */
@Controller
@RequestMapping(value="/customer")
public class CustomerAction {

	
	@Resource
	private CustomerService customerService;
	//customerId customerName customerIphone customerEmail
	//customerAddress customerDesc customerStatus
	//customerUpdater customerUpdatetime customerExtends
	
	//查询客户的方法
	@RequestMapping("/customerSelect")
	public ModelAndView customerSelect(JxcCustomer jxcCustomer,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断客户姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("customerName") && context != null && !"".equals(context)){
			jxcCustomer.setCustomerName(context);
		}
		
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcCustomer> page = null;
		//调用业务逻辑层的方法
		try {
			List<JxcCustomer> resultCustomer = customerService.selectAll(jxcCustomer);
			//将管理员的信息放入到PageInfo中
			page = new PageInfo<JxcCustomer>(resultCustomer, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemCustomerList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//插入客户的方法
	@RequestMapping("/insertCustomer")
	public ModelAndView insertCustomer(JxcCustomer jxcCustomer,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置客户正常值为7000
		jxcCustomer.setCustomerStatus(Constants.customerStatusTrue);
		try {
			boolean flag = customerService.insert(jxcCustomer);
			//如果返回为true,代表插入操作成功
			if(flag){
				mv.setViewName(Views.systemCustomerSelect);
			}else{
				//如果插入失败,在客户插入界面提示插入失败
				mv.setViewName(Views.systemCustomerAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//客户修改的方法customerUpdate
	@RequestMapping("/customerUpdate")
	public ModelAndView updateCustomer(JxcCustomer jxcCustomer,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = customerService.update(jxcCustomer);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到客户管理页面
				mv.setViewName(Views.systemCustomerSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//客户删除的方法customerDelete
	@RequestMapping("/customerDelete")
	public ModelAndView deleteCustomer(JxcCustomer jxcCustomer,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置客户异常值为7001
		jxcCustomer.setCustomerStatus(Constants.customerStatusFalse);
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = customerService.delete(jxcCustomer);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到客户管理页面
				mv.setViewName(Views.systemCustomerSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//客户查询个人的方法
	@RequestMapping("/queryCustomerBySingle")
	public ModelAndView queryCustomerBySingle(JxcCustomer jxcCustomer,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcCustomer resultSingleCustomer = customerService.select(jxcCustomer);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleCustomer != null && !"".equals(resultSingleCustomer)){
				//设置到域中
				request.setAttribute("resultSingleCustomer", resultSingleCustomer);
				//设置返回页面
				mv.setViewName(Views.systemCustomerUpdate);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除客户信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="customerIds")List<Integer> customerIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除客户的方法
		try {
			boolean batchDelete = customerService.deleteList(customerIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemCustomerSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	//客户查询个人详细信息的方法
	@RequestMapping("/queryCustomerDetail")
	public ModelAndView queryCustomerDetail(JxcCustomer jxcCustomer,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcCustomer queryCustomerDetail = customerService.select(jxcCustomer);
			//如果查询的值不为空,就显示在修改页面
			if(queryCustomerDetail != null && !"".equals(queryCustomerDetail)){
				//设置到域中
				request.setAttribute("queryCustomerDetail", queryCustomerDetail);
				//设置返回页面
				mv.setViewName(Views.systemCustomerShow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//客户导出到excel的方法
	/*@RequestMapping(value="/customerExport",method=RequestMethod.GET)
	public void employeeExport(JxcCustomer jxcCustomer,HttpServletRequest request,HttpServletResponse response){
		//客户导出，先将所有客户信息查询出来
		List<JxcEmployee> employee = new ArrayList<JxcEmployee>();
		try {
			employee = customerService.selectAll(JxcEmployee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置每个sheet的最大记录数,默认为10000,可不设置
		ExcelKit.$Export(JxcEmployee.class, response)
        .setMaxSheetRecords(500)
        .toExcel(employee, "客户信息");
		
		//导出案例
		ExcelKit.$Builder(User.class)
	    .setMaxSheetRecords(10000) //设置每个sheet的最大记录数,默认为10000,可不设置
	    .toExcel(records, "用户数据", new FileOutputStream(new File("c:/test001.xlsx")));
	}
	
	//导入excel到客户信息表，employeeImport
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
		                System.out.println(filePath);
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
									jxcEmployee.setEmployeeType(row.get(14));
									jxcEmployee.setEmployeeUpdater(row.get(15));
									jxcEmployee.setEmployeeUpdatetime(row.get(16));
									jxcEmployee.setEmployeeExtend(row.get(17));
									//插入操作
									try {
										boolean flag = customerService.insert(jxcEmployee);
										if(flag){
											mv.setViewName("redirect:/employee/employeeSelect.action");
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
	
	//客户excel的模板
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
	 */
	

}
