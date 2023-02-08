package inflearn_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class AboutFile {

	//파일 등록
	public static void main(String day, String work) {
		try {
		      // 파일로 저장할 test 변수 선언
		      String test = work;
		      // String 타입을 byte 형식으로 변환
		      byte[] binary = test.getBytes();
		      // 파일 인스턴스 생성
		      File file = new File("c:\\javaplayground\\"+day+".txt");
		      // Stream 인스턴스 생성
		      OutputStream stream = new FileOutputStream(file);
		      // OutputStream에 test의 바이너리를 작성
		      stream.write(binary);
		      // Stream 리소스 닫기
		      stream.close();
		    } catch (Throwable e) {
		      e.printStackTrace();
		      System.out.println("Error");
		    }
	  }
	
	//파일 찾기
	static void findDay(String checkday) throws IOException {
		
		try {
			String fileName = checkday+".txt";
			FileInputStream fis = new FileInputStream("c:\\javaplayground\\"+checkday+".txt");
			FileReader fr = new FileReader("c:\\javaplayground\\"+checkday+".txt");
			
			int data = 0;
			while((data=fr.read())!=-1) {
				System.out.print((char)data);
			}
			System.out.println();
			fr.close();
		}catch(IOException e) {
			System.out.println("해당 파일 존재 X");
			e.printStackTrace();
		}
	}
}
