# Decorator 패턴
  - 객체의 타입과 호출 가능한 메소드를 그대로 __유지하면서__ 객체에 __새로운 책임__ 을 추가할 때 사용
  - 탈부착 가능한 책임을 정의할 때 사용
  - 상속을 통해 서브클래스를 계속 만드는 방법이 비효율적일 때 사용.
    - 조합되는 서브클래스 수가 많을수록 유용
  ![deco](https://user-images.githubusercontent.com/22286957/86119403-5bf56800-bb0d-11ea-87af-b134f6d18ff9.PNG)
# Adapter 패턴
  - 서로 __일치하하지 않는__ 인터페이스를 갖는 클래스들을 함께 동작시킴.
  ![adapter](https://user-images.githubusercontent.com/22286957/86119382-51d36980-bb0d-11ea-9165-6058e99a7604.PNG)
# Facade 패턴
  - 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공.
  ![facade](https://user-images.githubusercontent.com/22286957/86119453-729bbf00-bb0d-11ea-8fb2-85fbbe59df11.png)
# Proxy 패턴
  - 실제 기능을 수행하는 객체 대신 가상의 객체를 사용해 로직의 흐름 제어
    - 가상프록시
    - 보호프록시
    
  ![proxy](https://user-images.githubusercontent.com/22286957/86119420-63b50c80-bb0d-11ea-9483-10aca33dbd67.gif)
## 위 패턴들의 유사점
  - Adapter 패턴은 interface를 __감싸서__ 호출을 위임.
  - Decorator는 Object를 __감싼__ 동작을 구현.
  - Facade는 하나 이상의 interface를 __감싸고__ 사용하기 쉬운 중앙 집중된 interface를 제공.
  - Proxy는 Subject를 __감싸고__ 호출을 위임.
## 위 패턴들의 차이점
  - 각 패턴들은 __목적__ 이 명확하게 다름.
  
### 해당 링크를 보고 정리..
  - https://javarevisited.blogspot.com/2015/01/adapter-vs-decorator-vs-facade-vs-proxy-pattern-java.html
