package com.pdftron.pdf;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: loaded from: classes7.dex */
public class RequestHandler {
    public static final int JOB_REQUEST_RESULT_CANCEL = 3;
    public static final int JOB_REQUEST_RESULT_FAILURE = 0;
    public static final int JOB_REQUEST_RESULT_PACKAGE_ERROR = 4;
    public static final int JOB_REQUEST_RESULT_POSTPONED = 9;
    public static final int JOB_REQUEST_RESULT_PREVIOUS_CRASH = 5;
    public static final int JOB_REQUEST_RESULT_SECURITY_ERROR = 2;
    public static final int JOB_REQUEST_RESULT_SUCCESS = 1;
    private final HandlerC6961a mJobRequestHandler = new HandlerC6961a(this);
    private RequestHandlerCallback mListener;

    public interface RequestHandlerCallback {
        void RequestHandlerProc(JobRequestResult jobRequestResult, String str, Object obj);
    }

    public enum JobRequestResult {
        FINISHED(1),
        CANCELLED(3),
        POSTPONED(9),
        FAILED(0),
        SECURITY_ERROR(2),
        PACKAGE_ERROR(4),
        PREVIOUS_CRASH(5);


        /* JADX INFO: renamed from: b */
        private static Map<Integer, JobRequestResult> f2041b = new HashMap(7);

        /* JADX INFO: renamed from: a */
        private final int f2043a;

        static {
            for (JobRequestResult jobRequestResult : values()) {
                f2041b.put(Integer.valueOf(jobRequestResult.f2043a), jobRequestResult);
            }
        }

        JobRequestResult(int i) {
            this.f2043a = i;
        }

        public final int getValue() {
            return this.f2043a;
        }

        public static JobRequestResult valueOf(int i) {
            return f2041b.get(Integer.valueOf(i));
        }
    }

    public RequestHandler(RequestHandlerCallback requestHandlerCallback) {
        this.mListener = requestHandlerCallback;
    }

    public void removeListener() {
        this.mListener = null;
    }

    private void RequestHandlerProc(int i, String str, Object obj) {
        Thread.yield();
        Message message = new Message();
        message.setTarget(this.mJobRequestHandler);
        Vector vector = new Vector();
        vector.add(Integer.valueOf(i));
        vector.add(str);
        vector.add(obj);
        message.obj = vector;
        message.sendToTarget();
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.RequestHandler$a */
    private static class HandlerC6961a extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<RequestHandler> f2044a;

        public HandlerC6961a(RequestHandler requestHandler) {
            this.f2044a = new WeakReference<>(requestHandler);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RequestHandler requestHandler = this.f2044a.get();
            if (requestHandler == null || requestHandler.mListener == null) {
                return;
            }
            Vector vector = (Vector) message.obj;
            int iIntValue = ((Integer) vector.elementAt(0)).intValue();
            requestHandler.mListener.RequestHandlerProc(JobRequestResult.valueOf(iIntValue), (String) vector.elementAt(1), vector.elementAt(2));
        }
    }
}
