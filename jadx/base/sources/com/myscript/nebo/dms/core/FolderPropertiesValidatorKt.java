package com.myscript.nebo.dms.core;

import com.myscript.nebo.common.utils.NameUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FolderPropertiesValidator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"NEBO_EXTENSION", "", "hasNeboExtension", "", "name", "removeNeboExtension", "cleanFolderName", "dms_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderPropertiesValidatorKt {
    private static final String NEBO_EXTENSION = ".nebo";

    public static final boolean hasNeboExtension(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.endsWith$default(name, NEBO_EXTENSION, false, 2, (Object) null);
    }

    public static final String removeNeboExtension(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.removeSuffix(name, (CharSequence) NEBO_EXTENSION);
    }

    public static final String cleanFolderName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return NameUtils.cleanName$default(name, 0, null, 6, null);
    }
}
