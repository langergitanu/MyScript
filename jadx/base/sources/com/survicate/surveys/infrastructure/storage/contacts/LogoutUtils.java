package com.survicate.surveys.infrastructure.storage.contacts;

import com.survicate.surveys.helpers.UserTraitUtilsKt;
import com.survicate.surveys.traits.UserTrait;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogoutUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\"\u0010\n\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J$\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J$\u0010\f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/LogoutUtils;", "", "<init>", "()V", "shouldLogout", "", "updatedTraits", "", "Lcom/survicate/surveys/traits/UserTrait;", "savedTraits", "shouldClearUserData", "isUserIdChanged", "isUserKeyCleared", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LogoutUtils {
    public static final LogoutUtils INSTANCE = new LogoutUtils();

    private LogoutUtils() {
    }

    public final boolean shouldLogout(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits) {
        Intrinsics.checkNotNullParameter(updatedTraits, "updatedTraits");
        Intrinsics.checkNotNullParameter(savedTraits, "savedTraits");
        return isUserIdChanged(updatedTraits, savedTraits) || isUserKeyCleared(updatedTraits, savedTraits);
    }

    public final boolean shouldClearUserData(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits) {
        Intrinsics.checkNotNullParameter(updatedTraits, "updatedTraits");
        Intrinsics.checkNotNullParameter(savedTraits, "savedTraits");
        return isUserIdChanged(updatedTraits, savedTraits);
    }

    private final boolean isUserIdChanged(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits) {
        String str;
        UserTrait userTraitFindUserIdTrait = UserTraitUtilsKt.findUserIdTrait(updatedTraits);
        UserTrait userTraitFindUserIdTrait2 = UserTraitUtilsKt.findUserIdTrait(savedTraits);
        return (userTraitFindUserIdTrait2 == null || (str = userTraitFindUserIdTrait2.value) == null || str.length() <= 0 || userTraitFindUserIdTrait == null || Intrinsics.areEqual(userTraitFindUserIdTrait.value, userTraitFindUserIdTrait2.value)) ? false : true;
    }

    private final boolean isUserKeyCleared(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits) {
        String str;
        UserTrait userTraitFindUserKeyTrait = UserTraitUtilsKt.findUserKeyTrait(updatedTraits);
        UserTrait userTraitFindUserKeyTrait2 = UserTraitUtilsKt.findUserKeyTrait(savedTraits);
        return (userTraitFindUserKeyTrait2 == null || (str = userTraitFindUserKeyTrait2.value) == null || str.length() <= 0 || userTraitFindUserKeyTrait == null || userTraitFindUserKeyTrait.value.length() != 0) ? false : true;
    }
}
