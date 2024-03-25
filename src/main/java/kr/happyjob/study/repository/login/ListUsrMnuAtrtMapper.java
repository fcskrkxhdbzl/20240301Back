package kr.happyjob.study.repository.login;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.login.LoginVO;
import kr.happyjob.study.vo.login.UserVO;
import kr.happyjob.study.vo.login.LgnInfoModel;
import kr.happyjob.study.vo.login.UsrMnuAtrtModel;
import kr.happyjob.study.vo.login.UsrMnuChildAtrtModel;

@Mapper
public interface ListUsrMnuAtrtMapper {
	List<UsrMnuAtrtModel> listUsrMnuAtrt(Map<String, Object> paramMap);
}
