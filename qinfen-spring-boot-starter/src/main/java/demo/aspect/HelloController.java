package demo.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        log.info("============index 开始打印日志==========");
        log.info("URL: " + request.getRequestURL().toString());
        log.info("============index 结束打印日志==========");
        return "hello index";
    }

    @GetMapping("/test1")
    public String test1(HttpServletRequest request) {
        log.info("============test1 开始打印日志==========");
        log.info("URL: " + request.getRequestURL().toString());
        log.info("============test1 结束打印日志==========");
        return "hello test1";
    }

    @GetMapping("/test2")
    public String test2(HttpServletRequest request) {
        log.info("============test2 开始打印日志==========");
        log.info("URL: " + request.getRequestURL().toString());
        log.info("============test2 结束打印日志==========");
        if (true) {
            throw new IllegalArgumentException("test2");
        }
        return "hello test2";
    }
}
