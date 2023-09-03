
public class Main {
    public static void main(String[] args) {
        UseThreadClass t1 = new UseThreadClass();       // Thread 상속 Class로 Thread 선언
        Thread t2 = new Thread(new UseRunnable());      // Runnable 확장 Class로 Thread 선언

        /**
         * Thread 실행
         * 실행 대기 상태에 있다가 본인의 차례일 때 실행된다(실행 대기 중인 쓰레드가 없는 경우)
         * 한번 실행 한 쓰레드는 다시 실행될 수 없다(일회성, 한번 더 실행할 경우 새로운 쓰레드 생성 필요)
         *
         * 출력 =================================
         * Thread : Thread-0
         * Thread : Thread-0
         * Thread : Thread-0
         * Thread : Thread-0
         * Thread : Thread-0
         * Runnable : Thread-1
         * Runnable : Thread-1
         * Runnable : Thread-1
         * Runnable : Thread-1
         * Runnable : Thread-1
         * ====================================
         */
        t1.start();
        t2.start();
    }
}


