import javax.swing.*;

/**
 * 진행 중인 쓰레드 작업이 끝나기 전에 취소하는 경우
 *
 * interrupt() : 쓰레드에게 작업을 멈추라고 요청, 단지 요청일 뿐 쓰레드를 강제적으로 종료시킬 수 없다
 *      interrupted 상태(인스턴스 변수)를 바꾸는 것, false => true로 변환
 *
 * interrupted() : 쓰레드에 대해 interrupt()가 호출되었는지 알려주는 함수
 *      호출된 경우 true, 호출되지 않은 경우 false return 후 false로 변경
 *      sleep(), wait(), join()에 의해 일시정지 상태(WAITING)에 있을 때  멈춰있던 쓰레드를 깨워서 실행가능(RUNNABLE)한 상태로 만드는 것
 *      
 * isInterrupted() : 쓰레드의 interrupted 상태를 반환
 */
public class InterruptThread {
    public static void main(String args[]) throws Exception {
        Thread9_1 th1 = new Thread9_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();
        System.out.println("isInterrupted() : " + th1.isInterrupted());

        // 현재 상태 반환 후 false 로 변경
//        System.out.println("interrupted() : " + th1.interrupted());
    }
}

class Thread9_1 extends Thread {
    public void run() {
        int i = 10;

        while (i != 0 && !isInterrupted()){
            System.out.println(i--);
            for(long x = 0; x<2500000000L; x++);
        }

        // interrupted() 테스트용
//        System.out.println("isInterrupted() : " + isInterrupted());
        System.out.println("카운트가 종료되었습니다.");
    }
}
