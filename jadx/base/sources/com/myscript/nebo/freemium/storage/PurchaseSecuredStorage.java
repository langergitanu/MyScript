package com.myscript.nebo.freemium.storage;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.media3.common.MimeTypes;
import com.myscript.nebo.freemium.InAppProduct;
import com.myscript.nebo.log.TechnicalLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchaseSecuredStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/freemium/storage/PurchaseSecuredStorage;", "Lcom/myscript/nebo/freemium/storage/PurchaseStorage;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/log/TechnicalLogger;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "store", "", "productId", "", "purchaseToken", "get", "product", "Lcom/myscript/nebo/freemium/InAppProduct;", "has", "", "remove", "Companion", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PurchaseSecuredStorage implements PurchaseStorage {
    private static final String FALLBACK_PREFS_NAME = "fallback_purchases_prefs";
    private static final String SECURE_PREFS_NAME = "secure_purchases_prefs_file";
    private final SharedPreferences sharedPreferences;
    public static final int $stable = 8;

    public PurchaseSecuredStorage(Application application, TechnicalLogger technicalLogger) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.sharedPreferences = SecureStorageHelperKt.getSecureSharedPreferences(application, SECURE_PREFS_NAME, FALLBACK_PREFS_NAME, technicalLogger);
    }

    public /* synthetic */ PurchaseSecuredStorage(Application application, TechnicalLogger technicalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? null : technicalLogger);
    }

    @Override // com.myscript.nebo.freemium.storage.PurchaseStorage
    public void store(String productId, String purchaseToken) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(productId, purchaseToken);
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.freemium.storage.PurchaseStorage
    public String get(InAppProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        return this.sharedPreferences.getString(product.getId(), null);
    }

    @Override // com.myscript.nebo.freemium.storage.PurchaseStorage
    public boolean has(InAppProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        return get(product) != null;
    }

    @Override // com.myscript.nebo.freemium.storage.PurchaseStorage
    public void remove(InAppProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(product.getId());
        editorEdit.apply();
    }
}
