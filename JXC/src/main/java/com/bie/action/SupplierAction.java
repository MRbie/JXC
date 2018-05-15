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

import com.bie.po.JxcEmployee;
import com.bie.po.JxcSupplier;
import com.bie.service.SupplierService;
import com.bie.utils.Constants;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:供应商的控制层
 */
@Controller
@RequestMapping(value="/supplier")
public class SupplierAction {

	@Resource()
	private SupplierService supplierService;
	
	//查询供应商的方法
	@RequestMapping("/supplierSelect")
	public ModelAndView selectSupplier(JxcSupplier jxcSupplier,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断供应商姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierName") && context != null && !"".equals(context)){
			jxcSupplier.setSupplierName(context);
		}
		//判断供应商类型
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierType") && context != null && !"".equals(context)){
			jxcSupplier.setSupplierType(context);
		}
		//判断供应商账号
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierAccount") && context != null && !"".equals(context)){
			jxcSupplier.setSupplierAccount(context);
		}
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcSupplier> page = null;
		//调用业务逻辑层的方法
		try {
			List<JxcSupplier> resultSupplier = supplierService.selectAll(jxcSupplier);
			System.out.println("供应商信息:" + resultSupplier);
			//将管理员的信息放入到PageInfo中
			page = new PageInfo<JxcSupplier>(resultSupplier, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemSupplierList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	//插入供应商的方法
	@RequestMapping("/insertSupplier")
	public ModelAndView insertSupplier(JxcSupplier jxcSupplier,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置供应商正常值为6000
		jxcSupplier.setSupplierStatus(Constants.supplierStatusTrue);
		try {
			boolean flag = supplierService.insert(jxcSupplier);
			//如果返回为true,代表插入操作成功
			if(flag){
				mv.setViewName(Views.systemSupplierSelect);
			}else{
				//如果插入失败,在供应商插入界面提示插入失败
				mv.setViewName(Views.systemSupplierAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//供应商修改的方法supplierUpdate
	@RequestMapping("/supplierUpdate")
	public ModelAndView updateSupplier(JxcSupplier jxcSupplier,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = supplierService.update(jxcSupplier);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到供应商管理页面
				mv.setViewName(Views.systemSupplierSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//供应商删除的方法supplierDelete
	@RequestMapping("/supplierDelete")
	public ModelAndView deleteSupplier(JxcSupplier jxcSupplier,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置供应商异常值为6001
		jxcSupplier.setSupplierStatus(Constants.supplierStatusFalse);
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = supplierService.delete(jxcSupplier);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到供应商管理页面
				mv.setViewName(Views.systemSupplierSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//供应商查询个人的方法
	@RequestMapping("/querySupplierBySingle")
	public ModelAndView querySupplierBySingle(JxcSupplier jxcSupplier,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcSupplier resultSingleSupplier = supplierService.select(jxcSupplier);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleSupplier != null && !"".equals(resultSingleSupplier)){
				//设置到域中
				request.setAttribute("resultSingleSupplier", resultSingleSupplier);
				//设置返回页面
				mv.setViewName(Views.systemSupplierUpdate);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除供应商信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="supplierIds")List<Integer> supplierIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除供应商的方法
		try {
			boolean batchDelete = supplierService.deleteList(supplierIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemSupplierSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	//供应商查询个人详细信息的方法
	@RequestMapping("/querySupplierDetail")
	public ModelAndView querySupplierDetail(JxcSupplier jxcSupplier,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcSupplier querySupplierDetail = supplierService.select(jxcSupplier);
			//如果查询的值不为空,就显示在修改页面
			if(querySupplierDetail != null && !"".equals(querySupplierDetail)){
				//设置到域中
				request.setAttribute("querySupplierDetail", querySupplierDetail);
				//设置返回页面
				mv.setViewName(Views.systemSupplierShow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/*//供应商导出到excel的方法
	@RequestMapping(value="/employeeExport",method=RequestMethod.GET)
	public void employeeExport(JxcSupplier jxcSupplier,HttpServletRequest request,HttpServletResponse response){
		//供应商导出，先将所有供应商信息查询出来
		List<JxcEmployee> employee = new ArrayList<JxcEmployee>();
		try {
			employee = supplierService.selectAll(JxcEmployee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置每个sheet的最大记录数,默认为10000,可不设置
		ExcelKit.$Export(JxcEmployee.class, response)
        .setMaxSheetRecords(500)
        .toExcel(employee, "供应商信息");
		
		//导出案例
		ExcelKit.$Builder(User.class)
	    .setMaxSheetRecords(10000) //设置每个sheet的最大记录数,默认为10000,可不设置
	    .toExcel(records, "用户数据", new FileOutputStream(new File("c:/test001.xlsx")));
	}
	
	//导入excel到供应商信息表，employeeImport
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
										boolean flag = supplierService.insert(jxcEmployee);
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
	
	//供应商excel的模板
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
	}*/
	
	
}
