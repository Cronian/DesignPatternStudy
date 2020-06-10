# 전략 패턴 ( Strategy Pattern )

- 객체의 행위 각각에 전략 클래스를 생성하고, 유사한 행위는 캡슐화 하는 인터페이스 정의
- 객체의 행위를 동적으로 바꾸고 싶은 경우 직접 행위를 수정하지 않고 **( 개방 폐쇠 원칙 )**, 전략을 바꿔 유연하게 확장하는 방법

## Java에서 이 패턴을 어디서 쓰고 있을까?
  + [[java.util.Comparator#compare()](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#compare-T-T-)]
  + [[javax.servlet.http.HttpServlet](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServlet.html)]
  + [[javax.servlet.Filter#doFilter()](https://docs.oracle.com/javaee/7/api/javax/servlet/Filter.html#doFilter-javax.servlet.ServletRequest-javax.servlet.ServletResponse-javax.servlet.FilterChain-)]
