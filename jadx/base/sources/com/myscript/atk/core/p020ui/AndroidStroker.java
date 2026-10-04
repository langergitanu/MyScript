package com.myscript.atk.core.p020ui;

import android.graphics.Path;
import com.myscript.atk.core.InkStroke;
import com.myscript.atk.core.Transform;

/* JADX INFO: loaded from: classes4.dex */
public class AndroidStroker extends NativeStroker<Path> {
    private float pixelSize = 0.0f;
    private boolean smooth = true;
    private int stroking;
    private float width;

    public AndroidStroker(float f, int i) {
        this.width = f;
        this.stroking = i;
    }

    @Override // com.myscript.atk.core.p020ui.IStroker
    public void stroke(InkStroke inkStroke, Transform transform, Path path) {
        path.reset();
        if (inkStroke == null || inkStroke.getSampleCount() == 0) {
            return;
        }
        computePath(strokeBufferedFromInkStroke(InkStroke.getCPtr(inkStroke), Transform.getCPtr(transform), this.width, this.smooth, this.stroking, this.pixelSize), path);
        path.setFillType(Path.FillType.WINDING);
    }

    @Override // com.myscript.atk.core.p020ui.IStroker
    public void stroke(com.myscript.atk.core.Path path, Path path2) {
        path2.reset();
        if (path == null || path.empty()) {
            return;
        }
        computePath(strokeBufferedFromPath(com.myscript.atk.core.Path.getCPtr(path), this.width, this.smooth, this.stroking, this.pixelSize), path2);
        path2.setFillType(Path.FillType.WINDING);
    }

    private static void computePath(float[] fArr, Path path) {
        if (fArr == null) {
            return;
        }
        int i = 0;
        while (i < fArr.length) {
            try {
                int i2 = (int) fArr[i];
                if (i2 == 0) {
                    float f = fArr[i + 1];
                    i += 2;
                    path.moveTo(f, fArr[i]);
                } else if (i2 == 1) {
                    float f2 = fArr[i + 1];
                    i += 2;
                    path.lineTo(f2, fArr[i]);
                } else if (i2 == 2) {
                    float f3 = fArr[i + 1];
                    float f4 = fArr[i + 2];
                    float f5 = fArr[i + 3];
                    i += 4;
                    path.quadTo(f3, f4, f5, fArr[i]);
                } else if (i2 != 3) {
                    return;
                } else {
                    path.close();
                }
                i++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.myscript.atk.core.p020ui.IStroker
    public int getStroking() {
        return this.stroking;
    }

    @Override // com.myscript.atk.core.p020ui.IStroker
    public void setWidth(float f) {
        this.width = f;
    }

    @Override // com.myscript.atk.core.p020ui.IStroker
    public float getWidth() {
        return this.width;
    }

    @Override // com.myscript.atk.core.p020ui.IStroker
    public void setStroking(int i) {
        this.stroking = i;
    }

    public void setSmooth(boolean z) {
        this.smooth = z;
    }

    public boolean getSmooth() {
        return this.smooth;
    }

    public void setPixelSize(float f) {
        this.pixelSize = f;
    }
}
