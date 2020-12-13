# codesquad 입학 과제입니다.
## Step-1 단어 밀어내기 구현하기
1. 입력: 사용자로부터 단어 하나, 정수 숫자 하나( -100 <= N < 100) , L 또는 R을 입력받는다. L 또는 R은 대소문자 모두 입력 가능하다.
2. 주어진 단어를 L이면 주어진 숫자 갯수만큼 왼쪽으로, R이면 오른쪽으로 밀어낸다.
3. 밀려나간 단어는 반대쪽으로 채워진다.

## 구현 설명
요구 사항을 만족하면서 최대한 간결하게 동작할 수 있도록 구현하였습니다.
1. 주어진 정수 숫자 cnt와 L, R을 이용해서 출력할 문자의 Start Index를 계산합니다.  
(L은 왼쪽으로 밀기 때문에 Index는 cnt만큼 +, R은 오른쪽으로 미는 것이기 때문에 cnt만큼 -  
 String range 밖을 벗어나는 걸 방지하기 위해 ```startIdx = (word.length ± cnt % word.length) % word.length``` 로 계산합니다.)
2. 계산한 Start Index부터 끝까지, 0부터 Start Index 직전까지 출력합니다.
