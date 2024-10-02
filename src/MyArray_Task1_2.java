import java.util.Arrays;

public class MyArray_Task1_2 {
    private int[] array;
    public MyArray_Task1_2(int[] array){

        this.array = array;
    }


    // Phương thức tìm các giá trị bị thiếu trong mảng
    public int[] getMissingValues(int[] arr) {
        int size = 0;
        int[] result = new int[500]; // Tạo mảng tạm

        // Duyệt qua mảng và kiểm tra hiệu của hai số liền kề
        for (int i =0; i< arr.length-1; i++){
            int current = arr[i];
            int nextEle = arr[i+1];

            // Nếu hiệu giữa hai số liền kề >1 suy ra có 1 số bị thiếu ở giữa
            while (nextEle - current > 1){
                current++;
                result[size++] = current; // Thêm số bị thiếu vào mảng kết quả
            }
        }
        // Rút gọn mảng
        int[] finalResult = new int[size];
        for (int i = 0; i < size; i++){
            finalResult[i] = result[i];
        }
        return finalResult;
    }
    // Phương thức điền giá trị tại ví trí -1 bằng trung bình cộng của các giá trị lân cận bên trái và phải của -1

    // Hàm điền giá trị còn thiếu bằng trung bình của k phần tử lân cận
    public int[] fillMissingValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Nếu giá trị phần tử là -1 thì cần xử lý
            if (arr[i] == -1) {
                int avg1 = 0;
                int avg2 = 0;

                if (i - 2 >= 0 && i + 1 < arr.length) {
                    avg1 = (arr[i - 2] + arr[i - 1] + arr[i + 1]) / 3;
                }
                if (i - 1 >= 0 && i + 2 < arr.length) {
                    avg1 = (arr[i - 1] + arr[i + 2] + arr[i + 1]) / 3;
                }
                if (avg1 != 0 && avg2 != 0) {
                    arr[i] = Math.min(avg1, avg2);
                } else if (avg1 != 0) {
                    arr[i] = avg1;
                } else if (avg2 != 0) {
                    arr[i] = avg2;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {10,11,12,13,14,16,17,19,20};
        int[] array2 = {10,11,12,-1,14,16,17,19,20};

        MyArray_Task1_2 myArrayTask12 = new MyArray_Task1_2(array);
        MyArray_Task1_2 myArrayTask121 = new MyArray_Task1_2(array2);

        int[] getMissingValues = myArrayTask12.getMissingValues(array);
        System.out.println("Các phần tử bị thiếu là:" + getMissingValues);

        int[] fillMissingValues = myArrayTask121.fillMissingValues(array2);
        System.out.println("Mảng có dạng là:" + Arrays.toString(fillMissingValues));

    }
}
