package kr.happyjob.study.service.comment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.comment.CommentMapper;
import kr.happyjob.study.vo.comment.CommentLikeModel;
import kr.happyjob.study.vo.comment.CommentModel;

@Service
public class CommentService {

	@Autowired
	CommentMapper commentMapper;
	
	/*
	 * params:postNo
	 * comment:게시글 당 댓글 목록 조회
	 * */
	public List<CommentModel> commentList(Map<String, Object> params){
		return commentMapper.commentList(params);
	}
	
	/*
	 * params:postNo
	 * comment:각 댓글 좋아요 조회
	 * */
	public boolean commentLike(CommentLikeModel commentNum) {
		return commentMapper.commentLike(commentNum);
	};
	
	/*
	 * params:postNo
	 * comment:각 댓글 좋아요 조회
	 * */
	public boolean commentUnLike(CommentLikeModel likeRowNum) {
		return commentMapper.commentUnLike(likeRowNum);
	};
}
