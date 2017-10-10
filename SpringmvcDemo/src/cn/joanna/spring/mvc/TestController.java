package cn.joanna.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 访问地址：http://localhost:8080/SpringmvcDemo/index.jsp
@Controller
public class TestController {
	
	/**
	 * 1. 使用 @RequestMapping 注解来映射请求的URL（相当于web.xml中的servlet-mapping元素的url-pattern）
	 * 2. 返回值会通过视图解析器解析为实际的物理视图，具体看第三步中的InternalResourceViewResolver配置信息
	 */
	@RequestMapping("/helloworld")
	public String success() {
		return "success";
	}

}
