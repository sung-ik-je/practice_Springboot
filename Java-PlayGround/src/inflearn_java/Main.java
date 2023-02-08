package inflearn_java;


import java.util.Calendar;

public class Main {
//	public static void main(String[] args) throws IOException {
//		PlanItem.printMenu();
//		PlanItem.menu_choice();
//	}
	
	//윤년 찾는 알고리즘
	static void findleapyear(String year, String month) {
		int lastday = 0;
		int number = Integer.parseInt(month);
		if(month.equals("2")) {
			if(Integer.parseInt(year) % 4 == 0) {
				if( Integer.parseInt(year) % 400 == 0) {
					lastday = 29;
				}
				else if((Integer.parseInt(year) % 100 == 0) ) {
					lastday = 28;
				}
				else {
					lastday = 28;
				}
			}
			else {
				lastday = 28;
			}
		}
		else {
			switch(number){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				lastday = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				lastday = 30;
				break;
			}
		}
		findcal(year, month, lastday);
	}
	
	//달력 찾는 알고리즘
	static void findcal(String year, String month, int lastday) {
		
		int count = 0;
		int start = 0;
		int line = 0;
		Calendar date = Calendar.getInstance(); 
		
		System.out.println("<"+year+"년  "+ month + "월>");
		
		date.set(Integer.parseInt(year), Integer.parseInt(month)-1, 1);
		int weekday = date.get(Calendar.DAY_OF_WEEK);

		
		switch(weekday) {
		case 1:
			count = 0;
			break;
		case 2:
			count = 1;
			break;
		case 3:
			count = 2;
			break;
		case 4:
			count = 3;
			break;
		case 5:
			count = 4;
			break;
		case 6:
			count = 5;
			break;
		case 7:
			count = 6;
			break;
		}
		
		System.out.println("SU MO TU WE TH FR SA");
		System.out.println("--------------------");
		for(int i = 1; i <= lastday; i++) {
			if(start == 0) {
				for(int j = 0; j < count; j++) {
					System.out.print("   ");
					start ++;
				}
			}
			if(i<10) {
				System.out.print(" "+i);
			}
			else {
				System.out.print(i);
			}
			System.out.print(" ");
			if((i % (7-count) == 0) && line == 0) {
				System.out.println();
				line ++;			
			}
			else if((i % 7  == 7-count) && line > 0) {
				System.out.println();
				
			}
		}
		System.out.println();
	}
}