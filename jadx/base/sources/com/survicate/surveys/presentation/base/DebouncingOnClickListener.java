package com.survicate.surveys.presentation.base;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public abstract class DebouncingOnClickListener implements View.OnClickListener {
    private static final Runnable ENABLE_AGAIN = new Runnable() { // from class: com.survicate.surveys.presentation.base.DebouncingOnClickListener.1
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = DebouncingOnClickListener.enabled = true;
        }
    };
    private static boolean enabled = true;

    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (enabled) {
            enabled = false;
            view.post(ENABLE_AGAIN);
            doClick(view);
        }
    }
}
