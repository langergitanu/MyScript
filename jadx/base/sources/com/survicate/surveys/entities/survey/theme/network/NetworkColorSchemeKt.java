package com.survicate.surveys.entities.survey.theme.network;

import com.survicate.surveys.entities.survey.theme.ColorScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkColorScheme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"toDomainModel", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkColorSchemeKt {
    public static final ColorScheme toDomainModel(NetworkColorScheme networkColorScheme) {
        Intrinsics.checkNotNullParameter(networkColorScheme, "<this>");
        return new ColorScheme(networkColorScheme.getQuestion(), networkColorScheme.getAnswer(), networkColorScheme.getButton(), networkColorScheme.getBackground(), networkColorScheme.getProgressBar());
    }
}
