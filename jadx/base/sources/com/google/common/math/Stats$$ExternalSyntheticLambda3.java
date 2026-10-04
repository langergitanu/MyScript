package com.google.common.math;

import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Stats$$ExternalSyntheticLambda3 implements ObjIntConsumer {
    @Override // java.util.function.ObjIntConsumer
    public final void accept(Object obj, int i) {
        ((StatsAccumulator) obj).add(i);
    }
}
