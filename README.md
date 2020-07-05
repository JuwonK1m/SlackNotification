# SlackNotification
## 설명
- Slack WebHooks 테스트용 프로젝트
## Spring 프로젝트에서 Slack으로 데이터 전송하기
### Spring Framework에서는 HTTP 통신을 할 수 있게 해주는 RestTemplate 클래스를 제공한다.
- org.springframework.web.client.RestTemplate
- postForObject(URI url, Object request, Class<T> responseType) 메소드를 이용해 전송
  - url: Slack url
  - request: Slack으로 전송할 내용(JSON으로 변환되어 전송됨)
    1. channel: 채널 이름
    2. username: 이름
    3. text: 전송 내용
    4. attachments: 첨부 내용 (2개 이상 가능)
  - responseType: response 타입
