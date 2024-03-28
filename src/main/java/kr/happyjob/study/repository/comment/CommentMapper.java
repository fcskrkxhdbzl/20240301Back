package kr.happyjob.study.repository.comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.comment.CommentLikeModel;
import kr.happyjob.study.vo.comment.CommentModel;

@Mapper
public interface CommentMapper {
	
	/*
	 * params:postNo
	 * comment:게시글 당 댓글 목록 조회
	 * */
	public List<CommentModel> commentList(Map<String, Object> params);
	
	/*
	 * params:postNo
	 * comment:각 댓글 좋아요 조회
	 * */
	public boolean commentLike(CommentLikeModel commentNum);

	/*
	 * params:postNo
	 * comment:각 댓글 좋아요 조회
	 * */
	public boolean commentUnLike(CommentLikeModel likeRowNum);
}
