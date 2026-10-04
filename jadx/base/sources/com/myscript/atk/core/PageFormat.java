package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class PageFormat {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PageFormat(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PageFormat pageFormat) {
        if (pageFormat == null) {
            return 0L;
        }
        return pageFormat.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_PageFormat(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static PageFormat build(Formats formats) {
        return new PageFormat(ATKCoreJNI.PageFormat_build(formats.swigValue()), true);
    }

    public static Formats formatsFromLocale(boolean z) {
        return Formats.swigToEnum(ATKCoreJNI.PageFormat_formatsFromLocale(z));
    }

    public PageFormat(float f, float f2, float f3, float f4, float f5, float f6) {
        this(ATKCoreJNI.new_PageFormat__SWIG_0(f, f2, f3, f4, f5, f6), true);
    }

    public PageFormat(float f, float f2, float f3) {
        this(ATKCoreJNI.new_PageFormat__SWIG_1(f, f2, f3), true);
    }

    public void setPageWidth(float f) {
        ATKCoreJNI.PageFormat_pageWidth_set(this.swigCPtr, this, f);
    }

    public float getPageWidth() {
        return ATKCoreJNI.PageFormat_pageWidth_get(this.swigCPtr, this);
    }

    public void setPageHeight(float f) {
        ATKCoreJNI.PageFormat_pageHeight_set(this.swigCPtr, this, f);
    }

    public float getPageHeight() {
        return ATKCoreJNI.PageFormat_pageHeight_get(this.swigCPtr, this);
    }

    public void setMarginLeft(float f) {
        ATKCoreJNI.PageFormat_marginLeft_set(this.swigCPtr, this, f);
    }

    public float getMarginLeft() {
        return ATKCoreJNI.PageFormat_marginLeft_get(this.swigCPtr, this);
    }

    public void setMarginRight(float f) {
        ATKCoreJNI.PageFormat_marginRight_set(this.swigCPtr, this, f);
    }

    public float getMarginRight() {
        return ATKCoreJNI.PageFormat_marginRight_get(this.swigCPtr, this);
    }

    public void setMarginTop(float f) {
        ATKCoreJNI.PageFormat_marginTop_set(this.swigCPtr, this, f);
    }

    public float getMarginTop() {
        return ATKCoreJNI.PageFormat_marginTop_get(this.swigCPtr, this);
    }

    public void setMarginBottom(float f) {
        ATKCoreJNI.PageFormat_marginBottom_set(this.swigCPtr, this, f);
    }

    public float getMarginBottom() {
        return ATKCoreJNI.PageFormat_marginBottom_get(this.swigCPtr, this);
    }

    public enum Formats {
        A4_PORTRAIT,
        A4_LANDSCAPE,
        US_LETTER_PORTRAIT,
        US_LETTER_LANDSCAPE;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static Formats swigToEnum(int i) {
            Formats[] formatsArr = (Formats[]) Formats.class.getEnumConstants();
            if (i < formatsArr.length && i >= 0) {
                Formats formats = formatsArr[i];
                if (formats.swigValue == i) {
                    return formats;
                }
            }
            for (Formats formats2 : formatsArr) {
                if (formats2.swigValue == i) {
                    return formats2;
                }
            }
            throw new IllegalArgumentException("No enum " + Formats.class + " with value " + i);
        }

        Formats() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        Formats(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        Formats(Formats formats) {
            int i = formats.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
