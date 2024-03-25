package kr.happyjob.study.controller.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.service.post.PostService;
import kr.happyjob.study.vo.post.PostModel;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;

	@PostMapping("/postDetail")
	@ResponseBody
	public Map<String, Object> postDetail(@RequestParam Map<String, Object> params){
		System.out.println("postDetail controller 에서 params 데이터 확인:"+params);
		PostModel post = postService.postDetail(params);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("data",post);
		return 	returnMap;
	}

	@GetMapping("/mytest")
	@ResponseBody
	public Map<String, Object> testCont(@RequestParam Map<String, Object> params){
		
		System.out.println(params);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("sucess","suceessssssss!!!");
		return 	returnMap;
	}
	

}
