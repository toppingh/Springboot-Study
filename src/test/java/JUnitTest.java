// JUnit : 자바 언어를 위한 단위 테스트 프레임워크 (단위T : 코드가 의도대로 작동하는지 작은 단위로 검증하는 것)
// 1. 테스트 방식을 구분할 수 있는 애너테이션 제공
// 2. @Test 애너테이션으로 메서드 호출할 때마다 새 인스턴스 생성, 독립 테스트 가능
// 3. 예상 결과를 검증하는 어설션 메서드 제공
// 4. 사용방법 단순, 테스트 코드 작성 시간 적음, 자동실행되며 자체 결과를 확인해 즉각적인 피드백 제공

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @DisplayName("1 + 2는 3이다.") // 테스트 이름 명시
    @Test // 테스트 수행
    public void junitTest() { // 테스트를 수행하는 메서드가 되도록 위에 @Test 애너테이션 붙임
        int a = 1;
        int b = 2;
        int sum = 3;

        Assertions.assertEquals(sum, a + b); // a + b와 sum의 값이 같은지 확인
        // 첫 번재 인수 : 기댓값, 두 번째 인수 : 실제 검증 값
    }

//    JUnit은 테스트 케이스가 하나라도 실패하면 전체 테스트를 실패한 것으로 보여줌!
//    @DisplayName("1 + 3는 4이다.")
//    @Test
//    public void junitFailedTest() {
//        int a = 1;
//        int b = 3;
//        int sum = 3;
//
//        Assertions.assertEquals(sum, a + b); // 실패하는 케이스
//    }
}
