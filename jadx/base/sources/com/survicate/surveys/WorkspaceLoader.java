package com.survicate.surveys;

import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.infrastructure.network.InstalledRequestBody;
import com.survicate.surveys.infrastructure.network.NetworkWorkspace;
import com.survicate.surveys.infrastructure.network.NetworkWorkspaceKt;
import com.survicate.surveys.infrastructure.network.WorkspaceApi;
import com.survicate.surveys.targeting.TargetingFiltersFactory;
import java.util.Date;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: WorkspaceLoader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/survicate/surveys/WorkspaceLoader;", "", "workspaceApi", "Lcom/survicate/surveys/infrastructure/network/WorkspaceApi;", "persistenceManager", "Lcom/survicate/surveys/PersistenceManager;", "targetingFiltersFactory", "Lcom/survicate/surveys/targeting/TargetingFiltersFactory;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/WorkspaceApi;Lcom/survicate/surveys/PersistenceManager;Lcom/survicate/surveys/targeting/TargetingFiltersFactory;Lcom/survicate/surveys/core/logging/SdkLogger;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isLoading", "", "lastLoadJob", "Lkotlinx/coroutines/Job;", "loadWorkspace", "", "force", "fetchWorkspace", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveWorkspace", "workspace", "Lcom/survicate/surveys/entities/survey/Workspace;", "sendInstalledRequest", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class WorkspaceLoader {
    private final CoroutineScope coroutineScope;
    private boolean isLoading;
    private Job lastLoadJob;
    private final SdkLogger logger;
    private final PersistenceManager persistenceManager;
    private final TargetingFiltersFactory targetingFiltersFactory;
    private final WorkspaceApi workspaceApi;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkspaceLoader(WorkspaceApi workspaceApi, PersistenceManager persistenceManager, TargetingFiltersFactory targetingFiltersFactory, SdkLogger logger) {
        this(workspaceApi, persistenceManager, targetingFiltersFactory, logger, null, 16, null);
        Intrinsics.checkNotNullParameter(workspaceApi, "workspaceApi");
        Intrinsics.checkNotNullParameter(persistenceManager, "persistenceManager");
        Intrinsics.checkNotNullParameter(targetingFiltersFactory, "targetingFiltersFactory");
        Intrinsics.checkNotNullParameter(logger, "logger");
    }

    public WorkspaceLoader(WorkspaceApi workspaceApi, PersistenceManager persistenceManager, TargetingFiltersFactory targetingFiltersFactory, SdkLogger logger, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(workspaceApi, "workspaceApi");
        Intrinsics.checkNotNullParameter(persistenceManager, "persistenceManager");
        Intrinsics.checkNotNullParameter(targetingFiltersFactory, "targetingFiltersFactory");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.workspaceApi = workspaceApi;
        this.persistenceManager = persistenceManager;
        this.targetingFiltersFactory = targetingFiltersFactory;
        this.logger = logger;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(ioDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    public /* synthetic */ WorkspaceLoader(WorkspaceApi workspaceApi, PersistenceManager persistenceManager, TargetingFiltersFactory targetingFiltersFactory, SdkLogger sdkLogger, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(workspaceApi, persistenceManager, targetingFiltersFactory, sdkLogger, (i & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final synchronized void loadWorkspace(boolean force) {
        if (this.isLoading && !force) {
            this.logger.info(LogTags.WORKSPACE, "Workspace is already loading, skipping.");
            return;
        }
        this.isLoading = true;
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, CoroutineStart.LAZY, new WorkspaceLoader$loadWorkspace$newLoadJob$1(this, null), 1, null);
        Job job = this.lastLoadJob;
        this.lastLoadJob = jobLaunch$default;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        jobLaunch$default.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchWorkspace(Continuation<? super Unit> continuation) {
        NetworkWorkspace networkWorkspaceFetchWorkspace = this.workspaceApi.fetchWorkspace();
        JobKt.ensureActive(continuation.getContext());
        Workspace workspaceMapToWorkspace = NetworkWorkspaceKt.mapToWorkspace(networkWorkspaceFetchWorkspace, new Date(), this.targetingFiltersFactory);
        this.logger.info(LogTags.WORKSPACE, "Loaded " + networkWorkspaceFetchWorkspace.getSurveys().size() + " surveys from api.");
        saveWorkspace(workspaceMapToWorkspace);
        if (networkWorkspaceFetchWorkspace.getInstalling()) {
            this.logger.info(LogTags.WORKSPACE, "Need to send installed request to api.");
            sendInstalledRequest();
        }
        return Unit.INSTANCE;
    }

    private final void saveWorkspace(Workspace workspace) {
        try {
            this.logger.debug(LogTags.WORKSPACE, "Surveys to save: " + workspace.getSurveys());
            this.persistenceManager.saveWorkspace(workspace);
            this.logger.info(LogTags.WORKSPACE, "Surveys saved");
        } catch (Exception e) {
            this.logger.error(LogTags.WORKSPACE, "Failed to save workspace", e);
        }
    }

    private final void sendInstalledRequest() {
        try {
            this.workspaceApi.sendInstalled(new InstalledRequestBody());
            this.logger.info(LogTags.WORKSPACE, "Installed event has been sent.");
        } catch (Exception e) {
            this.logger.error(LogTags.WORKSPACE, "Failed to send installed event", e);
        }
    }
}
