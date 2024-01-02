package com.ncs.test.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ncs.test.member.model.vo.Member;

@Repository
public class MemberDAO {

	public Member memberLogin(SqlSessionTemplate sst, Member vo) {
		return sst.selectOne("MemberMapper.loginMember", vo);
	}

}
