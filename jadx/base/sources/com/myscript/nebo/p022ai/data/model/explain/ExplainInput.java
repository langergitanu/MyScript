package com.myscript.nebo.p022ai.data.model.explain;

import com.google.gson.annotations.SerializedName;
import com.myscript.nebo.LaunchActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExplainInput.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/explain/ExplainInput;", "", "stream", "", LaunchActivity.LaunchRoute.Language, "", "environment", "Lcom/myscript/nebo/ai/data/model/explain/ExplainContent;", "<init>", "(ZLjava/lang/String;Lcom/myscript/nebo/ai/data/model/explain/ExplainContent;)V", "getStream", "()Z", "getLanguage", "()Ljava/lang/String;", "getEnvironment", "()Lcom/myscript/nebo/ai/data/model/explain/ExplainContent;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ExplainInput {
    public static final int $stable = 0;

    @SerializedName("environment")
    private final ExplainContent environment;

    @SerializedName(LaunchActivity.LaunchRoute.Language)
    private final String language;

    @SerializedName("stream")
    private final boolean stream;

    public static /* synthetic */ ExplainInput copy$default(ExplainInput explainInput, boolean z, String str, ExplainContent explainContent, int i, Object obj) {
        if ((i & 1) != 0) {
            z = explainInput.stream;
        }
        if ((i & 2) != 0) {
            str = explainInput.language;
        }
        if ((i & 4) != 0) {
            explainContent = explainInput.environment;
        }
        return explainInput.copy(z, str, explainContent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getStream() {
        return this.stream;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ExplainContent getEnvironment() {
        return this.environment;
    }

    public final ExplainInput copy(boolean stream, String language, ExplainContent environment) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(environment, "environment");
        return new ExplainInput(stream, language, environment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExplainInput)) {
            return false;
        }
        ExplainInput explainInput = (ExplainInput) other;
        return this.stream == explainInput.stream && Intrinsics.areEqual(this.language, explainInput.language) && Intrinsics.areEqual(this.environment, explainInput.environment);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.stream) * 31) + this.language.hashCode()) * 31) + this.environment.hashCode();
    }

    public String toString() {
        return "ExplainInput(stream=" + this.stream + ", language=" + this.language + ", environment=" + this.environment + ")";
    }

    public ExplainInput(boolean z, String language, ExplainContent environment) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.stream = z;
        this.language = language;
        this.environment = environment;
    }

    public final boolean getStream() {
        return this.stream;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final ExplainContent getEnvironment() {
        return this.environment;
    }
}
