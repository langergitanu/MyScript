package com.myscript.nebo.inspector;

import android.os.Build;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InspectorInformation.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0014\u0010\u0017\u001a\u00020\u0018X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/inspector/DeviceInfo;", "", "<init>", "()V", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_KEY, "", "getManufacturer", "()Ljava/lang/String;", AIQuizConstants.BOARD, "getBoard", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "getModel", "product", "getProduct", "supportedAbis", "", "getSupportedAbis", "()[Ljava/lang/String;", "[Ljava/lang/String;", "osVersion", "getOsVersion", "osBase", "getOsBase", "sdkInt", "", "getSdkInt", "()I", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeviceInfo {
    private final String board;
    private final String manufacturer;
    private final String model;
    private final String osBase;
    private final String osVersion;
    private final String product;
    private final int sdkInt;
    private final String[] supportedAbis;

    public DeviceInfo() {
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        this.manufacturer = MANUFACTURER;
        String BOARD = Build.BOARD;
        Intrinsics.checkNotNullExpressionValue(BOARD, "BOARD");
        this.board = BOARD;
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        this.model = MODEL;
        String PRODUCT = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
        this.product = PRODUCT;
        String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
        Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
        this.supportedAbis = SUPPORTED_ABIS;
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        this.osVersion = RELEASE;
        String BASE_OS = Build.VERSION.BASE_OS;
        Intrinsics.checkNotNullExpressionValue(BASE_OS, "BASE_OS");
        this.osBase = BASE_OS;
        this.sdkInt = Build.VERSION.SDK_INT;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getBoard() {
        return this.board;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getProduct() {
        return this.product;
    }

    public final String[] getSupportedAbis() {
        return this.supportedAbis;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getOsBase() {
        return this.osBase;
    }

    public final int getSdkInt() {
        return this.sdkInt;
    }
}
