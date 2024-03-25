package kr.happyjob.study.controller.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kr.happyjob.study.service.login.ListUsrChildMnuAtrtService;
import kr.happyjob.study.service.login.ListUsrMnuAtrtService;
import kr.happyjob.study.service.login.LoginProcService;
import kr.happyjob.study.service.login.LoginService;
import kr.happyjob.study.vo.login.LoginVO;
import kr.happyjob.study.vo.login.UserVO;
import kr.happyjob.study.vo.login.LgnInfoModel;
import kr.happyjob.study.vo.login.UsrMnuAtrtModel;
import kr.happyjob.study.vo.login.UsrMnuChildAtrtModel;

@Controller
public class LoginController {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	
	@Autowired
	private LoginService service;

	@Autowired
	private LoginProcService loginProcService;
	
	@Autowired
	private ListUsrChildMnuAtrtService listUsrChildMnuAtrtService;

	@Autowired
	private ListUsrMnuAtrtService listUsrMnuAtrtService;
	
	@GetMapping("/login")
	public ModelAndView loginPage() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> login(LoginVO vo) throws Exception {
		logger.info("login start");
		logger.info("inputId / inputPw");
		logger.info(vo.getId() + " / " + vo.getPw());
		UserVO userVo = new UserVO();
		Map<String, Object> resultMap = new HashMap<>();
		try {
			userVo = service.login(vo);
			if (userVo == null) {
				resultMap.put("resCode", "F");
				resultMap.put("resMsg", "로그인 실패");
			} else {
				resultMap.put("resCode", "S");
				resultMap.put("resMsg", "로그인 성공");
				//userVo = service.login(vo);
				logger.info("userVo");
				logger.info(userVo.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	@RequestMapping("/loginProc.do")
	@ResponseBody
	public Map<String, Object> loginProc(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {

	      logger.info("+ Start LoginController.loginProc.do");
		  logger.info("   - ParamMap : " + paramMap);
		    
		      // 사용자 로그인
		  String result;
		  String resultMsg;
		  Map<String, Object> resultMap = new HashMap<String, Object>();
		  
		  
		  try {
			  LgnInfoModel lgnInfoModel = loginProcService.loginProc(paramMap);
	      
		  
		       logger.info("   - lgnInfoModel : " + lgnInfoModel);

		  
		       if (lgnInfoModel != null) {
		    	   result = "SUCCESS";
		  	       resultMsg = "사용자 로그인 정보가 일치 합니다.";
		  	       System.out.println("asdf" + lgnInfoModel.getApproval_cd());
		  	       System.out.println("y".equals(lgnInfoModel.getApproval_cd()));
		  	       System.out.println("asdf" + lgnInfoModel.getApproval_cd());
		  	       System.out.println("n".equals(lgnInfoModel.getApproval_cd()));
		  	       // 사용자 메뉴 권한 조회
		  	       paramMap.put("usr_sst_id", lgnInfoModel.getUsr_sst_id());
		  	       paramMap.put("userType",lgnInfoModel.getMem_author());
		  	       // 메뉴 목록 조회 0depth
		  	       List<UsrMnuAtrtModel> listUsrMnuAtrtModel = listUsrMnuAtrtService.listUsrMnuAtrt(paramMap);
		  	       // 메뉴 목록 조회 1depth
		  	       for(UsrMnuAtrtModel list : listUsrMnuAtrtModel){
		  	          Map<String, Object> resultMapSub = new HashMap<String, Object>();
		  	          resultMapSub.put("lgn_Id", paramMap.get("lgn_Id")); 
		  	          resultMapSub.put("hir_mnu_id", list.getMnu_id());
		  	          resultMapSub.put("userType",lgnInfoModel.getMem_author());
		  	          list.setNodeList(listUsrChildMnuAtrtService.listUsrChildMnuAtrt(resultMapSub));
		  	       }
		  	     
		  	       session.setAttribute("loginId",lgnInfoModel.getLgn_id());                     //   로그인 ID
		  	       session.setAttribute("userNm",lgnInfoModel.getUsr_nm());                  // 사용자 성명
		  	       session.setAttribute("usrMnuAtrt", listUsrMnuAtrtModel);
		  	       session.setAttribute("userType", lgnInfoModel.getMem_author());            // 로그린 사용자 권란       A: 관리자       B: 기업회원    C:일반회원
		  	       session.setAttribute("serverName", request.getServerName());
		  	
		  	       resultMap.put("loginId",lgnInfoModel.getLgn_id()); 
		  	       resultMap.put("userNm",lgnInfoModel.getUsr_nm()); 
		  	       resultMap.put("usrMnuAtrt", listUsrMnuAtrtModel);
		  	       resultMap.put("userType", lgnInfoModel.getMem_author());
		  	       resultMap.put("serverName", request.getServerName());
			} else {
	
		         result = "FALSE";
		         resultMsg = "사용자 로그인 정보가 일치하지 않습니다.";
		    }

	            
	    
		    resultMap.put("result", result);
		    resultMap.put("resultMsg", resultMsg);
		    resultMap.put("serverName", request.getServerName());
	  
		  } catch (Exception e) {
			    e.printStackTrace();
		  }	  
	  
	  
	    logger.info("+ End LoginController.loginProc.do");

	    return resultMap;
}
	   
	   
	   /**
	* 로그아웃
	* @param request
	* @param response
	* @param session
	* @return
	*/
	   @RequestMapping(value = "/loginOut.do")
	   public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	                  
	      ModelAndView mav = new ModelAndView();
	      session.invalidate();
	      mav.setViewName("redirect:/login");
	      
	      return mav;
	   }
}