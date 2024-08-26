// AssertJ : JUnit과 함께 사용해 검증문 가독성을 높여주는 라이브러리
// assertThat(a + b).isEqualTo(sum); : a와 b를 더한 값이 sum과 같아야 한다.
// 값이 같은지 비교 : isEqualTo(), isNotEqualTo()
// 값을 포함하는지 비교 : contains(), doesNotContain()
// 접두(미)사 비교 : startsWith(), endsWith()
// 비어있는 값인지 비교 : isEmpty(), isNotEmpty()
// 양수인지 비교 : isPositive(), isNegative()
// 큰 값 비교 : isGreaterThan(), isLessThan()

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitQuiz {
    @Test
    public void juitTest() {
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길영";

        // 1. 모든 변수가 null이 아닌지 확인
        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        // 2. name1과 name2가 같은지 확인
        assertThat(name1).isEqualTo(name2);

        // 3. name1과 name3이 다른지 확인
        assertThat(name1).isNotEqualTo(name3);
    }

    @Test
    public void juitTest2() {
        int number1 = 15;
        int number2 = 0;
        int number3 = -5;

        // 1. number1이 양수인지 확인
        assertThat(number1).isPositive();

        // 2. number2가 0인지 확인
        assertThat(number2).isZero();

        // 3. number3이 음수인지 확인
        assertThat(number3).isNegative();

        // 4. number1은 number2보다 큰지 확인
        assertThat(number1).isGreaterThan(number2);

        // 5. number3은 number2보다 작은지 확인
        assertThat(number3).isLessThan(number2);
    }
}
