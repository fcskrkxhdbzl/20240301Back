package kr.happyjob.study.repository.explore;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.explore.ExploreModel;

@Mapper
public interface ExploreMapper {
	List<ExploreModel> exploreList(Map<String, Object> param);
}

