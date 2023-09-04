
public class Main {
    public static void main(String[] args) {
        UseThreadClass t1 = new UseThreadClass();       // Thread 상속 Class로 Thread 선언
        Thread t2 = new Thread(new UseRunnable());      // Runnable 확장 Class로 Thread 선언

        /**
         * Thread 실행
         * 실행 대기 상태에 있다가 본인의 차례일 때 실행된다(실행 대기 중인 쓰레드가 없는 경우)
         * 한번 실행 한 쓰레드는 다시 실행될 수 없다(일회성, 한번 더 실행할 경우 새로운 쓰레드 생성 필요)
         *
         * run() 메서드를 직접 실행하는 경우 쓰레드 별로 독립적인 호출 스택이 만들어지지 않는다
         * start()는 쓰레드 별로 독립적인 호출 스택을 만든 후 해당 스택에서 run() 메서드를 호출하는 메서드
         *
         * 평소 Intellij에서 사용하는 것은 main thread이며 해당 thread가 종료되면 프로그램이 종료되는 방식이었음
         *    만약 main thread가 종료되어도 호출 스택에 메서드 남아있는 경우 종료 X = 실행 중인 사용자의 쓰레드가 하나도 없을 때 프로그램 종료
         *
         */

         /**
         * @입력
         * t1.start();
         * t2.start();
         * @출력
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




