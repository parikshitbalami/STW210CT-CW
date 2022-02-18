package week7;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Manipulation {

	static void countManipulations(List<Integer> s1, List<Integer> s2) {

		List<Integer> difference = s1.stream().filter(aObject -> {
			return !s2.contains(aObject);
		}).collect(Collectors.toList());

		List<Integer> difference2 = s2.stream().filter(aObject -> !s1.contains(aObject)).collect(Collectors.toList());
		if (difference.size() < difference2.size()) {
			checkValue(difference, difference2);
		} else {
			checkValue(difference2, difference);
		}
	}

	
	public static void main(String[] args) {
		List<Integer> s1 = Arrays.asList(1,3,2,5,10);
		List<Integer> s2 = Arrays.asList(1,4,3,0);
		countManipulations(s1, s2);
	}

	public static void checkValue(List<Integer> g1, List<Integer> s1) {
		for (int i = 0; i < g1.size(); i++) {
			System.out.println("change " + s1.get(i) + " with " + g1.get(i));
		}
		for (int ii = g1.size(); ii < s1.size(); ii++) {
			System.out.println("remove " + s1.get(ii));
		}
	}
}
