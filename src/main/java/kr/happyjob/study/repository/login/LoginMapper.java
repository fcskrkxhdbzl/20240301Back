package kr.happyjob.study.repository.login;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.login.LoginVO;
import kr.happyjob.study.vo.login.UserVO;

@Mapper
public interface LoginMapper {
	UserVO login(LoginVO vo);
}

