package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class TypesetItem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public TypesetItem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(TypesetItem typesetItem) {
        if (typesetItem == null) {
            return 0L;
        }
        return typesetItem.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_TypesetItem(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public int getStrokeCount() {
        return ATKCoreJNI.TypesetItem_getStrokeCount(this.swigCPtr, this);
    }

    public InkStroke getStrokeAt(int i) {
        return new InkStroke(ATKCoreJNI.TypesetItem_getStrokeAt(this.swigCPtr, this, i), true);
    }

    public String getLabel() {
        return new String(ATKCoreJNI.TypesetItem_getLabel(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public Parallelogram getParallelogram() {
        return new Parallelogram(ATKCoreJNI.TypesetItem_getParallelogram(this.swigCPtr, this), true);
    }

    public boolean hasLines() {
        return ATKCoreJNI.TypesetItem_hasLines(this.swigCPtr, this);
    }

    public GlyphLines getLines() {
        return new GlyphLines(ATKCoreJNI.TypesetItem_getLines(this.swigCPtr, this), true);
    }

    public int getAlternateCount() {
        return ATKCoreJNI.TypesetItem_getAlternateCount(this.swigCPtr, this);
    }

    public void getData(Object obj, long j) {
        ATKCoreJNI.TypesetItem_getData(this.swigCPtr, this, obj, j);
    }

    public InkDecorationType getFirstDecoration() {
        return InkDecorationType.swigToEnum(ATKCoreJNI.TypesetItem_getFirstDecoration(this.swigCPtr, this));
    }

    public InkDecorationType getLastDecoration() {
        return InkDecorationType.swigToEnum(ATKCoreJNI.TypesetItem_getLastDecoration(this.swigCPtr, this));
    }

    public Extent getExtent() {
        return new Extent(ATKCoreJNI.TypesetItem_getExtent(this.swigCPtr, this), true);
    }

    public int getType() {
        return ATKCoreJNI.TypesetItem_getType(this.swigCPtr, this);
    }

    public void setGlyphGeometry(Parallelogram parallelogram, GlyphLines glyphLines) {
        ATKCoreJNI.TypesetItem_setGlyphGeometry(this.swigCPtr, this, Parallelogram.getCPtr(parallelogram), parallelogram, GlyphLines.getCPtr(glyphLines), glyphLines);
    }

    public void setPrimitiveData(Object obj, long j) {
        ATKCoreJNI.TypesetItem_setPrimitiveData(this.swigCPtr, this, obj, j);
    }

    public TypesetItem(TypesetItem typesetItem) {
        this(ATKCoreJNI.new_TypesetItem(getCPtr(typesetItem), typesetItem), true);
    }
}
