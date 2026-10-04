package com.myscript.nebo.p022ai.data.model.quiz;

import com.google.gson.annotations.SerializedName;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizInfo;", "", "provider", "", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "expectedQuestionCount", "", "expectedGenerationTimeMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getProvider", "()Ljava/lang/String;", "getModel", "getExpectedQuestionCount", "()I", "getExpectedGenerationTimeMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizInfo {
    public static final int $stable = 0;

    @SerializedName("expected_generation_time_ms")
    private final int expectedGenerationTimeMs;

    @SerializedName("expected_question_count")
    private final int expectedQuestionCount;

    @SerializedName(NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY)
    private final String model;

    @SerializedName("provider")
    private final String provider;

    public static /* synthetic */ QuizInfo copy$default(QuizInfo quizInfo, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = quizInfo.provider;
        }
        if ((i3 & 2) != 0) {
            str2 = quizInfo.model;
        }
        if ((i3 & 4) != 0) {
            i = quizInfo.expectedQuestionCount;
        }
        if ((i3 & 8) != 0) {
            i2 = quizInfo.expectedGenerationTimeMs;
        }
        return quizInfo.copy(str, str2, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getExpectedQuestionCount() {
        return this.expectedQuestionCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getExpectedGenerationTimeMs() {
        return this.expectedGenerationTimeMs;
    }

    public final QuizInfo copy(String provider, String model, int expectedQuestionCount, int expectedGenerationTimeMs) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(model, "model");
        return new QuizInfo(provider, model, expectedQuestionCount, expectedGenerationTimeMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizInfo)) {
            return false;
        }
        QuizInfo quizInfo = (QuizInfo) other;
        return Intrinsics.areEqual(this.provider, quizInfo.provider) && Intrinsics.areEqual(this.model, quizInfo.model) && this.expectedQuestionCount == quizInfo.expectedQuestionCount && this.expectedGenerationTimeMs == quizInfo.expectedGenerationTimeMs;
    }

    public int hashCode() {
        return (((((this.provider.hashCode() * 31) + this.model.hashCode()) * 31) + Integer.hashCode(this.expectedQuestionCount)) * 31) + Integer.hashCode(this.expectedGenerationTimeMs);
    }

    public String toString() {
        return "QuizInfo(provider=" + this.provider + ", model=" + this.model + ", expectedQuestionCount=" + this.expectedQuestionCount + ", expectedGenerationTimeMs=" + this.expectedGenerationTimeMs + ")";
    }

    public QuizInfo(String provider, String model, int i, int i2) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(model, "model");
        this.provider = provider;
        this.model = model;
        this.expectedQuestionCount = i;
        this.expectedGenerationTimeMs = i2;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final String getModel() {
        return this.model;
    }

    public final int getExpectedQuestionCount() {
        return this.expectedQuestionCount;
    }

    public final int getExpectedGenerationTimeMs() {
        return this.expectedGenerationTimeMs;
    }
}
