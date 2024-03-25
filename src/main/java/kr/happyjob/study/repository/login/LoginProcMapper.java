package kr.happyjob.study.repository.login;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kr.happyjob.study.vo.login.LoginVO;
import kr.happyjob.study.vo.login.UserVO;
import kr.happyjob.study.vo.login.LgnInfoModel;
import kr.happyjob.study.vo.login.UsrMnuAtrtModel;
import kr.happyjob.study.vo.login.UsrMnuChildAtrtModel;

@Mapper
public interface LoginProcMapper {
	
	LgnInfoModel loginProc(Map<String, Object> paramMap);
}

