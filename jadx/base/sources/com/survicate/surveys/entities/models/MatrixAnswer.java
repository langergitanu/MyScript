package com.survicate.surveys.entities.models;

import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MatrixAnswer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000  2\u00020\u0001:\u0001 B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B5\b\u0016\u0012*\u0010\u0002\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0088\u0001\u0002¨\u0006!"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/MatrixAnswer;", "", "answerToColumnIds", "", "", "constructor-impl", "(Ljava/util/Map;)Ljava/util/Map;", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "getAnswerToColumnIds", "()Ljava/util/Map;", "getColumnValue", "answerId", "getColumnValue-impl", "(Ljava/util/Map;J)Ljava/lang/Long;", "hasColumnValueFor", "", "hasColumnValueFor-impl", "(Ljava/util/Map;J)Z", "equals", "other", "equals-impl", "(Ljava/util/Map;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/util/Map;)I", "toString", "", "toString-impl", "(Ljava/util/Map;)Ljava/lang/String;", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@JvmInline
public final class MatrixAnswer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<Long, Long> answerToColumnIds;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MatrixAnswer m14347boximpl(Map map) {
        return new MatrixAnswer(map);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Map<Long, ? extends Long> m14348constructorimpl(Map<Long, Long> answerToColumnIds) {
        Intrinsics.checkNotNullParameter(answerToColumnIds, "answerToColumnIds");
        return answerToColumnIds;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m14350equalsimpl(Map<Long, ? extends Long> map, Object obj) {
        return (obj instanceof MatrixAnswer) && Intrinsics.areEqual(map, ((MatrixAnswer) obj).getAnswerToColumnIds());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m14351equalsimpl0(Map<Long, ? extends Long> map, Map<Long, ? extends Long> map2) {
        return Intrinsics.areEqual(map, map2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m14354hashCodeimpl(Map<Long, ? extends Long> map) {
        return map.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m14355toStringimpl(Map<Long, ? extends Long> map) {
        return "MatrixAnswer(answerToColumnIds=" + map + ')';
    }

    public boolean equals(Object obj) {
        return m14350equalsimpl(this.answerToColumnIds, obj);
    }

    public int hashCode() {
        return m14354hashCodeimpl(this.answerToColumnIds);
    }

    public String toString() {
        return m14355toStringimpl(this.answerToColumnIds);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Map getAnswerToColumnIds() {
        return this.answerToColumnIds;
    }

    private /* synthetic */ MatrixAnswer(Map map) {
        this.answerToColumnIds = map;
    }

    public final Map<Long, Long> getAnswerToColumnIds() {
        return this.answerToColumnIds;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Map<Long, ? extends Long> m14349constructorimpl(Pair<Long, Long>... answerToColumnIds) {
        Intrinsics.checkNotNullParameter(answerToColumnIds, "answerToColumnIds");
        return m14348constructorimpl((Map<Long, Long>) MapsKt.toMap(answerToColumnIds));
    }

    /* JADX INFO: renamed from: getColumnValue-impl, reason: not valid java name */
    public static final Long m14352getColumnValueimpl(Map<Long, ? extends Long> map, long j) {
        return map.get(Long.valueOf(j));
    }

    /* JADX INFO: renamed from: hasColumnValueFor-impl, reason: not valid java name */
    public static final boolean m14353hasColumnValueForimpl(Map<Long, ? extends Long> map, long j) {
        return m14352getColumnValueimpl(map, j) != null;
    }

    /* JADX INFO: compiled from: MatrixAnswer.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/MatrixAnswer$Companion;", "", "<init>", "()V", "fromRawAnswers", "Lcom/survicate/surveys/entities/models/MatrixAnswer;", "surveyAnswers", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "fromRawAnswers-yWLOJ_k", "(Ljava/util/List;)Ljava/util/Map;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: fromRawAnswers-yWLOJ_k, reason: not valid java name */
        public final Map<Long, ? extends Long> m14357fromRawAnswersyWLOJ_k(List<SurveyAnswer> surveyAnswers) {
            Intrinsics.checkNotNullParameter(surveyAnswers, "surveyAnswers");
            SurveyAnswer surveyAnswer = (SurveyAnswer) CollectionsKt.firstOrNull((List) surveyAnswers);
            if ((surveyAnswer != null ? surveyAnswer.getContent() : null) == null) {
                return MatrixAnswer.m14348constructorimpl((Map<Long, Long>) MapsKt.emptyMap());
            }
            List<SurveyAnswer> list = surveyAnswers;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (SurveyAnswer surveyAnswer2 : list) {
                Long questionAnswerId = surveyAnswer2.getQuestionAnswerId();
                Intrinsics.checkNotNull(questionAnswerId);
                String content = surveyAnswer2.getContent();
                Intrinsics.checkNotNull(content);
                Pair pairM1606to = TuplesKt.m1606to(questionAnswerId, Long.valueOf(Long.parseLong(content)));
                linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
            }
            return MatrixAnswer.m14348constructorimpl(linkedHashMap);
        }
    }
}
