package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.10.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zabl {
    private final ApiKey zaa;
    private final Feature zab;

    /* synthetic */ zabl(ApiKey apiKey, Feature feature, byte[] bArr) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zabl) {
            zabl zablVar = (zabl) obj;
            if (Objects.equal(this.zaa, zablVar.zaa) && Objects.equal(this.zab, zablVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa, this.zab);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(SubscriberAttributeKt.JSON_NAME_KEY, this.zaa).add("feature", this.zab).toString();
    }

    final /* synthetic */ ApiKey zaa() {
        return this.zaa;
    }

    final /* synthetic */ Feature zab() {
        return this.zab;
    }
}
