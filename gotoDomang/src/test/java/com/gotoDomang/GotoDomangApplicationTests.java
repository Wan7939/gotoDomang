package com.gotoDomang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;




@SpringBootTest
class GotoDomangApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	//private UserBO userBO;
	
	@Test
	void contextLoads() {
		logger.debug("### Hello world!!! ###");
	}

	@Test
	void 더하기테스트() {
		logger.debug("$$$ 더하기 테스트 시작!!!");
		
		int a = 10;
		int b = 20;
		assertEquals(30, sum(a, b));
	}
	
	int sum(int x, int y) {
		return x + y;
		
	}
	
	@Transactional
	@Test
	void 디비테스트() {
		//Test test = TestBO.(Null,Null)
		//assertNotNull(user);
	}
	
}
