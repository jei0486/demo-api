# demo-api

- Spring Boot (2.7.6), Gradle (7.5.1), jdk 11
- Spring Data JPA

### appliction on kubernets
- kubernetes 환경의 Spring Boot Application 배포
  - 도커라이징 with Dockerfile (ver 0.1 ~ 0.6)
  - Skaffold (ver1 ~ ver2)
- docker-compose - mysql
- Jenkins
- Skaffold


## make secret
kubectl -n db create secret generic mysql \
--from-literal=root.password="<root user 의 비밀번호>" \
--from-literal=user.name="<새로 생성할 user>" \
--from-literal=user.password="<위 user 의 비밀번호>"