import java.util.ArrayList;
import java.util.Arrays;

/**
 * synchronization을 통해 다른 스레드로부터 자원을 보호하는 것은 좋지만 너무 오래 시간동안 특정 자원을 선점하지 않게 하는 것도 중요
 *      이를 보완하고자 wait(), notify() 작업 고안
 *
 *      wait() : 현재 작업을 더 이상 진행할 상황이 아닌 경우에 호출해 스레드의 락을 반납하고 기다림
 *              객체의 대기실(waiting pool)에서 통지 기다림
 *                  waiting pool은 객체마다 존재하는 공간
 *              만약 매개변수가 있는 경우 해당 시간만큼만 lock을 반납 => 지정된 시간 이후 자동으로 notify() 호출하는 꼴
 *
 *      notify() : 차후에 작업을 진행해야되는 경우 호출해 중단했던 스레드가 락을 다시 얻어 작업 진행
 *              객체의 대기실에서 임의의 쓰레드만 통지 받는다, 락을 얻을 수 있는건 단 하나의 스레드이기에
 *
 *      notifyAll() : 기다리고 있는 모든 스레드의 통보, 통보는 다 하되 마찬가지로 락을 얻을 수 있는건 단 하나의 스레드
 *                  락 못 얻으면 계속 기다림
 */

/**
 * 프로그램 실행 과정
 *      1. 처음 Cook 객체 생성, dishNames에서 랜덤하게 dishes에 추가하고 sleep
 *          이 때 dishes가 최대 갯수 미만인 경우 계속해서 추가하는 로직이 존재
 *      
 *      2. Customer 객체 2개 생성, dishes 내에 각 donut, burger 먹는 작업
 *      
 *      해당 작업에서 요점은 (1번 작업 => 1번 작업 sleep => 2번 작업) 중에 1번 음식 추가하는 로직의 작동 X
 *          => 쓰레드의 lock이 2번 작업에 있기에 2번 작업만이 반복
 *
 *      데이터 추가, 삭제 등 수정하는 부분에 synchronized 이용해 작업을 통해 데이터의 동기화 작업은 마쳤지만 쓰레드의 독점 현상 발생하는 문제 존재
 */
public class WaitNotifyThread_1 {
    public static void main(String[] args) throws Exception{
        Table table = new Table();

        // Thread 이름 설정, (CUST1, CUST2, COOK)
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

    Customer(Table table, String food){
        this.table = table;
        this.food = food;
    }

    public void run() {
        while(true) {
            try { Thread.sleep(10); } catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();
            if(eatFood()){
                System.out.println(name + " ate a " + food);
            } else {
                System.out.println(name + " faliled to eat. :(");
            }
        }
    }
    boolean eatFood() { return table.remove(food); };
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) { this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(100); } catch(InterruptedException e) {}
        }
    }
}

class Table {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        if(dishes.size() >= MAX_FOOD)
            return;
        dishes.add(dish);
        System.out.println("Dishes:" + dishes.toString());
    }

    public boolean remove(String dishName){
        synchronized(this){
            while(dishes.size() == 0){
                String name = Thread.currentThread().getName();
                System.out.println(name+" is waiting.");
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }

            for(int i = 0; i<dishes.size(); i++){
                if(dishName.equals(dishes.get(i))){
                    dishes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    public int dishNum() { return dishNames.length; }
}
