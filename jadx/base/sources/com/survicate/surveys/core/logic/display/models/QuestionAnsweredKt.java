package com.survicate.surveys.core.logic.display.models;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionAnswered.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¨\u0006\b"}, m1599d2 = {"toFormAnswer", "Lcom/survicate/surveys/core/logic/display/models/FormAnswer;", "Lkotlin/Pair;", "", "", "toMatrixAnswer", "Lcom/survicate/surveys/core/logic/display/models/MatrixAnswer;", "", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class QuestionAnsweredKt {
    public static final FormAnswer toFormAnswer(Pair<Long, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return new FormAnswer(pair.getFirst().longValue(), pair.getSecond());
    }

    public static final MatrixAnswer toMatrixAnswer(Map.Entry<Long, Long> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return new MatrixAnswer(entry.getKey().longValue(), entry.getValue().longValue());
    }
}
