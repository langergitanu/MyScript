package com.pdftron.pdf;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Vector;

/* JADX INFO: loaded from: classes7.dex */
public class PreviewHandler {
    public static final int DOCUMENT_PREVIEW_RESULT_CANCEL = 3;
    public static final int DOCUMENT_PREVIEW_RESULT_FAILURE = 0;
    public static final int DOCUMENT_PREVIEW_RESULT_NOT_FOUNT = 6;
    public static final int DOCUMENT_PREVIEW_RESULT_PACKAGE_ERROR = 4;
    public static final int DOCUMENT_PREVIEW_RESULT_POSTPONED = 9;
    public static final int DOCUMENT_PREVIEW_RESULT_PREVIOUS_CRASH = 5;
    public static final int DOCUMENT_PREVIEW_RESULT_SECURITY_ERROR = 2;
    public static final int DOCUMENT_PREVIEW_RESULT_SUCCESS = 1;
    private PreviewHandlerCallback mListener;
    private final HandlerC6958a mThumbHandler = new HandlerC6958a(this);

    public interface PreviewHandlerCallback {
        void PreviewHandlerProc(int i, String str, Object obj);
    }

    public PreviewHandler(PreviewHandlerCallback previewHandlerCallback) {
        this.mListener = previewHandlerCallback;
    }

    public void removeListener() {
        this.mListener = null;
    }

    private void PreviewHandlerProc(int i, String str, Object obj) {
        Thread.yield();
        Message message = new Message();
        message.setTarget(this.mThumbHandler);
        Vector vector = new Vector();
        vector.add(Integer.valueOf(i));
        vector.add(str);
        vector.add(obj);
        message.obj = vector;
        message.sendToTarget();
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PreviewHandler$a */
    private static class HandlerC6958a extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PreviewHandler> f2003a;

        public HandlerC6958a(PreviewHandler previewHandler) {
            this.f2003a = new WeakReference<>(previewHandler);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PreviewHandler previewHandler = this.f2003a.get();
            if (previewHandler == null || previewHandler.mListener == null) {
                return;
            }
            Vector vector = (Vector) message.obj;
            previewHandler.mListener.PreviewHandlerProc(((Integer) vector.elementAt(0)).intValue(), (String) vector.elementAt(1), vector.elementAt(2));
        }
    }
}
