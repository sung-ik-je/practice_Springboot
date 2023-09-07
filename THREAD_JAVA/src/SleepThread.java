

/**
 * sleep() : 지정된 시간동안 쓰레드를 멈추게 한다
 *
 * 쓰레드가 일시 정지된 상태로 지정된 시간이 다 되거나 interrupt()가 호출되면
 * InterruptedException이 발생되어 잠에서 깨어나 실행대기 상태가 된다
 *      때문에 try - catch 구문으로 예외 처리해준다
 */

/**
 * th1 진행 ===> sleep 만난 경우 th1 멈추고 th2 진행 ===> th1 깨어나면 th2 멈추고 th1 마저 진행 ==>
 */
public class SleepThread {
    public static void main(String args[]) {
        Thread8_1 th1 = new Thread8_1();
        Thread8_2 th2 = new Thread8_2();

        th1.start();
        th2.start();

        try {
            th1.sleep(2000);
        } catch(InterruptedException e) {}

        System.out.println("<<main 종료>>");
    }
}

class Thread8_1 extends Thread {
    public void run() {
        for (int i = 0; i<300; i++) System.out.println("-");
        System.out.println("<<th1 종료>>");
    }
}

class Thread8_2 extends Thread {
    public void run() {
        for (int i = 0; i<300; i++) System.out.println("|");
        System.out.println("<<th2 종료>>");
    }
}

