package com.myscript.nebo.p022ai.data.model.explain;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExplainContent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/explain/ExplainContent;", "", FirebaseAnalytics.Param.TERM, "", WebViewMessageType.CONTEXT, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTerm", "()Ljava/lang/String;", "getContext", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ExplainContent {
    public static final int $stable = 0;

    @SerializedName(WebViewMessageType.CONTEXT)
    private final String context;

    @SerializedName(FirebaseAnalytics.Param.TERM)
    private final String term;

    public static /* synthetic */ ExplainContent copy$default(ExplainContent explainContent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = explainContent.term;
        }
        if ((i & 2) != 0) {
            str2 = explainContent.context;
        }
        return explainContent.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTerm() {
        return this.term;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContext() {
        return this.context;
    }

    public final ExplainContent copy(String term, String context) {
        Intrinsics.checkNotNullParameter(term, "term");
        Intrinsics.checkNotNullParameter(context, "context");
        return new ExplainContent(term, context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExplainContent)) {
            return false;
        }
        ExplainContent explainContent = (ExplainContent) other;
        return Intrinsics.areEqual(this.term, explainContent.term) && Intrinsics.areEqual(this.context, explainContent.context);
    }

    public int hashCode() {
        return (this.term.hashCode() * 31) + this.context.hashCode();
    }

    public String toString() {
        return "ExplainContent(term=" + this.term + ", context=" + this.context + ")";
    }

    public ExplainContent(String term, String context) {
        Intrinsics.checkNotNullParameter(term, "term");
        Intrinsics.checkNotNullParameter(context, "context");
        this.term = term;
        this.context = context;
    }

    public final String getTerm() {
        return this.term;
    }

    public final String getContext() {
        return this.context;
    }
}
