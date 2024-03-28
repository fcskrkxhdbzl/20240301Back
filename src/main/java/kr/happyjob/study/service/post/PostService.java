package kr.happyjob.study.service.post;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.post.PostMapper;
import kr.happyjob.study.vo.post.PostModel;

@Service
public class PostService {
	
	@Autowired
	PostMapper postMapper; 
	
	public PostModel postDetail(String params) {
		return postMapper.postDetail(params);
	}

}
