package org.ejml.ops;

/* JADX INFO: loaded from: classes9.dex */
public class SortCoupledArray_F32 {
    int[] tmp = new int[0];
    int[] copyA = new int[0];
    float[] copyB = new float[0];
    QuickSort_S32 quicksort = new QuickSort_S32();

    public void quick(int[] iArr, int i, int[] iArr2, float[] fArr) {
        for (int i2 = 1; i2 < i; i2++) {
            int i3 = iArr[i2 - 1];
            quick(i3, iArr[i2] - i3, iArr2, fArr);
        }
    }

    private void quick(int i, int i2, int[] iArr, float[] fArr) {
        if (i2 <= 1) {
            return;
        }
        if (this.tmp.length < i2) {
            int i3 = (i2 * 2) + 1;
            this.tmp = new int[i3];
            this.copyA = new int[i3];
            this.copyB = new float[i3];
        }
        System.arraycopy(iArr, i, this.copyA, 0, i2);
        System.arraycopy(fArr, i, this.copyB, 0, i2);
        if (i2 > 50) {
            this.quicksort.sort(this.copyA, i2, this.tmp);
        } else {
            shellSort(this.copyA, 0, i2, this.tmp);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i + i4;
            int[] iArr2 = this.copyA;
            int[] iArr3 = this.tmp;
            iArr[i5] = iArr2[iArr3[i4]];
            fArr[i5] = this.copyB[iArr3[i4]];
        }
    }

    public static void shellSort(int[] iArr, int i, int i2, int[] iArr2) {
        int i3;
        for (int i4 = 0; i4 < i2; i4++) {
            iArr2[i4] = i + i4;
        }
        int i5 = 1;
        do {
            i5 = (i5 * 3) + 1;
        } while (i5 <= i2);
        do {
            i5 /= 3;
            for (int i6 = i5; i6 < i2; i6++) {
                int i7 = iArr2[i6];
                int i8 = iArr[i7];
                int i9 = i6;
                do {
                    i3 = i9 - i5;
                    int i10 = iArr2[i3];
                    if (iArr[i10] > i8) {
                        iArr2[i9] = i10;
                        i9 = i3;
                    }
                    iArr2[i9] = i7;
                } while (i3 >= i5);
                iArr2[i9] = i7;
            }
        } while (i5 > 1);
    }
}
