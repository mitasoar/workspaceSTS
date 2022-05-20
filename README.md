<p align="center">
    <img src="#" alt="#" width="250px">
</p>

# 팀 프로젝트

---

> 총 840시간, 6개월 수업에 대한 마침표이자 결과물인 팀 프로젝트입니다.

---

# 목차

- [프로젝트 소개](#프로젝트-소개)
    - [프로젝트 팀원](#프로젝트-팀원)
    - [프로젝트 목표](#프로젝트-목표)
    - [프로젝트 아이디어](#프로젝트-아이디어)
    - [프로젝트 개발환경](#프로젝트-개발환경)
- [기능 구현](#기능-구현)
    - [개발 진행방향](#개발-방법)
    - [테이블 설계](#테이블-설계)
- [기능 목록](#기능-목록)
    - [기능 예시](#기능-예시)

---

## 프로젝트 소개

### 프로젝트 팀원

- 우미타 / 배도훈 / 이강국

### 프로젝트 목표

- 학습의 마침표이자 결과물인 프로젝트이기에 단순히 겉모습만 화려한 프로젝트는 지양하고,
- 학생으로서의 본분을 잊지않는 목표로 새로운 기술과 배운것을 다시 학습하며 기본에 충실하고 내실을 다지는 프로젝트를 지향하였습니다.

### 프로젝트 아이디어

- 어떤 홈페이지를 만들어볼까 하는 고민중에, 기본적인 기능을 다양하게 구현할 수 있는 '대학교 학사 홈페이지'로 결정하였습니다.

### 프로젝트 개발환경

- Programming Language : ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
- Web Framework : ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) / Spring Security
- Web Language : ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
- CSS Framework : ![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
- Bulid tool : ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
- DataBase : ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
- DataBase Cloud : Oracle Cloud
- SQL Mapper : MyBatis
- Web Library : ![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white) ![Socket.io](https://img.shields.io/badge/Socket.io-black?style=for-the-badge&logo=socket.io&badgeColor=010101) / Ajax / Tiles / Log4j / JSON / Nurigo
- Version Control : SVN
- Browser : ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white)
- OS : ![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
- IDE : SpringSTS

---

## 기능 구현

### 개발 방법

- 학사 홈페이지를 이용하는 회원 유형을 생각하여 '비회원' / '학생' / '교수' / '학사팀' / '관리자' 총 5가지의 회원 유형을 분리하고,
- 공통 및 관리자 기능(비회원 / 관리자), 학교 관련 기능(학생 / 교수 / 학사팀) 으로 기능을 나눠서 역할을 분배했습니다.
- 학교 관련 기능에서는 학생&교수, 교수&학사팀 등 같은 기능을 구현해야 하는 경우가 있기 때문에 

---

## 기능 목록

- 공통 및 관리자 기능(회원등록 및 로그인 등 회원 기능, 게시글 및 댓글 등 게시판 기능, 회원 및 메뉴 관리 등 관리자 기능)
- 학생 기능(내 정보 조회, 휴/복학 신청, 자퇴 신청, 학과변동 신청, 수강 신청, 시간표 확인, 성적 확인)
- 교수 기능(강의 등록, 강의 목록, 강의 시간표, 학적변동 관리, 학과변동 관리)
- 학사팀 기능(학생 조회, 강의 및 성적 조회, 학적변동 관리, 학사경고, 학과변동 조회)
- 기타 기능(간단한 웹 게임 및 실시간 채팅 기능, 회원간 메신저 기능, 홈페이지 소개)

### 문제 출제

- 1부터 9까지 서로 다른 임의의 수로 이루어진 3자리의 수가 생성된다
