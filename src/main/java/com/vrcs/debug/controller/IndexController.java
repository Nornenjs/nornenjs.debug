package com.vrcs.debug.controller;

import com.vrcs.debug.util.SocketConnect;
import com.vrcs.debug.volume.VolumeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private VolumeDao volumeDao;

	@Autowired
	private SocketConnect socketConnect;
	
	@RequestMapping(method = RequestMethod.GET)
	public String indexPage(Model model){
		return "index";
	}
	
	@RequestMapping(value = "getStarted", method = RequestMethod.GET)
	public String getStartedPage(Model model){
		return "getStarted";
	}
	
	@RequestMapping(value = "document", method = RequestMethod.GET)
	public String documentPage(Model model){
		return "document";
	}

	@RequestMapping(value = "demos", method = RequestMethod.GET)
	public String demos(Model model){
		model.addAttribute("volumes", volumeDao.selectListInfo());
		return "demos";
	}
	
	@RequestMapping(value = "demo/pn/{pn}", method = RequestMethod.GET)
	public String demo(Model model, @PathVariable(value = "pn") Integer pn){
		model.addAttribute("volume", volumeDao.selectOne(pn));
//		if(socketConnect.connection()){
//			return "demo";
//		}else{
			return "demo_not_supported";
//		}
	}

	@RequestMapping(value = "signIn", method = RequestMethod.GET)
	public String signInPage(Model model){
		return "user/signIn";
	}
}