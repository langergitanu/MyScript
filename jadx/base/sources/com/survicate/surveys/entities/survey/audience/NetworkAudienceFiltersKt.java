package com.survicate.surveys.entities.survey.audience;

import com.survicate.surveys.core.providers.LocaleProvider;
import com.survicate.surveys.core.targeting.audience.KnownUserAudienceFilter;
import com.survicate.surveys.core.targeting.audience.LocaleAudienceFilter;
import com.survicate.surveys.core.targeting.audience.PlatformAudienceFilter;
import com.survicate.surveys.core.targeting.audience.ScreenOrientationAudienceFilter;
import com.survicate.surveys.core.targeting.audience.UserTraitsAudienceFilter;
import com.survicate.surveys.core.targeting.provider.CoreUserTraitsProvider;
import com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute;
import com.survicate.surveys.utils.AndroidScreenOrientationProvider;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkAudienceFilters.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\u0000\u001a\u00020\t*\u00020\nH\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¨\u0006\u0013"}, m1599d2 = {"toDomainModel", "Lcom/survicate/surveys/core/targeting/audience/LocaleAudienceFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceLocaleFilter;", "localeProvider", "Lcom/survicate/surveys/core/providers/LocaleProvider;", "Lcom/survicate/surveys/core/targeting/audience/KnownUserAudienceFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceKnownUserFilter;", "userTraitsProvider", "Lcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;", "Lcom/survicate/surveys/core/targeting/audience/PlatformAudienceFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudiencePlatformFilter;", "Lcom/survicate/surveys/core/targeting/audience/UserTraitsAudienceFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceUserFilter;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "Lcom/survicate/surveys/core/targeting/audience/ScreenOrientationAudienceFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceScreenOrientationFilter;", "screenOrientationProvider", "Lcom/survicate/surveys/utils/AndroidScreenOrientationProvider;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkAudienceFiltersKt {
    public static final LocaleAudienceFilter toDomainModel(NetworkAudienceLocaleFilter networkAudienceLocaleFilter, LocaleProvider localeProvider) {
        Intrinsics.checkNotNullParameter(networkAudienceLocaleFilter, "<this>");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        return new LocaleAudienceFilter(networkAudienceLocaleFilter.getValues(), networkAudienceLocaleFilter.getExclude(), localeProvider);
    }

    public static final KnownUserAudienceFilter toDomainModel(NetworkAudienceKnownUserFilter networkAudienceKnownUserFilter, CoreUserTraitsProvider userTraitsProvider) {
        Intrinsics.checkNotNullParameter(networkAudienceKnownUserFilter, "<this>");
        Intrinsics.checkNotNullParameter(userTraitsProvider, "userTraitsProvider");
        return new KnownUserAudienceFilter(networkAudienceKnownUserFilter.getValues(), networkAudienceKnownUserFilter.getExclude(), userTraitsProvider);
    }

    public static final PlatformAudienceFilter toDomainModel(NetworkAudiencePlatformFilter networkAudiencePlatformFilter) {
        Intrinsics.checkNotNullParameter(networkAudiencePlatformFilter, "<this>");
        return new PlatformAudienceFilter(networkAudiencePlatformFilter.getValues(), networkAudiencePlatformFilter.getExclude());
    }

    public static final UserTraitsAudienceFilter toDomainModel(NetworkAudienceUserFilter networkAudienceUserFilter, CoreUserTraitsProvider userTraitsProvider, TimestampProvider timestampProvider) {
        Intrinsics.checkNotNullParameter(networkAudienceUserFilter, "<this>");
        Intrinsics.checkNotNullParameter(userTraitsProvider, "userTraitsProvider");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        List<NetworkAudienceUserFilterAttribute> values = networkAudienceUserFilter.getValues();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(((NetworkAudienceUserFilterAttribute) it.next()).toDomainModel(timestampProvider));
        }
        return new UserTraitsAudienceFilter(arrayList, AudienceRelationKt.toCoreRelation(networkAudienceUserFilter.getRelation()), networkAudienceUserFilter.getExclude(), userTraitsProvider);
    }

    public static final ScreenOrientationAudienceFilter toDomainModel(NetworkAudienceScreenOrientationFilter networkAudienceScreenOrientationFilter, AndroidScreenOrientationProvider screenOrientationProvider) {
        Intrinsics.checkNotNullParameter(networkAudienceScreenOrientationFilter, "<this>");
        Intrinsics.checkNotNullParameter(screenOrientationProvider, "screenOrientationProvider");
        return new ScreenOrientationAudienceFilter(networkAudienceScreenOrientationFilter.getValues(), networkAudienceScreenOrientationFilter.getExclude(), screenOrientationProvider);
    }
}
