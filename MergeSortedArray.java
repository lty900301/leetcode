/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * @author joshluo
 * 
 */
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        assert (A != null && B != null && A.length >= m + n && B.length >= n);
        int indexA = m - 1, indexB = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (indexA >= 0 && indexB >= 0) {
                if (B[indexB] > A[indexA]) {
                    A[i] = B[indexB--];
                } else {
                    A[i] = A[indexA--];
                }
            } else if (indexA >= 0 || indexB >= 0) {
                A[i] = indexA >= 0 ? A[indexA--] : B[indexB--];
            } else {
                break;
            }
        }
        if (A.length > m + n) {
            for (int i = 0; i < A.length; i++) {
                A[i] = A[A.length - m - n + i];
            }
        }
    }

}
