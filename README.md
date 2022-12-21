# TeamProject-T-5

이클립스 스프링 원드라이브에서 파일 받아서 셋팅

로컬 리포지토리(작업공간(이름 : ProjectWs)) 깃 풀 또는 체크아웃으로 가져와서 작업

깃 다운로드 https://git-scm.com/downloads

깃허브 사용방법 ** 붙여넣기 : shift + insert 0.git config --list -- 해당 커맨드를 입력했을때 user.name, user.email이 있는지 확인 없으면 0-1 재입력

0-1.git config --global user.name "아무이름"

0-2.git config --global user.email "깃허브에 회원가입한 이메일 입력"

1.git init -- 작업할 폴더(로컬 리포지토리)에 깃 폴더 생성

2.git remote add TeamProject-T-5 https://github.com/TeamProject-T-5/TeamProject-T-5.git 원격리포지토리 이름 + 원격리포지토리의 링크

3.git remote update -- 원격 리포지토리 불러오기

4.git remote -v -- 원격 리포지토리가 잘 들어와있나 확인

4-1.git pull -- 최종 커밋한 파일을 해당브런치에서 불러오기 (5번과 동일)

5.git checkout dev12 -- 해당 브랜치의 파일들을 로컬리포지토리에 불러오기

6.git commit -m "작업한 내용 입력" -- 푸시 하기전 작업한 내용 입력

7.git push -- 해당 checkout dev한 원격 리포지토리에 푸시

작업 규칙 https://www.notion.so/2764d7eda3b94627ae38c862cb759e0a

코드 컨벤션
네이밍 규칙

클래스 : PascalCase
멤버 : camelCase
상수 : SNAKE_CASE (대문자)
파일명 : 해당 소스 파일의 최상위 클래스명.java
약어 사용 금지
클래스 작성 순서

Class variable~~
Class method
Instance method
Constructor
Etc
공백

공백 문자는 space만 허용 / tab 불가
들여쓰기 공백 4칸
Tab키 사용할 경우 1 tab = 4 space로 editor 설정 통일
etc

문법(if, for 등) 에서 단일 문장이라도 중괄호 생략 금지 ( { } 무조건 작성 )
연산자 & 피연산자 간 공백 1칸
--java Ex) (int I = 0; i < 5; i++){

}
메소드 오버라이딩 시 반드시 @Override 어노테이션 표기
