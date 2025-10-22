# 꽃갈피 READ ME
<img width="1024" height="1024" alt="Image" src="https://github.com/user-attachments/assets/9c32ee42-fba8-477e-a706-f67e7fd07d08" />


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

- 아이디, 비밀번호를 이용한 JWT 기반 로그인

### 회원가입 기능
<img width="1880" height="934" alt="Image" src="https://github.com/user-attachments/assets/5f805b98-918e-4cc5-b828-ad9db46e5364" />

- 아이디, 비밀번호, 이름, 이메일을 함께 등록하여 JWT 기반 회원가입

### 도서 전체 조회
<img width="1892" height="948" alt="Image" src="https://github.com/user-attachments/assets/70eedf55-eaff-4373-b5b2-bba688d1a243" />

- 판매 중인 책에 대한 전체 조회
- 로그인한 회원에 한하여 장바구니 및 주문 내역 기능 제공

### 도서 상세 조회
<img width="1850" height="955" alt="Image" src="https://github.com/user-attachments/assets/2160f0a1-b46d-4042-897e-2d1785c01b54" />

- 도서 상세 확인으로 책에 대한 리뷰 확인 가능
- 로그인한 사용자만 댓글 작성 가능

### 장바구니 기능
<img width="1883" height="943" alt="Image" src="https://github.com/user-attachments/assets/b9357d9b-b4bf-4ea3-9c71-94a351a20e7e" />

- 구매하고자 하는 도서에 대해 장바구니에 추가 시 누적이 되어 결제 금액 및 적용 할인을 예상하여 금액 추출

### 관리자 기능
<img width="1883" height="948" alt="Image" src="https://github.com/user-attachments/assets/41cd8494-68a9-4ae9-a900-dcd8db7d218e" />

- 도서 추가, 수정, 삭제 기능 제공하여 관리자가 손쉽게 도서를 관리할 수 있는 기능

## 6. 트러블 슈팅
### 6-1. 도서 페이징 처리
- 문제 : 기존 프론트엔드에서 전체 도서에 대한 filter 처리를 통해 메모리 및 CPU 부하가 발생하며 초기 로딩 시간 지연 발생
- 해결 방법 : 백엔드에서 **Pageable**을 통해서 
<br/> **키워드가 null 또는 공백일 때**, 전체 도서 조회로 분기
<br/> **null이 아닐 때**, 제목이나 저자를 기준(대소문자 무시)으로 분기
- 개선 효과 : 기존에는 프론트엔트의 filter 연산에서 백엔드의 Pageable을 통한 DB 인덱스를 활용해 필요한 페이지만 조회 전송 가능하여 **초기 로딩 시간 지연이 3.4초에서 2.7초로 감소하였다.**

### 6-2. 장바구니 수량 누적 로직
- 문제 : 장바구니 생성 시 기존 수량이 누락되며 새롭게 객체를 생성하는 문제
- 해결 방법 : 기존 항목의 **존재 여부 확인 후 없을 경우** 장바구니 객체를 새롭게 생성,
<br/> **기존 항목이 존재할 경우** 기존 엔터티의 수량에 요청 수량을 더하는 업데이트 방식으로 로직 수정
- 개선 효과 : 기존에 중복 도서에 대한 장바구니 항목이 생성되는 것을 방지하며 도서에 대한 정확한 수량을 반영하여 누적 버그를 해소해 사용자 불편 감소 및 DB에 불필요한 레코드 저장 방지

<br/> 

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
