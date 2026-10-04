package com.pdftron.pdf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class CurvePainter {
    public static final int DRAW_MODE_LINES = 1;
    public static final int DRAW_MODE_PATH = 0;

    /* JADX INFO: renamed from: a */
    private byte[] f1488a;

    /* JADX INFO: renamed from: b */
    private double[] f1489b;

    /* JADX INFO: renamed from: c */
    private double[] f1490c;

    /* JADX INFO: renamed from: d */
    private double[] f1491d;

    /* JADX INFO: renamed from: e */
    private double[] f1492e;

    /* JADX INFO: renamed from: f */
    private double[] f1493f;

    /* JADX INFO: renamed from: g */
    private double[] f1494g;

    /* JADX INFO: renamed from: h */
    private int f1495h;

    /* JADX INFO: renamed from: i */
    private int f1496i;

    /* JADX INFO: renamed from: j */
    private int f1497j;

    /* JADX INFO: renamed from: k */
    private boolean f1498k;

    /* JADX INFO: renamed from: l */
    private ArrayList<float[]> f1499l;

    /* JADX INFO: renamed from: m */
    private int f1500m;

    /* JADX INFO: renamed from: n */
    private Path f1501n;

    /* JADX INFO: renamed from: o */
    private Bitmap f1502o;

    /* JADX INFO: renamed from: p */
    private int[] f1503p;

    /* JADX INFO: renamed from: q */
    private Paint f1504q;

    /* JADX INFO: renamed from: r */
    private Paint f1505r;

    /* JADX INFO: renamed from: s */
    private int f1506s;

    /* JADX INFO: renamed from: t */
    private int f1507t;

    /* JADX INFO: renamed from: u */
    private float f1508u;

    /* JADX INFO: renamed from: v */
    private int f1509v;

    /* JADX INFO: renamed from: w */
    private boolean f1510w;

    /* JADX INFO: renamed from: x */
    private android.graphics.Rect f1511x;

    public static CurvePainter create(CurvePainter curvePainter) {
        CurvePainter curvePainter2;
        if (curvePainter == null) {
            return null;
        }
        if (curvePainter.getBuffer() != null) {
            curvePainter2 = new CurvePainter(curvePainter.getBuffer());
        } else {
            curvePainter2 = new CurvePainter(curvePainter.getBitmap());
        }
        curvePainter2.setRect(curvePainter.getRect());
        curvePainter2.setMultBlend(curvePainter.getMultBlend());
        return curvePainter2;
    }

    public CurvePainter(Bitmap bitmap) {
        this.f1489b = new double[2];
        this.f1490c = new double[2];
        this.f1491d = new double[2];
        this.f1492e = new double[2];
        this.f1493f = new double[2];
        this.f1494g = new double[6];
        this.f1495h = 0;
        this.f1496i = 0;
        this.f1497j = 0;
        this.f1500m = 0;
        m1145a();
        this.f1502o = bitmap;
    }

    public CurvePainter(String str) throws UnsupportedEncodingException {
        this.f1489b = new double[2];
        this.f1490c = new double[2];
        this.f1491d = new double[2];
        this.f1492e = new double[2];
        this.f1493f = new double[2];
        this.f1494g = new double[6];
        this.f1495h = 0;
        this.f1496i = 0;
        this.f1497j = 0;
        this.f1500m = 0;
        m1145a();
        this.f1488a = str.getBytes("US-ASCII");
    }

    public CurvePainter(int[] iArr) {
        int i;
        this.f1489b = new double[2];
        this.f1490c = new double[2];
        this.f1491d = new double[2];
        this.f1492e = new double[2];
        this.f1493f = new double[2];
        this.f1494g = new double[6];
        this.f1495h = 0;
        this.f1496i = 0;
        this.f1497j = 0;
        this.f1500m = 0;
        m1145a();
        this.f1503p = iArr;
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        if (length >= 0) {
            int i2 = iArr[length];
            i = 0;
            while (i < 4 && ((i2 >> ((3 - i) << 3)) & 255) == 0) {
                i++;
            }
        } else {
            i = 0;
        }
        this.f1488a = new byte[((length + 1) << 2) - i];
        if (length >= 0) {
            for (int i3 = 0; i3 < 4 - i; i3++) {
                this.f1488a[(length << 2) + i3] = (byte) (iArr[length] >> (i3 << 3));
            }
            for (int i4 = 0; i4 < length; i4++) {
                byte[] bArr = this.f1488a;
                int i5 = i4 * 4;
                int i6 = iArr[i4];
                bArr[i5] = (byte) i6;
                bArr[i5 + 1] = (byte) (i6 >> 8);
                bArr[i5 + 2] = (byte) (i6 >> 16);
                bArr[i5 + 3] = (byte) (i6 >>> 24);
            }
        }
        try {
            Log.d("painter", new String(this.f1488a, "US-ASCII"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1145a() {
        this.f1499l = new ArrayList<>();
        this.f1501n = new Path();
        Paint paint = new Paint();
        this.f1504q = paint;
        paint.setAntiAlias(true);
        this.f1504q.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(this.f1504q);
        this.f1505r = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f1505r.setColor(0);
    }

    public void setRect(android.graphics.Rect rect) {
        this.f1511x = rect;
    }

    public android.graphics.Rect getRect() {
        return this.f1511x;
    }

    public void setMultBlend(boolean z) {
        this.f1510w = z;
        if (z) {
            this.f1504q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.f1505r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        }
    }

    public boolean getMultBlend() {
        return this.f1510w;
    }

    public void draw(Canvas canvas, float f, float f2, double d, double d2, double d3, double d4) {
        this.f1509v = 0;
        double[] dArr = this.f1492e;
        dArr[0] = d;
        dArr[1] = d2;
        double[] dArr2 = this.f1491d;
        dArr2[0] = f;
        dArr2[1] = f2;
        double[] dArr3 = this.f1493f;
        dArr3[0] = d3;
        dArr3[1] = d4;
        this.f1506s = 0;
        this.f1508u = 0.0f;
        this.f1507t = 0;
        this.f1495h = 0;
        this.f1496i = 0;
        do {
            int i = 0;
            while (true) {
                double[] dArr4 = this.f1494g;
                if (i >= dArr4.length) {
                    break;
                }
                dArr4[i] = 0.0d;
                i++;
            }
            this.f1501n.reset();
            this.f1499l.clear();
            this.f1500m = 0;
            boolean zM1150b = false;
            while (this.f1495h < this.f1488a.length && !zM1150b) {
                zM1150b = m1150b();
            }
            this.f1505r.setColor(this.f1506s);
            if (this.f1506s != 0) {
                m1148a(canvas, this.f1509v, this.f1505r);
            }
            this.f1504q.setColor(this.f1507t);
            this.f1504q.setStrokeWidth(this.f1508u);
            if (this.f1508u > 0.0f && this.f1507t != 0) {
                m1148a(canvas, this.f1509v, this.f1504q);
            }
        } while (this.f1495h < this.f1488a.length);
    }

    /* JADX INFO: renamed from: a */
    private void m1148a(Canvas canvas, int i, Paint paint) {
        if (i == 0) {
            canvas.drawPath(this.f1501n, paint);
            return;
        }
        int i2 = 0;
        for (float[] fArr : this.f1499l) {
            int length = fArr.length;
            if (i2 == this.f1499l.size() - 1) {
                length = this.f1500m;
            }
            canvas.drawLines(fArr, 0, length, paint);
            i2++;
        }
    }

    public Bitmap getBitmap() {
        return this.f1502o;
    }

    public int[] getBuffer() {
        return this.f1503p;
    }

    /* JADX INFO: renamed from: b */
    private boolean m1150b() {
        int i;
        int i2;
        double[] dArr;
        double[] dArr2;
        double[] dArr3;
        double[] dArr4;
        char c;
        int i3;
        char c2;
        Paint.Join join;
        byte[] bArr = this.f1488a;
        int i4 = this.f1496i;
        byte b = bArr[i4];
        int i5 = 1;
        this.f1496i = i4 + 1;
        this.f1495h++;
        while (true) {
            i = this.f1496i;
            byte[] bArr2 = this.f1488a;
            if (i >= bArr2.length || bArr2[i] > 57) {
                break;
            }
            this.f1496i = i + 1;
        }
        if (b >= 65 && b <= 90) {
            b = (byte) (b + 32);
            this.f1498k = false;
        } else {
            this.f1498k = true;
        }
        char c3 = 5;
        char c4 = 4;
        int i6 = 2;
        if (b == 99) {
            int i7 = 2;
            int iM1152d = this.f1495h;
            while (true) {
                iM1152d = m1152d(m1152d(m1152d(iM1152d, 0), i5), i7);
                int i8 = this.f1497j;
                if (i8 == 0) {
                    double[] dArr5 = this.f1489b;
                    double[] dArr6 = this.f1490c;
                    dArr5[0] = dArr6[0];
                    dArr5[i5] = dArr6[i5];
                }
                this.f1497j = i8 + 1;
                double[] dArr7 = this.f1490c;
                double[] dArr8 = this.f1494g;
                double d = dArr8[4];
                dArr7[0] = d;
                double d2 = dArr8[c3];
                dArr7[i5] = d2;
                if (this.f1509v == 0) {
                    i2 = i5;
                    this.f1501n.cubicTo((float) dArr8[0], (float) dArr8[i5], (float) dArr8[2], (float) dArr8[3], (float) d, (float) d2);
                } else {
                    i2 = i5;
                }
                if (iM1152d >= this.f1496i) {
                    break;
                }
                i7 = 2;
                i5 = i2;
                c3 = 5;
            }
            double[] dArr9 = this.f1494g;
            dArr9[0] = dArr9[2];
            dArr9[i2] = dArr9[3];
        } else {
            if (b == 101) {
                this.f1495h = i;
                return true;
            }
            if (b == 104) {
                int iM1143a = this.f1495h;
                do {
                    iM1143a = m1143a(iM1143a, 0);
                    int i9 = this.f1497j;
                    if (i9 == 0) {
                        double[] dArr10 = this.f1489b;
                        double[] dArr11 = this.f1490c;
                        dArr10[0] = dArr11[0];
                        dArr10[1] = dArr11[1];
                    }
                    this.f1497j = i9 + 1;
                    if (this.f1509v == 1) {
                        m1146a(this.f1490c[0]);
                        m1146a(this.f1490c[1]);
                        m1146a(this.f1494g[0]);
                        m1146a(this.f1490c[1]);
                    }
                    if (this.f1509v == 0) {
                        this.f1501n.lineTo((float) this.f1494g[0], (float) this.f1490c[1]);
                    }
                    dArr = this.f1490c;
                    dArr2 = this.f1494g;
                    dArr[0] = dArr2[0];
                } while (iM1143a < this.f1496i);
                dArr2[1] = dArr[1];
            } else if (b == 118) {
                int iM1143a2 = this.f1495h;
                do {
                    iM1143a2 = m1143a(iM1143a2, 1);
                    int i10 = this.f1497j;
                    if (i10 == 0) {
                        double[] dArr12 = this.f1489b;
                        double[] dArr13 = this.f1490c;
                        dArr12[0] = dArr13[0];
                        dArr12[1] = dArr13[1];
                    }
                    this.f1497j = i10 + 1;
                    if (this.f1509v == 1) {
                        m1146a(this.f1490c[0]);
                        m1146a(this.f1490c[1]);
                        m1146a(this.f1490c[0]);
                        m1146a(this.f1494g[1]);
                    }
                    if (this.f1509v == 0) {
                        this.f1501n.lineTo((float) this.f1490c[0], (float) this.f1494g[1]);
                    }
                    dArr3 = this.f1490c;
                    dArr4 = this.f1494g;
                    dArr3[1] = dArr4[1];
                } while (iM1143a2 < this.f1496i);
                dArr4[0] = dArr3[0];
            } else if (b == 108) {
                m1147a(this.f1495h);
            } else if (b == 109) {
                int iM1152d2 = m1152d(this.f1495h, 0);
                double[] dArr14 = this.f1490c;
                double[] dArr15 = this.f1494g;
                double d3 = dArr15[0];
                dArr14[0] = d3;
                double d4 = dArr15[1];
                dArr14[1] = d4;
                if (this.f1509v == 0) {
                    this.f1501n.moveTo((float) d3, (float) d4);
                }
                this.f1497j = 0;
                if (iM1152d2 != this.f1496i) {
                    m1147a(iM1152d2);
                }
            } else if (b == 115 || b == 116) {
                int iM1152d3 = this.f1495h;
                while (true) {
                    iM1152d3 = m1152d(m1152d(iM1152d3, 1), i6);
                    int i11 = this.f1497j;
                    if (i11 == 0) {
                        double[] dArr16 = this.f1489b;
                        double[] dArr17 = this.f1490c;
                        dArr16[0] = dArr17[0];
                        dArr16[1] = dArr17[1];
                    }
                    this.f1497j = i11 + 1;
                    double[] dArr18 = this.f1490c;
                    double[] dArr19 = this.f1494g;
                    double d5 = dArr19[c4];
                    dArr18[0] = d5;
                    double d6 = dArr19[5];
                    dArr18[1] = d6;
                    if (this.f1509v == 0) {
                        c = c4;
                        i3 = i6;
                        c2 = 3;
                        this.f1501n.cubicTo((float) dArr19[0], (float) dArr19[1], (float) dArr19[i3], (float) dArr19[3], (float) d5, (float) d6);
                    } else {
                        c = c4;
                        i3 = i6;
                        c2 = 3;
                    }
                    double[] dArr20 = this.f1494g;
                    dArr20[0] = dArr20[i3];
                    dArr20[1] = dArr20[c2];
                    if (iM1152d3 >= this.f1496i) {
                        break;
                    }
                    c4 = c;
                    i6 = i3;
                }
            } else if (b == 122) {
                if (this.f1497j > 0) {
                    if (this.f1509v == 1) {
                        m1146a(this.f1490c[0]);
                        m1146a(this.f1490c[1]);
                        m1146a(this.f1489b[0]);
                        m1146a(this.f1489b[1]);
                    }
                    if (this.f1509v == 0) {
                        Path path = this.f1501n;
                        double[] dArr21 = this.f1489b;
                        path.lineTo((float) dArr21[0], (float) dArr21[1]);
                        this.f1501n.close();
                    }
                    double[] dArr22 = this.f1490c;
                    double[] dArr23 = this.f1489b;
                    dArr22[0] = dArr23[0];
                    dArr22[1] = dArr23[1];
                }
                this.f1497j = 0;
            } else if (b == 123) {
                while (true) {
                    int i12 = this.f1496i;
                    byte[] bArr3 = this.f1488a;
                    if (i12 < bArr3.length && bArr3[i12] != 125) {
                        this.f1496i = i12 + 1;
                    } else {
                        try {
                            int i13 = this.f1495h;
                            String str = new String(this.f1488a, i13, this.f1496i - i13, "US-ASCII");
                            int iIndexOf = str.indexOf(58) + 1;
                            char cCharAt = str.charAt(0);
                            char cCharAt2 = iIndexOf > 2 ? str.charAt(1) : (char) 0;
                            if (cCharAt2 == 0) {
                                if (cCharAt == 'w') {
                                    double dDoubleValue = Double.valueOf(str.substring(iIndexOf)).doubleValue();
                                    double[] dArr24 = this.f1493f;
                                    this.f1508u = (float) (dDoubleValue * (dArr24[0] + dArr24[1]) * 0.5d);
                                } else if (cCharAt == 's') {
                                    this.f1507t = (int) Long.parseLong(str.substring(iIndexOf), 16);
                                } else if (cCharAt == 'f') {
                                    this.f1506s = (int) Long.parseLong(str.substring(iIndexOf), 16);
                                } else if (cCharAt == 'h') {
                                    double dDoubleValue2 = Double.valueOf(str.substring(iIndexOf)).doubleValue();
                                    double[] dArr25 = this.f1492e;
                                    dArr25[0] = dArr25[0] * dDoubleValue2;
                                    double[] dArr26 = this.f1493f;
                                    dArr26[0] = dArr26[0] * dDoubleValue2;
                                } else if (cCharAt == 'v') {
                                    double dDoubleValue3 = Double.valueOf(str.substring(iIndexOf)).doubleValue();
                                    double[] dArr27 = this.f1492e;
                                    dArr27[1] = dArr27[1] * dDoubleValue3;
                                    double[] dArr28 = this.f1493f;
                                    dArr28[1] = dArr28[1] * dDoubleValue3;
                                } else if (cCharAt == 'm') {
                                    if (str.charAt(iIndexOf) == 'l') {
                                        this.f1509v = 1;
                                    }
                                } else if (cCharAt == 'j') {
                                    Paint paint = this.f1504q;
                                    char cCharAt3 = str.charAt(iIndexOf);
                                    if (cCharAt3 == 'r') {
                                        join = Paint.Join.ROUND;
                                    } else if (cCharAt3 == 'b') {
                                        join = Paint.Join.BEVEL;
                                    } else {
                                        join = Paint.Join.MITER;
                                    }
                                    paint.setStrokeJoin(join);
                                }
                            } else if (cCharAt == 's' && cCharAt2 == 'c') {
                                this.f1504q.setStrokeCap(m1144a(str.charAt(iIndexOf)));
                            } else if (cCharAt == 'e' && cCharAt2 == 'c') {
                                this.f1504q.setStrokeCap(m1144a(str.charAt(iIndexOf)));
                            } else if (cCharAt == 'm' && cCharAt2 == 'l') {
                                this.f1504q.setStrokeMiter((float) Double.valueOf(str.substring(iIndexOf)).doubleValue());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.f1496i++;
                    }
                }
            }
        }
        this.f1495h = this.f1496i;
        return false;
    }

    /* JADX INFO: renamed from: a */
    private int m1143a(int i, int i2) {
        byte b;
        int i3 = i + 1;
        while (i3 < this.f1496i && (b = this.f1488a[i3]) != 44 && b != 32 && b != 45) {
            try {
                i3++;
            } catch (Exception unused) {
            }
        }
        this.f1494g[i2] = Float.valueOf(new String(this.f1488a, i, i3 - i)).floatValue();
        double[] dArr = this.f1494g;
        int i4 = i2 & 1;
        double d = dArr[i2] * this.f1492e[i4];
        dArr[i2] = d;
        if (this.f1498k) {
            dArr[i2] = d + this.f1490c[i4];
        } else {
            dArr[i2] = d + this.f1491d[i4];
        }
        if (i3 != this.f1496i && this.f1488a[i3] == 44) {
            i3++;
        }
        while (i3 < this.f1496i && this.f1488a[i3] == 32) {
            i3++;
        }
        return i3;
    }

    /* JADX INFO: renamed from: b */
    private int m1149b(int i, int i2) {
        return m1143a(i, i2 << 1);
    }

    /* JADX INFO: renamed from: c */
    private int m1151c(int i, int i2) {
        return m1143a(i, (i2 << 1) + 1);
    }

    /* JADX INFO: renamed from: d */
    private int m1152d(int i, int i2) {
        return m1151c(m1149b(i, i2), i2);
    }

    /* JADX INFO: renamed from: a */
    private static Paint.Cap m1144a(char c) {
        if (c == 'r') {
            return Paint.Cap.ROUND;
        }
        if (c == 's') {
            return Paint.Cap.SQUARE;
        }
        return Paint.Cap.BUTT;
    }

    /* JADX INFO: renamed from: a */
    private void m1147a(int i) {
        do {
            i = m1152d(i, 0);
            int i2 = this.f1497j;
            if (i2 == 0) {
                double[] dArr = this.f1489b;
                double[] dArr2 = this.f1490c;
                dArr[0] = dArr2[0];
                dArr[1] = dArr2[1];
            }
            this.f1497j = i2 + 1;
            int i3 = this.f1509v;
            if (i3 == 1) {
                m1146a(this.f1490c[0]);
                m1146a(this.f1490c[1]);
                m1146a(this.f1494g[0]);
                m1146a(this.f1494g[1]);
            } else if (i3 == 0) {
                Path path = this.f1501n;
                double[] dArr3 = this.f1494g;
                path.lineTo((float) dArr3[0], (float) dArr3[1]);
            }
            double[] dArr4 = this.f1490c;
            double[] dArr5 = this.f1494g;
            dArr4[0] = dArr5[0];
            dArr4[1] = dArr5[1];
        } while (i < this.f1496i);
    }

    /* JADX INFO: renamed from: a */
    private void m1146a(double d) {
        try {
            if (this.f1499l.size() == 0 || this.f1500m == 4096) {
                this.f1499l.add(new float[4096]);
                this.f1500m = 0;
            }
            int size = this.f1499l.size() - 1;
            float[] fArr = this.f1499l.get(size > 0 ? size : 0);
            int i = this.f1500m;
            this.f1500m = i + 1;
            fArr[i] = (float) d;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
