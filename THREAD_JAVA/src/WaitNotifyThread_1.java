
/**
 * synchronization을 통해 다른 스레드로부터 자원을 보호하는 것은 좋지만 너무 오래 시간동안 특정 자원을 선점하지 않게 하는 것도 중요
 *      이를 보완하고자 wait(), notify() 작업 고안
 *      wait() : 현재 작업을 더 이상 진행할 상황이 아닌 경우에 호출해 스레드의 락을 반납하고 기다림
 *              객체의 대기실(waiting pool)에서 통지 기다림
 *                  waiting pool은 객체마다 존재하는 공간
 *              만약 매개변수가 있는 경우 해당 시간만큼만 lock을 반납 => 지정된 시간 이후 자동으로 notify() 호출하는 꼴
 *      notify() : 차후에 작업을 진행해야되는 경우 호출해 중단했던 스레드가 락을 다시 얻어 작업 진행
 *              객체의 대기실에서 임의의 쓰레드만 통지 받는다, 락을 얻을 수 있는건 단 하나의 스레드이기에
 *      notifyAll() : 기다리고 있는 모든 스레드의 통보, 통보는 다 하되 마찬가지로 락을 얻을 수 있는건 단 하나의 스레드
 *                  락 못 얻으면 계속 기다림
 */
public class WaitNotifyThread_1 {
    public static void main(String[] args) throws Exception{
        Table table = new Table();

        new Thread(new Cook(table), "COOK").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(5000);
        System.exit(0);
    }
}

class Customer implements Runnable {
    private Table table;
    private String food;
}
