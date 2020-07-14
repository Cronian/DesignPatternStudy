# 추상 팩토리 패턴 [AbstractFactory]
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
  ∧     ∧                            │ +remove():  void       │
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
  - [출처](https://johngrib.github.io/wiki/abstract-factory-pattern/)
  
  # 팩토리 메소드 패턴 (Factory Method)
  ![fm1](https://user-images.githubusercontent.com/22286957/87487306-4426f380-c678-11ea-80eb-40162d5c62d9.gif)
  - 객체를 생성하기 위해 인터페이스를 정의하지만, 어떤 클래스의 인스턴스를 생성할지에 대한 결정은 서브 클래스가 내리도록 함.
  - 객체 생성을 캡슐화하는 패턴
  ``` JAVA
  abstract class Product {
    public abstract void use();
  }
  class IDCard extends Product {
      private String owner;

      public IDCard(String owner) {
          System.out.println(owner + "의 카드를 만듭니다.");
          this.owner = owner;
      }

      @Override
      public void use() {
          System.out.println(owner + "의 카드를 사용합니다.");
      }

      public String getOwner() {
          return owner;
      }
  }
  // createProduc가 팩토리 메소드
  abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product p);
  }
  
  class IDCardFactory extends Factory {
      private List<String> owners = new ArrayList<>();

      @Override
      protected Product createProduct(String owner) {
          return new IDCard(owner);
      }

      @Override
      protected void registerProduct(Product p) {
          owners.add(((IDCard) p).getOwner());
      }

      public List<String> getOwners() {
          return owners;
      }
  }
  ```
  - [출처](https://johngrib.github.io/wiki/factory-method-pattern/)
