public class RepeatMiss {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length;

        long expectedSum = (n * (n + 1)) / 2;
        long expectedSquareSum = (n * (n + 1) * (2 * n + 1)) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int value : nums) {
            actualSum += value;
            actualSquareSum += (long) value * value;
        }

        long difference = actualSum - expectedSum;
        long squareDifference = actualSquareSum - expectedSquareSum;

        long sumOfNumbers = squareDifference / difference;
        long repeating = (difference + sumOfNumbers) / 2;
        long missing = repeating - difference;

        return new int[] {(int) repeating, (int) missing};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        RepeatMiss solution = new RepeatMiss();
        int[] result = solution.findMissingRepeatingNumbers(nums);

        System.out.printf(
            "The repeating and missing numbers are: {%d, %d}%n",
            result[0],
            result[1]
        );
    }
}
