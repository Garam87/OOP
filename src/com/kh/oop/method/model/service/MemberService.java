package com.kh.oop.method.model.service;

import java.util.Scanner;

import com.kh.oop.method.model.vo.Member;

public class MemberService { // 클래스
	// 속성(필드)
	// 필드는 기본적으로 캡슐화 원칙에 의해 private이라는 접근제한자를 꼭 작성
	// 필드에 변수를 하나 작성하면, 클래스 안에서 어디에서든 사용 가능
	private Scanner sc = new Scanner(System.in);
							// System.in : 자바에서 기본적으로 지정해둔 입력장치(키보드)
	private Member memberInfo = null; // 가입한 회원의 정보를 저장할 변수
	private Member loginMember = null; // 로그인한 회원의 정보를 저장할 변수
	
	// 기능(생성자, 메서드)
	// ** 여러기능을 하나의 메소드에 모두 작성하지 말 것!
	// 되도록 하나의 기능만 수행하도록 작성
	// 메소드는 메소드당 딱 하나의 기능만 가지고 있는게 좋다.
	
	// 왜??
	// 기능별로 세분환 해놔야 필요한 기능만 호출하여 쓸 수 있다.
	/*public void today() {
		// 1. 밥먹는 행위
		// 2. 일하는 행위
	}
	public void eat() {}
	public void work() {}
	// 두가지를 나누ㅏ서 메소드를 만들고
	// eat(); work(); 하나씩 불러서 쓸 수 있게 된다.
	 */
	public MemberService() {}
//	public MemberService(int a) {} // 기본생성자 미작성시 에러
	
	// ** 메서드 작성법 **
	
	//[접근제한자]     [예약어]          반환형             메소드명([매개변수])
	// public        static         기본자료형
	// protected      final         참조형(배열,클래스)
	// (default)     abstract        void
	// private      static final
	
	// ** 반환형 void **
	// - 반환(return)이란? 메서드 수행 후 호출부로 돌아가는 것
	// - 반환 값 : 돌아가면서 가져갈 결과 값
	// - 반환 형 : 반환 값의 자료형
	// -> void(텅빈, 없는, 무효의) : 돌려보낼 값(반환 값)이 없다.

	// 메뉴 화면 출력 기능
	public void displayMenu() {
		//일은 하는데요.. 결과값은 없어용
		int menuNum = 0; // 지역 변수
		
		do { // 한 번은 무조건 반복
			System.out.println("====== 회원 정보 관리 프로그램 =======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 >>> ");
			menuNum = sc.nextInt(); // 필드에 작성된 Scanner sc 사용
			sc.nextLine(); // 입력버퍼에 남은 개행문자 제거
			
			switch(menuNum) {
			case 1 : System.out.println(signUp()); break;
			case 2 : System.out.println(login()); break;
			case 3 : selectMember(); break;
			case 4 : memberUpdate(); break;
			
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못 입력 하셨습니다. 다시 입력바랍니다!");
			}
		} while(menuNum != 0); // menuNum이 0이면 반복종료
	}
	
	// 회원 가입 기능
	public String signUp() {
		// (반환형)
		System.out.println("\n ***** 회원 가입 ***** ");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입
		// 일치하지 않으면 회원가입 실패
		if(memberPw.equals(memberPw2)) { // 일치하는 경우
			memberInfo = new Member(memberId, memberPw, memberName, memberAge);
			return "회원 가입 성공!!!";

		} else {
			return "회원 가입 실패!!!(비밀번호 불일치)";
		}
		
		
	}
	
	// 로그인 메서드(기능)
	public String login() {
		System.out.println("***** 로그인 *****");
		
		// 회원 가입을 했는지 부터 확인
		// == memberInfo가 객체를 참조하고 있는지 확인
		
		if(memberInfo == null) { // 회원가입을 먼저 안한 경우
			return "회원 가입부터 진행하십시오";
		}
		
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		System.out.println("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		if(memberId.equals(memberInfo.getMemberId()) && memberPw.equals(memberInfo.getMemberPw())) {
			loginMember = memberInfo;
			return loginMember.getMemberName() + "님 환영합니다!";
		} else {
			return "아이디 또는 비밀번호가 일치하지 않습니다";
		}
	}
	
