package com.vrcs.debug;

import com.vrcs.debug.access.AccessDao;
import com.vrcs.debug.access.StatisticsFilter;
import com.vrcs.debug.volume.VolumeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private VolumeDao volumeDao;
	
	@Autowired
	private AccessDao accessDao;
	
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
		model.addAllAttributes(accessDao.selectStatisticsGroup());
		return "demos";
	}
	
	@RequestMapping(value = "demo/pn/{pn}", method = RequestMethod.GET)
	public String demo(Model model, @PathVariable(value = "pn") Integer pn){
		
		model.addAttribute("volume", volumeDao.selectOne(pn));
		
		return "demo";
	}
}