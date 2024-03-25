package kr.happyjob.study.service.login;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.login.ListUsrMnuAtrtMapper;
import kr.happyjob.study.repository.login.LoginMapper;
import kr.happyjob.study.repository.login.LoginProcMapper;
import kr.happyjob.study.repository.login.ListUsrChildMnuAtrtMapper;
import kr.happyjob.study.vo.login.LgnInfoModel;
import kr.happyjob.study.vo.login.LoginVO;
import kr.happyjob.study.vo.login.UserVO;
import kr.happyjob.study.vo.login.UsrMnuAtrtModel;
import kr.happyjob.study.vo.login.UsrMnuChildAtrtModel;

@Service
public class LoginProcService {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	
	@Autowired
	private LoginProcMapper loginProcMapper;
	
	/** 사용자 로그인 */
	public LgnInfoModel loginProc(Map<String, Object> paramMap) {
		//logger.info("   - loginProc service ParamMap : " + paramMap);
		LgnInfoModel lgnInfoModel = loginProcMapper.loginProc(paramMap);
		//logger.info("   - loginProc service lgnInfoModel : " + lgnInfoModel);
		
		return lgnInfoModel;
	}
	

}
