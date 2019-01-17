package in.mizardar.testappsride.utils;

public class Utils {

    public static boolean isPrimeNumberSelected(int selectedDay) {

        // 0 and 1 are prime numbers
        if (selectedDay == 0 || selectedDay == 1) {
            return true;
        } else {
            // if the number is not divisible by half the it is a prime number
            //ex 7/2 = 3 and 7 is not divided by 1 2 3
            for (int dayCount = 2; dayCount <= selectedDay / 2; dayCount++) {
                if (selectedDay %dayCount == 0){
                    return true;
                }
            }
            return false;
        }
    }
}
