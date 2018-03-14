package cn.dean.spring.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.dean.spring.exception.MessageException;
import cn.dean.spring.pojo.Items;
import cn.dean.spring.pojo.QueryVo;
import cn.dean.spring.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	public ItemService itemService;

	@RequestMapping("/item/itemlist.action")
//	public ModelAndView itemList(){
	public String itemList(Model model) throws MessageException{
		//Integer i = 1/0;
		//预期异常
		/*if(null==null){
			throw new MessageException("商品信息不能为空");
		}*/
		List<Items> itemList = itemService.selectItemsList();
		model.addAttribute("itemList", itemList);
		return "itemList";
	}
	
	@RequestMapping("/itemEdit.action")
/*	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session, Model model){*/
	public ModelAndView toEdit(/*@RequestParam(value="id",required=true)*/Integer id,
			HttpServletRequest request, HttpServletResponse response,
			Model model){
		ModelAndView mav = new ModelAndView();
//		String id = request.getParameter("id");
		Items item = itemService.selectItemsById(/*Integer.parseInt(id)*/id);
		mav.addObject("item", item);
		mav.setViewName("editItem");
		return mav;
	}
	
	@RequestMapping("/updateitem.action")
		public String updateItems(QueryVo vo, MultipartFile pictureFile) throws Exception{
			String name = UUIDUtil.getTimeBasedUUID().toString().replaceAll("-", "");
			//获取后缀名
			String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
			//保存文件
			pictureFile.transferTo(new File("E:\\upload\\" + name + "." +ext));
			//保存到数据库
			vo.getItems().setPic(name + "." +ext);
			itemService.updateItemsById(vo.getItems());
			return "redirect:/itemEdit.action?id=" + vo.getItems().getId();
			//return "redirect:/item/itemlist.action";
		}
	
	@RequestMapping("/deletes.action")
	public ModelAndView deleteItems(Integer[] ids){
		ModelAndView mav = new ModelAndView();
		System.out.println("666");
		mav.setViewName("success");
		return mav;
	}

	@RequestMapping("/updates.action")
	public ModelAndView updatesItems(QueryVo vo){
		ModelAndView mav = new ModelAndView();
		System.out.println("666");
		mav.setViewName("success");
		return mav;
	}
	//json数据交互
	@RequestMapping("/json.action")
	//Springmvc提供了json转换包，采用注解的方式进行json和pojo对象的相互转换
	public @ResponseBody Items json(@RequestBody Items items){
		return items;
	}
	
	//去登陆的页面
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	//用户提交上来
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String username, HttpSession session){
		session.setAttribute("USER_SESSION", username);
		return "redirect:/item/itemlist.action";
	}
}
