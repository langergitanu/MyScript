package com.survicate.surveys.traits;

import com.survicate.surveys.core.traits.CoreUserTrait;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserTraitExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1599d2 = {"toCoreUserTrait", "Lcom/survicate/surveys/core/traits/CoreUserTrait;", "Lcom/survicate/surveys/traits/UserTrait;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UserTraitExtensionsKt {
    public static final CoreUserTrait toCoreUserTrait(UserTrait userTrait) {
        Intrinsics.checkNotNullParameter(userTrait, "<this>");
        return new CoreUserTrait(userTrait.key, userTrait.value);
    }
}
