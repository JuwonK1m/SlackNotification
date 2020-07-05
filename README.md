# SlackNotification
## 설명
- Slack WebHooks 테스트용 프로젝트
## Spring 프로젝트에서 Slack으로 데이터 전송하기
### Spring Framework에서는 HTTP 통신을 할 수 있게 해주는 RestTemplate 클래스를 제공한다.
- org.springframework.web.client.RestTemplate
- postForObject(URI url, Object request, Class<T> responseType)
  - url
