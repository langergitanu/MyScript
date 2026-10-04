package androidx.compose.p004ui.text.googlefonts;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;

/* JADX INFO: compiled from: HandlerHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, m1599d2 = {"Landroidx/compose/ui/text/googlefonts/HandlerHelper;", "", "<init>", "()V", "createAsync", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "Handler28Impl", "ui-text-google-fonts"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class HandlerHelper {
    public static final int $stable = 0;
    public static final HandlerHelper INSTANCE = new HandlerHelper();

    private HandlerHelper() {
    }

    public final Handler createAsync(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler28Impl.INSTANCE.createAsync(looper);
        }
        return new Handler(looper);
    }

    /* JADX INFO: compiled from: HandlerHelper.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Landroidx/compose/ui/text/googlefonts/HandlerHelper$Handler28Impl;", "", "<init>", "()V", "createAsync", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "ui-text-google-fonts"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Handler28Impl {
        public static final int $stable = 0;
        public static final Handler28Impl INSTANCE = new Handler28Impl();

        private Handler28Impl() {
        }

        public final Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
