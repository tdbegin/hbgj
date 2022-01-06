package io.hbgj;

import io.hbgj.modules.app.utils.JwtUtils;
import io.hbgj.modules.sys.oauth2.OAuth2Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    @Autowired
    private JwtUtils jwtUtils;

    private OAuth2Token token2;
    @Test
    public void test(HttpServletRequest request) {

    }

}
