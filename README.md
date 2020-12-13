# codesquad 입학 과제입니다.
## Step-3 루빅스 큐브 구현하기
[문제](https://lucas.codesquad.kr/main/course/2021%EB%85%84-%EB%A7%88%EC%8A%A4%ED%84%B0%EC%A6%88-%EC%98%A8%EB%9D%BC%EC%9D%B8%EB%AC%B8%EC%A0%9C/2021-problem-1/3%EB%8B%A8%EA%B3%84--%EB%A3%A8%EB%B9%85%EC%8A%A4-%ED%81%90%EB%B8%8C-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0)
## 구현 설명
1. RubiksCube Class와 내부 클래스인 Plane Class로 구현하였습니다.  

2. 큐브의 상태는 직육면체 전개도로 표현됩니다.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**[윗쪽면]**  
**[왼쪽면]** **[앞쪽면]** **[오른면]** **[뒷쪽면]**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**[아랫면]**  

3. Plane Class는 큐브의 한 면을 의미합니다.  
3-1) ```getRow(int row)```, ```getCol(int col)``` 메소드로 원하는 행, 열을 ```char[]``` 형태로 가져올 수 있습니다.  
3-2) ```setRow(int row, char[] toReplace)```, ```setCol(int col, char[] toReplace)``` 메소드로 원하는 행, 열을 ```toReplace```값으로 변경합니다.

4. RubiksCube는 멤버 변수로 6개의 ```Plane```을 가지며 각각 큐브의 위, 아래, 왼쪽, 오른쪽, 앞, 뒤의 한 면을 의미합니다.  

5. RubiksCube의 F, L, R, U, D, B 등의 커맨드는 멤버 변수인 ```Plane```의 ```get```, ```set```메소드를 조합하여 구현했습니다.

6. 커맨드에서 U', R'과 같은 명령은 해석하기 쉽도록 u, r과 같이 소문자로 변경합니다.  

7. 여러 명령어 중에서 Q를 만나거나 큐브가 완성되면 즉시 종료합니다.  
(예) UBL'QRBL: 차례대로 U, B, L'을 실행 후 Q를 실행하여 종료합니다. 뒤의 RBL은 무시됩니다.  
(예) UBL'RFBD: 차례대로 실행하다가 F에서 큐브가 완성되었다면 축하 메세지와 함께 종료됩니다. 뒤의 BD는 무시됩니다.
