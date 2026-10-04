package org.ejml.data;

/* JADX INFO: loaded from: classes9.dex */
public class IGrowArray {
    public int[] data;
    public int length;

    public IGrowArray(int i) {
        this.data = new int[i];
        this.length = i;
    }

    public IGrowArray() {
        this(0);
    }

    public int length() {
        return this.length;
    }

    public void reshape(int i) {
        if (this.data.length < i) {
            this.data = new int[i];
        }
        this.length = i;
    }

    public int get(int i) {
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
        this.data = new int[0];
        this.length = 0;
    }
}
