package aws.smithy.kotlin.runtime.http.operation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: SdkHttpOperation.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ,\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001b\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;", "", "Lkotlin/reflect/KClass;", "inputType", "outputType", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "component1", "()Lkotlin/reflect/KClass;", "component2", "copy", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/KClass;", "getInputType", "getOutputType", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class OperationTypeInfo {
    private final KClass<?> inputType;
    private final KClass<?> outputType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OperationTypeInfo copy$default(OperationTypeInfo operationTypeInfo, KClass kClass, KClass kClass2, int i, Object obj) {
        if ((i & 1) != 0) {
            kClass = operationTypeInfo.inputType;
        }
        if ((i & 2) != 0) {
            kClass2 = operationTypeInfo.outputType;
        }
        return operationTypeInfo.copy(kClass, kClass2);
    }

    public final KClass<?> component1() {
        return this.inputType;
    }

    public final KClass<?> component2() {
        return this.outputType;
    }

    public final OperationTypeInfo copy(KClass<?> inputType, KClass<?> outputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        Intrinsics.checkNotNullParameter(outputType, "outputType");
        return new OperationTypeInfo(inputType, outputType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationTypeInfo)) {
            return false;
        }
        OperationTypeInfo operationTypeInfo = (OperationTypeInfo) other;
        return Intrinsics.areEqual(this.inputType, operationTypeInfo.inputType) && Intrinsics.areEqual(this.outputType, operationTypeInfo.outputType);
    }

    public int hashCode() {
        return (this.inputType.hashCode() * 31) + this.outputType.hashCode();
    }

    public String toString() {
        return "OperationTypeInfo(inputType=" + this.inputType + ", outputType=" + this.outputType + ')';
    }

    public OperationTypeInfo(KClass<?> inputType, KClass<?> outputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        Intrinsics.checkNotNullParameter(outputType, "outputType");
        this.inputType = inputType;
        this.outputType = outputType;
    }

    public final KClass<?> getInputType() {
        return this.inputType;
    }

    public final KClass<?> getOutputType() {
        return this.outputType;
    }
}
