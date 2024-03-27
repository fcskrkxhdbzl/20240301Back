package kr.happyjob.study.controller.explore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	

	@GetMapping("/list")
	@ResponseBody
	public Map<String, Object> explore(Map<String, Object> param) throws Exception {
		System.out.println("");
		logger.info("hello world:::" + param);
		List<ExploreModel> exploreList = exploreService.exploreList(param);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("exploreList", exploreList);
		return resultMap;
	}
	
}