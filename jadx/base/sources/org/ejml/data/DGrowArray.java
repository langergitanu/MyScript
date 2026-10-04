package org.ejml.data;

/* JADX INFO: loaded from: classes9.dex */
public class DGrowArray {
    public double[] data;
    public int length;

    public DGrowArray(int i) {
        this.data = new double[i];
        this.length = i;
    }

    public DGrowArray() {
        this(0);
    }

    public int length() {
        return this.length;
    }

    public void reshape(int i) {
        if (this.data.length < i) {
            this.data = new double[i];
        }
        this.length = i;
    }

    public double get(int i) {
        if (i < 0 || i >= this.length) {
            throw new IllegalArgumentException("Out of bounds");
        }
        return this.data[i];
    }

    public void set(int i, int i2) {
        if (i < 0 || i >= this.length) {
            throw new IllegalArgumentException("Out of bounds");
        }
        this.data[i] = i2;
    }

    public void free() {
        this.data = new double[0];
        this.length = 0;
    }
}
