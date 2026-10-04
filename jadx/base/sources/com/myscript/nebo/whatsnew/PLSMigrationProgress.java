package com.myscript.nebo.whatsnew;

import com.myscript.atk.core.ICancelableTaskProgressCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PLSMigrationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B)\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R4\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\n¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationProgress;", "Lcom/myscript/atk/core/ICancelableTaskProgressCallback;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "delegate", "Lkotlin/Function2;", "", "", "Lcom/myscript/nebo/whatsnew/PLSMigrationProgressDelegate;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getDelegate", "()Lkotlin/jvm/functions/Function2;", "setDelegate", "progress", "done", "todo", "close", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class PLSMigrationProgress implements ICancelableTaskProgressCallback, AutoCloseable {
    private Function2<? super Float, ? super Float, Boolean> delegate;

    public PLSMigrationProgress(Function2<? super Float, ? super Float, Boolean> function2) {
        this.delegate = function2;
    }

    public final Function2<Float, Float, Boolean> getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(Function2<? super Float, ? super Float, Boolean> function2) {
        this.delegate = function2;
    }

    @Override // com.myscript.atk.core.ICancelableTaskProgressCallback
    public boolean progress(float done, float todo) {
        Function2<? super Float, ? super Float, Boolean> function2 = this.delegate;
        if (function2 != null) {
            return function2.invoke(Float.valueOf(done), Float.valueOf(todo)).booleanValue();
        }
        return false;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.delegate = null;
    }
}
