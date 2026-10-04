package com.survicate.surveys.utils;

import com.survicate.surveys.traits.UserTrait;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserTraitsValidator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/utils/UserTraitsValidator;", "", "<init>", "()V", "filterOutInvalidTraits", "", "Lcom/survicate/surveys/traits/UserTrait;", "userTraits", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UserTraitsValidator {
    public static final UserTraitsValidator INSTANCE = new UserTraitsValidator();

    private UserTraitsValidator() {
    }

    @JvmStatic
    public static final List<UserTrait> filterOutInvalidTraits(List<? extends UserTrait> userTraits) {
        Intrinsics.checkNotNullParameter(userTraits, "userTraits");
        ArrayList arrayList = new ArrayList();
        for (Object obj : userTraits) {
            if (((UserTrait) obj).key.length() > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
