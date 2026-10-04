package com.survicate.surveys;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateAnswer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JB\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/SurvicateAnswer;", "", "type", "", "id", "", "ids", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Set;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIds", "()Ljava/util/Set;", "getValue", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Set;Ljava/lang/String;)Lcom/survicate/surveys/SurvicateAnswer;", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurvicateAnswer {
    private final Long id;
    private final Set<Long> ids;
    private final String type;
    private final String value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurvicateAnswer copy$default(SurvicateAnswer survicateAnswer, String str, Long l, Set set, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = survicateAnswer.type;
        }
        if ((i & 2) != 0) {
            l = survicateAnswer.id;
        }
        if ((i & 4) != 0) {
            set = survicateAnswer.ids;
        }
        if ((i & 8) != 0) {
            str2 = survicateAnswer.value;
        }
        return survicateAnswer.copy(str, l, set, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    public final Set<Long> component3() {
        return this.ids;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final SurvicateAnswer copy(String type, Long id, Set<Long> ids, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new SurvicateAnswer(type, id, ids, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurvicateAnswer)) {
            return false;
        }
        SurvicateAnswer survicateAnswer = (SurvicateAnswer) other;
        return Intrinsics.areEqual(this.type, survicateAnswer.type) && Intrinsics.areEqual(this.id, survicateAnswer.id) && Intrinsics.areEqual(this.ids, survicateAnswer.ids) && Intrinsics.areEqual(this.value, survicateAnswer.value);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Long l = this.id;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Set<Long> set = this.ids;
        int iHashCode3 = (iHashCode2 + (set == null ? 0 : set.hashCode())) * 31;
        String str = this.value;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SurvicateAnswer(type=" + this.type + ", id=" + this.id + ", ids=" + this.ids + ", value=" + this.value + ')';
    }

    public SurvicateAnswer(String type, Long l, Set<Long> set, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.id = l;
        this.ids = set;
        this.value = str;
    }

    public final String getType() {
        return this.type;
    }

    public final Long getId() {
        return this.id;
    }

    public final Set<Long> getIds() {
        return this.ids;
    }

    public final String getValue() {
        return this.value;
    }
}
