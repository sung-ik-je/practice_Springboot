package inflearn_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PlanItem {
	
	public static void main(String[] args) throws IOException {
		PlanItem.printMenu();
		PlanItem.menu_choice();
	}
	
	//메뉴 프린트
	public static void printMenu() {
		
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}
	
	
	//메뉴 선택 알고리즘
	public static void menu_choice() throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//HashMap<String, String> map = new HashMap<String, String>();
		String N;
		do {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print(">");
			N = br.readLine();
			switch(N) {
			case "1":
				System.out.println("[일정 등록] 날짜를 입력하세요.");
				System.out.print(">");
				String day = br.readLine();
				System.out.println("일정을 입력하세요");
				System.out.print(">");
				String work = br.readLine();
				//file i/o(day - 파일명, work - 파일데이터로)
				AboutFile.main(day,work);
				//map.put(day, work);
				System.out.println("일정이 등록되었습니다");
				break;
			case "2":
				System.out.println("[일정 검색] 날짜를 입력하세요");
				System.out.print(">");
				String checkday = br.readLine();
				
				//file에 day(파일명) 존재한다면 일정출력
				//없으면 존재하지 않습니다
				AboutFile.findDay(checkday);
//				if(map.containsKey(checkday)) {
//					System.out.println("1개의 일정이 있습니다");
//					System.out.println(map.get(checkday));
//				}
//				else {
//					System.out.println("일정이 존재하지 않습니다");
//				}
				break;
			case "3":
				System.out.println("년도를 입력해주세요");
				System.out.print("YEAR>");
				String year = br.readLine();
				System.out.println("달을 입력하세요");
				System.out.print("MONTH>");
				String month = br.readLine();
				Main.findleapyear(year, month);
				break;
			case "h":
				PlanItem.printMenu();
				break;
			}
		}while(!N.equals("q"));
		System.out.println("Bye");
	}
}