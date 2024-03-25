package kr.happyjob.study.controller.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.service.NoticeService.NoticeService;
import kr.happyjob.study.vo.notice.NoticeModel;

@Controller
@RequestMapping("/system/")
public class NoticeController {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@Autowired
	private NoticeService noticeService;

	// 공지사항 리스트 출력
	@RequestMapping("noticeListvue.do")
	@ResponseBody
	public Map<String, Object> noticeListvue(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("   - paramMap : " + paramMap);
		String title = (String) paramMap.get("title");

		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		int pageIndex = (currentPage - 1) * pageSize;

		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		paramMap.put("title", title);

		// 공지사항 목록 조회
		List<NoticeModel> noticeList = noticeService.noticeList(paramMap);
		// 목록 수 추출해서 보내기
		int noticeCnt = noticeService.noticeCnt(paramMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("notice", noticeList); // success 용어 담기
		resultMap.put("noticeCnt", noticeCnt); // 리턴 값 해쉬에 담기
		resultMap.put("pageSize", pageSize);
		resultMap.put("currentPage", currentPage);

		return resultMap;
	}

	@PostMapping("/noticeDetail")
	@ResponseBody
	public Map<String, Object> noticeDetail(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("noticeDatail start");
		logger.info("   - paramMap : " + paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap.put("noticeDetail", noticeService.noticeDetail(paramMap));
		} catch (Exception e) {
			throw e;
		}
		return resultMap;
	}

	@PostMapping("/noticeUpdate")
	@ResponseBody
	public void noticeUpdate(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("noticeUpdate start");
		logger.info("   - paramMap : " + paramMap);
		try {
			noticeService.noticeUpdate(paramMap);
		} catch (Exception e) {
			throw e;
		}
	}

	@PostMapping("/insertNotice")
	@ResponseBody
	public void insertNotice(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("insertNotice start");
		logger.info("   - paramMap : " + paramMap);

		try {
			noticeService.insertNotice(paramMap);
		} catch (Exception e) {
			throw e;
		}
	}
}