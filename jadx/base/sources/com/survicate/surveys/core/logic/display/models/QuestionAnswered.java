package com.survicate.surveys.core.logic.display.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionAnswered.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "", "<init>", "()V", "pointId", "", "getPointId", "()J", "Text", "Date", "Range", "Single", "Multiple", "Form", "Matrix", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Date;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Form;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Matrix;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Multiple;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Range;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Single;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Text;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class QuestionAnswered {
    public /* synthetic */ QuestionAnswered(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract long getPointId();

    private QuestionAnswered() {
    }

    /* JADX INFO: compiled from: QuestionAnswered.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Text;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "pointId", "", "answer", "", "<init>", "(JLjava/lang/String;)V", "getPointId", "()J", "getAnswer", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Text extends QuestionAnswered {
        private final String answer;
        private final long pointId;

        public static /* synthetic */ Text copy$default(Text text, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = text.pointId;
            }
            if ((i & 2) != 0) {
                str = text.answer;
            }
            return text.copy(j, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPointId() {
            return this.pointId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAnswer() {
            return this.answer;
        }

        public final Text copy(long pointId, String answer) {
            Intrinsics.checkNotNullParameter(answer, "answer");
            return new Text(pointId, answer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Text)) {
                return false;
            }
            Text text = (Text) other;
            return this.pointId == text.pointId && Intrinsics.areEqual(this.answer, text.answer);
        }

        public int hashCode() {
            return (Long.hashCode(this.pointId) * 31) + this.answer.hashCode();
        }

        public String toString() {
            return "Text(pointId=" + this.pointId + ", answer=" + this.answer + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(long j, String answer) {
            super(null);
            Intrinsics.checkNotNullParameter(answer, "answer");
            this.pointId = j;
            this.answer = answer;
        }

        public final String getAnswer() {
            return this.answer;
        }

        @Override // com.survicate.surveys.core.logic.display.models.QuestionAnswered
        public long getPointId() {
            return this.pointId;
        }
    }

    /* JADX INFO: compiled from: QuestionAnswered.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Date;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "pointId", "", "answer", "", "<init>", "(JLjava/lang/String;)V", "getPointId", "()J", "getAnswer", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Date extends QuestionAnswered {
        private final String answer;
        private final long pointId;

        public static /* synthetic */ Date copy$default(Date date, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = date.pointId;
            }
            if ((i & 2) != 0) {
                str = date.answer;
            }
            return date.copy(j, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPointId() {
            return this.pointId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAnswer() {
            return this.answer;
        }

        public final Date copy(long pointId, String answer) {
            Intrinsics.checkNotNullParameter(answer, "answer");
            return new Date(pointId, answer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Date)) {
                return false;
            }
            Date date = (Date) other;
            return this.pointId == date.pointId && Intrinsics.areEqual(this.answer, date.answer);
        }

        public int hashCode() {
            return (Long.hashCode(this.pointId) * 31) + this.answer.hashCode();
        }

        public String toString() {
            return "Date(pointId=" + this.pointId + ", answer=" + this.answer + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Date(long j, String answer) {
            super(null);
            Intrinsics.checkNotNullParameter(answer, "answer");
            this.pointId = j;
            this.answer = answer;
        }

        public final String getAnswer() {
            return this.answer;
        }

        @Override // com.survicate.surveys.core.logic.display.models.QuestionAnswered
        public long getPointId() {
            return this.pointId;
        }
    }

    /* JADX INFO: compiled from: QuestionAnswered.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Range;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "pointId", "", "answerId", "<init>", "(JLjava/lang/Long;)V", "getPointId", "()J", "getAnswerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(JLjava/lang/Long;)Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Range;", "equals", "", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Range extends QuestionAnswered {
        private final Long answerId;
        private final long pointId;

        public static /* synthetic */ Range copy$default(Range range, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = range.pointId;
            }
            if ((i & 2) != 0) {
                l = range.answerId;
            }
            return range.copy(j, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPointId() {
            return this.pointId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getAnswerId() {
            return this.answerId;
        }

        public final Range copy(long pointId, Long answerId) {
            return new Range(pointId, answerId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Range)) {
                return false;
            }
            Range range = (Range) other;
            return this.pointId == range.pointId && Intrinsics.areEqual(this.answerId, range.answerId);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.pointId) * 31;
            Long l = this.answerId;
            return iHashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "Range(pointId=" + this.pointId + ", answerId=" + this.answerId + ')';
        }

        public Range(long j, Long l) {
            super(null);
            this.pointId = j;
            this.answerId = l;
        }

        public final Long getAnswerId() {
            return this.answerId;
        }

        @Override // com.survicate.surveys.core.logic.display.models.QuestionAnswered
        public long getPointId() {
            return this.pointId;
        }
    }

    /* JADX INFO: compiled from: QuestionAnswered.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Single;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "pointId", "", "answerId", "<init>", "(JLjava/lang/Long;)V", "getPointId", "()J", "getAnswerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(JLjava/lang/Long;)Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Single;", "equals", "", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Single extends QuestionAnswered {
        private final Long answerId;
        private final long pointId;

        public static /* synthetic */ Single copy$default(Single single, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = single.pointId;
            }
            if ((i & 2) != 0) {
                l = single.answerId;
            }
            return single.copy(j, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPointId() {
            return this.pointId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getAnswerId() {
            return this.answerId;
        }

        public final Single copy(long pointId, Long answerId) {
            return new Single(pointId, answerId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Single)) {
                return false;
            }
            Single single = (Single) other;
            return this.pointId == single.pointId && Intrinsics.areEqual(this.answerId, single.answerId);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.pointId) * 31;
            Long l = this.answerId;
            return iHashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "Single(pointId=" + this.pointId + ", answerId=" + this.answerId + ')';
        }

        public Single(long j, Long l) {
            super(null);
            this.pointId = j;
            this.answerId = l;
        }

        public final Long getAnswerId() {
            return this.answerId;
        }

        @Override // com.survicate.surveys.core.logic.display.models.QuestionAnswered
        public long getPointId() {
            return this.pointId;
        }
    }

    /* JADX INFO: compiled from: QuestionAnswered.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Multiple;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "pointId", "", "answersIds", "", "<init>", "(JLjava/util/List;)V", "getPointId", "()J", "getAnswersIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Multiple extends QuestionAnswered {
        private final List<Long> answersIds;
        private final long pointId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Multiple copy$default(Multiple multiple, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = multiple.pointId;
            }
            if ((i & 2) != 0) {
                list = multiple.answersIds;
            }
            return multiple.copy(j, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPointId() {
            return this.pointId;
        }

        public final List<Long> component2() {
            return this.answersIds;
        }

        public final Multiple copy(long pointId, List<Long> answersIds) {
            Intrinsics.checkNotNullParameter(answersIds, "answersIds");
            return new Multiple(pointId, answersIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Multiple)) {
                return false;
            }
            Multiple multiple = (Multiple) other;
            return this.pointId == multiple.pointId && Intrinsics.areEqual(this.answersIds, multiple.answersIds);
        }

        public int hashCode() {
            return (Long.hashCode(this.pointId) * 31) + this.answersIds.hashCode();
        }

        public String toString() {
            return "Multiple(pointId=" + this.pointId + ", answersIds=" + this.answersIds + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Multiple(long j, List<Long> answersIds) {
            super(null);
            Intrinsics.checkNotNullParameter(answersIds, "answersIds");
            this.pointId = j;
            this.answersIds = answersIds;
        }

        public final List<Long> getAnswersIds() {
            return this.answersIds;
        }

        @Override // com.survicate.surveys.core.logic.display.models.QuestionAnswered
        public long getPointId() {
            return this.pointId;
        }
    }

    /* JADX INFO: compiled from: QuestionAnswered.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Form;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "pointId", "", "answers", "", "Lcom/survicate/surveys/core/logic/display/models/FormAnswer;", "<init>", "(JLjava/util/List;)V", "getPointId", "()J", "getAnswers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Form extends QuestionAnswered {
        private final List<FormAnswer> answers;
        private final long pointId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Form copy$default(Form form, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = form.pointId;
            }
            if ((i & 2) != 0) {
                list = form.answers;
            }
            return form.copy(j, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPointId() {
            return this.pointId;
        }

        public final List<FormAnswer> component2() {
            return this.answers;
        }

        public final Form copy(long pointId, List<FormAnswer> answers) {
            Intrinsics.checkNotNullParameter(answers, "answers");
            return new Form(pointId, answers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Form)) {
                return false;
            }
            Form form = (Form) other;
            return this.pointId == form.pointId && Intrinsics.areEqual(this.answers, form.answers);
        }

        public int hashCode() {
            return (Long.hashCode(this.pointId) * 31) + this.answers.hashCode();
        }

        public String toString() {
            return "Form(pointId=" + this.pointId + ", answers=" + this.answers + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Form(long j, List<FormAnswer> answers) {
            super(null);
            Intrinsics.checkNotNullParameter(answers, "answers");
            this.pointId = j;
            this.answers = answers;
        }

        public final List<FormAnswer> getAnswers() {
            return this.answers;
        }

        @Override // com.survicate.surveys.core.logic.display.models.QuestionAnswered
        public long getPointId() {
            return this.pointId;
        }
    }

    /* JADX INFO: compiled from: QuestionAnswered.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Matrix;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "pointId", "", "answers", "", "Lcom/survicate/surveys/core/logic/display/models/MatrixAnswer;", "<init>", "(JLjava/util/List;)V", "getPointId", "()J", "getAnswers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Matrix extends QuestionAnswered {
        private final List<MatrixAnswer> answers;
        private final long pointId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Matrix copy$default(Matrix matrix, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = matrix.pointId;
            }
            if ((i & 2) != 0) {
                list = matrix.answers;
            }
            return matrix.copy(j, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPointId() {
            return this.pointId;
        }

        public final List<MatrixAnswer> component2() {
            return this.answers;
        }

        public final Matrix copy(long pointId, List<MatrixAnswer> answers) {
            Intrinsics.checkNotNullParameter(answers, "answers");
            return new Matrix(pointId, answers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Matrix)) {
                return false;
            }
            Matrix matrix = (Matrix) other;
            return this.pointId == matrix.pointId && Intrinsics.areEqual(this.answers, matrix.answers);
        }

        public int hashCode() {
            return (Long.hashCode(this.pointId) * 31) + this.answers.hashCode();
        }

        public String toString() {
            return "Matrix(pointId=" + this.pointId + ", answers=" + this.answers + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Matrix(long j, List<MatrixAnswer> answers) {
            super(null);
            Intrinsics.checkNotNullParameter(answers, "answers");
            this.pointId = j;
            this.answers = answers;
        }

        public final List<MatrixAnswer> getAnswers() {
            return this.answers;
        }

        @Override // com.survicate.surveys.core.logic.display.models.QuestionAnswered
        public long getPointId() {
            return this.pointId;
        }
    }
}
