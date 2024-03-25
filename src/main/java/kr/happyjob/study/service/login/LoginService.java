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
public class LoginService {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	
	@Autowired
	private LoginMapper mapper;
	
	public UserVO login(LoginVO vo) {
		return mapper.login(vo);
	}
	
}
