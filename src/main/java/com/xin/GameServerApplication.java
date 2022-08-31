package com.xin;

import com.xin.core.GameServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameServerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GameServerApplication.class, args);
        GameServer.main(args);
    }

}
