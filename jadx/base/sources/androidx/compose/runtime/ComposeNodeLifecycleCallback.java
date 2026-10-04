package androidx.compose.runtime;

import kotlin.Metadata;

/* JADX INFO: compiled from: ComposeNodeLifecycleCallback.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, m1599d2 = {"Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "", "onReuse", "", "onDeactivate", "onRelease", "runtime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ComposeNodeLifecycleCallback {
    void onDeactivate();

    void onRelease();

    void onReuse();
}
