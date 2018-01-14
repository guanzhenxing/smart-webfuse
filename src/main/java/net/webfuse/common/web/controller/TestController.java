package net.webfuse.common.web.controller;

import net.webfuse.common.exception.ForbiddenException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by guanzhenxing on 2018/1/6.
 */
@RestController
public class TestController {


    @GetMapping("/test")
    public Map<String, Object> testException(@RequestParam(value = "id") String id) {
        throw new ForbiddenException("");
    }

}
