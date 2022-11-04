package com.example.travelapi.app.retrofit;

import com.example.travelapi.app.dto.HelloResponseDto;
import net.minidev.json.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloCallerImplTest {

    @Autowired
    private HelloCallerImpl helloCaller;


    @Test
    public void 헬로넘겨줌() throws Exception {
        String Hello = helloCaller.hello();
    }

    @Test
    public void helloDto넘겨줌() throws Exception {
        String name = "hello";
        int amount = 1000;

        JSONParser jsonParser = new JSONParser();

        HelloResponseDto helloResponseDto = helloCaller.helloDto(name, amount);
    }
}





