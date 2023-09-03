
/**
 * Thread 클래스 상속 이용한 경우
 * run 메서드 내부에 작업 내용으로 채우면 된다
 */
public class UseThreadClass extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++){
            // getName() : Thread 이름 반환
            System.out.println("Thread : " + getName());
        }
    }
}
