package io.hbgj.modules.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface WebSocketXdxController {


    /**
     *
     * @param shipId
     * @return
     */
    @GetMapping("/xdx/text")
    Object xdxTest(String shipId) throws InterruptedException;


}


