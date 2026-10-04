package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class LayoutGrid {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LayoutGrid(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutGrid layoutGrid) {
        if (layoutGrid == null) {
            return 0L;
        }
        return layoutGrid.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_LayoutGrid(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static class StyleProperties {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public StyleProperties(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(StyleProperties styleProperties) {
            if (styleProperties == null) {
                return 0L;
            }
            return styleProperties.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboEngineJNI.delete_LayoutGrid_StyleProperties(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public void setRem(float f) {
            NeboEngineJNI.LayoutGrid_StyleProperties_rem_set(this.swigCPtr, this, f);
        }

        public float getRem() {
            return NeboEngineJNI.LayoutGrid_StyleProperties_rem_get(this.swigCPtr, this);
        }

        public void setFontSize(float f) {
            NeboEngineJNI.LayoutGrid_StyleProperties_fontSize_set(this.swigCPtr, this, f);
        }

        public float getFontSize() {
            return NeboEngineJNI.LayoutGrid_StyleProperties_fontSize_get(this.swigCPtr, this);
        }

        public void setLineHeight(float f) {
            NeboEngineJNI.LayoutGrid_StyleProperties_lineHeight_set(this.swigCPtr, this, f);
        }

        public float getLineHeight() {
            return NeboEngineJNI.LayoutGrid_StyleProperties_lineHeight_get(this.swigCPtr, this);
        }

        public void setCompact(boolean z) {
            NeboEngineJNI.LayoutGrid_StyleProperties_compact_set(this.swigCPtr, this, z);
        }

        public boolean getCompact() {
            return NeboEngineJNI.LayoutGrid_StyleProperties_compact_get(this.swigCPtr, this);
        }

        public StyleProperties() {
            this(NeboEngineJNI.new_LayoutGrid_StyleProperties(), true);
        }
    }

    public LayoutGrid() {
        this(NeboEngineJNI.new_LayoutGrid(), true);
    }

    public boolean set(float f, float f2, int i, float f3, float f4, float f5, float f6, float f7, boolean z, String str) {
        return NeboEngineJNI.LayoutGrid_set__SWIG_0(this.swigCPtr, this, f, f2, i, f3, f4, f5, f6, f7, z, str.getBytes());
    }

    public boolean set(LayoutGrid layoutGrid) {
        return NeboEngineJNI.LayoutGrid_set__SWIG_1(this.swigCPtr, this, getCPtr(layoutGrid), layoutGrid);
    }

    public float columnFirst() {
        return NeboEngineJNI.LayoutGrid_columnFirst(this.swigCPtr, this);
    }

    public float columnGap() {
        return NeboEngineJNI.LayoutGrid_columnGap(this.swigCPtr, this);
    }

    public int columnCount() {
        return NeboEngineJNI.LayoutGrid_columnCount(this.swigCPtr, this);
    }

    public float columnGutter() {
        return NeboEngineJNI.LayoutGrid_columnGutter(this.swigCPtr, this);
    }

    public float lineFirst() {
        return NeboEngineJNI.LayoutGrid_lineFirst(this.swigCPtr, this);
    }

    public float lineGap() {
        return NeboEngineJNI.LayoutGrid_lineGap(this.swigCPtr, this);
    }

    public float lineHeight() {
        return NeboEngineJNI.LayoutGrid_lineHeight(this.swigCPtr, this);
    }

    public float fontSize() {
        return NeboEngineJNI.LayoutGrid_fontSize(this.swigCPtr, this);
    }

    public boolean compact() {
        return NeboEngineJNI.LayoutGrid_compact(this.swigCPtr, this);
    }

    public String guideLinesBig() {
        return new String(NeboEngineJNI.LayoutGrid_guideLinesBig(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public float rem() {
        return NeboEngineJNI.LayoutGrid_rem(this.swigCPtr, this);
    }

    public StyleProperties styleProperties() {
        return new StyleProperties(NeboEngineJNI.LayoutGrid_styleProperties(this.swigCPtr, this), true);
    }

    public float lastColumn() {
        return NeboEngineJNI.LayoutGrid_lastColumn(this.swigCPtr, this);
    }

    public float width() {
        return NeboEngineJNI.LayoutGrid_width(this.swigCPtr, this);
    }

    public float fullWidth() {
        return NeboEngineJNI.LayoutGrid_fullWidth(this.swigCPtr, this);
    }

    public float line(int i) {
        return NeboEngineJNI.LayoutGrid_line(this.swigCPtr, this, i);
    }

    public float column(int i) {
        return NeboEngineJNI.LayoutGrid_column(this.swigCPtr, this, i);
    }

    public float columnGutterLeft(int i) {
        return NeboEngineJNI.LayoutGrid_columnGutterLeft(this.swigCPtr, this, i);
    }

    public float columnGutterRight(int i) {
        return NeboEngineJNI.LayoutGrid_columnGutterRight(this.swigCPtr, this, i);
    }

    public int columnIndexAt(float f) {
        return NeboEngineJNI.LayoutGrid_columnIndexAt(this.swigCPtr, this, f);
    }

    public int lineIndexAt(float f) {
        return NeboEngineJNI.LayoutGrid_lineIndexAt(this.swigCPtr, this, f);
    }

    public float columnAt(float f) {
        return NeboEngineJNI.LayoutGrid_columnAt(this.swigCPtr, this, f);
    }

    public float columnGutterLeftAt(float f) {
        return NeboEngineJNI.LayoutGrid_columnGutterLeftAt(this.swigCPtr, this, f);
    }

    public float columnGutterRightAt(float f) {
        return NeboEngineJNI.LayoutGrid_columnGutterRightAt(this.swigCPtr, this, f);
    }

    public float lineAt(float f) {
        return NeboEngineJNI.LayoutGrid_lineAt(this.swigCPtr, this, f);
    }

    public int columnClosestIndexAt(float f) {
        return NeboEngineJNI.LayoutGrid_columnClosestIndexAt(this.swigCPtr, this, f);
    }

    public int lineClosestIndexAt(float f) {
        return NeboEngineJNI.LayoutGrid_lineClosestIndexAt(this.swigCPtr, this, f);
    }

    public float columnClosestAt(float f) {
        return NeboEngineJNI.LayoutGrid_columnClosestAt(this.swigCPtr, this, f);
    }

    public float lineClosestAt(float f) {
        return NeboEngineJNI.LayoutGrid_lineClosestAt(this.swigCPtr, this, f);
    }

    public float snapLineAt(float f, float f2) {
        return NeboEngineJNI.LayoutGrid_snapLineAt__SWIG_0(this.swigCPtr, this, f, f2);
    }

    public float snapLineAt(float f) {
        return NeboEngineJNI.LayoutGrid_snapLineAt__SWIG_1(this.swigCPtr, this, f);
    }
}
