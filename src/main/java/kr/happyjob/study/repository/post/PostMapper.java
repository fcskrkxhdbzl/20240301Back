package kr.happyjob.study.repository.post;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.post.PostModel;

@Mapper
public interface PostMapper {
	public PostModel postDetail(String params) ;
}
