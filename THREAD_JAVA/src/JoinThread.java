
/**
 * join() : 다른 쓰레드의 작업을 기다린다
 *      자신이 하던 작업을 멈추고 다른 쓰레드가 지정된 시간동안 작업을 수행하도록 할 때 사용
 *      작업 중에 다른 쓰레드의 작업이 먼저 수행되어야 할 필요가 있을 때 사용
 *      
 *      sleep()과 마찬가지로 interrupt()에 의해 대기상태에서 벗어날 수 있으며 try-catch 처럼 유사한 부분이 많다
 *          가장 큰 차이점은 sleep()의 경우 하나의 쓰레드 내에서 작업이 진행된다면 join()은 서로 다른 스레드 간의 작업 차이
 *
 */
public class JoinThread {
    static long startTime = 0;

    public static void main(String args[]) {
        Thread11_1 th1 = new Thread11_1();
        Thread11_2 th2 = new Thread11_2();

        th1.start();
        th2.start();

        startTime = System.currentTimeMillis();

        try {
//            th1.join();     // 현재 실행중인 쓰레드(main tharead)가 th1 쓰레드의 작업이 끝날 때 까지 기다린다
//            th2.join();
            th1.yield();    // main thread가 기다리지 않고 종료, 쓰고 안쓰고 크게 차이 없는 것 같다
            th2.yield();
        } catch(Exception e){}

        System.out.println("소요시간 : " + (System.currentTimeMillis() - JoinThread.startTime));
    }
}

class Thread11_1 extends Thread {
    public void run() {

        for(int i = 0; i<300; i++){
            System.out.print(new String("-"));
        }
    }
}

class Thread11_2 extends Thread {
    public void run() {
        for(int i = 0; i<300; i++){
            System.out.println(new String("|"));
        }
    }
}
