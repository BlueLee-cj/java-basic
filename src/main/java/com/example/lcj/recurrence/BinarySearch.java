package com.example.lcj.recurrence;

public class BinarySearch {
    /**
     * @param array  Ŀ������
     * @param low    ��߽�
     * @param high   �ұ߽�
     * @param target Ŀ��ֵ
     * @return Ŀ��ֵ����λ��
     * @description ���ֲ��ҵĵݹ�ʵ��
     * @author rico
     */
    public static int binarySearch(int[] array, int low, int high, int target) {

        //�ݹ���ֹ����
        if (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] == target) {
                return mid + 1;  // ����Ŀ��ֵ��λ�ã���1��ʼ
            } else if (array[mid] > target) {
                // ����array[mid]����Ŀ��ֵ������ٴεݹ�����ʱ�����Խ����ų�
                binarySearch(array, low, mid - 1, target);
            } else {
                // ����array[mid]����Ŀ��ֵ������ٴεݹ�����ʱ�����Խ����ų�
                binarySearch(array, mid + 1, high, target);
            }
        }
        return -1;   //��ʾû��������
    }

    //--------------------------------���Ƿָ���-------------------------------------

    /**
     * @param array  Ŀ������
     * @param low    ��߽�
     * @param high   �ұ߽�
     * @param target Ŀ��ֵ
     * @return Ŀ��ֵ����λ��
     * @description ���ֲ��ҵķǵݹ�ʵ��
     * @author rico
     */
    public static int binarySearchNoRecursive(int[] array, int low, int high, int target) {

        // ѭ��
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] == target) {
                return mid + 1; // ����Ŀ��ֵ��λ�ã���1��ʼ
            } else if (array[mid] > target) {
                // ����array[mid]����Ŀ��ֵ������ٴεݹ�����ʱ�����Խ����ų�
                high = mid - 1;
            } else {
                // ����array[mid]����Ŀ��ֵ������ٴεݹ�����ʱ�����Խ����ų�
                low = mid + 1;
            }
        }
        return -1;  //��ʾû��������
    }

    public static void main(String[] args) {
        int[] arry = {1, 3, 6, 11, 13, 56};
        System.out.println(binarySearch(arry, 0, 5, 3));
        System.out.println(binarySearchNoRecursive(arry, 0, 5, 3));
    }
}
