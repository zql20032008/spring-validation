package org.syaku.spring.boot;

import org.aliyun.spring.boot.Bootstrap;
import org.aliyun.spring.boot.servlet.ServletConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
		Bootstrap.class,
		ServletConfiguration.class
})
public class BootstrapTest {
	@Test
	public void test() {
	}
}
