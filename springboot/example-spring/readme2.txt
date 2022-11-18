
1. Lombok 설치
   eclipse.ini or SpringToolSuite4.ini 파일에서 아래 라인 추가 후 이클립스 재기동
   -javaagent:lombok.jar

   
   // Lombok 적용
   kr.co.songjava.mvc.domain.Board
   
   
 2. 서비스 호출
  http://localhost:8080/board 
  http://localhost:8080/board/1
  
  http://localhost:8080/board/save?title=abcd&contents=abcd1234
  
  
 3. swagger 호출 (SwaggerConfiguration)
  http://localhost:8080/swagger-ui.html