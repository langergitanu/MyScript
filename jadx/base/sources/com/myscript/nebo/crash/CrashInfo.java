package com.myscript.nebo.crash;

import com.google.gson.Gson;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CrashInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/crash/CrashInfo;", "", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "pageKey", "Lcom/myscript/snt/core/PageKey;", DiagnosticsEntry.TIMESTAMP_KEY, "", "<init>", "(Lcom/myscript/snt/core/NotebookKey;Lcom/myscript/snt/core/PageKey;J)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "notebookKeySerialized", "", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "pageKeySerialized", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "serialize", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CrashInfo {
    private final String notebookKeySerialized;
    private final String pageKeySerialized;
    private long timestamp;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final CrashInfo deserialize(String str) {
        return INSTANCE.deserialize(str);
    }

    public CrashInfo(NotebookKey notebookKey, PageKey pageKey, long j) {
        this.timestamp = j;
        this.notebookKeySerialized = notebookKey != null ? notebookKey.serialize() : null;
        this.pageKeySerialized = pageKey != null ? pageKey.serialize() : null;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final NotebookKey getNotebookKey() {
        String str = this.notebookKeySerialized;
        if (str != null) {
            return NotebookKey.deserialize(str);
        }
        return null;
    }

    public final PageKey getPageKey() {
        String str = this.pageKeySerialized;
        if (str != null) {
            return PageKey.deserialize(str);
        }
        return null;
    }

    public final String serialize() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    /* JADX INFO: compiled from: CrashInfo.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/crash/CrashInfo$Companion;", "", "<init>", "()V", "deserialize", "Lcom/myscript/nebo/crash/CrashInfo;", "input", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CrashInfo deserialize(String input) {
            if (input == null) {
                return new CrashInfo(null, null, 0L);
            }
            Object objFromJson = new Gson().fromJson(input, (Class<Object>) CrashInfo.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            return (CrashInfo) objFromJson;
        }
    }
}
