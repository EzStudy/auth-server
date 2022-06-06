# Auth-Server

- 일단 JWT를 이용한 인증기능 구현
- 인증 서버 확장(대규모 트래픽을 처리할 수 있도록 메모리DB(ex, redis...)를 사용하여 관리하는 방안 고안
- 통합 인증 구현

----
### 코딩 방법
- 돌아가면서 30분씩 코딩(페어프로그래밍)

---
#### 220606 
1. Spring Security 5.7.1에서 더이상 WebSecurityConfigurerAdapater 지원 안함... -> 해결 방안 찾기
2. JWT Filter(Custom Filter) 적용 방법 찾기
3. JWT, Spring Security 동작 원리 이해
