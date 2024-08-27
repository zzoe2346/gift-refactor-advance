package gift.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CallController {
    private static final Logger log = LoggerFactory.getLogger(CallController.class);

    @PostMapping("/call")
    public void callCheck(@RequestParam Map<String, String> allParams) {

        String fromNumber = allParams.get("From");
        String toNumber = allParams.get("To");

        // 받은 전화번호와 다른 정보를 로그로 출력하거나, 다른 로직을 추가로 처리할 수 있습니다.
        System.out.println("Incoming call from: " + fromNumber + " to: " + toNumber);
        log.info("Incoming call from: " + fromNumber + " to: " + toNumber);

    }
}
