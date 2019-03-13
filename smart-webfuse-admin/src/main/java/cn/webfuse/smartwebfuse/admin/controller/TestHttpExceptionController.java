package cn.webfuse.smartwebfuse.admin.controller;

import cn.webfuse.framework.exception.BadParameterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestHttpExceptionController {


    @GetMapping("/401")
    public ResponseEntity<Map<String, Object>> test404(@RequestParam("b") String b) {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            throw new BadParameterException(401, "BAD-PARAMETER", "错误的参数");
        }
        return null;
    }
}
