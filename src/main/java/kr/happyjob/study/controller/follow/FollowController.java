package kr.happyjob.study.controller.follow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.service.follow.FollowService;
import kr.happyjob.study.vo.follow.FollowModel;

@Controller
//@RequestMapping("/system/")
public class FollowController {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@Autowired
	private FollowService followService;

	// 팔로우 조회
	@RequestMapping("/followlist")
	@ResponseBody
	public Map<String, Object> followList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		System.out.println("followList" + paramMap);
		// 1.follow data select
		List<FollowModel> list = followService.followList(paramMap);
		logger.info(list.size());

		// 2.return data set
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// validation check
		if (list.size() > 0) {
			resultMap.put("rst", "SUCCESS");
			resultMap.put("list", list);
			// resultMap.put("key", "value");
		} else {
			resultMap.put("rst", "FAIL");
		}

		// 3.return data check
		logger.info("resultMap확인 팔로우 ::: " + resultMap);
		return resultMap;
	}

	// 팔로워 조회
	@RequestMapping("/followerlist")
	@ResponseBody
	public Map<String, Object> followerlist(@RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		System.out.println("followerlist" + paramMap);
		// 1.data select
		List<FollowModel> list = followService.followerlist(paramMap);
		logger.info(list.size());

		// 2.return data set
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// validation check
		if (list.size() > 0) {
			resultMap.put("rst", "SUCCESS");
			resultMap.put("list", list);
			// resultMap.put("key", "value");
		} else {
			resultMap.put("rst", "FAIL");
		}

		// 3.return data check
		logger.info("resultMap확인 팔로워 ::: " + resultMap);
		return resultMap;
	}
		
	//팔로잉
	@RequestMapping("/following")
	@ResponseBody
	public Map<String, Object> following(@RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		System.out.println("following" + paramMap);

	    Map<String, Object> resultMap = new HashMap<String, Object>();
	    String action = (String) paramMap.get("action");

	    if (action == null || action.trim().isEmpty()) {
	        resultMap.put("message", "FALSE : action이 유효하지 않습니다.");
	    } else {	        
	    	
	    	String resultMsg;
	    	
	    	// followerUNo과 followUNo의 데이터 값이 같은지 확인
	        int followerUNo = Integer.parseInt((String) paramMap.get("followerUNo"));
	        int followUNo = Integer.parseInt((String) paramMap.get("followUNo"));
	        if (followerUNo == followUNo) {
	            resultMap.put("message", "FALSE : followerUNo와 followUNo는 같을 수 없습니다.");
	            return resultMap;
	        } else if ("D".equals(action)) {
	        	        	
	        	System.out.println("액션값 확인" + action);
	        	System.out.println("paramMap 확인" + paramMap);
	            followService.deleteFollowing(paramMap);
	            resultMsg = "DSUCCESS";
	        }
	        // followerUNo와 followUNo을 기준으로 조회하여 결과가 존재하는지 확인
	        boolean followExists = followService.checkFollowing(followerUNo, followUNo);
	        if (followExists) {
	            resultMap.put("message", "FALSE : 이미 팔로우된 사용자입니다.");
	            resultMap.put("modalOpen", true); // 인서트가 일어나지 않았을 때 모달 열기 여부를 전달
	            return resultMap;
	        }
	        if ("I".equals(action)) {
	            followService.insertFollowing(paramMap);
	            resultMsg = "ISUCCESS";
	        } else {
	            resultMap.put("message", "FALSE : action 값이 유효하지 않습니다.");
	            return resultMap;
	        }

	        resultMap.put("list", paramMap);
	        resultMap.put("message", resultMsg);
	        System.out.println(paramMap);
	    }

	    logger.info("resultMap확인 팔로잉 ::: " + resultMap);
	    return resultMap;
	
	}
}