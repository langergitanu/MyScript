package com.revenuecat.purchases;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchasesServices.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0014\u0010\u000e\u001a\u00020\t*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u00020\t*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/ServiceLoaderDispatcher;", "Lcom/revenuecat/purchases/PurchasesServiceDispatcher;", "()V", "configuredPurchases", "Lcom/revenuecat/purchases/Purchases;", Literals.SERVICES_KEYWORD, "", "Lcom/revenuecat/purchases/PurchasesService;", "close", "", "purchases", "closeServices", "initialize", "loadServices", "safelyClose", "safelyInitialize", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class ServiceLoaderDispatcher implements PurchasesServiceDispatcher {
    private Purchases configuredPurchases;
    private List<? extends PurchasesService> services = CollectionsKt.emptyList();

    @Override // com.revenuecat.purchases.PurchasesServiceDispatcher
    public synchronized void initialize(Purchases purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        closeServices();
        List<PurchasesService> listLoadServices = loadServices();
        this.services = listLoadServices;
        this.configuredPurchases = purchases;
        Iterator<T> it = listLoadServices.iterator();
        while (it.hasNext()) {
            safelyInitialize((PurchasesService) it.next(), purchases);
        }
    }

    @Override // com.revenuecat.purchases.PurchasesServiceDispatcher
    public synchronized void close(Purchases purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        closeServices();
    }

    private final void closeServices() {
        Purchases purchases = this.configuredPurchases;
        if (purchases == null) {
            return;
        }
        Iterator<T> it = this.services.iterator();
        while (it.hasNext()) {
            safelyClose((PurchasesService) it.next(), purchases);
        }
        this.services = CollectionsKt.emptyList();
        this.configuredPurchases = null;
    }

    private final void safelyInitialize(PurchasesService purchasesService, Purchases purchases) {
        Object objM14499constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            purchasesService.initialize(purchases);
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "PurchasesService " + purchasesService.getClass().getName() + " threw during initialize.", thM14502exceptionOrNullimpl);
        }
    }

    private final void safelyClose(PurchasesService purchasesService, Purchases purchases) {
        Object objM14499constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            purchasesService.close(purchases);
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "PurchasesService " + purchasesService.getClass().getName() + " threw during close.", thM14502exceptionOrNullimpl);
        }
    }

    private final List<PurchasesService> loadServices() {
        Object objM14499constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ServiceLoaderDispatcher serviceLoaderDispatcher = this;
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(PurchasesService.class, PurchasesService.class.getClassLoader());
            Intrinsics.checkNotNullExpressionValue(serviceLoaderLoad, "load(\n            Purcha…va.classLoader,\n        )");
            objM14499constructorimpl = Result.m14499constructorimpl(CollectionsKt.toList(serviceLoaderLoad));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to load PurchasesService implementations.", thM14502exceptionOrNullimpl);
            objM14499constructorimpl = CollectionsKt.emptyList();
        }
        return (List) objM14499constructorimpl;
    }
}
