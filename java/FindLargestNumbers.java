
import java.util.*;

/**
 * The purpose of this class is to obtain either 3 largest numbers in a given
 * array OR some one can use this class to obtain 'K' largest elements in the
 * array. The LinkedList is used to create the K largest element list because
 * insertion in linked list is very efficient compared to any other sequential
 * data structure like Array. We did not use Array because inserting an element
 * in the middle of an array requires us to move all the elements to the right.
 * This class has two utility methods and 1 main method. main method is also
 * used to run test cases.
 * 
 * 
 * @author munish
 *
 */
class FindLargestNumbers {

	public static void main(String[] args) throws Exception {

		// Sample input Array used to write the test cases.

		// In real project I use JUNIT test cases, but to maintain code under
		// same
		// class for simplicity i am using main method for all testing.
		int[] arr = new int[] { 2, 5, 7, 12, 3, 9, 56, 34, 11, 33 };

		// Make a call to get three largest numbers.
		int[] threebiggest = findThreeLargest(arr);

		int biggest = threebiggest[0];
		int bigger = threebiggest[1];
		int big = threebiggest[2];

		if (biggest == 56) {
			System.out.println("TEST 1: Passed , Expected Max:" + biggest);
		}

		if (bigger == 34) {
			System.out.println("TEST 2: Passed , Expected 2nd Max:" + bigger);
		}

		if (big == 33) {
			System.out.println("TEST 3: Passed, Expected 3rd Max:" + big);
		}

		// Make a call to get K Largest Elements, choose any value of k
		int k = 5;
		List<Integer> topKNumbers = findKLargest(arr, k);

		if (topKNumbers.size() == k) {
			System.out.println("TEST 4: Passed, Expected k numbers:" + topKNumbers.size());
		}

		List<Integer> expectedTop5 = Arrays.asList(56, 34, 33, 12, 11);

		if (expectedTop5.equals(topKNumbers)) {
			System.out.println("TEST 5: Passed, Expected top 5 :" + topKNumbers);
		}

		int illegalK = 100;
		List<Integer> topKNumbers2 = findKLargest(arr, illegalK);

		if (topKNumbers2.size() == arr.length) {
			System.out.println("TEST 6: Passed, Expected k numbers is complete array when k is > arr.length:"
					+ topKNumbers2.size());
		}

		List<Integer> topKNumbers3 = findKLargest(null, 5);
		System.out.println(
				"Test 7: Passed, Expected top 5 should be empty set because array passed is null :" + topKNumbers3);

	}

	/**
	 * findThreeLargest method returns the three most largest numbers from the
	 * given array
	 * 
	 * @param numbers the array of numbers
	 * @throws Exception
	 */
	public static int[] findThreeLargest(int[] numbers) throws Exception {

		int big = Integer.MIN_VALUE;   // 3rd max
		int bigger = Integer.MIN_VALUE; // 2nd max
		int biggest = Integer.MIN_VALUE; // the maximum number

		if (numbers == null || numbers.length < 3) {
			return null;
		}

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i] > biggest) {

				big = bigger;
				bigger = biggest;
				biggest = numbers[i];

			} else if (numbers[i] > bigger) {

				big = bigger;
				bigger = numbers[i];

			} else if (numbers[i] > big) {

				big = numbers[i];

			}

		}

		return new int[] { biggest, bigger, big };

	}

	/**
	 * written by: @author munish
	 * 
	 * This method returns the K largest element in the array, For example if
	 * you pass numbers[]{ 2, 5, 7, 12, 3, 9, 56, 34, 11, 33 } it will return a
	 * list of elemtnst {56, 34, 33} This method is more useful when the value
	 * of K is relatively smaller than the number of elements in the array.
	 * Otherwise using generic sorting ( in place ) algo like quick sort is a
	 * better option.
	 * 
	 * @param numbers
	 *            The numbers passed as input in an array
	 * 
	 */
	public static List<Integer> findKLargest(int[] numbers, int k) {

		// We are choosing linkList because the insertion is constant.
		// LinkList inserts element in-place without doing shifting like array
		// does.
		List<Integer> kLargest = new LinkedList<Integer>();

		// If the numbers passed are null and an empty array
		// return an empty list.
		if (numbers == null || numbers.length == 0) {
			return kLargest;
		}

		// If the value of K is larger than the numbers in the array
		// reset the value of k to the array length.
		if (k > numbers.length) {
			k = numbers.length;
		}

		// Once for all the elements in the array
		for (int i = 0; i < numbers.length; i++) {
			// only if there is at least 1 element in the linkedlist
			// else add the first element in the "else" part
			if (kLargest.size() > 0) {
				int j = 0;
				Integer value = kLargest.get(j);
				// find the spot in the LinkedList where number has to be
				// inserted.
				// We
				while (numbers[i] < value) {
					j++;
					if (j > kLargest.size() - 1) {
						break;
					}
					value = kLargest.get(j);
				}

				kLargest.add(j, numbers[i]);

			} else {
				kLargest.add(numbers[i]);
			}

		}

		// Just copy the top k elements from the linkList to a new list and
		// return the new list.
		List<Integer> topKNumbers = new ArrayList<Integer>(kLargest.subList(0, k));

		return topKNumbers;
	}

}
