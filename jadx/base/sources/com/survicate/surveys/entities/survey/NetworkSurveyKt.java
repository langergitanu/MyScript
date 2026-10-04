package com.survicate.surveys.entities.survey;

import com.survicate.surveys.entities.survey.audience.AudienceVisitorType;
import com.survicate.surveys.entities.survey.audience.NetworkAudience;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkSurvey.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, m1599d2 = {"isContactMode", "", "Lcom/survicate/surveys/entities/survey/NetworkSurvey;", "audiences", "", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudience;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkSurveyKt {
    public static final boolean isContactMode(NetworkSurvey networkSurvey, List<NetworkAudience> audiences) {
        Intrinsics.checkNotNullParameter(networkSurvey, "<this>");
        Intrinsics.checkNotNullParameter(audiences, "audiences");
        List<NetworkAudience> list = audiences;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((NetworkAudience) it.next()).getVisitorType() == AudienceVisitorType.IDENTIFIED) {
                return true;
            }
        }
        return false;
    }
}
