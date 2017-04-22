package zhang.fan.service;

import org.springframework.stereotype.Service;

import common.service.BaseService;
import zhang.fan.entity.Member;

@Service
public class MemberService extends BaseService {
	
	public Member getMemberByName(String name){
		String qlString = "from "+Member.class.getName()+" as m where m.name =?";
		Member member = genericDao.findFirst(qlString, name);
		return member;
	}
}
