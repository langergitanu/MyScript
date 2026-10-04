package com.myscript.atk.text;

import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.SWIGVectorMimeType;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGClipboard {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGClipboard(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGClipboard sWIGClipboard) {
        if (sWIGClipboard == null) {
            return 0L;
        }
        return sWIGClipboard.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_SWIGClipboard(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SWIGClipboard(SWIGTYPE_p_std__mapT_atk__core__MimeType_std__string_t sWIGTYPE_p_std__mapT_atk__core__MimeType_std__string_t) {
        this(ATKTextJNI.new_SWIGClipboard__SWIG_0(SWIGTYPE_p_std__mapT_atk__core__MimeType_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_atk__core__MimeType_std__string_t)), true);
    }

    public SWIGClipboard(SWIGTYPE_p_std__mapT_std__string_std__string_t sWIGTYPE_p_std__mapT_std__string_std__string_t) {
        this(ATKTextJNI.new_SWIGClipboard__SWIG_1(SWIGTYPE_p_std__mapT_std__string_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_std__string_std__string_t)), true);
    }

    public SWIGClipboard() {
        this(ATKTextJNI.new_SWIGClipboard__SWIG_2(), true);
    }

    public List<MimeType> getKeys() {
        return new SWIGVectorMimeType(ATKTextJNI.SWIGClipboard_getKeys(this.swigCPtr, this), true);
    }

    public List<MimeType> getMimeTypes() {
        return new SWIGVectorMimeType(ATKTextJNI.SWIGClipboard_getMimeTypes(this.swigCPtr, this), true);
    }

    public boolean hasKey(String str) {
        return ATKTextJNI.SWIGClipboard_hasKey__SWIG_0(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasKey(MimeType mimeType) {
        return ATKTextJNI.SWIGClipboard_hasKey__SWIG_1(this.swigCPtr, this, mimeType.swigValue());
    }

    public String get(String str) {
        return new String(ATKTextJNI.SWIGClipboard_get__SWIG_0(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public String get(MimeType mimeType) {
        return new String(ATKTextJNI.SWIGClipboard_get__SWIG_1(this.swigCPtr, this, mimeType.swigValue()), StandardCharsets.UTF_8);
    }

    public void put(MimeType mimeType, String str) {
        ATKTextJNI.SWIGClipboard_put__SWIG_0(this.swigCPtr, this, mimeType.swigValue(), str.getBytes());
    }

    public void put(String str, String str2) {
        ATKTextJNI.SWIGClipboard_put__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }
}
