package kr.happyjob.study.controller.post;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.service.post.PostService;
import kr.happyjob.study.vo.post.PostModel;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;

	@PostMapping("/postDetail")
	@ResponseBody
	public Map<String, Object> postDetail( PostModel param ) throws Exception {
//		,HttpServletRequest request, @RequestBody String postId, @RequestBody String postNo
//		Enumeration<String> params = request.getParameterNames();
//		System.out.println("----------------------------");
//		while (params.hasMoreElements()){
//		    String name = (String)params.nextElement();
//		    System.out.println(name + " : " +request.getParameter(name));
//		}
//		System.out.println("----------------------------");		
//		System.out.println("postDetail controller 에서 params 데이터 확인11111	:"+request);
//		System.out.println("postDetail controller 에서 params 데이터 확인11111	:"+postNo);
//		System.out.println("postDetail controller 에서 params 데이터 확인2222 :"+postId);
//		Iterator<String> iter =  params.keySet().iterator();
//		while(iter.hasNext()) {
//			System.out.println("hello world::::" + iter.next());
//		}
//		PostModel post = postService.postDetail(null);
//		Set<String> keys = params.keySet();
//		Iterator<String> iter =  params.keySet().iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//		System.out.println("hello world::::" + key);
//		System.out.println("hello world::::" + params.get(key));
//	}
		System.out.println("paramparamparamparamparam:"+("" +param.getPostNo()));
		PostModel post = postService.postDetail("" +param.getPostNo());
		// 게시물등록-현재일차이
		long diffDate = ((post.getPostNewDate()).getTime()-(new Date()).getTime())/1000;
		System.out.println("diffDate   ::::::"+diffDate);
	
		Map<String, Object> returnMap = new HashMap<String, Object>();
		System.out.println("postpostpostpostpostpostpostpost:"+post);
		returnMap.put("post",post);
		returnMap.put("diffDate",diffDate);
		
		return 	returnMap;
	}

	

}
