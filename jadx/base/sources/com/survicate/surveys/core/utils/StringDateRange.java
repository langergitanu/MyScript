package com.survicate.surveys.core.utils;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringDateRange.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/core/utils/StringDateRange;", "", TtmlNode.START, "", TtmlNode.END, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getStart", "()Ljava/lang/String;", "getEnd", "contains", "", QuestionSurveyAnswerType.DATE, "Companion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class StringDateRange {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String end;
    private final String start;

    public /* synthetic */ StringDateRange(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    private StringDateRange(String str, String str2) {
        this.start = str;
        this.end = str2;
    }

    public final String getEnd() {
        return this.end;
    }

    public final String getStart() {
        return this.start;
    }

    public final boolean contains(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String str = date;
        return str.compareTo(this.end) <= 0 && str.compareTo(this.start) >= 0;
    }

    /* JADX INFO: compiled from: StringDateRange.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/core/utils/StringDateRange$Companion;", "", "<init>", "()V", "fromIsoDates", "Lcom/survicate/surveys/core/utils/StringDateRange;", "dates", "", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StringDateRange fromIsoDates(List<String> dates) {
            String dateOnlyPart;
            String dateOnlyPart2;
            Intrinsics.checkNotNullParameter(dates, "dates");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (dates.size() != 2 || (dateOnlyPart = DateUtilsKt.getDateOnlyPart(dates.get(0))) == null || (dateOnlyPart2 = DateUtilsKt.getDateOnlyPart(dates.get(1))) == null) {
                return null;
            }
            return new StringDateRange(dateOnlyPart, dateOnlyPart2, defaultConstructorMarker);
        }
    }
}
