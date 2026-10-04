package com.survicate.surveys.entities.survey.theme.network;

import com.survicate.surveys.entities.survey.theme.ThemeType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkThemeType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"toDomainModel", "Lcom/survicate/surveys/entities/survey/theme/ThemeType;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeType;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkThemeTypeKt {

    /* JADX INFO: compiled from: NetworkThemeType.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkThemeType.values().length];
            try {
                iArr[NetworkThemeType.MICRO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ThemeType toDomainModel(NetworkThemeType networkThemeType) {
        Intrinsics.checkNotNullParameter(networkThemeType, "<this>");
        if (WhenMappings.$EnumSwitchMapping$0[networkThemeType.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return ThemeType.MICRO;
    }
}
