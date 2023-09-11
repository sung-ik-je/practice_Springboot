import java.util.ArrayList;

/**
 * WaitNotifyThread_1과의 차이점
 *      1. 초기에 음식 dishes에 추가, 최대 크기 도달하면 COOK => waiting
 *      2. Customer 음식 소비
 *
 *      1, 2번 반복
 *      => 결론적으로 wait(), notify()의 사용으로 코드의 구조가 변경될 수 있었으며
 *          특정 쓰레드의 독점 현상을 방지하며 쓰레드를 운용할 수 있었다
 */
public class WaitNotifyThread_2 {
    public static void main(String[] args) throws Exception{
        Table_2 table = new Table_2();

        new Thread(new Cook_2(table), "COOK").start();
        new Thread(new Customer_2(table, "donut"), "CUST1").start();
        new Thread(new Customer_2(table, "burger"), "CUST2").start();

        Thread.sleep(2000);
        System.exit(0);
    }
}

class Customer_2 implements Runnable {
    private Table_2 table;
    private String food;

    Customer_2(Table_2 table, String food){
        this.table = table;
        this.food = food;
    }

    public void run() {
        while(true) {
            try { Thread.sleep(100); } catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

class Cook_2 implements Runnable {
    private Table_2 table;

    Cook_2(Table_2 table) { this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(10); } catch(InterruptedException e) {}
        }
    }
}

class Table_2 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        if(dishes.size() >= MAX_FOOD){
            String name = Thread.currentThread().getName();
            System.out.println(name+" is waiting.");
            try {
                wait();
                Thread.sleep(500);
            } catch(InterruptedException e) {}
        }
        dishes.add(dish);
        notify();
        System.out.println("Dishes:" + dishes.toString());
    }

    public void remove(String dishName){
        synchronized(this){
            String name = Thread.currentThread().getName();
            while(dishes.size() == 0){
                System.out.println(name+" is waiting.");
                try {
                    wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            while(true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();
                        return;
                    }
                }

                try {
                    System.out.println(name+" is waiting.");
                    wait();
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }
        }
    }
    public int dishNum() { return dishNames.length; }
}
