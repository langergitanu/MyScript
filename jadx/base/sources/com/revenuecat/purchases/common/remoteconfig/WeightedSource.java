package com.revenuecat.purchases.common.remoteconfig;

import kotlin.Metadata;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: WeightedSourceSelector.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/WeightedSource;", "", LogFactory.PRIORITY_KEY, "", "getPriority", "()I", "weight", "getWeight", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface WeightedSource {
    int getPriority();

    int getWeight();
}
