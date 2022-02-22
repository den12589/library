package com.library.library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class LibraryApplicationTests {

	@Test
	void contextLoads() {
		var fss3 = UUID.randomUUID().toString();
		var fss1 = UUID.randomUUID().toString();
		var fss2 = UUID.randomUUID().toString();
		var fss4 = UUID.randomUUID().toString();
	}

}
