
/**
 * daemon thread : 다른 일반 쓰레드(데몬 쓰레드가 아닌 쓰레드)의 작업을 돋는 보조적인 역할을 수행하는 쓰레드
 *      ex) 가비지 컬렉터, 워드프로세서의 자동저장, 화면자동갱신 등
 *      일반 쓰레드가 종료되면 데몬 쓰레드는 강제적으로 자동 종료
 *          데몬 쓰레드는 일반 쓰레드의 보조 역할이기 때문에 일반 쓰레드가 종료되고 나면 데몬 쓰레드의 존재 의미는 없기 때문
 *      무한루프와 조건문을 이용해 실행 후 대기하고 있다 특정 조건이 만족하면 작업 수행 후 다시 대기하도록 작성
 */

/**
 * sleep() : 일정 시간 동안 쓰레드 정지
 *      쓰레드는 선언된 순간부터 작업이 시작되는데 일정 시간 정지했다 작업 재개하는 함수
 */
public class DaemonThread implements Runnable{
    static boolean autoSave = false;

    public static void main(String[] args){
        Thread t = new Thread(new DaemonThread());
        t.setDaemon(true);      // 데몬 쓰레드로 선언, 이 부분이 없으면 종료되지 않는다.
        t.start();

        for(int i = 1; i <= 10; i++){
            try{
                Thread.sleep(1000);     // thread 잠시 정지 시키는 것, 딜레이 통해 출력 확인 목적
            } catch (InterruptedException e) {}
            System.out.println(i);

            if(i == 5) autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");
    }

    public void run() {
        while(true){
            try {
                Thread.sleep(3*1000);       // 3초마다 autoSave = true이면 autoSave() 메서드 실행
            } catch(InterruptedException e){}
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}
