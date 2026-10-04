package com.myscript.nebo.p022ai.presentation.compose;

import com.myscript.nebo.p022ai.AIAnalyticsOrigin;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIContainerViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AiTextSelection;", "", "selectedText", "", WebViewMessageType.CONTEXT, "selectionType", "pageType", "Lcom/myscript/nebo/ai/AIAnalyticsOrigin;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/myscript/nebo/ai/AIAnalyticsOrigin;)V", "getSelectedText", "()Ljava/lang/String;", "getContext", "getSelectionType", "getPageType", "()Lcom/myscript/nebo/ai/AIAnalyticsOrigin;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AiTextSelection {
    public static final int $stable = 0;
    private final String context;
    private final AIAnalyticsOrigin pageType;
    private final String selectedText;
    private final String selectionType;

    public AiTextSelection() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AiTextSelection copy$default(AiTextSelection aiTextSelection, String str, String str2, String str3, AIAnalyticsOrigin aIAnalyticsOrigin, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiTextSelection.selectedText;
        }
        if ((i & 2) != 0) {
            str2 = aiTextSelection.context;
        }
        if ((i & 4) != 0) {
            str3 = aiTextSelection.selectionType;
        }
        if ((i & 8) != 0) {
            aIAnalyticsOrigin = aiTextSelection.pageType;
        }
        return aiTextSelection.copy(str, str2, str3, aIAnalyticsOrigin);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSelectedText() {
        return this.selectedText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSelectionType() {
        return this.selectionType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AIAnalyticsOrigin getPageType() {
        return this.pageType;
    }

    public final AiTextSelection copy(String selectedText, String context, String selectionType, AIAnalyticsOrigin pageType) {
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        return new AiTextSelection(selectedText, context, selectionType, pageType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiTextSelection)) {
            return false;
        }
        AiTextSelection aiTextSelection = (AiTextSelection) other;
        return Intrinsics.areEqual(this.selectedText, aiTextSelection.selectedText) && Intrinsics.areEqual(this.context, aiTextSelection.context) && Intrinsics.areEqual(this.selectionType, aiTextSelection.selectionType) && this.pageType == aiTextSelection.pageType;
    }

    public int hashCode() {
        int iHashCode = ((((this.selectedText.hashCode() * 31) + this.context.hashCode()) * 31) + this.selectionType.hashCode()) * 31;
        AIAnalyticsOrigin aIAnalyticsOrigin = this.pageType;
        return iHashCode + (aIAnalyticsOrigin == null ? 0 : aIAnalyticsOrigin.hashCode());
    }

    public String toString() {
        return "AiTextSelection(selectedText=" + this.selectedText + ", context=" + this.context + ", selectionType=" + this.selectionType + ", pageType=" + this.pageType + ")";
    }

    public AiTextSelection(String selectedText, String context, String selectionType, AIAnalyticsOrigin aIAnalyticsOrigin) {
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        this.selectedText = selectedText;
        this.context = context;
        this.selectionType = selectionType;
        this.pageType = aIAnalyticsOrigin;
    }

    public /* synthetic */ AiTextSelection(String str, String str2, String str3, AIAnalyticsOrigin aIAnalyticsOrigin, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : aIAnalyticsOrigin);
    }

    public final String getContext() {
        return this.context;
    }

    public final AIAnalyticsOrigin getPageType() {
        return this.pageType;
    }

    public final String getSelectedText() {
        return this.selectedText;
    }

    public final String getSelectionType() {
        return this.selectionType;
    }
}
