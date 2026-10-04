package androidx.recyclerview.selection;

import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class OperationMonitor {
    private static final String TAG = "OperationMonitor";
    private int mNumOps = 0;
    private List<OnChangeListener> mListeners = new ArrayList();

    public interface OnChangeListener {
        void onChanged();
    }

    synchronized void start() {
        int i = this.mNumOps + 1;
        this.mNumOps = i;
        if (i == 1) {
            Iterator<OnChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onChanged();
            }
        }
    }

    synchronized void stop() {
        Preconditions.checkState(this.mNumOps > 0);
        int i = this.mNumOps - 1;
        this.mNumOps = i;
        if (i == 0) {
            Iterator<OnChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onChanged();
            }
        }
    }

    public synchronized boolean isStarted() {
        return this.mNumOps > 0;
    }

    public void addListener(OnChangeListener onChangeListener) {
        Preconditions.checkArgument(onChangeListener != null);
        this.mListeners.add(onChangeListener);
    }

    public void removeListener(OnChangeListener onChangeListener) {
        Preconditions.checkArgument(onChangeListener != null);
        this.mListeners.remove(onChangeListener);
    }

    void checkStarted() {
        Preconditions.checkState(this.mNumOps > 0);
    }

    void checkStopped() {
        Preconditions.checkState(this.mNumOps == 0);
    }
}
