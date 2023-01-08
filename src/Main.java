public class Main {
    public static void main(String[] args) {

        /* TODO:  You are given an array of characters letters that is sorted
            in non-decreasing order, and a character target.
            There are at least two different characters in letters.
            Return the smallest character in letters that is lexicographically greater than target.
            If such a character does not exist, return the first character in letters.
         */
        char[] arr = {'f', 'h', 'k', 'o', 'y'};
        // для уникальных
        System.out.println(nextGreatestLetter(arr, 'z'));
        System.out.println(nextGreatestLetter(arr, 'o'));
        System.out.println(nextGreatestLetter(arr, 'a'));
        System.out.println(nextGreatestLetter(arr, 'g'));
        System.out.println(nextGreatestLetter(arr, 'm'));
        System.out.println(nextGreatestLetter(arr, 'y'));

        /* TODO: Given a sorted array of distinct integers and a target value,
                 return the index if the target is found. If not, return the index
                 where it would be if it were inserted in order.
         */
        int[] arr2 = {1, 4, 6, 8};
        System.out.println(searchInsert(arr2, 6));
        System.out.println(searchInsert(arr2, 1));
        System.out.println(searchInsert(arr2, 3));
        System.out.println(searchInsert(arr2, 8));
        System.out.println(searchInsert(arr2, 9));

        /* TODO: Given a positive integer num, return true if num is a perfect
            square or false otherwise. A perfect square is an integer that is
             the square of an integer. In other words, it is the product of some integer with itself.
             You must not use any built-in library function, such as sqrt.
         */
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(0));
        System.out.println(isPerfectSquare(2400));
        System.out.println(isPerfectSquare(1369));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;
        int middle;

        while (start <= end) {

            middle = (start + end) / 2;

            if (target == letters[middle]) {
                return letters[middle + 1];
            }
            if (target == letters[letters.length - 2]) {
                return letters[letters.length - 1];
            }
            if (target > letters[letters.length - 1] || target < letters[0]
                    || target == letters[letters.length - 1]) {
                return letters[0];
            }
            if (target < letters[middle]) {
                end = middle - 1;
            } else {
                if (letters[middle + 1] != target) {
                    return letters[middle + 1];
                }
                start = middle + 1;
            }
        }
        return letters[start];
    }

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int middle;

        while (start <= end) {

            middle = (start + end) / 2;

            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }

    private static boolean isPerfectSquare(int num) {

        long start = 1;
        long end = num;
        while (start + 1 < end) {
            long mid = (start + end) / 2;
            if (mid * mid <= num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start * start == num) {
            return true;
        }
        return false;

        /*int sum = 0;
        int i = 1;
        while (num > sum) {
            sum = sum + i;
            i = i + 2;
        }
        return sum == num;
         */
    }
}
