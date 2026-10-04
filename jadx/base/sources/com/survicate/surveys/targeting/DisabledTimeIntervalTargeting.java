package com.survicate.surveys.targeting;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeIntervalTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/targeting/DisabledTimeIntervalTargeting;", "Lcom/survicate/surveys/targeting/TimeIntervalTargeting;", "<init>", "()V", "onTimePassed", "Lkotlin/Function0;", "", "getOnTimePassed", "()Lkotlin/jvm/functions/Function0;", "setOnTimePassed", "(Lkotlin/jvm/functions/Function0;)V", TtmlNode.START, "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisabledTimeIntervalTargeting implements TimeIntervalTargeting {
    private Function0<Unit> onTimePassed = new Function0() { // from class: com.survicate.surveys.targeting.DisabledTimeIntervalTargeting$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Unit.INSTANCE;
        }
    };

    @Override // com.survicate.surveys.targeting.TimeIntervalTargeting
    public void clear() {
    }

    @Override // com.survicate.surveys.targeting.TimeIntervalTargeting
    public void start() {
    }

    @Override // com.survicate.surveys.targeting.TimeIntervalTargeting
    public Function0<Unit> getOnTimePassed() {
        return this.onTimePassed;
    }

    @Override // com.survicate.surveys.targeting.TimeIntervalTargeting
    public void setOnTimePassed(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTimePassed = function0;
    }
}
