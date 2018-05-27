package com.yume.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yume.domain.MemberVO;
import com.yume.service.MemberService;
import com.yume.util.MemberUtil;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	private static final Logger L = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * For Debug, It output Log
	 * @param msg
	 * @throws Exception
	 */
	private void L(String msg) throws Exception{
		L("");
		L.info(msg);
		L("");
	}
	
	@Inject
	private MemberService service;
	
	
	@RequestMapping(value="/createMember", method = RequestMethod.GET)
	public void createMember() throws Exception{
		L.info("createMember");
	}
	
	
	@RequestMapping(value="/createMember", method = RequestMethod.POST)
	public String createMember(MemberVO mvo, RedirectAttributes rttr) throws Exception{
		L("createMember post");
		memberService.joinMember(mvo);
		return "redirect:/member/readMember?m_num="+mvo.getM_num();
		
	}
	
	
	@RequestMapping(value="/readMember", method = RequestMethod.GET)
	public void readMember(Integer m_num, Model model) throws Exception{
		L("readMember get");
		model.addAttribute("memberInfo", memberService.readMember(m_num));
	}
	
	
	@RequestMapping(value="/updateMember" , method = RequestMethod.GET)
	public void updateMember(Integer m_num, Model model) throws Exception{
		L("updateMember get");
		model.addAttribute("user",service.readMember(m_num));
	}
	
	
	@RequestMapping(value="/updateMember" , method = RequestMethod.POST)
	public String updateMember(MemberVO mvo, RedirectAttributes rttr) throws Exception{
		L("updateMember post");
		service.joinMember(mvo);
		return "redirect:/member/readMember?m_num="+mvo.getM_num();
	}
	
	
	@RequestMapping(value="/deleteMember", method= RequestMethod.POST)
	public String deleteMember(Integer m_num, RedirectAttributes rttr) throws Exception{
		L("deleteMember post");
		service.deleteMember(m_num);
		return "redirect:/member/main";
	}
	
	
	@RequestMapping(value="/joinMember", method = RequestMethod.GET)
	public void mainPage() throws Exception{
		L("mainPage");
	}
	
	
	
	@RequestMapping(value="/loginMember" , method = RequestMethod.GET)
	public void loginMember() throws Exception{
		L("loginMember get");
	}
	
	
	@RequestMapping(value="/loginMember", method= RequestMethod.POST)
	public String loginMember(MemberVO mvo, Model model, 
			RedirectAttributes rttr,
			HttpServletRequest req) throws Exception{
		L("loginMember post");
		HttpSession session = req.getSession();
		String resultPage=null;
		
		MemberUtil memberUtil = new MemberUtil(mvo);
		HashMap hm = memberUtil.loginCheck(service.listMember());
		
		if(hm.get("memberInfo")==null){
			model.addAttribute("resultMsg", hm.get("resultMsg"));
			resultPage = "redirect:/member/loginMember";
		}else{
			session.setAttribute("memberInfo", hm.get("memberInfo"));
			model.addAttribute("resultMsg", hm.get("resultMsg"));
			resultPage = "redirect:/member/readMember?m_num="+mvo.getM_num();
		}
		
		return resultPage;
	}
	
}
