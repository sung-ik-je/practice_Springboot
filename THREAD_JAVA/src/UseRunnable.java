
/**
 * Runnable 인터페이스 이용한 구현
 * run 메서드 내부에 작업 내용으로 채우면 된다
 */
public class UseRunnable implements Runnable{
    public void run() {
        for(int i = 0; i < 5; i++){
            // Thread.currentThread().getName() : 현재 실행 중인 쓰레드의 참조 반환
            System.out.println("Runnable : " + Thread.currentThread().getName());
        }
    }
}
