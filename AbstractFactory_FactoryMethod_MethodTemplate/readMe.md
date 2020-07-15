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
  
  # 템플릿 메소드 패턴 (Template Method pattern)
  ![tm1](https://user-images.githubusercontent.com/22286957/87500883-a7c11900-c698-11ea-89cd-873ca79619e8.png)
  - 알고리즘의 구조 자체는 그대로 두고, 각 단계 처리를 서브클래스에서 재정의하여 사용할 수 있도록 함.
  
  ## 구현전 코드
  ``` JAVA
   public class Coffee {
      // 커피 만드는 방법
      void prepareRecipe() {
          boilWater();
          brewCoffeeGrinds();
          pourInCup();
          addSugarAndMilk();
      }
      public void boilWater() {
          System.out.println("물 끓이는 중");
      }
      public void brewCoffeeGrinds() {
          System.out.println("필터를 통해서 커피를 우려내는 중");
      }
      public void pourInCup() {
          System.out.println("컵에 따르는 중");
      }
      public void addSugarAndMilk() {
          System.out.println("설탕과 우유를 추가하는 중");
      }
  }
  public class Tea {
      // 홍차 만드는 방법
      void prepareRecipe() {
          boilWater();
          steepTeaBag();
          pourInCup();
          addLemon();
      }
      public void boilWater() {
          System.out.println("물 끓이는 중");
      }
      public void steepTeaBag() {
          System.out.println("차를 우려내는 중");
      }
      public void pourInCup() {
          System.out.println("컵에 따르는 중");
      }
      public void addLemon() {
          System.out.println("레몬을 추가하는 중");
      }
  }
  ```
  
  ## 구현후
  ``` JAVA
  public abstract class CaffeineBeverage {
      // 알고리즘을 갖고 있는 이 메소드를 '템플릿 메소드'라 부른다
      final void prepareRecipe() {
          boilWater();
          brew();
          pourInCup();
          addCondiments();
      }

      abstract void brew();           // 서브클래스에서 구현
      abstract void addCondiments();  // 서브클래스에서 구현

      void boilWater() {
          System.out.println("물 끓이는 중");
      }
      void pourInCup() {
          System.out.println("컵에 따르는 중");
      }
  }
  public class Coffee extends CaffeineBeverage {
      public void brew() {
          System.out.println("필터로 커피를 우려내는 중");
      }
      public void addCondiments() {
          System.out.println("설탕과 커피를 추가하는 중");
      }
  }
  public class Tea extends CaffeineBeverage {
      public void brew() {
          System.out.println("차를 우려내는 중");
      }
      public void addCondiments() {
          System.out.println("레몬을 추가하는 중");
      }
  }
  ```
  - [출처](https://johngrib.github.io/wiki/template-method-pattern/)
  
  # 템플릿 메소드와 팩토리 메소드의 차이점
    - 템플릿 메소드는 슈퍼 클래스에 기본적인 메소드가 정의되어 있고, 세부적인 메소드는 추상 메소드로 둬 서브클래스에서 구현해 사용함
    - 팩토리 메소드는 서브 클래스에서 구체적인 오브젝트 __생성방법__을 결정하게 하는 것
  
