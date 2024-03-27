package kr.happyjob.study.controller.explore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.service.explore.ExploreService;
import kr.happyjob.study.vo.explore.ExploreModel;

@Controller
@RequestMapping(value="/explore")
public class ExploreController {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	

	@Autowired
	private ExploreService exploreService;
	

	@PostMapping("/list")
	@ResponseBody
	public Map<String, Object> explore(@RequestParam Map<String, Object> param) throws Exception {
		Iterator<String> iter = param.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			logger.info("iter key:::" + key);
			logger.info("iter val:::" + param.get(key));
		}
		System.out.println("hello world:::" + param);
		logger.info("hello world:::" + param);
		List<ExploreModel> exploreList = exploreService.exploreList(param);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("exploreList", exploreList);
		return resultMap;
	}
	
}