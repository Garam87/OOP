package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;
import edu.kh.oop.cls.model.vo.User;

public class ClsService {
	// 클래스 접근제한자 확인하기
	
	public void ex1() {
		Student std = new Student();
		// public class인 student는 import 가능
		
		// TestVo test = new TestVo();
		// (default) class인 TestVo는 import 불가(다른 패키지여서)
		
		System.out.println(std.v1);
		// 다른 패키지에서도 접근 가능한 public만 에러가 없다.
	}
	
	public void ex2() {
		// static 필드 확인 예제
		
		//학생 객체 2개 생성
		Student std1 = new Student();
		Student std2 = new Student();
		
		System.out.println(std1.schoolName);
		// public 이기 때문에 직접 접근 가능
		
		System.out.println("변경 전: " + std1.getName());
		std1.setName("오가람");
		System.out.println("변경 후: " + std1.getName());
		
		//System.out.println(std2.schoolName);
		// public 이기 때문에 직접 접근 가능

		System.out.println("변경 전: " + std1.schoolName);
		std1.schoolName = "KH고등학교!";
		System.out.println("변경 후: " + std1.schoolName);
		
		// schoolName에 노란줄이 뜨는 이유! -> 제대로 작성 안해서
		
		// *** static이 붙은 필드(변수)는
		// 클래스명. 변수명 으로 사용함.
		
		Student.schoolName = "KH";
		System.out.println("Student.schoolName: " + Student.schoolName);
		
		/* static
		 * 
		 * 1) 공유 메모리 영역( 또는 정적 메모리 영역) 이라고 함.
		 * 
		 * => 프로그램 시작 시 static이 붙은 코드들이
		 * 모두 static 영역에 생성되고,
		 * 프로그램이 종료될 때 까지 사라지지 않음. (정적)
		 * 그리고 static 영역에 생성된 변수는 어디서든 공유가능(공유)
		 * 
		 * 2) 사용 법: 클래스명. 변수명
		 * 
		 */
	}
	
	public void ex3() {
		// 생성자 확인 테스트
		
		Student s1 = new Student();
		            // 기본 생성자
		
		// User 기본 생성자를 이용해서 객체 생성
		User u1 = new User();
		
		System.out.println(u1.getUserId());
		System.out.println(u1.getUserPw());
		System.out.println(u1.getUserName());
		System.out.println(u1.getUserAge());
		System.out.println(u1.getUserGender());
		
		// ==> 클래스에서 메서드에 getter/setter 메서드 만들지 않으면 
		// 간접 접근 불가능
		
		User u2 = new User();
		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPw());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserGender());
		
		System.out.println("=================================");
		
		// 문제점: u1이 참조하고 있는 User객체와
		//       u2가 참조하고 User객체가 필드의 값이 모두 동일함.
		// 해결 방법 1 : setter를 이용해서 새로운 값을 대입
		
		u2.setUserId("garam234");
		u2.setUserPw("1234sdf");
		u2.setUserName("오가람");
		u2.setUserAge(30);
		u2.setUserGender('F');
		
		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPw());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserGender());
		
		User u3 = new User("test33", "pwrd34r234");
		
	}
}
