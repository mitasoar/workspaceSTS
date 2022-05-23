<p align="center">
    <img src="https://user-images.githubusercontent.com/49469777/169728992-410bc03c-f6f8-4194-a33c-6bcdab369ba0.PNG" alt="메인화면" width="100%">
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
    - [개발 방법](#개발-방법)
- [기능 목록](#기능-목록)
    - [공통 및 관리자 기능](#공통 및 관리자-기능)
    - [학생 기능](#학생-기능)
    - [교수 기능](#교수-기능)
    - [학사팀 기능](#학사팀-기능)
    - [기타 기능](#기타-기능)

---

## 프로젝트 소개

### 프로젝트 팀원

- 우미타 / 배도훈 / 이강국

### 프로젝트 목표

- 학습의 마침표이자 결과물인 프로젝트이기에 단순히 겉모습만 화려한 프로젝트는 지양하고,
- 학생의 본분을 잊지않는 목표로 새로운 기술과 배운것을 다시 학습하며 기본에 충실하고 내실을 다지는 프로젝트를 지향하였습니다.

### 프로젝트 아이디어

- 어떤 홈페이지를 만들어볼까 하는 고민중에, CRUD 기능을 다양하게 구현할 수 있는 '대학 학사 홈페이지'로 결정하였습니다.

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
- 학교 관련 기능에서는 학생&교수, 교수&학사팀 등 같은 기능을 구현해야 하는 경우가 있기 때문에 구현할 기능을 전체적으로 미리 설계하여
- 기능 구현의 중복을 방지하고, 각자 구현할 기능들을 정하고 나서 개발을 시작 하였습니다.
- 데이터베이스는 물리적 설계와 논리적 설계, 전부 직접 각자 맡은 파트부분을 담당하여 설계하였습니다.
- 그리고 오라클 클라우드를 사용하여 서로의 테이블과 데이터를 공유하여 사용하였습니다.
- 형상 관리는 SVN을 사용하였고, 기능을 구분지어서 개발하였기에 별다른 브랜치 사용없이도 깔끔한 코드 관리가 되었습니다.
- 무료 프로그램인 SpringSTS를 사용하여 개발하였고, 브라우저는 가장 보편적인 크롬을 기준으로 설정했습니다.
- 자바는 1.8버전을 사용했으며, 스프링은 5.0.7 RELEASE버전, 메이븐은 2.9버전으로 진행하였습니다.
- 화면은 타일즈 라이브러리를 사용하여 구현하였고, CSS는 부트스트랩 프레임워크를 대부분 사용하여 구현하였습니다.
- 스프링 서큐리티는 비밀번호를 암호화 시키는 용도로 사용하였습니다.

---

## 기능 목록

- 공통 및 관리자 기능(회원등록 및 로그인 등 회원 기능, 게시글 및 댓글 등 게시판 기능, 실시간 채팅 및 회원간 메신저 기능, 회원 및 게시판 카테고리 관리 등 관리자 기능)
- 학생 기능(내 정보 조회, 휴/복학 신청, 자퇴 신청, 학과변동 신청, 수강 신청, 시간표 확인, 성적 확인)
- 교수 기능(강의 등록, 강의 목록, 강의 시간표, 학적변동 관리, 학과변동 관리)
- 학사팀 기능(학생 조회, 강의 및 성적 조회, 학적변동 관리, 학사경고, 학과변동 조회)
- 기타 기능(간단한 웹 게임, 홈페이지 소개)

### 공통 및 관리자 기능

#### 회원 기능

##### 회원등록 및 수정

- 학사 홈페이지는 회원가입의 개념보다는 회원등록이라는 개념이 적합하다고 생각하여 회원등록으로 진행하였습니다.
- 학생과 교수 등록은 학사팀 그리고 관리자, 그 외 학사팀과 관리자등록은 관리자만 가능하도록 하였습니다.
- 모든 가입절차는 동일하게 설계하였지만, 학생과 교수 등록만 해당 학과를 선택해야만 가입이 되도록 설계하였습니다.
- 가입 절차로는 주어진 형식에 맞게 비밀번호 설정, 이메일과 연락처 인증, 이름, 주소, 성별, 생일, 사진 등록으로 진행됩니다.
- 비밀번호는 영어, 숫자, 특수문자를 각각 하나 이상 포함하여 8자 이상 16자 이하 로 설계되었으며,
- 이메일은 중복체크를 하여 없을 시, 해당 이메일로 인증코드 6자리를 보내 인증하도록 하였습니다.
- 연락처 또한 이메일과 마찬가지로 동일하게 중복체크 및 인증코드를 진행하여 인증됩니다.
- 주소는 카카오 주소API를 사용하여 검색 후 우편번호를 제외한 도로명주소와 상세주소만 저장하도록 하였고,
- 그 외 이름과 성별, 생일은 별다른 제한없이 등록 가능하도록 하였습니다.
- 마지막 사진 등록은 한장만 등록가능하게 하여 파일 업로드 시 썸네일을 나타내서 해당 사진이 맞는지 확인가능하도록 하였습니다.
- 그리고 회원 등록 버튼은 이메일과 연락처가 정상적으로 인증되어야 버튼을 누를수 있도록 설정하였고,
- 이메일과 연락처는 인증 시 인증되었다는 체크표시가 생기게 하여 인증이 되었는지에 대한 의문점을 해결하였습니다.
- 모든 유효성 검사는 HTML태그로 대부분 설정하였고, Form태그에 onSubmit기능을 활용하여 유효성 검사를 진행하였습니다.
- 그 외 자바스크립트로 나머지 필요한 유효성검사와 Ajax를 활용하여 회원등록 기능을 구현하였습니다.
- 회원정보 수정은 회원등록 페이지에서 비밀번호를 제외한 폼태그를 그대로 사용하였고,
- 비밀번호 수정은 현재 비밀번호와 새 비밀번호를 입력받아 확인 후 수정되도록 하였습니다.

##### 회원 로그인 및 아이디, 비밀번호 찾기

- 회원 로그인 기능은 아이디와 비밀번호를 입력받아 진행되고, 로그인 시 체크여부에 따라 아이디 저장 기능도 추가하였습니다.
- 아이디 저장은 쿠키로 30일 동안 저장되도록 하였고, 쿠키에 대한 설명은 아이디 저장 태그에 툴팁으로 표시하였습니다.
- 아이디 찾기와 비밀번호 찾기는 동일한 모달을 사용하며 기능을 구현할 수 있게 진행하였고,
- 이메일과 연락처, 두가지 방법으로 찾을수 있게 만들어서 해당 이메일과 연락처가 있을 시 해당 데이터가 전송이 됩니다.
- 아이디는 해당 이메일과 연락처로 등록된 아이디(회원번호 + 학생 or 직원번호)를 보내게 구현하였고,
- 비밀번호는 임시 비밀번호 8자리를 생성하여 비밀번호를 변경한 뒤 해당 임시 비밀번호를 보내도록 구현하였습니다.




