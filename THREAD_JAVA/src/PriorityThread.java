
/**
 * Thread 우선순위
 *
 * 운영하는 서비스에 상황에 맞게 쓰레드 작업에 대해 우선순위를 부여해 운영할 수 있다
 *      1~10으로 클수록 우선순위 높음(기본값 5)
 *
 *      우선순위 높을수록 Thread 빠르게 마침(우선 순위 높을수록 더 많은 시간이 할당되기 때문)
 *
 *      하지만 멀티코어의 경우 크게 차이가 없으며 OS마다 다른 방식으로 스케줄링하기 때문에 다른 결과 얻을 수 있다
 *          우선순위를 명확하게 주고 싶다면 특정 OS의 스케쥴링 정책과 JVM 구현을 직접 확인해야된다
 */

public class PriorityThread {
    public static void main(String args[]){
        // main thread에서 생성했기에 main thread 우선순위 상속 받음
        Thread_1 th1 = new Thread_1();
        Thread_2 th2 = new Thread_2();

        // setPriority() : 쓰레드 우선순위 지정한 값으로 변경
        th2.setPriority(7);

        // getPriority() : 쓰레드 우선순위 반환
        System.out.println("Priority of th(-) : " + th1.getPriority());
        System.out.println("Priority of th(|) : " + th2.getPriority());
        th1.start();
        th2.start();
    }
}

class Thread_1 extends Thread {
    public void run(){
        for(int i = 0; i<300; i++){
            System.out.print("-");
            for(int x=0; x<10000000; x++);  // 작업 지연용 for 문
        }
    }
}

class Thread_2 extends Thread {
    public void run(){
        for(int i = 0; i<300; i++){
            System.out.print("|");
            for(int x=0; x<10000000; x++);  // 작업 지연용 for 문
        }
    }
}
