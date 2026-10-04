package com.myscript.atk.p021ui;

import com.myscript.atk.core.Extent;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PrompterBox {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PrompterBox(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PrompterBox prompterBox) {
        if (prompterBox == null) {
            return 0L;
        }
        return prompterBox.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKSharedUIJNI.delete_PrompterBox(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public PrompterBox(String str) {
        this(ATKSharedUIJNI.new_PrompterBox__SWIG_0(str.getBytes()), true);
    }

    public PrompterBox(PrompterBox prompterBox) {
        this(ATKSharedUIJNI.new_PrompterBox__SWIG_1(getCPtr(prompterBox), prompterBox), true);
    }

    public void addWord(PrompterWord prompterWord) {
        ATKSharedUIJNI.PrompterBox_addWord(this.swigCPtr, this, PrompterWord.getCPtr(prompterWord), prompterWord);
    }

    public void insertWord(int i, PrompterWord prompterWord) {
        ATKSharedUIJNI.PrompterBox_insertWord(this.swigCPtr, this, i, PrompterWord.getCPtr(prompterWord), prompterWord);
    }

    public boolean removeWord(int i) {
        return ATKSharedUIJNI.PrompterBox_removeWord(this.swigCPtr, this, i);
    }

    public void setRemoveState(int i) {
        ATKSharedUIJNI.PrompterBox_setRemoveState(this.swigCPtr, this, i);
    }

    public void updateWord(int i, int i2, String str, int i3, long j, long j2, int i4) {
        ATKSharedUIJNI.PrompterBox_updateWord(this.swigCPtr, this, i, i2, str.getBytes(), i3, j, j2, i4);
    }

    public List<PrompterWord> getWords() {
        return new SWIGPrompterWordList(ATKSharedUIJNI.PrompterBox_getWords(this.swigCPtr, this), true);
    }

    public long getLastEndTimestamp() {
        return ATKSharedUIJNI.PrompterBox_getLastEndTimestamp(this.swigCPtr, this);
    }

    public void setLastEndTimestamp(long j) {
        ATKSharedUIJNI.PrompterBox_setLastEndTimestamp(this.swigCPtr, this, j);
    }

    public PrompterWord getPrompterWordForId(int i) {
        long jPrompterBox_getPrompterWordForId = ATKSharedUIJNI.PrompterBox_getPrompterWordForId(this.swigCPtr, this, i);
        if (jPrompterBox_getPrompterWordForId == 0) {
            return null;
        }
        return new PrompterWord(jPrompterBox_getPrompterWordForId, true);
    }

    public int getTagType() {
        return ATKSharedUIJNI.PrompterBox_getTagType(this.swigCPtr, this);
    }

    public void setTagType(int i) {
        ATKSharedUIJNI.PrompterBox_setTagType(this.swigCPtr, this, i);
    }

    public String getPrompterId() {
        return new String(ATKSharedUIJNI.PrompterBox_getPrompterId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getContentFieldId() {
        return new String(ATKSharedUIJNI.PrompterBox_getContentFieldId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void updateContentFieldId(String str) {
        ATKSharedUIJNI.PrompterBox_updateContentFieldId(this.swigCPtr, this, str.getBytes());
    }

    public Extent getCurrentExtent() {
        return new Extent(ATKSharedUIJNI.PrompterBox_getCurrentExtent(this.swigCPtr, this), true);
    }

    public void setCurrentExtent(Extent extent) {
        ATKSharedUIJNI.PrompterBox_setCurrentExtent(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }
}
