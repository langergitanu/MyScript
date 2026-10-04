package com.revenuecat.purchases.common.uiconfig;

import com.revenuecat.purchases.UiConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UiConfigResolution.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution;", "", "Found", "NotConfigured", "Superseded", "Unavailable", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution$Found;", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution$NotConfigured;", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution$Superseded;", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution$Unavailable;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface UiConfigResolution {

    /* JADX INFO: compiled from: UiConfigResolution.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution$Found;", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution;", "uiConfig", "Lcom/revenuecat/purchases/UiConfig;", "(Lcom/revenuecat/purchases/UiConfig;)V", "getUiConfig", "()Lcom/revenuecat/purchases/UiConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class Found implements UiConfigResolution {
        private final UiConfig uiConfig;

        public static /* synthetic */ Found copy$default(Found found, UiConfig uiConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                uiConfig = found.uiConfig;
            }
            return found.copy(uiConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UiConfig getUiConfig() {
            return this.uiConfig;
        }

        public final Found copy(UiConfig uiConfig) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            return new Found(uiConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Found) && Intrinsics.areEqual(this.uiConfig, ((Found) other).uiConfig);
        }

        public int hashCode() {
            return this.uiConfig.hashCode();
        }

        public String toString() {
            return "Found(uiConfig=" + this.uiConfig + ')';
        }

        public Found(UiConfig uiConfig) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            this.uiConfig = uiConfig;
        }

        public final UiConfig getUiConfig() {
            return this.uiConfig;
        }
    }

    /* JADX INFO: compiled from: UiConfigResolution.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution$NotConfigured;", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class NotConfigured implements UiConfigResolution {
        public static final NotConfigured INSTANCE = new NotConfigured();

        private NotConfigured() {
        }
    }

    /* JADX INFO: compiled from: UiConfigResolution.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution$Superseded;", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Superseded implements UiConfigResolution {
        public static final Superseded INSTANCE = new Superseded();

        private Superseded() {
        }
    }

    /* JADX INFO: compiled from: UiConfigResolution.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution$Unavailable;", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigResolution;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Unavailable implements UiConfigResolution {
        public static final Unavailable INSTANCE = new Unavailable();

        private Unavailable() {
        }
    }
}
