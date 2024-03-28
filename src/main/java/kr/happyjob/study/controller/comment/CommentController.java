package kr.happyjob.study.controller.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.service.comment.CommentService;
import kr.happyjob.study.vo.comment.CommentLikeModel;
import kr.happyjob.study.vo.comment.CommentModel;

@Controller
public class CommentController {

	@Autowired
	CommentService commentService;
	
	/*
	 * params:postNo
	 * comment:게시글 당 댓글 목록 조회
	 * */
	@PostMapping("/commentList")
	@ResponseBody
	public Map<String, Object> commentList(@RequestParam Map<String, Object> params){
		System.out.println("comment List params --->"+params);
		
		List<CommentModel> comments = commentService.commentList(params);
		System.out.println("comment List result comments --->"+comments);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("comments",comments);
		
		return returnMap;
	}
	
	/*
	 * params:userNo, commentNo
	 * comment:각 댓글 좋아요 삽입(까만하트)
	 * */
	@PostMapping("/commentLike")
	@ResponseBody
	public Map<String, Object> commentLike(CommentLikeModel commentNum, CommentModel commentModel){
		System.out.println("like user no :"+commentNum.getUserNo());
		System.out.println("like comment no :"+commentNum.getCommentNo());
		System.out.println("like commentNum :"+commentNum);
		System.out.println("like post no :"+commentModel.getPostNo());
		
		boolean result = commentService.commentLike((commentNum));
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("postNo",commentModel.getPostNo());
		List<CommentModel> comments = commentService.commentList(params);

		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("result",result);
		returnMap.put("comments",comments);
		
			
		return returnMap;
	}
	
	/*
	 * params:commentLikeNo
	 * comment:각 댓글 좋아요 조회 삭제(하얀하트)
	 * */
	@PostMapping("/commentUnLike")
	@ResponseBody
	public Map<String, Object> commentUnLike(CommentLikeModel likeRowNum, CommentModel commentModel){
		System.out.println("UnLike comment like no :"+likeRowNum.getCommentNo());
		
		boolean result = commentService.commentUnLike((likeRowNum));
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("postNo",commentModel.getPostNo());
		List<CommentModel> comments = commentService.commentList(params);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("result",result);
		returnMap.put("comments",comments);
		
		return returnMap;
	}
	

}
