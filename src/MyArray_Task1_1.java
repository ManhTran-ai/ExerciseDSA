import java.util.Arrays;

public class MyArray_Task1_1 {
    private int[] array;
    public MyArray_Task1_1(int[] array){

        this.array = array;
    }

    // Phương thức tạo 1 mảng có độ dài gấp đôi mảng đầu, nửa cuối của mảng là mảng đầu được đảo ngược
    public int[] mirror() {
        int[] mirroredArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            mirroredArray[i] = array[i];
            mirroredArray[mirroredArray.length - 1 - i] = array[i];
        }
        return mirroredArray;
    }


    // Phương thức giữ nguyên thứ tự phần tử khi loại bỏ các phần tử trùng lặp -> mảng mới
    public int[] removeDuplicates(int[] inputArray) {
        // Tạo mảng lưu các giá trị ko trùng
        int[] resultArray = new int[inputArray.length];
        int resultIndex = 0;


        for (int i = 0; i < inputArray.length; i++) {
            boolean isDuplicate = false;

            // Kiểm tra phần tử có tồn tại trong mảng result chưa
            for (int j = 0; j < resultIndex; j++) {
                if (inputArray[i] == resultArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // Nếu không trùng thì thêm vào mảng
            if (!isDuplicate) {
                resultArray[resultIndex] = inputArray[i];
                resultIndex++;
            }
        }

        // Tạo mảng kết quả cuối cùng
        int[] finalResult = new int[resultIndex];
        for (int i = 0; i < resultIndex; i++) {
            finalResult[i] = resultArray[i];
        }

        return finalResult;
    }


    // Phương thức ktra phần tử có nhỏ hơn hoặc bằng phần tử kế tiếp không
    public boolean isSorted(int[] array) {
        // Mảng 2 phần tử là mảng đã đc sắp xếp
        if (array.length < 2)
            return true;

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        // So từng phần tử trong mảng
        for (int i =1; i < array.length; i++) {
            if (array[i] <= array[i - 1]){
                isIncreasing = false;//
            }
            if (array[i] >= array[i - 1] );
            isDecreasing = false;

        }
        return isIncreasing || isDecreasing;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] array2 = {1, 3, 5, 1, 3, 7, 9, 8};
        int[] array3 = {10, 11, 12, 13, 14, 16, 17, 19, 20};

        MyArray_Task1_1 myArray = new MyArray_Task1_1(array);
        MyArray_Task1_1 myArray2 = new MyArray_Task1_1(array2);
        MyArray_Task1_1 myArray3 = new MyArray_Task1_1(array3);

        int[] mirrorArray = myArray.mirror();
        System.out.println("MirrorArray có dạng là: " + Arrays.toString(mirrorArray));

        int[] duplicateArray = myArray2.removeDuplicates(array2);
        System.out.println("DuplicateArray có dạng là: " + Arrays.toString(duplicateArray));

        boolean sortedArray = myArray3.isSorted(array3);
        System.out.println(sortedArray);


    }
}
