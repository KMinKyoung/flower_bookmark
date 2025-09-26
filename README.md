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

## 4. 개발기간 및 작업 관리 
### 개발 기간
- 전체 개발 기간 : 
- 기능 구현 : 

### 작업 관리
- GutHub ~진행 상황 관리
- Notion을 통해 내용 정리
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
















# 🪻Flower Bookmark(BackEnd)

<img width="1024" height="1024" alt="Image" src="https://github.com/user-attachments/assets/9c32ee42-fba8-477e-a706-f67e7fd07d08" />

도서 구매를 위한 웹 서비스입니다.
회원은 책을 탐색하고 장바구니를 통해 주문할 수 있으며, 관리자 기능 또한 포함되어있습니다.
프론트엔드의 경우 따로 관리되어있습니다.



## 🔨 기술 스택
Language : Java 17
Framework: Spring Boot(Version 3.4.5)
Database : Mysql
Build Tool : Gradle
Security : Spring Security 기반 JWT 및 Refresh Token 방식
ORM : Spring Data JPA
IDE : IntelliJ IDEA
API 테스트 : Postman

## 주요 기능 구현 현황

## ✅ 회원 기능
- 회원가입(유저 아이디,이메일, 비밀번호, 닉네임)
- 로그인(JWT 발급)
- 사용자 권한 분리('ROLE_USER','ROLE_ADMIN')

## ✅ 도서 기능
- 도서 목록 조회/ 검색
- 도서 상세 정보 확인

## ✅ 장바구니 / 주문 기능
- 장바구니 추가/삭제/수정
- 장바구니에 추가된걸 바탕으로 주문 추가/조회/수정

## ✅ 리뷰 및 평점
- 도서별 리뷰 작성 / 조회 / 수정 / 삭제
- 평점 계산

## ✅ 관리자 기능
- 도서 등록/ 수정/ 삭제

## 🔨 구현 예정 기능
- 결제 API 연동
- 주문상세 연동
- jwt 보안적 측면에서 변경
- OAuth 추가
- 이미지 추가할 수 있도록 변경
- db 리팩토링
- 관리자 페이지 분리
- 배포 환경 구축(Docker + AWS)

정리할 내용 : 이미지 추가, 동영상 추가, 내용 재정리

이 프로젝트는 끝내 처음으로 "내가 진짜 만들고 싶은 서비스가 어떤 것인지"를 또렷하게 느끼게 해준 작업이였습니다.
단순히 기능을 구현하는 것이 아니라,
교보문고라는 웹앱 서비스에서 영감을 받아 만든 서비스로 **단순 기능 구현을 넘어서, 나만의 브랜드를 구현한다는 마음으로** 하나하나 설계하고 구현했습니다.
결제나 배포, 이미지 등 부족한 부분이 있었지만 그 과정에서 단순 SI 개발을 넘어, 스스로 기획하고 구현하는 솔루션 개발에 흥미를 느낀 계기였습니다.