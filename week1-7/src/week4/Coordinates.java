package week4;

//Java program for implementation of
//above approach
import java.util.*;

class Coordinates {

//Function to print required answer
	static void dClosest(int[][] pts, int[][] k) {
		Map<Integer, String> map = new HashMap<Integer, String>();// to store first 3 value

		int x1 = k.length; // main x
		int y1 = k[0].length;// main y

		int n = pts.length; // number of other points
		int[] distance = new int[n];
		for (int i = 0; i < n; i++)// loop all points
		{
			int x = pts[i][0], y = pts[i][1];
			distance[i] = (int) (Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1))); // calculate distance
			map.put(distance[i], ("{" + x + "," + y + "}"));// store in map function

		}

		Arrays.sort(distance);// sort array
		int[] out = new int[3];// get small 3
		for (int i = 0; i < 3; i++) {
			out[i] = distance[i];
		}
// print
		Set<Integer> keys = map.keySet();
System.out.println("closest three coordinates are :");
		for (Integer key : keys)
			for (int i = 0; i < 3; i++) {
				if (key == out[i]) {
					System.out.println("distance = "+key + " from point " + map.get(key)+" to "+"{" + x1 + "," + y1 + "}");

				}

			}

	}

//Driver code
	public static void main(String[] args) {
		int points[][] = { { 2, 3 }, // 1
				{ 5, 8 }, // 6
				{ 3, 4 }, // 2
				{ 5, 7 } };// 5

		int[][] cp = new int[2][2];// main point

		dClosest(points, cp);
	}
}


