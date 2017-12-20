package org.example.xdiamond.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author maorui.wang
 * @date 2017年12月20日
 * @version 1.0
 */
@Controller
public class ApplicationAction {
	/**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(ApplicationAction.class);
    
	
	@Value("${spring.datasource.jdbc.driver}")
    String jdbcUrl;
	
	@GetMapping("/getJdbcUrl")
	@ResponseBody
	public String getJdbcUrl(){
		logger.info("# Get value, jdbcUrl={}",jdbcUrl);
		return jdbcUrl;
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String helloMrWang(){
		return "Hello mr.wang";
	}
	
}

