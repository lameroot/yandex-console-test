package net.radar.yandexconsole.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/first")
    public @ResponseBody String first(@RequestParam("param1") String param1) {
      log.debug("Test: " + param1);
      return "OK";
    }
}
