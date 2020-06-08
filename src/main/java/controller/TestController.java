package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import slack.*;

import java.nio.charset.Charset;

@Controller
public class TestController {
    @Value("")
    private String url;
    private RestTemplate restTemplate;

    public TestController() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        SlackParameter slackParameter = new SlackParameter();
        slackParameter.setText("백엔드 멤버들입니다.");
        slackParameter.setChannel("#slacktest");

        SlackAttachment[] slackAttachments = new SlackAttachment[4];
        slackAttachments[0] = new SlackAttachment();
        slackAttachments[0].setAuthorName("김주원");
        slackAttachments[0].setTitle("저는 김주원입니다.");
        slackAttachments[0].setColor("#36a64f");
        slackAttachments[1] = new SlackAttachment();
        slackAttachments[1].setAuthorName("김통일");
        slackAttachments[1].setTitle("저는 김통일입니다.");
        slackAttachments[1].setColor("#3697a6");
        slackAttachments[2] = new SlackAttachment();
        slackAttachments[2].setAuthorName("정기솔");
        slackAttachments[2].setTitle("저는 정기솔입니다.");
        slackAttachments[2].setColor("#9d36a6");
        slackAttachments[3] = new SlackAttachment();
        slackAttachments[3].setAuthorName("최준호");
        slackAttachments[3].setTitle("저는 최준호입니다.");
        slackAttachments[3].setColor("#a69536");

        slackParameter.getSlackAttachments().add(slackAttachments[0]);
        slackParameter.getSlackAttachments().add(slackAttachments[1]);
        slackParameter.getSlackAttachments().add(slackAttachments[2]);
        slackParameter.getSlackAttachments().add(slackAttachments[3]);

        restTemplate.postForObject(url, slackParameter, String.class);

        return "test";
    }
}
