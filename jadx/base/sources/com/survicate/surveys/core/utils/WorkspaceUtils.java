package com.survicate.surveys.core.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WorkspaceUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/core/utils/WorkspaceUtils;", "", "<init>", "()V", "WORKSPACE_KEY_LENGTH", "", "isWorkspaceKeyValid", "", "workspaceKey", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class WorkspaceUtils {
    public static final WorkspaceUtils INSTANCE = new WorkspaceUtils();
    private static final int WORKSPACE_KEY_LENGTH = 32;

    private WorkspaceUtils() {
    }

    public final boolean isWorkspaceKeyValid(String workspaceKey) {
        Intrinsics.checkNotNullParameter(workspaceKey, "workspaceKey");
        return StringsKt.trim((CharSequence) workspaceKey).toString().length() == 32;
    }
}
