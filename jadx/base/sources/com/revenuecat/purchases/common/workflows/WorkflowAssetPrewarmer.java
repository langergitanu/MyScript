package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.uiconfig.UiConfigProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.paywalls.OfferingFontPreDownloader;
import com.revenuecat.purchases.paywalls.PaywallAssetWarming;
import com.revenuecat.purchases.utils.PaywallComponentAssets;
import com.revenuecat.purchases.utils.PaywallComponentAssetsKt;
import com.yalantis.ucrop.UCrop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowAssetPrewarmer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010\u000eJ<\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2$\u0010\u0012\u001a \b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowAssetPrewarmer;", "", "uiConfigProvider", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;", "assetWarming", "Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;", "offeringFontPreDownloader", "Lcom/revenuecat/purchases/paywalls/OfferingFontPreDownloader;", "(Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;Lcom/revenuecat/purchases/paywalls/OfferingFontPreDownloader;)V", "warmedWorkflowIds", "", "", "loadUiConfig", "Lcom/revenuecat/purchases/UiConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onWorkflowLoaded", "", "workflowId", "transientDecode", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preDownloadWorkflowAssets", Keys.WORKFLOW, "uiConfig", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WorkflowAssetPrewarmer {
    private final PaywallAssetWarming assetWarming;
    private final OfferingFontPreDownloader offeringFontPreDownloader;
    private final UiConfigProvider uiConfigProvider;
    private final Set<String> warmedWorkflowIds;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowAssetPrewarmer$loadUiConfig$1 */
    /* JADX INFO: compiled from: WorkflowAssetPrewarmer.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowAssetPrewarmer", m1609f = "WorkflowAssetPrewarmer.kt", m1610i = {}, m1611l = {80}, m1612m = "loadUiConfig", m1613n = {}, m1615s = {})
    static final class C72521 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C72521(Continuation<? super C72521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowAssetPrewarmer.this.loadUiConfig(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowAssetPrewarmer$onWorkflowLoaded$1 */
    /* JADX INFO: compiled from: WorkflowAssetPrewarmer.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowAssetPrewarmer", m1609f = "WorkflowAssetPrewarmer.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {65, UCrop.REQUEST_CROP}, m1612m = "onWorkflowLoaded", m1613n = {"this", "workflowId", "transientDecode", "this", "workflowId", "uiConfig"}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C72531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C72531(Continuation<? super C72531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowAssetPrewarmer.this.onWorkflowLoaded(null, null, this);
        }
    }

    public WorkflowAssetPrewarmer(UiConfigProvider uiConfigProvider, PaywallAssetWarming assetWarming, OfferingFontPreDownloader offeringFontPreDownloader) {
        Intrinsics.checkNotNullParameter(uiConfigProvider, "uiConfigProvider");
        Intrinsics.checkNotNullParameter(assetWarming, "assetWarming");
        Intrinsics.checkNotNullParameter(offeringFontPreDownloader, "offeringFontPreDownloader");
        this.uiConfigProvider = uiConfigProvider;
        this.assetWarming = assetWarming;
        this.offeringFontPreDownloader = offeringFontPreDownloader;
        this.warmedWorkflowIds = new LinkedHashSet();
    }

    public final void preDownloadWorkflowAssets(PublishedWorkflow workflow, UiConfig uiConfig) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        synchronized (this.warmedWorkflowIds) {
            if (this.warmedWorkflowIds.add(workflow.getId())) {
                Unit unit = Unit.INSTANCE;
                if (this.assetWarming.isAvailable()) {
                    List<WorkflowScreen> listScreensInVisitOrder = WorkflowScreenOrderKt.screensInVisitOrder(workflow);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listScreensInVisitOrder, 10));
                    Iterator<T> it = listScreensInVisitOrder.iterator();
                    while (it.hasNext()) {
                        arrayList.add(PaywallComponentAssetsKt.collectAssets(((WorkflowScreen) it.next()).getComponentsConfig().getBase()));
                    }
                    PaywallAssetWarming paywallAssetWarming = this.assetWarming;
                    ArrayList arrayList2 = arrayList;
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        CollectionsKt.addAll(linkedHashSet, ((PaywallComponentAssets) it2.next()).getImageUris());
                    }
                    paywallAssetWarming.warmImages(linkedHashSet);
                    PaywallAssetWarming paywallAssetWarming2 = this.assetWarming;
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        CollectionsKt.addAll(linkedHashSet2, ((PaywallComponentAssets) it3.next()).getWebViewUrls());
                    }
                    paywallAssetWarming2.warmWebViewUrls(linkedHashSet2);
                }
                this.offeringFontPreDownloader.preDownloadFontsIfNeeded(uiConfig.getApp().getFonts().values());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0099 A[Catch: Exception -> 0x0039, CancellationException -> 0x003c, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x003c, blocks: (B:13:0x0035, B:41:0x0095, B:43:0x0099, B:37:0x0081), top: B:58:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onWorkflowLoaded(String str, Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        C72531 c72531;
        boolean zContains;
        WorkflowAssetPrewarmer workflowAssetPrewarmer;
        String str2;
        Exception e;
        Object objInvoke;
        UiConfig uiConfig;
        WorkflowAssetPrewarmer workflowAssetPrewarmer2;
        PublishedWorkflow publishedWorkflow;
        if (continuation instanceof C72531) {
            c72531 = (C72531) continuation;
            if ((c72531.label & Integer.MIN_VALUE) != 0) {
                c72531.label -= Integer.MIN_VALUE;
            } else {
                c72531 = new C72531(continuation);
            }
        }
        Object objLoadUiConfig = c72531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72531.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objLoadUiConfig);
                synchronized (this.warmedWorkflowIds) {
                    zContains = this.warmedWorkflowIds.contains(str);
                }
                if (zContains) {
                    return Unit.INSTANCE;
                }
                c72531.L$0 = this;
                c72531.L$1 = str;
                c72531.L$2 = function2;
                c72531.label = 1;
                objLoadUiConfig = loadUiConfig(c72531);
                if (objLoadUiConfig != coroutine_suspended) {
                    workflowAssetPrewarmer = this;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                uiConfig = (UiConfig) c72531.L$2;
                str2 = (String) c72531.L$1;
                workflowAssetPrewarmer2 = (WorkflowAssetPrewarmer) c72531.L$0;
                try {
                    ResultKt.throwOnFailure(objLoadUiConfig);
                    publishedWorkflow = (PublishedWorkflow) objLoadUiConfig;
                    if (publishedWorkflow != null) {
                        workflowAssetPrewarmer2.preDownloadWorkflowAssets(publishedWorkflow, uiConfig);
                    }
                } catch (Exception e2) {
                    e = e2;
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to prewarm assets for workflow '" + str2 + "'.", e);
                }
                return Unit.INSTANCE;
            }
            function2 = (Function2) c72531.L$2;
            str = (String) c72531.L$1;
            workflowAssetPrewarmer = (WorkflowAssetPrewarmer) c72531.L$0;
            ResultKt.throwOnFailure(objLoadUiConfig);
            UiConfig uiConfig2 = (UiConfig) objLoadUiConfig;
            if (uiConfig2 == null) {
                return Unit.INSTANCE;
            }
            try {
                c72531.L$0 = workflowAssetPrewarmer;
                c72531.L$1 = str;
                c72531.L$2 = uiConfig2;
                c72531.label = 2;
                objInvoke = function2.invoke(str, c72531);
            } catch (Exception e3) {
                str2 = str;
                e = e3;
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to prewarm assets for workflow '" + str2 + "'.", e);
            }
            if (objInvoke != coroutine_suspended) {
                str2 = str;
                uiConfig = uiConfig2;
                objLoadUiConfig = objInvoke;
                workflowAssetPrewarmer2 = workflowAssetPrewarmer;
                publishedWorkflow = (PublishedWorkflow) objLoadUiConfig;
                if (publishedWorkflow != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (CancellationException e4) {
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadUiConfig(Continuation<? super UiConfig> continuation) {
        C72521 c72521;
        if (continuation instanceof C72521) {
            c72521 = (C72521) continuation;
            if ((c72521.label & Integer.MIN_VALUE) != 0) {
                c72521.label -= Integer.MIN_VALUE;
            } else {
                c72521 = new C72521(continuation);
            }
        }
        Object uiConfig = c72521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72521.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(uiConfig);
                UiConfigProvider uiConfigProvider = this.uiConfigProvider;
                c72521.label = 1;
                uiConfig = uiConfigProvider.getUiConfig(c72521);
                if (uiConfig == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(uiConfig);
            }
            return (UiConfig) uiConfig;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to load ui_config; skipping workflow asset prewarm.", e2);
            return null;
        }
    }
}
