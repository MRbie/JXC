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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wuwz.poi.ExcelKit;
import org.wuwz.poi.hanlder.ReadHandler;

import com.bie.po.JxcEmployee;
import com.bie.po.JxcGoods;
import com.bie.po.JxcPurchaseorder;
import com.bie.po.JxcSupplier;
import com.bie.po.JxcWarehouse;
import com.bie.service.EmployeeService;
import com.bie.service.GoodsService;
import com.bie.service.PurchaseorderService;
import com.bie.service.SupplierService;
import com.bie.service.WarehouseService;
import com.bie.utils.Constants;
import com.bie.utils.JsonUtils;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:商品的控制层
 */
@Controller
@RequestMapping(value="/goods")
public class GoodsAction {
	
	@Resource
	private GoodsService goodsService;
	@Resource()
	private EmployeeService purchaseorderEmployeeService;
	@Resource()
	private SupplierService purchaseorderSupplierService;
	@Resource()
	private WarehouseService purchaseorderWarehouseService;
	@Resource()
	private PurchaseorderService purchaseorderGoodsService;
	
	//查询名称的方法
	@RequestMapping("/goodsSelect")
	public ModelAndView selectGoods(JxcGoods jxcGoods,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断名称名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsName") && context != null && !"".equals(context)){
			jxcGoods.setGoodsName(context);
		}
		//判断名称品牌
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsBrand") && context != null && !"".equals(context)){
			jxcGoods.setGoodsBrand(context);
		}
		//判断名称类型
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsColor") && context != null && !"".equals(context)){
			jxcGoods.setGoodsColor(context);
		}
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcGoods> page = null;
		//调用业务逻辑层的方法
		try {
			List<JxcGoods> resultGoods = goodsService.selectAll(jxcGoods);
			//将商品的信息放入到PageInfo中
			page = new PageInfo<JxcGoods>(resultGoods, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemGoodsList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//插入名称的方法
	@RequestMapping("/insertGoods")
	public ModelAndView insertGoods(JxcGoods jxcGoods,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置名称正常值为4000
		jxcGoods.setGoodsStatus(Constants.goodStatusTrue);
		try {
			boolean flag = goodsService.insert(jxcGoods);
			//如果返回为true,代表插入操作成功
			if(flag){
				mv.setViewName(Views.systemGoodsSelect);
			}else{
				//如果插入失败,在名称插入界面提示插入失败
				mv.setViewName(Views.systemGoodsAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//名称修改的方法goodsUpdate
	@RequestMapping("/goodsUpdate")
	public ModelAndView updateGoods(JxcGoods jxcGoods,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = goodsService.update(jxcGoods);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到名称管理页面
				mv.setViewName(Views.systemGoodsSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//名称删除的方法goodsDelete
	@RequestMapping("/goodsDelete")
	public ModelAndView deleteGoods(JxcGoods jxcGoods,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置名称异常值为5001
		jxcGoods.setGoodsStatus(Constants.goodStatusFalse);
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = goodsService.delete(jxcGoods);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到名称管理页面
				mv.setViewName(Views.systemGoodsSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//名称查询商品的方法
	@RequestMapping("/queryGoodsBySingle")
	public ModelAndView queryGoodsBySingle(JxcGoods jxcGoods,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcGoods resultSingleGoods = goodsService.select(jxcGoods);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleGoods != null && !"".equals(resultSingleGoods)){
				//设置到域中
				request.setAttribute("resultSingleGoods", resultSingleGoods);
				//设置返回页面
				mv.setViewName(Views.systemGoodsUpdate);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除名称信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="goodsIds")List<Integer> goodsIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除名称的方法
		try {
			boolean batchDelete = goodsService.deleteList(goodsIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemGoodsSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	//名称查询商品详细信息的方法
	@RequestMapping("/queryGoodsDetail")
	public ModelAndView queryGoodsDetail(JxcGoods jxcGoods,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcGoods queryGoodsDetail = goodsService.select(jxcGoods);
			//如果查询的值不为空,就显示在修改页面
			if(queryGoodsDetail != null && !"".equals(queryGoodsDetail)){
				//设置到域中
				request.setAttribute("queryGoodsDetail", queryGoodsDetail);
				//设置返回页面
				mv.setViewName(Views.systemGoodsShow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	
	//员工导出到excel的方法
	@RequestMapping(value="/goodsExport",method=RequestMethod.GET)
	public void goodsExport(JxcGoods jxcGoods,HttpServletRequest request,HttpServletResponse response){
		//员工导出，先将所有员工信息查询出来
		List<JxcGoods> goods = new ArrayList<JxcGoods>();
		try {
			goods = goodsService.selectAll(jxcGoods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置每个sheet的最大记录数,默认为10000,可不设置
		ExcelKit.$Export(JxcGoods.class, response)
        .setMaxSheetRecords(500)
        .toExcel(goods, "商品信息");
		
		//导出案例
		/*ExcelKit.$Builder(User.class)
	    .setMaxSheetRecords(10000) //设置每个sheet的最大记录数,默认为10000,可不设置
	    .toExcel(records, "用户数据", new FileOutputStream(new File("c:/test001.xlsx")));*/
	}
	
	
	//导入excel到员工信息表，goodsImport
	@RequestMapping(value="/goodsImport",method=RequestMethod.POST)
	public ModelAndView goodsImport(HttpServletRequest request,HttpServletResponse response){
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
									JxcGoods jxcGoods = new JxcGoods();
									if(jxcGoods != null && !"".equals(jxcGoods)){
										jxcGoods.setGoodsId(Integer.parseInt(row.get(0)));
										jxcGoods.setGoodsName(row.get(1));
										jxcGoods.setGoodsCode(row.get(2));
										jxcGoods.setGoodsType(row.get(3));
										jxcGoods.setGoodsBrand(row.get(4));
										jxcGoods.setGoodsColor(row.get(5));
										jxcGoods.setGoodsSpecifications(row.get(6));
										jxcGoods.setGoodsPicture(row.get(7));
										jxcGoods.setGoodsMaterial(row.get(8));
										jxcGoods.setGoodsBuyprice(Double.parseDouble(row.get(9)));
										jxcGoods.setGoodsSaleprice(Double.parseDouble(row.get(10)));
										jxcGoods.setGoodsModel(row.get(11));
										jxcGoods.setGoodsDesc(row.get(12));
										jxcGoods.setGoodsUpdater(row.get(13));
										jxcGoods.setGoodsUpdatetie(row.get(14));
										jxcGoods.setGoodsStatus(row.get(15));
										jxcGoods.setGoodsExtend(row.get(16));
										jxcGoods.setGoodsProducer(row.get(17));
										jxcGoods.setGoodsLowerLimit(Integer.parseInt(row.get(18)));
									}
									//插入操作
									try {
										boolean flag = goodsService.insert(jxcGoods);
										if(flag){
											mv.setViewName(Views.systemGoodsSelect);
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
	@RequestMapping(value="goodsTemplate",method=RequestMethod.GET)
	public void goodsTemplate(HttpServletRequest request,HttpServletResponse response){
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
	
	
	//查询名称的方法
	/*@RequestMapping("/purchaseOrderByGoods")
	public ModelAndView purchaseOrderByGoods(JxcGoods jxcGoods,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,3);
		PageInfo<JxcPurchaseorder> page = null;
		//调用业务逻辑层的方法
		try {
			//查询出仓库管理员
			//查询员工是仓库管理员的
			List<JxcEmployee> resultEmployee = purchaseorderEmployeeService.selectByEmployeeRole("采购管理员");
			System.out.println("查询出指定的管理员:"+ resultEmployee);
			if(!resultEmployee.isEmpty() && resultEmployee.size() > 0){
				request.setAttribute("resultEmployee", resultEmployee);
			}
			//查询出仓库
			List<JxcWarehouse> resultWarehouse = purchaseorderWarehouseService.selectAll(null);
			if(!resultWarehouse.isEmpty() && resultWarehouse.size()>0){
				request.setAttribute("resultWarehouse", resultWarehouse);
			}
			
			//查询出所有的供应商
			List<JxcSupplier> resultSupplier = purchaseorderSupplierService.selectAll(null);
			if(!resultSupplier.isEmpty() && resultSupplier.size()>0){
				request.setAttribute("resultSupplier", resultSupplier);
			}
			//查询出采购订单的信息，显示在页面上
			JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
			jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusFalse);
			List<JxcPurchaseorder> resultPurchaseorder = purchaseorderGoodsService.selectAll(jxcPurchaseorder);
			if(!resultPurchaseorder.isEmpty() && resultPurchaseorder.size()>0){
				//request.setAttribute("resultPurchaseorder", resultPurchaseorder);
				//将商品的信息放入到PageInfo中
				page = new PageInfo<JxcPurchaseorder>(resultPurchaseorder, 3);
				System.out.println("采购订单分析信息:" + page);
				//保存到域中
				request.setAttribute("pageInfo", page);
			}
			//查询出商品的信息，用于选择
			List<JxcGoods> resultGoods = goodsService.selectAll(jxcGoods);
			if(resultGoods.size()>0 && !resultGoods.isEmpty()){
				request.setAttribute("resultGoods", resultGoods);
			}
			//将商品的信息放入到PageInfo中
			//page = new PageInfo<JxcGoods>(resultGoods, 5);
			//保存到域中
			//request.setAttribute("pageInfo", page);
			//设置返回值system/purchaseorder/purchaseorder_list.jsp
			mv.setViewName(Views.systemPurchaseorderSelect);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}*/
		
	//采购商品的方法@RequestParam(value="pn",defaultValue="1")Integer pn,
	@RequestMapping("/purchaseOrderByGoods")
	public ModelAndView purchaseOrderByGoods(JxcGoods jxcGoods,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		//PageHelper.startPage(pn,3);
		//PageInfo<JxcGoods> page = null;
		//调用业务逻辑层的方法
		try {
			//查询出仓库管理员
			//查询员工是仓库管理员的,指定仓库管路员
			List<JxcEmployee> resultEmployee = purchaseorderEmployeeService.selectByEmployeeRole(Views.systemEmployeeTypeByRoleType_Purchaseorder);
			System.out.println("查询出指定的管理员:"+ resultEmployee);
			if(!resultEmployee.isEmpty() && resultEmployee.size() > 0){
				request.setAttribute("resultEmployee", resultEmployee);
			}
			//查询出仓库
			List<JxcWarehouse> resultWarehouse = purchaseorderWarehouseService.selectAll(null);
			if(!resultWarehouse.isEmpty() && resultWarehouse.size()>0){
				request.setAttribute("resultWarehouse", resultWarehouse);
			}
			
			//查询出所有的供应商
			List<JxcSupplier> resultSupplier = purchaseorderSupplierService.selectAll(null);
			if(!resultSupplier.isEmpty() && resultSupplier.size()>0){
				request.setAttribute("resultSupplier", resultSupplier);
			}
			//查询出采购订单的信息，显示在页面上
			JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
			jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusFalse);
			List<JxcPurchaseorder> resultPurchaseorder = purchaseorderGoodsService.selectAll(jxcPurchaseorder);
			if(!resultPurchaseorder.isEmpty() && resultPurchaseorder.size()>0){
				//request.setAttribute("resultPurchaseorder", resultPurchaseorder);
				//保存到域中
				request.setAttribute("resultPurchaseorder", resultPurchaseorder);
			}
			//查询出商品的信息，用于选择
			/*List<JxcGoods> resultGoods = goodsService.selectAll(jxcGoods);
			if(resultGoods.size()>0 && !resultGoods.isEmpty()){
				request.setAttribute("resultGoods", resultGoods);
			}
			//将商品的信息放入到PageInfo中
			page = new PageInfo<JxcGoods>(resultGoods, 3);
			System.out.println("采购订单分析信息:" + page);
			//将商品的信息放入到PageInfo中
			request.setAttribute("pageInfo", page);*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置返回值system/purchaseorder/purchaseorder_list.jsp
		mv.setViewName(Views.systemPurchaseorderSelect);
		return mv;
	}
	
	//选择商品,弹出模态框,可以选择想要的商品信息@RequestParam(value="pn",defaultValue="1")Integer pn,
	@RequestMapping(value="/ajaxPurchaseOrderByGoods",method=RequestMethod.POST)
	@ResponseBody
	public void ajaxPurchaseOrderByGoods(JxcGoods jxcGoods,HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		//ModelAndView mv = new ModelAndView();
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		//PageHelper.startPage(pn,3);
		//PageInfo<JxcGoods> page = null;
		//System.out.println("查询所有的商品:" + jxcGoods);
		try {
			//查询出商品的信息，用于选择
			List<JxcGoods> resultGoods = goodsService.selectAll(jxcGoods);
			if(resultGoods.size()>0 && !resultGoods.isEmpty()){
				//page = new PageInfo<JxcGoods>(resultGoods, 3);
				//request.setAttribute("pageInfo", page);
				request.setAttribute("resultGoods", resultGoods);
				response.getWriter().write(JsonUtils.object2String(resultGoods));
				response.getWriter().flush();
				response.getWriter().close();
			}
			//将商品的信息放入到PageInfo中
			//page = new PageInfo<JxcGoods>(resultGoods, 3);
			//System.out.println("采购订单分析信息:" + page);
			//将商品的信息放入到PageInfo中
			//page = new PageInfo<JxcGoods>(resultGoods, 5);
			//保存到域中
			//request.setAttribute("pageInfo", page);
			//mv.setViewName(Views.systemPurchaseorderSelect);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return mv;
	}
	
	
	
}
