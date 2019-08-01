package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private com.example.demo.dao.UserMapper UserMapper;

	public void testQuery() throws Exception {
		List<User> users = UserMapper.findAll();
		System.out.println(users.toString());
	}

	@Test
	public void contextLoads() {
	}

}
