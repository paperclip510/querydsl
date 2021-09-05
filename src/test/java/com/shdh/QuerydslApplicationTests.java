package com.shdh;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shdh.entity.Hello;
import com.shdh.entity.QHello;

@SpringBootTest
@Transactional
class QuerydslApplicationTests {

	@Autowired //스프링 최신버전 
	//@PersistenceContext //자바 표준 (스프링 외 다른 프레임워크로 변경할 경우 사용)
	EntityManager em;
	
	@Test
	void contextLoads() {
		Hello hello = new Hello();
		em.persist(hello);
		
		JPAQueryFactory query = new JPAQueryFactory(em);
		//QHello qHello = new QHello("h");
		QHello qHello = QHello.hello;
		
		
		//querydsl에서는 qType을 넣는다.
		Hello result = query
				.selectFrom(qHello)
				.fetchOne();
		
		Assertions.assertThat(result).isEqualTo(hello);
		Assertions.assertThat(result.getId());
		
	}
	
	

}
