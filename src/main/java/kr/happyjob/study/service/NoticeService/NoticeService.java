package kr.happyjob.study.service.NoticeService;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.notice.NoticeMapper;

import kr.happyjob.study.vo.notice.NoticeModel;

@Service
public class NoticeService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@Autowired
	private NoticeMapper noticeMapper;

	public List<NoticeModel> noticeList(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeList(paramMap);
	}

	public int noticeCnt(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeCnt(paramMap);
	}

	public NoticeModel noticeDetail(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeDetail(paramMap);
	}

	public void noticeUpdate(Map<String, Object> paramMap) throws Exception {
		noticeMapper.updateNotice(paramMap);
	}
	
	public void insertNotice(Map<String, Object> paramMap) throws Exception {
		noticeMapper.insertNotice(paramMap);
	}	
}