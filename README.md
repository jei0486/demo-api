# demo-api

- 도커라이징 with Dockerfile
- docker-compose - mysql
- appliction on kubernets
- Spring Data Jpa

## make secret
kubectl -n db create secret generic mysql \
--from-literal=root.password="<root user 의 비밀번호>" \
--from-literal=user.name="<새로 생성할 user>" \
--from-literal=user.password="<위 user 의 비밀번호>"