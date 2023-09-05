import javax.swing.*;

/**
 * I/O Blocking이란 쓰레드가 입출력(I/O) 처리를 위해 기다리는 것을 의미한다
 * 
 * 하나의 쓰레드로 입력과 출력을 처리하기 때문에 사용자의 입력이 마치기 전까지 출력하지 않는다
 */
public class IoBlocking {
    public static void main(String[] args) throws Exception {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");

        for (int i = 10; i > 0; i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch(Exception e){}
        }
    }
}
