package com.google.common.math;

import java.util.function.ObjDoubleConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Stats$$ExternalSyntheticLambda4 implements ObjDoubleConsumer {
    @Override // java.util.function.ObjDoubleConsumer
    public final void accept(Object obj, double d) {
        ((StatsAccumulator) obj).add(d);
    }
}
