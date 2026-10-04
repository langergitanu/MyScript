package com.myscript.atk.p021ui;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class PrompterWord {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PrompterWord(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PrompterWord prompterWord) {
        if (prompterWord == null) {
            return 0L;
        }
        return prompterWord.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKSharedUIJNI.delete_PrompterWord(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public PrompterWord(int i, String str, int i2, long j, long j2, int i3) {
        this(ATKSharedUIJNI.new_PrompterWord(i, str.getBytes(), i2, j, j2, i3), true);
    }

    public boolean updateWord(int i, String str, int i2, long j, long j2, int i3) {
        return ATKSharedUIJNI.PrompterWord_updateWord(this.swigCPtr, this, i, str.getBytes(), i2, j, j2, i3);
    }

    /* JADX INFO: renamed from: id */
    public int m1061id() {
        return ATKSharedUIJNI.PrompterWord_id(this.swigCPtr, this);
    }

    public long beginTimestamp() {
        return ATKSharedUIJNI.PrompterWord_beginTimestamp(this.swigCPtr, this);
    }

    public void setBeginTimestamp(long j) {
        ATKSharedUIJNI.PrompterWord_setBeginTimestamp(this.swigCPtr, this, j);
    }

    public long endTimestamp() {
        return ATKSharedUIJNI.PrompterWord_endTimestamp(this.swigCPtr, this);
    }

    public void setEndTimestamp(long j) {
        ATKSharedUIJNI.PrompterWord_setEndTimestamp(this.swigCPtr, this, j);
    }

    public PrompterWordState state() {
        return PrompterWordState.swigToEnum(ATKSharedUIJNI.PrompterWord_state(this.swigCPtr, this));
    }

    public void setState(PrompterWordState prompterWordState) {
        ATKSharedUIJNI.PrompterWord_setState(this.swigCPtr, this, prompterWordState.swigValue());
    }

    public int wordIndex() {
        return ATKSharedUIJNI.PrompterWord_wordIndex(this.swigCPtr, this);
    }

    public void setWordIndex(int i) {
        ATKSharedUIJNI.PrompterWord_setWordIndex(this.swigCPtr, this, i);
    }

    public String label() {
        return new String(ATKSharedUIJNI.PrompterWord_label(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String labelWithSpace() {
        return new String(ATKSharedUIJNI.PrompterWord_labelWithSpace(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int selectedLabelIndex() {
        return ATKSharedUIJNI.PrompterWord_selectedLabelIndex(this.swigCPtr, this);
    }
}
