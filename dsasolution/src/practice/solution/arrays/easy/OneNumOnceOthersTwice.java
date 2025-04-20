package practice.solution.arrays.easy;

public class OneNumOnceOthersTwice {

	public static void main(String[] args) {

		int arr[] = { 4, 1, 2, 1, 2 };

		int onceNum = findNumberAppearingOnce(arr);

		System.out.println(onceNum);

	}

	private static int findNumberAppearingOnce(int[] arr) {
		int onceNum = methodA(arr);
		return onceNum;
	}

	private static int methodA(int[] arr) {
		int xorNum = 0;

		for (int i = 0; i < arr.length; i++) {
			xorNum = xorNum ^ arr[i];
		}
		return xorNum;
	}

}
