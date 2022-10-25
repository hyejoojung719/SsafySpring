package com.ssafy.mvc.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.mvc.ApplicationContextHolder;
import com.ssafy.mvc.model.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	//log 찍는거
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<ApplicationContext> list = ApplicationContextHolder.list;
		for(ApplicationContext ac : list) {
			logger.debug("ApplicationContext 정보 : {}", ac.toString());
			
			String[] beanNames = ac.getBeanDefinitionNames();
			for(int i=0; i<beanNames.length; i++) {
				logger.debug("{}번 빈이름 : {}", i, beanNames[i] );
			}
			
			BookService b =  (BookService) ac.getBean("bookServiceImpl");
			logger.debug(b.toString());
			// rootApplicaionContext와 servletApplication Context 모두 bookServiceImpl 정보를 가져올 수 있다.
			// 만약 bookController로 했다면 rootApplicationContainer에는 해당 정보가 없기 때문에 에러가 뜬당
		}
		
//		logger.debug("안녕하세요. {}", 30);	// debug를 해도 콘솔에 찍히지 않는당... 기본 설정이 info 이상이라서? => 장점 : 개발할때는 debug하고, 실제 배포할 때는 info로 높이면 된다.
		
		return "home";
	}
	
}
