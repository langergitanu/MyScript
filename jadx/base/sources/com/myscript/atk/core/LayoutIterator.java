package com.myscript.atk.core;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutIterator implements Iterator<LayoutItem> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LayoutIterator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutIterator layoutIterator) {
        if (layoutIterator == null) {
            return 0L;
        }
        return layoutIterator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayoutIterator(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Extent getExtent() {
        return new Extent(ATKCoreJNI.LayoutIterator_getExtent(this.swigCPtr, this), true);
    }

    public boolean styleChanged() {
        return ATKCoreJNI.LayoutIterator_styleChanged(this.swigCPtr, this);
    }

    public boolean groupChanged() {
        return ATKCoreJNI.LayoutIterator_groupChanged(this.swigCPtr, this);
    }

    public LayoutIterator(SWIGTYPE_p_myscript__document__PageSelection sWIGTYPE_p_myscript__document__PageSelection, boolean z) {
        this(ATKCoreJNI.new_LayoutIterator__SWIG_0(SWIGTYPE_p_myscript__document__PageSelection.getCPtr(sWIGTYPE_p_myscript__document__PageSelection), z), true);
    }

    public LayoutIterator(Selection selection) {
        this(ATKCoreJNI.new_LayoutIterator__SWIG_2(Selection.getCPtr(selection), selection), true);
    }

    public int getType() {
        return ATKCoreJNI.LayoutIterator_getType(this.swigCPtr, this);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return ATKCoreJNI.LayoutIterator_hasNext(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: com.myscript.atk.core.LayoutIterator$1 */
    static /* synthetic */ class C60191 {
        static final /* synthetic */ int[] $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T;

        static {
            int[] iArr = new int[VO_DOCUMENT_PRIVATE_T.values().length];
            $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T = iArr;
            try {
                iArr[VO_DOCUMENT_PRIVATE_T.LayoutItemStroke.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T[VO_DOCUMENT_PRIVATE_T.LayoutItemArc.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T[VO_DOCUMENT_PRIVATE_T.LayoutItemLine.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T[VO_DOCUMENT_PRIVATE_T.LayoutItemPoint.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T[VO_DOCUMENT_PRIVATE_T.LayoutItemDecoration.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T[VO_DOCUMENT_PRIVATE_T.LayoutItemGuide.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T[VO_DOCUMENT_PRIVATE_T.LayoutItemObject.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T[VO_DOCUMENT_PRIVATE_T.LayoutItemString.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public LayoutItem next() {
        switch (C60191.$SwitchMap$com$myscript$atk$core$VO_DOCUMENT_PRIVATE_T[VO_DOCUMENT_PRIVATE_T.swigToEnum(getType()).ordinal()]) {
            case 1:
                return new LayoutItemStroke(ATKCoreJNI.LayoutIterator_next(this.swigCPtr, this), true);
            case 2:
                return new LayoutItemArc(ATKCoreJNI.LayoutIterator_next(this.swigCPtr, this), true);
            case 3:
                return new LayoutItemLine(ATKCoreJNI.LayoutIterator_next(this.swigCPtr, this), true);
            case 4:
                return new LayoutItemPoint(ATKCoreJNI.LayoutIterator_next(this.swigCPtr, this), true);
            case 5:
                return new LayoutItemDecoration(ATKCoreJNI.LayoutIterator_next(this.swigCPtr, this), true);
            case 6:
                return new LayoutItemGuide(ATKCoreJNI.LayoutIterator_next(this.swigCPtr, this), true);
            case 7:
                return new LayoutItemObject(ATKCoreJNI.LayoutIterator_next(this.swigCPtr, this), true);
            case 8:
                return new LayoutItemString(ATKCoreJNI.LayoutIterator_next(this.swigCPtr, this), true);
            default:
                return null;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        ATKCoreJNI.LayoutIterator_remove(this.swigCPtr, this);
    }
}
