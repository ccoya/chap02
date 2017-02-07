package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;

public class RequestServletTest {

	/*
	 * junit 단위 테스트
	 */
	@Test
	public void requestTest01(){
		System.out.println("requestTest01()....");
	}
	
	@Test
	public void requestTest02() throws UnknownHostException, IOException{
		System.out.println("requestTest02()....");
		
//		Socket soc = new Socket("www.soen.kr", 80);
		Socket soc = new Socket("localhost", 8080);
		
		OutputStream out = soc.getOutputStream();	//byte stream
		InputStream in = soc.getInputStream();		//byte stream
		
		PrintWriter writer = new PrintWriter(out);	//char stream
		Scanner reader = new Scanner(in);			//char stream
		
		/*
		 * 요청전문 전송
		 */
		
		writer.println("GET /request HTTP/1.1");
		writer.println("Host: localhost");
		writer.println();
		writer.println();
		writer.flush();
		
		
		/*
		 * 응답전문 수신
		 */
		
		while(reader.hasNextLine()){
			System.out.println(reader.nextLine());
		}
	}
	
	@Test
	public void requestTest03(){
		System.out.println("requestTest03()....");
	}
	
}
