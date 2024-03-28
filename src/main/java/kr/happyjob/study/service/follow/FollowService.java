package kr.happyjob.study.service.follow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.follow.FollowMapper;
import kr.happyjob.study.vo.follow.FollowModel;

@Service
public class FollowService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@Autowired
	private FollowMapper followMapper;

	//팔로우 조회
	public List<FollowModel> followList(Map<String, Object> paramMap) throws Exception {
		return followMapper.followList(paramMap);
		
	}
    //팔로워 조회
	public List<FollowModel> followerlist(Map<String, Object> paramMap) throws Exception {
		return followMapper.followerlist(paramMap);
	}

	//팔로우 등록
	public int insertFollowing(Map<String, Object> paramMap) throws Exception{
		return followMapper.insertFollowing(paramMap);
	}

	//팔로우 삭제
	public int deleteFollowing(Map<String, Object> paramMap) throws Exception{
		return followMapper.deleteFollowing(paramMap);
	}

	//팔로우 여부 확인 조회
	public boolean checkFollowing(int followerUNo, int followUNo) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("followerUNo", followerUNo);
        paramMap.put("followUNo", followUNo);
        return followMapper.checkFollowing(paramMap);
    }

}