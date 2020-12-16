package com.ENTER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class teamShuffle {

	public static void main(String[] args) {

		String[] member = {
				"갓김치"
				,"린사원"
				,"댄디"
				,"빅윈"
				,"린튜브"
				,"코사"
				,"윈드"
				,"사자콩"
				,"그림자"
				,"디동전"
				,"참치"
				,"솔핀"
				,"이주임"
				,"호랑구"
				,"뿌리"
				,"안내데스크"
				};

		ArrayList<String> al = new ArrayList<String>();

		al.addAll(Arrays.asList(member));
		System.out.println("섞기 전---- "+al);
		Collections.shuffle(al);
		Collections.shuffle(al);
		Collections.shuffle(al);
		Collections.shuffle(al);
		Collections.shuffle(al);
		Collections.shuffle(al);
		Collections.shuffle(al);
		System.out.println("섞기 후---- "+al);
		ArrayList<String> Team_A = new ArrayList<String>();
		ArrayList<String> Team_B = new ArrayList<String>();
		ArrayList<String> Team_C = new ArrayList<String>();
		ArrayList<String> Team_D = new ArrayList<String>();
		for(int i= 0; i < al.size(); i++) {
			/* System.out.println(i +"  ---   "+ al.get(i)); */
			if(0 <= i && i < 4) {
				Team_A.add(al.get(i));
			}
			if(4 <= i && i < 8) {
				Team_B.add(al.get(i));
			}
			if(8 <= i && i < 12) {
				Team_C.add(al.get(i));
			}
			if(12 <= i && i < 16) {
				Team_D.add(al.get(i));
			}
		}
		System.out.println("Team_A --  "+ Team_A +"");
		System.out.println("Team_B --  "+ Team_B +"");
		System.out.println("Team_C --  "+ Team_C +"");
		System.out.println("Team_D --  "+ Team_D +"");




	}


}
