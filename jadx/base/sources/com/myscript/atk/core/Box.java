package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class Box {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Box(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Box box) {
        if (box == null) {
            return 0L;
        }
        return box.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Box(j);
            }
            this.swigCPtr = 0L;
        }
    }

    /* JADX INFO: renamed from: id */
    public String mo1042id() {
        return new String(ATKCoreJNI.Box_id(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void updateSelection() {
        ATKCoreJNI.Box_updateSelection(this.swigCPtr, this);
    }

    public Page page() {
        return new Page(ATKCoreJNI.Box_page(this.swigCPtr, this), true);
    }

    public Layout layout() {
        return new Layout(ATKCoreJNI.Box_layout(this.swigCPtr, this), true);
    }

    public Content content() {
        return new Content(ATKCoreJNI.Box_content(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest typesetRequest(SWIGTYPE_p_atk__core__ActiveBackend__TextType sWIGTYPE_p_atk__core__ActiveBackend__TextType) {
        return new SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest(ATKCoreJNI.Box_typesetRequest__SWIG_0(this.swigCPtr, this, SWIGTYPE_p_atk__core__ActiveBackend__TextType.getCPtr(sWIGTYPE_p_atk__core__ActiveBackend__TextType)), true);
    }

    public SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest typesetRequest() {
        return new SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest(ATKCoreJNI.Box_typesetRequest__SWIG_1(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings typesetSettings(SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest sWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest) {
        return new SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings(ATKCoreJNI.Box_typesetSettings(this.swigCPtr, this, SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest.getCPtr(sWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest)), true);
    }

    public String type() {
        return new String(ATKCoreJNI.Box_type(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean empty() {
        return ATKCoreJNI.Box_empty(this.swigCPtr, this);
    }

    public Selection selection() {
        return new Selection(ATKCoreJNI.Box_selection(this.swigCPtr, this), true);
    }

    public void remove() {
        ATKCoreJNI.Box_remove(this.swigCPtr, this);
    }

    public String toString() {
        return new String(ATKCoreJNI.Box_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public Extent extent() {
        return new Extent(ATKCoreJNI.Box_extent(this.swigCPtr, this), true);
    }

    public void move(float f, float f2) {
        ATKCoreJNI.Box_move(this.swigCPtr, this, f, f2);
    }

    public long tagId() {
        return ATKCoreJNI.Box_tagId(this.swigCPtr, this);
    }

    public LayoutGroup layoutGroup() {
        return new LayoutGroup(ATKCoreJNI.Box_layoutGroup(this.swigCPtr, this), true);
    }

    public boolean isRoot() {
        return ATKCoreJNI.Box_isRoot(this.swigCPtr, this);
    }

    public Box parent() {
        long jBox_parent = ATKCoreJNI.Box_parent(this.swigCPtr, this);
        if (jBox_parent == 0) {
            return null;
        }
        return new Box(jBox_parent, true);
    }

    public Box previousBrother() {
        long jBox_previousBrother = ATKCoreJNI.Box_previousBrother(this.swigCPtr, this);
        if (jBox_previousBrother == 0) {
            return null;
        }
        return new Box(jBox_previousBrother, true);
    }

    public Box nextBrother() {
        long jBox_nextBrother = ATKCoreJNI.Box_nextBrother(this.swigCPtr, this);
        if (jBox_nextBrother == 0) {
            return null;
        }
        return new Box(jBox_nextBrother, true);
    }

    public boolean needCheckReco() {
        return ATKCoreJNI.Box_needCheckReco(this.swigCPtr, this);
    }

    public boolean hasValidContent() {
        return ATKCoreJNI.Box_hasValidContent(this.swigCPtr, this);
    }
}
