package kr.happyjob.study.service.explore;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.login.ListUsrMnuAtrtMapper;
import kr.happyjob.study.repository.login.LoginMapper;
import kr.happyjob.study.repository.login.LoginProcMapper;
import kr.happyjob.study.repository.explore.ExploreMapper;
import kr.happyjob.study.repository.login.ListUsrChildMnuAtrtMapper;
import kr.happyjob.study.vo.explore.ExploreModel;
import kr.happyjob.study.vo.login.LgnInfoModel;
import kr.happyjob.study.vo.login.LoginVO;
import kr.happyjob.study.vo.login.UserVO;
import kr.happyjob.study.vo.login.UsrMnuAtrtModel;
import kr.happyjob.study.vo.login.UsrMnuChildAtrtModel;

@Service
public class ExploreService {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	
	@Autowired
	private ExploreMapper mapper;
	
	public List<ExploreModel> exploreList(Map<String, Object> param) {
		if(param.get("pageIndex") == null) {
			param.put("pageIndex", 0);
		}
		if(param.get("pageSizeIndex") == null) {
			param.put("pageSize", 10);
		}
		
		return mapper.exploreList(param);
	}
	
}
