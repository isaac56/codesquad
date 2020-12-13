# codesquad 입학 과제입니다.
## Step-2 평면 큐브 구현하기
[문제](https://lucas.codesquad.kr/main/course/2021%EB%85%84-%EB%A7%88%EC%8A%A4%ED%84%B0%EC%A6%88-%EC%98%A8%EB%9D%BC%EC%9D%B8%EB%AC%B8%EC%A0%9C/2021-problem-1/2%EB%8B%A8%EA%B3%84--%ED%8F%89%EB%A9%B4-%ED%81%90%EB%B9%85-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0)
## 구현 설명
1. Cube Class를 만들어 구현하였습니다.  

2. ```ShiftLeft(int row, int num)```, ```ShiftUp(int col, int num)``` 메소드로 원하는 row 또는 column을 원하는 값 만큼 이동합니다.  
(Right는 ShiftLeft에서 num값을 -로, Down은 ShiftUp에서 num값을 -로)  

3. 커맨드에서 U', R'과 같은 명령은 해석하기 쉽도록 u, r과 같이 소문자로 변경합니다.  

4. U,R 등의 명령은 ```ShiftLeft``` ```ShiftRight``` 메소드를 조합하여 구현합니다.  

5. 여러 명령어 중에서 Q를 만나면 즉시 종료합니다.  
(예) UBL'QRBL: 차례대로 U, B, L'을 실행 후 Q를 실행하여 종료합니다. 뒤의 RBL은 무시됩니다.
