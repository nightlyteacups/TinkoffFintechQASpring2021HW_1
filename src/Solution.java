public class Solution {
    public static void main(String[] args) {
        int[] array1 = {24, 15, 7, 20, 5, 1, 12, 14, 8};
        int[] array2 = {16, 42, 15, 4, 23, 8};
        int[] array3 = {4, 4, 4, 4};
        int[] array4 = {2, 1};
        int[] array5 = {1};
        int[] array6 = {};

        array1 = Thanos_Sort(array1);
        array2 = Thanos_Sort(array2);
        array3 = Thanos_Sort(array3);
        array4 = Thanos_Sort(array4);
        array5 = Thanos_Sort(array5);
        array6 = Thanos_Sort(array6);

        Output_Array(array1);
        Output_Array(array2);
        Output_Array(array3);
        Output_Array(array4);
        Output_Array(array5);
        Output_Array(array6);
    }

    public static int[] Thanos_Sort(int[] mass) {
        if (mass.length > 0) {
            Sort_Part(mass, 0, mass.length - 1);
        }
        return mass;
    }

    public static void Sort_Part(int[] mass, int start, int end) {
        int sum = 0;
        double avg = 0.0;
        for (int i = start; i <= end; i++) {
            sum += mass[i];
        }
        avg = sum / (end - start + 1);
        int tmp_mass[] = new int[end - start + 1];
        int l = 0;                        // левая граница массива
        int r = tmp_mass.length - 1;      // правая граница массива
        for (int i = start; i <= end; i++) {
            if (mass[i] <= avg) {
                tmp_mass[l++] = mass[i];
            } else {
                tmp_mass[r--] = mass[i];
            }
        }
        int j = 0;
        for (int i = start; i <= end; i++) {
            mass[i] = tmp_mass[j++];
        }
        int half = (end - start + 1) / 2;
        if (half != 0 && l != tmp_mass.length) {
            Sort_Part(mass, start, --l + (end - tmp_mass.length + 1));
            Sort_Part(mass, ++r + (end - tmp_mass.length + 1), end);
        }
    }

    public static void Output_Array(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println();
    }
}