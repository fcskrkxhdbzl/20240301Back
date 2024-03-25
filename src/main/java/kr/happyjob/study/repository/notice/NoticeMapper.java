package kr.happyjob.study.repository.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kr.happyjob.study.vo.notice.NoticeModel;

@Mapper
public interface NoticeMapper {

	// 공지사항 리스트 조회
	public List<NoticeModel> noticeList(Map<String, Object> paramMap);

	// 공지사항 목록 카운트 조회
	public int noticeCnt(Map<String, Object> paramMap);

	public NoticeModel noticeDetail(Map<String, Object> paramMap) throws Exception;

	public void updateNotice(Map<String, Object> paramMap) throws Exception;
	
	public void insertNotice(Map<String, Object> paramMap) throws Exception;	
}