package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//그냥 Controller는 반환된 String을 View 이름으로 인식함
@RestController //REST API 만들때 핵심적인 Controller
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); //어떤 클래스의 로그인지 알 수 있게

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

//        log.trace("trace log = " + name); //이런식으로 쓰면, JAVA 특성상 출력이 안되는데도 연산이 일어나게 되므로 낭비
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "ok";
    }
}

