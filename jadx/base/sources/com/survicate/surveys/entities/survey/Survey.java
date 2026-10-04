package com.survicate.surveys.entities.survey;

import com.survicate.surveys.core.targeting.displayfilter.DisplayFilter;
import com.survicate.surveys.entities.survey.audience.AudienceVisitorType;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.theme.ThemeConfiguration;
import com.survicate.surveys.targeting.audience.Audience;
import com.survicate.surveys.utils.MiscUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Survey.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010%\u001a\u00020\u0003H\u0016J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020\u001eJ\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\u0006\u0010,\u001a\u00020'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006-"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/Survey;", "", "id", "", "name", "points", "", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "displayFilters", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "audiences", "Lcom/survicate/surveys/targeting/audience/Audience;", "settings", "Lcom/survicate/surveys/entities/survey/SurveySettings;", "theme", "Lcom/survicate/surveys/entities/survey/theme/ThemeConfiguration;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/survicate/surveys/entities/survey/SurveySettings;Lcom/survicate/surveys/entities/survey/theme/ThemeConfiguration;)V", "getId", "()Ljava/lang/String;", "getName", "getPoints", "()Ljava/util/List;", "getDisplayFilters", "getAudiences", "getSettings", "()Lcom/survicate/surveys/entities/survey/SurveySettings;", "getTheme", "()Lcom/survicate/surveys/entities/survey/theme/ThemeConfiguration;", "isContactMode", "", "()Z", "value", "", "answerCount", "getAnswerCount", "()I", "toString", "incrementAnswerCount", "", "decrementAnswerCount", "canBeDisplayed", "allDisplayFiltersSatisfied", "anyAudienceSatisfied", "resetState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class Survey {
    private int answerCount;
    private final List<Audience> audiences;
    private final List<DisplayFilter> displayFilters;
    private final String id;
    private final String name;
    private final List<SurveyPoint> points;
    private final SurveySettings settings;
    private final ThemeConfiguration theme;

    /* JADX WARN: Multi-variable type inference failed */
    public Survey(String id, String name, List<? extends SurveyPoint> points, List<? extends DisplayFilter> displayFilters, List<Audience> audiences, SurveySettings settings, ThemeConfiguration theme) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(displayFilters, "displayFilters");
        Intrinsics.checkNotNullParameter(audiences, "audiences");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.id = id;
        this.name = name;
        this.points = points;
        this.displayFilters = displayFilters;
        this.audiences = audiences;
        this.settings = settings;
        this.theme = theme;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<SurveyPoint> getPoints() {
        return this.points;
    }

    public final List<DisplayFilter> getDisplayFilters() {
        return this.displayFilters;
    }

    public final List<Audience> getAudiences() {
        return this.audiences;
    }

    public final SurveySettings getSettings() {
        return this.settings;
    }

    public final ThemeConfiguration getTheme() {
        return this.theme;
    }

    public final boolean isContactMode() {
        List<Audience> list = this.audiences;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Audience) it.next()).getVisitorType() == AudienceVisitorType.IDENTIFIED) {
                return true;
            }
        }
        return false;
    }

    public final int getAnswerCount() {
        return this.answerCount;
    }

    public String toString() {
        return MiscUtilsKt.reflectionToString(this);
    }

    public final void incrementAnswerCount() {
        this.answerCount++;
    }

    public final void decrementAnswerCount() {
        this.answerCount--;
    }

    public final boolean canBeDisplayed() {
        return allDisplayFiltersSatisfied() && anyAudienceSatisfied();
    }

    private final boolean allDisplayFiltersSatisfied() {
        List<DisplayFilter> list = this.displayFilters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((DisplayFilter) it.next()).isSatisfied()));
        }
        ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return true;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            if (!((Boolean) it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private final boolean anyAudienceSatisfied() {
        List<Audience> list = this.audiences;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Audience) it.next()).isSatisfied()) {
                return true;
            }
        }
        return false;
    }

    public final void resetState() {
        this.answerCount = 0;
    }
}
