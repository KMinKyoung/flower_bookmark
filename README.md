# 꽃갈피 READ ME
<img width="1024" height="1024" alt="Image" src="https://github.com/user-attachments/assets/9c32ee42-fba8-477e-a706-f67e7fd07d08" />

시연 영상 또는 URL(고민)

<br/><br/>

## 프로젝트 소개
- 꽃갈피는 쉽게 책을 구매할 수 있는 도서 구매 사이트입니다.
- 책에 대한 리뷰를 작성하고 좋아하는 책을 찜할 수 있습니다.
- 검색을 통해 관련된 책 정보를 얻을 수 있습니다.

꽃갈피 프로젝트는 교보문고 앱에서 영감을 받아 진행한 도서 구매 서비스 프로젝트입니다. <br/> 
단순한 이커머스 기능 구현을 넘어, 나만의 브랜드를 담은 웹/앱 서비스를 설계하고 개발하는데 목표를 두었습니다.

<br/>

## 1. 개발 환경
언어 : JAVA(JDK-17) <br/>
프레임워크 : Spring Boot(백엔드), Next.js(프론트엔드) <br/>
빌드 및 의존성 관리 : Gradle<br/>
데이터베이스 : DATA GRIP(MySql)<br/>
테스트 : Postman<br/>
[요구사항정의서 & 기능 명세서](https://docs.google.com/spreadsheets/d/1tx1Fwn7XINvjStAxNoDd8iMqW4mWuhmSUcMeJy1vZMY/edit?usp=sharing)

<br/>

## 2. 채택한 개발 기술
### React
- 컴포넌트 기반 구조를 적용해 UI를 재사용 가능하게 만들고, 유지보수성을 높였습니다.
- 헤더, 푸터, 버튼과 같이 반복되는 요소를 컴포넌트화하여 개발 효율성을 높일 수 있습니다.

### Next.js
- React 기반 프레임워크이기에 페이지 기반 라우팅을 쉽게 구현할 수 있습니다.
- 개발 서버를 통해 빠르게 기능 테스트하고, 프론트엔드 개발 속도를 높일 수 있었습니다.

### Java 17 & Spring Boot 3.x
- 안정적인 LTS 버전인 Java 17을 사용하여 최신 문법과 안정성을 동시에 확보했습니다.
- Spring Boot 설정으로 빠르게 REST API 서버를 구축할 수 있었습니다.


<br/>

## 3. 프로젝트 구조
```
┣ 📂src
┃ ┣ 📂main
┃ ┃ ┣ 📂java
┃ ┃ ┃ ┗ 📂me
┃ ┃ ┃ ┃ ┗ 📂minkyoung
┃ ┃ ┃ ┃ ┃ ┗ 📂flower_bookmark
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminInitializer.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtAuthenticationFilter.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtTokenProvider.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebConfig.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthController.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookController.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartItemController.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderController.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ReviewController.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderStatus.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Role.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookRequest.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookResponse.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartItemRequestDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartItemResponseDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderItemResponseDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderRequestDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderResponseDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRequestDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewResponseDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SignupRequestDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TokenDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenRequestDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Book.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartItem.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Order.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderItem.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Review.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartItemRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderItemRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RefreshTokenRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthService.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookService.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookServiceImpl.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartItemService.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderService.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewService.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDetailService.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂token
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RefreshToken.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FlowerBookmarkApplication.java
┃ ┃ ┗ 📂resources
┃ ┃ ┃ ┣ 📜application.properties
┃ ┃ ┃ ┗ 📜application.yml
┃ ┗ 📂test
┃ ┃ ┗ 📂java
┃ ┃ ┃ ┗ 📂me
┃ ┃ ┃ ┃ ┗ 📂minkyoung
┃ ┃ ┃ ┃ ┃ ┗ 📂flower_bookmark
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FlowerBookmarkApplicationTests.java
```

<br/>

## 4. 개발기간
### 개발 기간
- 기능 구현 기간 : 2025. 05 ~ 2025.05
- 리팩토링 기간 : 2025. 09 ~ 2025. 


## 5. 페이지별 기능
### 로그인 기능
<img width="1903" height="922" alt="Image" src="https://github.com/user-attachments/assets/90953aa7-d3b6-4607-973e-385da6040236" />

## 6. 트러블 슈팅
## 7. 개선 목표
| 확장 범위                    | Description                             |
|--------------------------|-----------------------------------------|
| 주문 상태 추적                 | 주문 완료 후 상태값(결제 완료 -> 배송중 -> 배송완료) 변환 관리 |
| 주문 취소 / 교환 / 환불 요청       | 마이페이지에서 주문 취소 또는 환불 요청 가능               |
| 쿠폰 / 할인 코드 적용            | 사용자가 입력한 쿠폰에 따라 할인을 계산 및 적용             |
| PG사 연동                   | 실제 결제 API를 연동해 실 결제 구현                  |
| 결제 내역 저장 및 조회            | 사용자 마이페이지에서 결제 기록 확인                    |
| AWS 배포 구성(EC2 + RDS + S3 | 클라우드 기반 인프라 구축 및 자원 관리                  |

<br/>
