package com.survicate.surveys.targeting;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TimeIntervalTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/targeting/TimeIntervalTargeting;", "", "onTimePassed", "Lkotlin/Function0;", "", "getOnTimePassed", "()Lkotlin/jvm/functions/Function0;", "setOnTimePassed", "(Lkotlin/jvm/functions/Function0;)V", TtmlNode.START, "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface TimeIntervalTargeting {
    void clear();

    Function0<Unit> getOnTimePassed();

    void setOnTimePassed(Function0<Unit> function0);

    void start();
}
