import javax.swing.*;

/**
 * IoBlocking class와는 다르게 입 출력 작업 쓰레드가 분리된 상황
 * 자원이 분리되어 있는 상태이기에 함께 실행된다
 * 
 * 입력이 되지 않고 있는 상태에서 출력은 계속해서 반복되고 입력이 들어오면 입력을 출력하고 출력이 다시 반복된다
 *
 * @출력
 * 10
 * 9
 * 8
 * 입력하신 값은 ~
 * 7
 * 이런 식으로 IoBlocking처럼 순차적으로 작업되지 않음
 */
public class IoBlocking_2 {
    public static void main(String[] args) throws Exception {

        ThreadIoBlocking th1 = new ThreadIoBlocking();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}

class ThreadIoBlocking extends Thread{
    public void run() {
        for(int i = 10; i>0; i--){
            System.out.println(i);
            try {
                sleep(1000);
            } catch(Exception e){}
        }
    }
}
