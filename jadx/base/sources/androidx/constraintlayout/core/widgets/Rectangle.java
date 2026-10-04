package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes2.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x */
    public int f239x;

    /* JADX INFO: renamed from: y */
    public int f240y;

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f239x = i;
        this.f240y = i2;
        this.width = i3;
        this.height = i4;
    }

    void grow(int i, int i2) {
        this.f239x -= i;
        this.f240y -= i2;
        this.width += i * 2;
        this.height += i2 * 2;
    }

    boolean intersects(Rectangle rectangle) {
        int i;
        int i2;
        int i3 = this.f239x;
        int i4 = rectangle.f239x;
        return i3 >= i4 && i3 < i4 + rectangle.width && (i = this.f240y) >= (i2 = rectangle.f240y) && i < i2 + rectangle.height;
    }

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.f239x;
        return i >= i4 && i < i4 + this.width && i2 >= (i3 = this.f240y) && i2 < i3 + this.height;
    }

    public int getCenterX() {
        return (this.f239x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f240y + this.height) / 2;
    }
}
