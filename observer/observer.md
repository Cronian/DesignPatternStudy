# 옵저버 패턴 ( Observer Pattern )
  - 이벤트 발생시 객체와 관련된 객체들에게 알림해주는 패턴 
  - 객체 상태 변경시 특정 객체에 의존하지 않으면서 변경된 정보를 얻을 수 있는 패턴
  - Subject에 Observer를 직접 등록해야 하고(in jvm), Subject에서 Observer에 변경사항을 직접 알려줘야 함.(결합도 증가)
  - 때문에 결합도를 낮추고, 별도 작업없이(프록시 패턴 적용) 원격으로 사용 가능하도록 하려면?
  ![obser](https://user-images.githubusercontent.com/22286957/84873658-8a5f5600-b0be-11ea-80d9-1f8d15b1469d.jpg)
# 출판/구독 패턴 ( Pub / Sub Pattern)
  - 이벤트 발생시 구독하고 있는 객체들에게 알림을 제공
  - 옵저버 패턴은 Subject와 Observer의 결합도가 높지만, Pub와 Sub는 Broker를 통해 연락하기때문에 결합도가 낮아짐.
  - 중간에 Broker가 있기 때문에 다른 도메인(또는 다른 자바머신)에서도 별도의 구현없이 동작가능.
  - Observer와 다르게 비동기적으로 처리 가능.
  ![obs_sub](https://user-images.githubusercontent.com/22286957/84873684-93e8be00-b0be-11ea-8488-cdc6f5999789.png)
---
## 어디서 사용하고 있을까?
  - 안드로이드 푸시
  - 카프카 ( 내용보충 예정 )
