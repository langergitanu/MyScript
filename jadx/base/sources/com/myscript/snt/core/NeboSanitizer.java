package com.myscript.snt.core;

import com.myscript.atk.core.Page;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class NeboSanitizer {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public NeboSanitizer(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(NeboSanitizer neboSanitizer) {
        if (neboSanitizer == null) {
            return 0L;
        }
        return neboSanitizer.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_NeboSanitizer(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static class SanitizerResult {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public SanitizerResult(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(SanitizerResult sanitizerResult) {
            if (sanitizerResult == null) {
                return 0L;
            }
            return sanitizerResult.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboEngineJNI.delete_NeboSanitizer_SanitizerResult(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public void setStatus(SanitizerStatus sanitizerStatus) {
            NeboEngineJNI.NeboSanitizer_SanitizerResult_status_set(this.swigCPtr, this, sanitizerStatus.swigValue());
        }

        public SanitizerStatus getStatus() {
            return SanitizerStatus.swigToEnum(NeboEngineJNI.NeboSanitizer_SanitizerResult_status_get(this.swigCPtr, this));
        }

        public void setSource(String str) {
            NeboEngineJNI.NeboSanitizer_SanitizerResult_source_set(this.swigCPtr, this, str.getBytes());
        }

        public String getSource() {
            return new String(NeboEngineJNI.NeboSanitizer_SanitizerResult_source_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public void setReason(String str) {
            NeboEngineJNI.NeboSanitizer_SanitizerResult_reason_set(this.swigCPtr, this, str.getBytes());
        }

        public String getReason() {
            return new String(NeboEngineJNI.NeboSanitizer_SanitizerResult_reason_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public void setMessage(String str) {
            NeboEngineJNI.NeboSanitizer_SanitizerResult_message_set(this.swigCPtr, this, str.getBytes());
        }

        public String getMessage() {
            return new String(NeboEngineJNI.NeboSanitizer_SanitizerResult_message_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public SanitizerResult() {
            this(NeboEngineJNI.new_NeboSanitizer_SanitizerResult(), true);
        }
    }

    public static SanitizerResult sanitizePage(String str, Page page) {
        return new SanitizerResult(NeboEngineJNI.NeboSanitizer_sanitizePage__SWIG_0(str.getBytes(), Page.getCPtr(page), page), true);
    }

    public static SanitizerResult sanitizePage(PageKey pageKey, Page page) {
        return new SanitizerResult(NeboEngineJNI.NeboSanitizer_sanitizePage__SWIG_1(PageKey.getCPtr(pageKey), pageKey, Page.getCPtr(page), page), true);
    }

    public static boolean isPageTreeInvalid(Page page) {
        return NeboEngineJNI.NeboSanitizer_isPageTreeInvalid(Page.getCPtr(page), page);
    }

    public NeboSanitizer() {
        this(NeboEngineJNI.new_NeboSanitizer(), true);
    }

    public enum SanitizerStatus {
        Ok(0),
        ResetedFields,
        Corrupted;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static SanitizerStatus swigToEnum(int i) {
            SanitizerStatus[] sanitizerStatusArr = (SanitizerStatus[]) SanitizerStatus.class.getEnumConstants();
            if (i < sanitizerStatusArr.length && i >= 0) {
                SanitizerStatus sanitizerStatus = sanitizerStatusArr[i];
                if (sanitizerStatus.swigValue == i) {
                    return sanitizerStatus;
                }
            }
            for (SanitizerStatus sanitizerStatus2 : sanitizerStatusArr) {
                if (sanitizerStatus2.swigValue == i) {
                    return sanitizerStatus2;
                }
            }
            throw new IllegalArgumentException("No enum " + SanitizerStatus.class + " with value " + i);
        }

        SanitizerStatus() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        SanitizerStatus(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        SanitizerStatus(SanitizerStatus sanitizerStatus) {
            int i = sanitizerStatus.swigValue;
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
