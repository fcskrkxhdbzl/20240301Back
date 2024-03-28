package kr.happyjob.study.repository.follow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.follow.FollowModel;

@Mapper
public interface FollowMapper {
	
	public List<FollowModel> followList(Map<String, Object> paramMap) throws Exception;

	public List<FollowModel> followerlist(Map<String, Object> paramMap) throws Exception;

	public int insertFollowing(Map<String, Object> paramMap) throws Exception;

	public int deleteFollowing(Map<String, Object> paramMap) throws Exception;

	//public boolean checkFollowingExist(int followerUNo, int followUNo);

	public boolean checkFollowing(Map<String, Object> paramMap);

}