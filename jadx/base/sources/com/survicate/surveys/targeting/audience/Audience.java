package com.survicate.surveys.targeting.audience;

import com.survicate.surveys.core.targeting.audience.AudienceFilter;
import com.survicate.surveys.entities.survey.audience.AudienceRelation;
import com.survicate.surveys.entities.survey.audience.AudienceVisitorType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Audience.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/targeting/audience/Audience;", "", "id", "", "relation", "Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;", "filters", "", "Lcom/survicate/surveys/core/targeting/audience/AudienceFilter;", "visitorType", "Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;", "<init>", "(JLcom/survicate/surveys/entities/survey/audience/AudienceRelation;Ljava/util/List;Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;)V", "getId", "()J", "getRelation", "()Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;", "getFilters", "()Ljava/util/List;", "getVisitorType", "()Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;", "isSatisfied", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class Audience {
    private final List<AudienceFilter> filters;
    private final long id;
    private final AudienceRelation relation;
    private final AudienceVisitorType visitorType;

    /* JADX INFO: compiled from: Audience.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudienceRelation.values().length];
            try {
                iArr[AudienceRelation.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudienceRelation.f2274OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Audience(long j, AudienceRelation relation, List<? extends AudienceFilter> filters, AudienceVisitorType visitorType) {
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(filters, "filters");
        Intrinsics.checkNotNullParameter(visitorType, "visitorType");
        this.id = j;
        this.relation = relation;
        this.filters = filters;
        this.visitorType = visitorType;
    }

    public final long getId() {
        return this.id;
    }

    public final AudienceRelation getRelation() {
        return this.relation;
    }

    public final List<AudienceFilter> getFilters() {
        return this.filters;
    }

    public final AudienceVisitorType getVisitorType() {
        return this.visitorType;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isSatisfied() {
        Object obj;
        List<AudienceFilter> list = this.filters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((AudienceFilter) it.next()).isSatisfied()));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            while (it2.hasNext()) {
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                boolean zBooleanValue2 = ((Boolean) next).booleanValue();
                int i = WhenMappings.$EnumSwitchMapping$0[this.relation.ordinal()];
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (zBooleanValue2 || zBooleanValue) {
                        z = true;
                    }
                } else if (!zBooleanValue2 || !zBooleanValue) {
                }
                next = Boolean.valueOf(z);
            }
            obj = next;
        } else {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }
}
