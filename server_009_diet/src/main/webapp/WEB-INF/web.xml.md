# web.xml
* Java EE(Enterprise Edition) 프로젝트에서 Servlet, Controller 등을 관리하는
서버 설정 파일
* @WebServlet() Annotation이 만들어지기 전에는 Servlet, Controller 관련 정보를 
web.xml 파일에 설정했었다
* @WebServlet() Annotation을 사용하기 때문에 굳이 web.xml을 사용하지 않아도
프로젝트를 실행하는데 문제가 없다
* 다만 슬래시(/, root Path)로 접근하는 경로를 catch 하는 Controller가 없을 때는
아무런 문제가 없다
* 지금 프로젝트 HomeController에서 슬래시(/, root Path)를 직접 핸들링 하고 있기
때문에 모든 파일(이미자, css, html 등등)의 요청을 할 수 없게 되어 버렸다
* 이미지, css 파일을 jsp에서 link 하려면 Controller가 직접 핸들링
하지 못하도록 만들어줘야 한다.
* Controller가 직접 핸들링 하지 않고 css 등을 link 하기 위해서
web.xml에 default mapping을 선언해 줘야 한다

## web.xml을 사용한 Controller 설정
<servlet>
	<servlet-name>home</servlet-name>
	<servlet-class>com.callor.diet.HomeController</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>default</servlet-name>
	<url-pattern>*.css</url-pattern>
</servlet-mapping>

<servlet-mapping>
	<servlet-name>default</servlet-name>
	<url-pattern>*.jpg</url-pattern>
</servlet-mapping>

<servlet-mapping>
	<servlet-name>default</servlet-name>
	<url-pattern>*.png</url-pattern>
</servlet-mapping>


* 슬래시(/) 로 req가 오면 com.callor.diet.HomeController가 처리해라




