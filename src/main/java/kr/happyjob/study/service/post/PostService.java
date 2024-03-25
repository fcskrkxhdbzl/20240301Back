package kr.happyjob.study.service.post;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kr.happyjob.study.repository.post.PostMapper;
import kr.happyjob.study.vo.post.PostModel;

@Service
public class PostService {
	
	@Autowired
	PostMapper postMapper; 
	
	public PostModel postDetail(Map<String, Object> params) {
		return postMapper.postDetail(params);
	}

}
