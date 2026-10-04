package com.myscript.nebo.whatsnew;

import com.myscript.nebo.whatsnew.PLSMigrationScreenState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PLSMigrationFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class PLSMigrationFragment$onStateUpdate$1$1 extends FunctionReferenceImpl implements Function0<String> {
    PLSMigrationFragment$onStateUpdate$1$1(Object obj) {
        super(0, obj, PLSMigrationScreenState.Migrating.class, "toString", "toString()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return ((PLSMigrationScreenState.Migrating) this.receiver).toString();
    }
}
