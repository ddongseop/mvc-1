package hello.servlet;

import hello.servlet.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

//	컴포넌트 스캔으로 안하고 이렇게 직접 등록할 수도 있음
//	@Bean
//	SpringMemberFormControllerV1 springMemberFormControllerV1(){
//		return new SpringMemberFormControllerV1();
//	}
}