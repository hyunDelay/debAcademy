package com.kh.app.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.kh.app.service.DateService;
import com.kh.app.vo.DateVo;

public class DateController {
	
	// 필드 (멤버변수)
	private final Scanner sc;
	private final DateService ds;
	
	// 기본생성자
	public DateController() {
		sc = new Scanner(System.in);
		ds = new DateService();
	}

	// 메뉴선택 (일주일 일정 보기)
	public void dateSelectMenu() {
		
		// 일주일 일정 보여주기
		weekShow();
		
		// 메뉴선택
		System.out.println("===== 메뉴 선택 =====");
		System.out.println("1. 일정 조회");
		System.out.println("2. 일정 추가");
		System.out.println("3. 일정 삭제");
//		System.out.println("4. 로그아웃");
		System.out.println("==================");
		
		String num = sc.nextLine();
		switch(num) {
		case "1" : showPlanner(); break;
		case "2" : addPlanner(); break;
		case "3" : delectPlanner(); break;
		// case "4" : logout(); break;
		default : System.out.println("그런 메뉴 없음");
		}
		
	}
	
	// 일주일 일정 보여주기
	@SuppressWarnings("null")
	private void weekShow() {
		// 서비스 호출
		// 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();
        
        // 오늘날짜 표시
        String year = currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")).substring(0, 4);
		String month = currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")).substring(4, 6);
		String day = currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")).substring(6);
		System.out.println("----- 오늘 날짜 -----");
        System.out.println(year + "년 " + month + "월 " + day + "일");


		System.out.println("----- 일주일 일정 -----");
		
		ArrayList<DateVo> voList = null; // 가져온 일정있는날 데이터
		try {
			voList = ds.weekShow();
			
			// 현재 날짜가 속한 주의 첫 번째 요일 (일요일) 구하기
	        LocalDate firstDayOfWeek = currentDate.with(DayOfWeek.MONDAY);
	
	        
			
			// 결과 처리
	        for (int i = 0; i < 7; i++) {
	            LocalDate date = firstDayOfWeek.plusDays(i);
	            String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	            
	            String fyear = formattedDate.substring(0, 4);
	            String fmonth = formattedDate.substring(4, 6);
	            String fday = formattedDate.substring(6);
	            
	            String title = "일정없음"; // 기본값 설정
	            
	            // voList가 null이 아니면서 vo의 date와 현재 주간 날짜가 같으면 title 설정
	            if (voList != null) {
	                for (DateVo vo : voList) {
	                    if (vo.getDate().equals(formattedDate)) {
	                        title = vo.getTitle();
	                        break; // 해당 날짜와 일치하는 일정을 찾았으면 루프 종료
	                    }
	                }
	            }
	            
	            System.out.println("[ " + fmonth + "월 " + fday + "일 일정 ] " + title);
	        }
			
			
			
		} catch (Exception e) {
			System.err.println("조회 실패");
			e.printStackTrace();
		}

        
	}

	// 일정조회
	private void showPlanner() {
		// 서비스 호출
		ArrayList<DateVo> voList = null;
		try {
			voList = ds.getShowPlanner();
			
			// 결과 처리
			for(DateVo vo : voList) {
				String date = vo.getDate();
				String year = date.substring(0, 4);
				String month = date.substring(4, 6);
				String day = date.substring(6);
				System.out.println("[ " + year + "년 " + month + "월 " + day + "일 ] " + vo.getTitle());
			}
		} catch (Exception e) {
			System.err.println("조회 실패");
			e.printStackTrace();
		}
		
	}
	
	// 일정추가
	private void addPlanner() {
		String date;
        while(true) {
        	// 데이터 입력받기 
    		System.out.println("일정추가할 날짜를 입력하세요. ex)20231007");
    		 date = sc.nextLine();
    		
    		// "yyyyMMdd" 형식에 맞는 정규 표현식
            String dateFormatPattern = "\\d{8}";
            // 정규 표현식과 입력 문자열을 비교
        	if(!Pattern.matches(dateFormatPattern, date)) {
            	System.out.println("잘못된 날짜입니다.");
        	} else {
        		break;
        	}
        }
        
		System.out.println("일정내용을 입력하세요.");
		String dayContent = sc.nextLine();
		
		DateVo vo = new DateVo(dayContent, date);
		
		// 서비스
		try {
			int result = ds.addPlanner(vo);
			
			// 결과 처리
			if(result == 1) {
				System.out.println("일정이 추가되었습니다.");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.err.println("일정이 추가되지 않았습니다.");
			e.printStackTrace();
		}
		
	}
	
	// 일정삭제
	private void delectPlanner() {
		String date;
        while(true) {
        	// 데이터 입력받기 
    		System.out.println("일정삭제할 날짜를 입력하세요. ex)20231007");
    		 date = sc.nextLine();
    		
    		// "yyyyMMdd" 형식에 맞는 정규 표현식
            String dateFormatPattern = "\\d{8}";
            // 정규 표현식과 입력 문자열을 비교
        	if(!Pattern.matches(dateFormatPattern, date)) {
            	System.out.println("잘못된 날짜입니다.");
        	} else {
        		break;
        	}
        }
        
        // 서비스
 		try {
 			int result = ds.delectPlanner(date);
 			
 			// 결과 처리
 			if(result == 1) {
 				System.out.println("일정이 삭제되었습니다.");
 			} else {
 				throw new Exception();
 			}
 		} catch (Exception e) {
 			System.err.println("일정이 삭제되지 않았습니다.");
 			e.printStackTrace();
 		}
        
	}
	
}

