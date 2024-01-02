package com.ncs.test.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.member.model.dao.MemberDAO;
import com.ncs.test.member.model.vo.Member;

@Service
public class MemberService {

	private final MemberDAO dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
    public MemberService(MemberDAO dao, SqlSessionTemplate sst) {
        this.dao = dao;
        this.sst = sst;
    }
	
	public Member memberLogin(Member vo) {
		
		return dao.memberLogin(sst, vo);
	}
	
}
