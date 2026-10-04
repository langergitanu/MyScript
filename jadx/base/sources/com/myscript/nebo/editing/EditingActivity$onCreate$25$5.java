package com.myscript.nebo.editing;

import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class EditingActivity$onCreate$25$5 extends FunctionReferenceImpl implements Function0<String> {
    EditingActivity$onCreate$25$5(Object obj) {
        super(0, obj, PageKey.class, "uuid", "uuid()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return ((PageKey) this.receiver).uuid();
    }
}
