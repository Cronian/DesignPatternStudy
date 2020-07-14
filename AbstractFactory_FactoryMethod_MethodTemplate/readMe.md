# 추상 팩토리 [AbstractFactory]
![af1](https://user-images.githubusercontent.com/22286957/87485877-c44b5a00-c674-11ea-84c0-b95e1071483f.gif)
  - 상세화된 서브클래스를 정의하지 않고도 관련성이 있거나 독립적인 여러 객체의 군을 생성하기 위한 인터페이스
  - 실제 객체가 정확히 무엇인지 알지 못해도 객체를 생성하고 조작할 수 있도록 해준다.
  ``` JAVA
   // AbstractFactory
  interface Factory {
    Wall makeWall();
    Room makeRoom();
    Door makeDoor();
  }

  // AbstractProduct
  interface Game {
    void createMap(Factory factory);
    void show();
  }

  public class Main {
    public static void main(String[] args) {
      // 두 개의 ConcreteFactory
      Factory bombFactory = new BombedMazeFactory();
      Factory monsterFactory = new MonsterFactory();

      // 폭탄 테마의 미로 게임 맵을 만든다
      Game bomberMan = new MazeGame();
      bomberMan.createMap(bombFactory);

      // 괴물 테마의 미로 게임 맵을 만든다
      Game diablo = new MazeGame();
      diablo.createMap(monsterFactory);

      // 괴물 테마의 슈팅 게임 맵을 만든다
      Game doom = new ShootingGame();
      doom.createMap(monsterFactory);
    }
  }
  ```
  - 예제 [ Collection의 iterator ]
  ```
  ┌──────────────────────────┐         ┌────────────────────────┐
│ Collection <<interface>> │         │ Iterator <<interface>> │
╞══════════════════════════╡         ╞════════════════════════╡
│ +iterator(): Iterator    │         │ +hasNext(): boolean    │
└──────────────────────────┘         │ +next():    Object     │
 ∧     ∧                             │ +remove():  void       │
 │     │                             └────────────────────────┘
 │  ┌──┴────────────────────┐          ∧                     ∧
 │  │ LinkedList            │          │                     │
 │  ╞═══════════════════════╡creates ┌─┴──────────────────┐  │
 │  │ +iterator(): Iterator -------->│ LinkedListIterator │  │
 │  └───────────────────────┘        ╞════════════════════╡  │
 │                                   │ +hasNext(): boolean│  │
 │                                   │ +next():    Object │  │
 │                                   │ +remove():  void   │  │
 │                                   └────────────────────┘  │
 │  ┌───────────────────────┐                                │
 └──│ Tree                  │                                │
    ╞═══════════════════════╡creates ┌───────────────────────┴───┐
    │ +iterator(): Iterator -------->│ TreeIterator <<anonymous>>│
    └───────────────────────┘        ╞═══════════════════════════╡
                                     │ +hasNext(): boolean       │
                                     │ +next():    Object        │
                                     │ +remove():  void          │
                                     └───────────────────────────┘
  ```
