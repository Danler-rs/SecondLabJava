package SecondLab;

import java.util.Scanner;

public class Task1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] z1 = new double[2];
        double [] z2 = new double[2];

        System.out.println("Введите действительную часть для первого компл числа: ");
        double a1 = scanner.nextDouble();
        System.out.println("Введите мнимую часть для первого компл числа: ");
        double b1 = scanner.nextDouble();
        System.out.println("Введите действительную часть для второго компл числа: ");
        double a2 = scanner.nextDouble();
        System.out.println("Введите мнимую часть для первого компл числа: ");
        double b2 = scanner.nextDouble();

        z1[0] = a1;
        z1[1] = b1;
        z2[0] = a2;
        z2[1] = b2;

        double [] sum_res = SumOfKompleks(z1, z2);
        System.out.println("Сумма (разность) компл чисел = " + printArray(sum_res));

        double[] mul_res = MulOfKompleks(z1, z2);
        System.out.println("Произведение компл чисел = " + printArray(mul_res));

        String del_res = DelOfKompleks(z1, z2);
        System.out.println("Частное компл чисел = " + del_res);

    }




    public static double[] SumOfKompleks(double[] arr1, double[] arr2) {
        double[] res = new double[2];

        res[0] = arr1[0] + arr2[0];
        res[1] = arr1[1] + arr2[1];

        return res;
    }


    public static double[] MulOfKompleks(double[] arr1, double[] arr2) {
        double[] res = new double[2];

        double first_skob;
        first_skob = arr1[0] * arr2[0] - arr1[1]*arr2[1];
        double second_skob = arr1[1]*arr2[0]+arr1[0]*arr2[1];

        res[0] = first_skob;
        res[1] = second_skob;



        return res;
    }

    public static String DelOfKompleks(double[] arr1, double[] arr2){
        String res = "";

        double[] sopryag_chis = new double[2];
        sopryag_chis = Sopryag_Chis(arr2);

        double[] chisl = MulOfKompleks(arr1, sopryag_chis);
        double[] znam = MulOfKompleks(arr2, sopryag_chis);


        res = res + printArray(chisl) + " / " + printArray(znam);

        return res;
    }

    public static double[] Sopryag_Chis(double[] arr){
        double[] res = new double[2];

        double a = arr[0];
        double b = arr[1]*-1;

        res[0] = a;
        res[1] = b;
        return res;
    }


    public static String printArray(double[] arr){
        String res = "";
        for (int i = 0; i < arr.length; i++){
            res = res + arr[i] + " ";
        }
        return res;
    }

}