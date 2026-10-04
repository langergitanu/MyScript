package com.survicate.surveys.core.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.random.Random;

/* JADX INFO: compiled from: RandomGenerator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/core/utils/DefaultRandomGenerator;", "Lcom/survicate/surveys/core/utils/RandomGenerator;", "<init>", "()V", "randomPercent", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DefaultRandomGenerator implements RandomGenerator {
    @Override // com.survicate.surveys.core.utils.RandomGenerator
    public double randomPercent() {
        return Random.INSTANCE.nextDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 100.0d);
    }
}
