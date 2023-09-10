
/**
 * 싱글 스레드의 경우 동시 작업이 이루어지지 않기 때문에 자원을 공유하지 않는다
 *
 * 멀티 스레드의 경우 여러 쓰레드가 같은 프로세스 내의 자원을 공유해서 작업하기 때문에 서로의 작업에 대한 영향을 주게 된다.
 * 쓰레드 A가 작업을 하던 중 제어권이 쓰레드 B로 넘어가고 쓰레드 B가 A가 사용하던 자원을 사용할 때 A의 결과물에 영향을 줄 수 있다.
 *
 * 때문에 이러한 일이 생기는 것을 방지하고자 한 스레드가 특정 작업을 끝마치기 전까지 다른 스레드에 의해 방해받지 않도록 하는 작업이 필요하고
 * 이를 위해 도입된 개념이 임계 영역(Critical Section)과 잠금(Lock)이다.
 *
 * 공유 데이터를 사용하는 코드 영역을 임계 영역으로 지정해놓고
 * 공유 데이터가 가지고 있는 lock을 획득한 단 하나의 스레드만 이 영역 내의 코드를 수행하게끔 하는 개념
 *      lock을 반납해야만 다른 스레드가 lock을 얻을 수 있고 작업할 수 있다
 * ==> 이처럼 한 스레드가 진행 중인 작업을 다른 쓰레드가 간섭하지 못하도록 하는 것을 스레드의 동기화(synchronization)라고 한다.
 */
public class SynchronizationThread {
    public static void main(String args[]){
        Runnable r = new RunnableEx();
        new Thread(r).start();
        new Thread(r).start();
    }
}
class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    /**
     * method 기본 형태에서는 if() 조건문을 확인하는 경우에는 조건이 만족하되 다른 스레드가 먼저 자원을 소모하고 그 다음 현재 스레드가 자원을 소모해
     *      음수값으로 갈 수 있다    =>  코드가 모순적으로 바뀜
     *
     * method return 형태 앞에 synchronized 선언할 경우
     *      메서드 전체를 임계 영역으로 지정한 것이기에 하나의 쓰레드가 해당 작업을 마칠 때 까지 다른 스레드는 작업에 진행할 수 없다
     */
//    public void withdraw(int money){
    public synchronized void withdraw(int money){
        if(balance >= money){
            try { Thread.sleep(1000); } catch(InterruptedException e){}
            balance -= money;
        }
    }
}

class RunnableEx implements Runnable {
    Account acc = new Account();

    public void run() {
        while(acc.getBalance() > 0){
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    }
}
