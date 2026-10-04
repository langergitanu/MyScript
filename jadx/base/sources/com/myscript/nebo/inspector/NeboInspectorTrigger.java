package com.myscript.nebo.inspector;

import android.app.Application;
import android.os.SystemClock;
import android.widget.Toast;
import androidx.media3.common.MimeTypes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboInspectorTrigger.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboInspectorTrigger;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "onTriggered", "Lkotlin/Function0;", "", "<init>", "(Landroid/app/Application;Lkotlin/jvm/functions/Function0;)V", "getOnTriggered", "()Lkotlin/jvm/functions/Function0;", "clickCount", "", "firstClickTime", "", "reset", "onClick", "", "Companion", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboInspectorTrigger {
    private static final long CLICK_INTERVAL_DURATION_LIMIT = 5000;
    private final Application application;
    private int clickCount;
    private long firstClickTime;
    private final Function0<Unit> onTriggered;

    public NeboInspectorTrigger(Application application, Function0<Unit> onTriggered) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(onTriggered, "onTriggered");
        this.application = application;
        this.onTriggered = onTriggered;
        this.firstClickTime = SystemClock.uptimeMillis();
    }

    public final Function0<Unit> getOnTriggered() {
        return this.onTriggered;
    }

    public final void reset() {
        this.clickCount = 0;
        this.firstClickTime = SystemClock.uptimeMillis();
    }

    public final boolean onClick() {
        if (SystemClock.uptimeMillis() - this.firstClickTime > 5000) {
            reset();
        }
        int i = this.clickCount + 1;
        this.clickCount = i;
        if (i == 5) {
            Toast.makeText(this.application, C6609R.string.inspector_files_need_some_help_toast, 0).show();
        } else if (i == 7) {
            reset();
            this.onTriggered.invoke();
            return true;
        }
        return false;
    }
}
