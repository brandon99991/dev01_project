-------------------------------------------------------
# Project : C:\dev.workspace\STS4\brandon99991.dev01_project.springboot
# Workspace : /home/user01/dev.workspace/vscode/docker/restful-web-service_docker
# Jenkins : 1) restful-web-service  (WSL > Tomcat9) -> war 배포           
            2) restful-web-service_docker (WSL > Docker)  -> jar 배포
-------------------------------------------------------

1. application.properties를 yaml파일로 변경하기
   -> application.properties 파일에서 Refactor로 변경  (application.yml)
   
2. 편집기 자동완성 
   1) 단축키 
      ctrl + space
   2) 자동 입력 (Content Assist)      
      eclipse -> window -> Preferences
      Java -> editor -> content Assist
      Auto Activation
           Auto activation delay : 0
           Auto activation triggers for java : <=$:{.@qwertyuioplkjhgfdsazxcvbnm_QWERTYUIOPLKJHGFDSAZXCVBNM
           Auto activation triggers for javadoc : @#  
   
3. 이클립스 단축키
   자동 줄바꿈 : alt + shift ++ y 
   파일명 검색 : Ctrl + Shift + R
   특정 코드 포함한 파일 검색 : Ctrl + H

4. Lombok이 사용된 클래스에서 이클립스의 outline 을 보면, 구조가 확인됨.

5. Swagger
	http://localhost:9001/v2/api-docs
	http://localhost:9001/swagger-ui.html

6. Actuator
    http://localhost:9001/actuator

7. HAL
	http://localhost:9001
	http://localhost:9001/actuator/metrics
	http://localhost:9001/actuator/metrics/jvm.memory.max

8. SpringSecurity
   http://localhost:9001/login

user / f3b40975-af3c-4c8d-83cb-03185696a949
Using generated security password: f3b40975-af3c-4c8d-83cb-03185696a949

or application.yml에 추가
spring:
  security:
    user:
      name: oing
      password: daddy

98. Jenkins 빌드 실패시
    원격 Tomcat에 Deploy시에는 WAR타입으로 배포해야 함. (pom.xml확인)

99. 테스트 url
	http://localhost:9001/hello-world
	http://localhost:9001/hello-world-bean
	http://localhost:9001/users   
	http://localhost:9001/users/1
	http://localhost:9001/users/2
	http://localhost:9001/users/3