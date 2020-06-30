# Decorator 패턴
  - 객체의 타입과 호출 가능한 메소드를 그대로 __유지하면서__ 객체에 __새로운 책임__ 을 추가할 때 사용
  - 탈부착 가능한 책임을 정의할 때 사용
  - 상속을 통해 서브클래스를 계속 만드는 방법이 비효율적일 때 사용.
    - 조합되는 서브클래스 수가 많을수록 유용
  ![deco](https://user-images.githubusercontent.com/22286957/86119403-5bf56800-bb0d-11ea-87af-b134f6d18ff9.PNG)
  
 ### 음료와 첨가물 조합의 구현
  ``` JAVA
    // 음료
    abstract class Beverage {
        String description = "제목 없음";

        public String getDescription() { return description; }
        public abstract double cost();

        @Override
        public String toString() {
            return getDescription() + ": $" + cost();
        }
    }

    // 첨가물
    abstract class CondimentDecorator extends Beverage {
        public abstract String getDescription();
    }
 ```
 ### 베이스가 되는 두 음료
 ``` JAVA
  class Espresso extends Beverage {
    public Espresso() { description = "에스프레소"; }

    @Override
    public double cost() { return 1.99; }
}

class HouseBlend extends Beverage {
    public HouseBlend() { description = "하우스 블렌드 커피"; }

    @Override
    public double cost() { return 0.89; }
}
 ```
 ### 모카 첨가물
 ``` JAVA
  class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        description = "모카";
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        // 중요한 부분
        return 0.20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        // 중요한 부분
        return beverage.getDescription() + ", " + description;
    }
}
 ```
 ### 사용 예시
 ``` JAVA
 Beverage beverage = new Espresso();
System.out.println(beverage);

beverage = new Mocha(beverage);
System.out.println(beverage);

Beverage beverage2 = new HouseBlend();
System.out.println(beverage2);

beverage2 = new Mocha(beverage2);
System.out.println(beverage2);
 ```
 ``` JAVA
에스프레소: $1.99
에스프레소, 모카: $2.19
하우스 블렌드 커피: $0.89
하우스 블렌드 커피, 모카: $1.09
 ```
 - [[출처]기계인간 블로그 / 데코레이터 패턴](https://johngrib.github.io/wiki/decorator-pattern/)
# Adapter 패턴
  - 서로 __일치하하지 않는__ 인터페이스를 갖는 클래스들을 함께 동작시킴.
  ![adapter](https://user-images.githubusercontent.com/22286957/86119382-51d36980-bb0d-11ea-9165-6058e99a7604.PNG)
  ### 헤드퍼스트 디자인패턴 내 코드 (칠면조 객체로 오리만들기)
  ### 오리 인터페이스
  ``` JAVA
  interface Duck {
  public void quack();  // 오리는 꽉꽉 소리를 낸다
  public void fly();
}

class MallardDuck implements Duck {
  @Override
  public void quack() {
    System.out.println("Quack");
  }
  @Override
  public void fly() {
    System.out.println("I'm flying");
  }
}
  ```
  ### 칠면조 인터페이스
  ``` JAVA
   interface Turkey {
  public void gobble();   // 칠면조는 골골거리는 소리를 낸다
  public void fly();
}

class WildTurkey implements Turkey {
  @Override
  public void gobble() {
    System.out.println("Gobble gobble");
  }
  @Override
  public void fly() {
    System.out.println("I'm flying a short distance");
  }
}
  ```
  ### 어뎁터 구현
  ``` JAVA
  class TurkeyAdapter implements Duck {
  Turkey turkey;

  public TurkeyAdapter(Turkey turkey) {
    this.turkey = turkey;
  }
  @Override
  public void quack() {
    turkey.gobble();
  }
  @Override
  public void fly() {
    // 칠면조는 멀리 날지 못하므로 다섯 번 날아서 오리처럼 긴 거리를 날게 한다
    for (int i = 0; i < 5; i++) {
      turkey.fly();
    }
  }
}
  ```
  - [[출처]기계인간 블로그 / 어댑터 패턴](https://johngrib.github.io/wiki/adapter-pattern/)
# Facade 패턴
  - 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공.
  ![facade](https://user-images.githubusercontent.com/22286957/86125531-cad7be80-bb17-11ea-8385-1782ff96b9dd.png)
### 홈시어터 예제 클래스
![home](https://user-images.githubusercontent.com/22286957/86125601-e773f680-bb17-11ea-9098-df3ef1dca379.png)
### 홈시어터 Facade
![home2](https://user-images.githubusercontent.com/22286957/86125671-04a8c500-bb18-11ea-9789-50bf788acbbb.png)
``` JAVA
public class HomeTheaterFacade {
           Amplifier amp;
           Tuner tuner;
           Dvdplayer dvd;
           CdPlayer cd;
           Projector projector;
           TheaterLights lights;
           Screen screen;
           PopcornPopper popper;

           public HomeTheaterFacade( Amplifier amp,
                                                Tuner tuner, 
                                                DvdPlayer dvd,
                                                CdPlayer cd,
                                                Projector projector,
                                                Screen screen,
                                                TheaterLights lights,
                                                PopcornPopper popper) {
                    this.amp = amp;
                    this.tunner = tuner;
                    this.dvd = dvd;
                    this.cd = cd;
                    this.projector = projector;
                    this.screen = screen;
                    this.lights = lights;
                    this.popper = popper;
          }



          public void watchMovie (String movie) {

                    System.out.println("Get ready to watch a movie...");
                    popper.on();
                    popper.pop();
                    lights.dim(10);
                    screen.down();
                    projector.on();
                    projector.wideScreenMode();
                    amp.on();
                    amp.setDvd(dvd);
                    amp.setsurroundSound();
                    amp.setVolume(5);
                    dvd.on();
                    dvd.play(movie);

          }



          public void endMovie() {

                    System.out.println("Shutting movie theater down...");
                    popper.off();
                    lights.on();
                    screen.up();
                    projector.off();
                    amp.off();
                    dvd.stop();
                    dvd.eject();
                    dvd.off();

          }



 }
```
- [[출처] Facade 패턴 ](https://jusungpark.tistory.com/23)
# Proxy 패턴
  - 실제 기능을 수행하는 객체 대신 가상의 객체를 사용해 로직의 흐름 제어
    - 가상프록시
    - 보호프록시
    - https://jdm.kr/blog/235
    
  ![proxy](https://user-images.githubusercontent.com/22286957/86119420-63b50c80-bb0d-11ea-9483-10aca33dbd67.gif)
## 위 패턴들의 유사점
  - Adapter 패턴은 interface를 __감싸서__ 호출을 위임.
  - Decorator는 Object를 __감싼__ 동작을 구현.
  - Facade는 하나 이상의 interface를 __감싸고__ 사용하기 쉬운 중앙 집중된 interface를 제공.
  - Proxy는 Subject를 __감싸고__ 호출을 위임.
## 위 패턴들의 차이점
  - 각 패턴들은 __목적__ 이 명확하게 다름.
  - Adapter 패턴의 목적은 interface 전환하여 두개의 컴포넌트가 함께 동작하도록 하는 것.
  - Decorator 패턴은 실행시점에 새로운 기능추가가 목적.
  - Facade 패턴은 간단한 interface를 제공하여 클라이언트가 복잡한 내부를 알 필요 없도록 하는 것.
  - Proxy 패턴은 Object의 접근제어가 주 목적. 클라이언트의 직접적인 접근을 막고, 실제 object처럼 동작.
### 해당 링크를 보고 정리..
  - https://javarevisited.blogspot.com/2015/01/adapter-vs-decorator-vs-facade-vs-proxy-pattern-java.html
