package com.baekhwa.song;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.baekhwa.song.domain.entity.Member;
import com.baekhwa.song.domain.entity.MemberRepository;
import com.baekhwa.song.security.MemberRole;

@SpringBootTest
class BaekhwaApplicationTests {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	PasswordEncoder pe;
	
	//@Test
	void 관리자생성() {
		memberRepository.save(Member.builder()
				.email("admin").pass(pe.encode("1111")).name("관리자").userIp("127.0.0.1")
				.build().addRole(MemberRole.ADMIN).addRole(MemberRole.USER));
	}
	
	//@Test
	void 회원생성() {
		memberRepository.save(Member.builder()
				.email("test01@test.com").pass(pe.encode("1111")).name("테스트01").userIp("127.0.0.1")
				.build().addRole(MemberRole.USER));
	}
	
	
	//insert into member 
	//(created_date, updated_date, email, is_deleted, name, pass, phone, user_ip)
	// values (?, ?, ?, ?, ?, ?, ?, ?)
	//insert into member 
	//(created_date, updated_date, email, is_deleted, name, pass, user_ip) 
	// values (?, ?, ?, ?, ?, ?, ?)
	@Rollback(value =false )
	@Transactional
	//@Test
	void 회원수정테스트() {
		
		System.out.println("-------------------");
		//Member entity2=entity.pass("2222");
		//Member entity3=entity2.name("이름변경");
		//Hibernate: update member set created_date=?, deleted_date=?, email=?, is_deleted=?, name=?, pass=?, updated_date=?, user_ip=? where mno=?
		//update member set name=?, pass=?, updated_date=? where mno=?
		//memberRepository.save(entity);
	}

}
