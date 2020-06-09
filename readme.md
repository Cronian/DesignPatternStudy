# BookStudy
- HeadFirstDesignsPatterns 책 읽고 정리된 내용, 이야기해볼 내용을 공유하는 공간입니다.

## 왜 HeadFirst Design Patterns 책으로 선정했나?
- 이해하기 쉬운 문장과 예시 제공.
- 기술서적 답지않은(?) 친근한 접근성

## 진행방식
- 디자인 패턴마다 읽고 이해한 내용 정리 및 설명
- 실제 Java나 유명 프레임워크에서 사용된 사례 조사
- 내용을 바탕으로 직접 디자인패턴 구현해보기

---
### Design Pattern ?
- 좋은 객체지향 설계를 하기 위한 **5원칙(SOLID)**를 충분히 고려해서 모두 지켜가면서 프로그래밍 하기는 쉽지않음.
- 이런 점을 **가엾고 딱하게** 여긴 고수 4명이 공통된 문제들에 대해 **표준적인 해법**과 **작명법**을 제안한 것이 **디자인 패턴.**
- 배우고 써먹자. 이제 이건 제껍니다.

### SOLID ?
1. SRP( Single Responsibility Principle ) 단일 책임 원칙
   + 객체는 단 하나의 책임만을 가져야 함
   + 응집도는 높게, 결합도는 낮게
2. OCP( Open-Closed Principle ) 개방 폐쇄 원칙
   + 기존 코드를 변경하지 않으면서, 기능을 추가할 수 있도록 설계해야 함.
   + 확장에는 개방적, 수정에는 폐쇠적
3. LSP( Liskov Substitution Principle ) 리스코프 치환 원칙
   + 자식 클래스는 최소한 자신의 부모 클래스에서 가능한 행위는 수행할 수 있어야 함.
   + 자식 클래스가 부모 클래스 역할을 대행할 수 있어야 함.
4. ISP( Interface Segregation Principle ) 인터페이스 분리 원칙
   + 자신이 사용하지 않는 인터페이스는 구현하지 말아야 함.
   + SRP는 **객체 단일책임**, ISP는 **인터페이스 단일 책임**
5. DIP( Dependency Inversion Principle ) 의존 역전 원칙
   + 객체들의 의존관계가 형성될 때, 나름의 원칙을 갖고 정보를 주고받아야 함.
   + 추상성이 낮은 클래스보다 추상성이 높은 클래스와 의존관계를 맺어야 함.
