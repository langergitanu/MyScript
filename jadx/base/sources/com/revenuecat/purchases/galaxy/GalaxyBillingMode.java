package com.revenuecat.purchases.galaxy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GalaxyBillingMode.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/galaxy/GalaxyBillingMode;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toString", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class GalaxyBillingMode {
    private final String name;
    public static final GalaxyBillingMode PRODUCTION = new GalaxyBillingMode() { // from class: com.revenuecat.purchases.galaxy.GalaxyBillingMode$Companion$PRODUCTION$1
    };
    public static final GalaxyBillingMode TEST = new GalaxyBillingMode() { // from class: com.revenuecat.purchases.galaxy.GalaxyBillingMode$Companion$TEST$1
    };
    public static final GalaxyBillingMode ALWAYS_FAIL = new GalaxyBillingMode() { // from class: com.revenuecat.purchases.galaxy.GalaxyBillingMode$Companion$ALWAYS_FAIL$1
    };

    public GalaxyBillingMode(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
