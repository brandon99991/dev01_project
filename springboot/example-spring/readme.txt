####################################################################
# 인프런 springboot교육
# https://www.inflearn.com/course/backend-%EC%86%A1%EC%9E%90%EB%B0%94/lecture/60964?tab=curriculum
# https://github.com/stylehosting/example-spring
####################################################################

# (Back end) Spring Boot 쉽게 동영상 보면서 배우기
	E01 서버개발 프로젝트 생성 + Mybatis + MariaDB 연동 : https://youtu.be/AcbzhJoQ-OY
	E02 lombok설치 + Mybatis 설정 + 간단한 게시판 Api 구현 : https://youtu.be/YYlXmkpjRrU
	E03 Swagger 설치 + 게시판 API 문서화 : https://youtu.be/groXYLpRndI
	E04 공통 Response class, enum 사용하기 : https://youtu.be/kSII5YLTX2o


# Lombok 설치
   eclipse.ini or SpringToolSuite4.ini 파일에서 아래 라인 추가 후 이클립스 재기동
   -javaagent:lombok.jar

# 게시판 테이블 DDL
	CREATE TABLE T_BOARD ( BOARD_SEQ int(11) NOT NULL AUTO_INCREMENT, TITLE varchar(100) NOT NULL, CONTENTS text NOT NULL, REG_DATE datetime NOT NULL, PRIMARY KEY (BOARD_SEQ) ) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='게시판';

# 게시판 테이블 샘플 QUERY
	INSERT INTO T_BOARD (TITLE,CONTENTS,REG_DATE) VALUES ('테스트','테스트 컨텐츠','2020-10-06 23:17:38.0');
	
# Eclipse 단축키
  1) 이름 변경할 시에 해당 이름 선택 후에 ALT+SHIFT+R 하면 전체 이름 변경됨. 	
  2) CTRL+1  변수 정의됨.
     예) repository.get(board.getBoardSeq());  에서 CTRL+1 	
	    Board board2 = repository.get(board.getBoardSeq());
  3) CTRL + SHIFT + O
     자동 import	    
  4) CTRL + Page UP or Page Down
     다음 탭, 이전 탭 	
	
# 서비스 호출
  http://localhost:8080/board 
  http://localhost:8080/board/1
  http://localhost:8080/board/save?title=abcd&contents=abcd1234
  
 # swagger 호출 (SwaggerConfiguration)
  http://localhost:8080/swagger-ui.html
  
    
 # 외장 톰캣으로 구동하기 위한 방법
  1) ExampleSpringApplication 클래스에서 아래의 내용 추가 
     // 외장 톰캣으로 구동하기 위한 import 추가
		import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
		import org.springframework.boot.builder.SpringApplicationBuilder;
     // SpringBootServletInitializer 를 상속받는다.
	    ExampleSpringApplication extends SpringBootServletInitializer
     // configure함수를 override한다
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return builder.sources(ExampleSpringApplication.class);
		}	
		    
  2) pom.xml에서 아래 내용 추가 
        <packaging>war</packaging>	
 		... 
  		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>	
	    
  	