import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    // DB 연결이나 텟트 환경 초기화 시 사용, 전체 테스트 실행 주기에서 한 번만 호출되어야 하므로 static으로 선언해야 함!
    @BeforeAll // 전체 테스트를 시작하기 전 1회 실행하므로 메서드는 static으로 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    // 테스트 메서드에서 사용하는 객체를 초기화하거나 테스트에 필요한 값을 미리 넣을 때 사용, 각 인스턴스에 대해 메서드를 호출하므로 static이 아니어야 함!
    @BeforeEach // 테스트 케이스 시작하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    // DB 연결을 종료하거나 공통적으로 사용하는 자언을 해제할 때 사용, 전체 테스트 실행 주기에서 한 번만 호출되어야 하므로 메서드를 static으로 선언해야 함!
    @AfterAll // 전체 테스트를 마치고 종료하기 전, 1회 실행하므로 메서드는 static으로 선언
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    // 테스트 이후 특정 데이터를 삭제해야 하는 경우 사용, static이 아니어야 함!
    @AfterEach // 테스트 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}
