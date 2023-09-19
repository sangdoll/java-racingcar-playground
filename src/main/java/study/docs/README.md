## 기능 요구사항
[ ] 빈 문자열이나, null 값이 입력되면 0을 리턴함.
[ ] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환
    
    "1,2"는 3을 리턴, "1,2:3"은 6을 리턴함.

[ ] 커스텀 구분자를 지정 가능. 커스텀 구분자는 "//"과 "\n" 사이에 위치하는 문자.

    "//;\n1;2;3"은 ;를 커스텀 구분자로 하여, 6을 리턴함.
    
[ ] 숫자 이외의 값 또는 음수가 존재하는 경우, RuntimeException을 발생시킨다.

## 프로그래밍 요구사항
[ ] 들여쓰기의 depth를 최대 1까지
    
    for문과 if문을 사용하면 depth는 2이다.

[ ] 메서드의 크기가 최대 10라인을 넘지 않도록

    메서드가 한 가지 일만 하도록 최대한 작게 만든다.

[ ] else 예약어를 사용하지 않는다.

## 구현 기능
[ ] splitAndSum 메서드

    text를 받아, null 또는 빈 문자열이면 0을 리턴하고,( isNullOrEmpty 메서드 호출 ) 
    0이 아닌경우 getSum과 textParser 메서드를 적용하여 합을 구한 뒤 리턴합니다.

[ ] textParser 메서드

    조건에 따라, //를 포함하는 문자열이면 커스텀 구분자가 있는 경우이며, 이 경우 상수로 정의한 커스텀 구분자의 인덱스인 2를 활용합니다.
    - \n으로 split한 뒤, 그 배열의 두 번째 요소를 커스텀 구분자로 한번 더 split 합니다.

    커스텀 구분자가 없는 경우, 기본 조건인 ,(쉼표), :(콜론)으로 숫자를 분리합니다.

[ ] getSum 메서드
    
    - textParser를 통해 받은, 숫자들로 이루어진 배열을 받아 우선 int로 매핑합니다.
    - 이후, 스트림의 Peek을 이용하여 검사를 하며, 음수가 있는경우 바로 예외를 발생시키고, 음수가 없으면 그 합을 리턴합니다.
