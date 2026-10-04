package com.survicate.surveys.infrastructure.environment;

import android.content.Context;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.ManifestMetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkspaceKeyStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\b\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyStore;", "Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyProvider;", "applicationContext", "Landroid/content/Context;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Landroid/content/Context;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "workspaceKey", "", "getWorkspaceKey", "setWorkspaceKey", "", "readKeyFromManifestOrThrow", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class WorkspaceKeyStore implements WorkspaceKeyProvider {
    private final Context applicationContext;
    private final SdkLogger logger;
    private String workspaceKey;

    public WorkspaceKeyStore(Context applicationContext, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.applicationContext = applicationContext;
        this.logger = logger;
    }

    @Override // com.survicate.surveys.infrastructure.environment.WorkspaceKeyProvider
    public synchronized String getWorkspaceKey() {
        String str;
        if (this.workspaceKey == null) {
            this.workspaceKey = readKeyFromManifestOrThrow();
        }
        str = this.workspaceKey;
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final synchronized void setWorkspaceKey(String workspaceKey) {
        Intrinsics.checkNotNullParameter(workspaceKey, "workspaceKey");
        this.workspaceKey = workspaceKey;
        this.logger.info(LogTags.WORKSPACE, "Changed Workspace Key: " + workspaceKey);
    }

    private final String readKeyFromManifestOrThrow() {
        String strObtainOrNull = ManifestMetaData.obtainOrNull("com.survicate.surveys.workspaceKey", this.applicationContext);
        if (strObtainOrNull == null) {
            throw new IllegalStateException("You need to provide Workspace Key in AndroidManifest.xml meta-data or by setWorkspaceKey method".toString());
        }
        this.logger.info(LogTags.WORKSPACE, "Loaded Workspace Key: " + strObtainOrNull);
        return strObtainOrNull;
    }
}
