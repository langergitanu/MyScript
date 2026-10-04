package aws.smithy.kotlin.runtime.telemetry.context;

import kotlin.Metadata;

/* JADX INFO: compiled from: AbstractContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/context/AbstractContext;", "Laws/smithy/kotlin/runtime/telemetry/context/Context;", "<init>", "()V", "makeCurrent", "Laws/smithy/kotlin/runtime/telemetry/context/Scope;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractContext implements Context {
    @Override // aws.smithy.kotlin.runtime.telemetry.context.Context
    public Scope makeCurrent() {
        return Scope.INSTANCE.getNone();
    }
}
