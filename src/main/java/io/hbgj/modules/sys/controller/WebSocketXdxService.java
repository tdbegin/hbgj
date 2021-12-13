package io.hbgj.modules.sys.controller;

import io.hbgj.config.WebSocket;
import io.hbgj.modules.sys.controller.WebSocketXdxController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketXdxService implements WebSocketXdxController {


    @Autowired
    private WebSocket webSocket;

    @Override
    public Object xdxTest(String shipId) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            Thread.sleep(1000);
            webSocket.sendTextMessage(shipId, ""+i);
        }

        return null;
    }
}