	// 회원 정보 조회 기능
	// 아이디, 이름, 나이
	
	// CRUD ( C:Create R:Read U:Update D:Delete )
   public void selectMember() {
	   // 1) 로그인 여부 확인 -> 필드 loginMember가 참조하는 객체가있는지 확인
	   // 2) 로그인 되어있는 경우
	   //    회원정보를 출력할 문자열을 만들어서 반환(return)
	   //    단, 비밀번호는 제외
	   if(loginMember == null) {
		   System.out.println("로그인을 먼저 해주세요");
	   } else {
		   System.out.println(" ***** 회원 정보 조회 ***** ");
		   System.out.println("아이디 : " + memberInfo.getMemberId());
		   System.out.println("이름 : " + memberInfo.getMemberName());
		   System.out.println("나이 : " + memberInfo.getMemberAge());
	   }
   }
	
   // 회원 정보 수정(update) 기능
   
   public void memberUpdate() {
	   // 1) 로그인 여부 판별
	   // 로그인이 되어있지 않으면 -1 반환
	   // 2) 수정할 회원 정보 입력 받기(이름, 나이)
	   // 3) 비밀번호 입력 받아서
	   // 로그인한 회원의 비밀번호롸 일치한지 확인
	   // 4) 비밀번호 같은 경우
	   //    로그인한 회원의 이름, 나이 정보를 입력받은 값으로 변경 후
	   //    1 반환
	   // 5) 비밀번호가 다를 경우 0 반환
	   if(loginMember == null) {
		   System.out.println("로그인을 먼저 해주세요");
	   } else {
		   System.out.println("\n ***** 회원 정보 수정 ***** ");
		   System.out.println("수정 할 항목을 선택해주세요");
		   System.out.println("1. 아이디");
		   System.out.println("2. 비밀번호");
		   System.out.println("3. 이름");
		   System.out.println("4. 나이");
		   System.out.println("5. 처음 화면으로 되돌아 갑니다");
		   System.out.print("메뉴 입력 >>> ");
		   int menu2 = sc.nextInt();
		   sc.nextLine();
		   
		   switch(menu2) {
		   case 1 : System.out.println(updateId()); break;
		   case 2 : System.out.println(updatePw()); break;
		   case 3 : System.out.println(updateName()); break;
		   case 4 : System.out.println(updateAge()); break;
		   case 5 : displayMenu(); break;
		   default : System.out.println("1~5의 숫자만 입력해 주세요");
			   
		   
		   }
	   }
   }
   
   public String updateId() {
	  String userId;
	  System.out.println("아이디 변경 : ");
	  memberInfo.setMemberId(userId = sc.next());
	  return "아이디가 성공적으로 변경되었습니다.";
   }
   
   public String updatePw() {
	   String userPw;
	   System.out.println("비밀번호 변경 : ");
	   memberInfo.setMemberPw(userPw = sc.next());
	   return "비밀번호가 성공적으로 변경되었습니다.";
   }
   
   public String updateName() {
	   String userName;
	   System.out.println("이름 변경 : ");
	   memberInfo.setMemberName(userName = sc.next());
	   return "이름이 성공적으로 변경되었습니다.";
   }
   
   public String updateAge() {
	   int userAge;
	   System.out.println("나이 변경 : ");
	   memberInfo.setMemberAge(userAge = sc.nextInt());
	   return "나이가 성공적으로 변경되었습니다.";
   }
	   
   public int updateMember() {
	   System.out.println("\n*****회원정보 수정*****");
	   if(loginMember == null) {
		   return -1;
	   }
	   System.out.print("수정할 이름 입력 : ");
	   String inputName = sc.next();
	   System.out.print("수정할 나이 입력 : ");
	   int inputAge = sc.nextInt();
	   sc.nextLine();
	   System.out.print("비밀번호 입력 : ");
	   String inputPw = sc.next();
	   if(inputPw.equals(loginMember.getMemberPw())) {
		   loginMember.setMemberName(inputName);
		   // 입력받은 inputName을
		   // loginMember가 참조하는 Member 객체의 필드 memberName에 대입
		   loginMember.setMemberAge(inputAge);
		   return 1;
	   } else {
		   return 0;
	   }
   }
   
   
   
	
}