/**
 * yield() : 다른 쓰레드에게 양보
 *      쓰레드 자신에게 주어진 실행시간을 다음 차례의 쓰레드에게 양보
 *      본인 실행 대기 상태로 전환하고 다음 쓰레드 실행
 *      프로그램의 응답성을 높이고 보다 효율적인 실행 가능하게 한다
 *
 * ref : https://cornswrold.tistory.com/186
 */

public class yieldThread {

    public static void main(String args[]) {
        Thread12_1 th1 = new Thread12_1();
        Thread12_2 th2 = new Thread12_2();

        th1.start();
        th2.start();

        try {
            Thread.sleep(1000);
        } catch(Exception e){}

        /**
         * 이론적으로는
         * yield가 작업되지 않은 경우는  th1, th2 thread 순으로
         *      작업된 경우는 th2, th1 thread 순으로 작업이 종료되어야 하는데 현 코드, 컴퓨터 상황에서는 크게 차이 못느끼는 수준이다
         *
         * 만약 yield가 작업된 경우
         */
        th1.work = false;

        try {
            Thread.sleep(1000);
        } catch(Exception e){}

        th1.stop = true;
        th2.stop = true;

        System.out.println("main thread 종료");
    }
}

class Thread12_1 extends Thread {
    static boolean work = true;
    static boolean stop = false;

    public void run() {
        while(!stop){
            if (work){
                System.out.println("th1 실행중======================");
            } else {
                Thread.yield();
            }
        }
        System.out.println("th1 종료");
    }
}

class Thread12_2 extends Thread {
    static boolean stop = false;

    public void run() {
        while(!stop){
            System.out.println("======================th2 실행중");
        }
        System.out.println("th2 종료");
    }
}
