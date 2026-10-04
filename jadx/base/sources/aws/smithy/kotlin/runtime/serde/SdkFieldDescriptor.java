package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkFieldDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\f\"\u00020\b¢\u0006\u0004\b\t\u0010\rB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\u000eJ\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "", "kind", "Laws/smithy/kotlin/runtime/serde/SerialKind;", FirebaseAnalytics.Param.INDEX, "", "traits", "", "Laws/smithy/kotlin/runtime/serde/FieldTrait;", "<init>", "(Laws/smithy/kotlin/runtime/serde/SerialKind;ILjava/util/Set;)V", "trait", "", "(Laws/smithy/kotlin/runtime/serde/SerialKind;[Laws/smithy/kotlin/runtime/serde/FieldTrait;)V", "(Laws/smithy/kotlin/runtime/serde/SerialKind;Ljava/util/Set;)V", "getKind", "()Laws/smithy/kotlin/runtime/serde/SerialKind;", "getIndex", "()I", "setIndex", "(I)V", "getTraits", "()Ljava/util/Set;", "toString", "", "Companion", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class SdkFieldDescriptor {
    private int index;
    private final SerialKind kind;
    private final Set<FieldTrait> traits;

    /* JADX WARN: Multi-variable type inference failed */
    public SdkFieldDescriptor(SerialKind kind, int i, Set<? extends FieldTrait> traits) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(traits, "traits");
        this.kind = kind;
        this.index = i;
        this.traits = traits;
    }

    public final SerialKind getKind() {
        return this.kind;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public /* synthetic */ SdkFieldDescriptor(SerialKind serialKind, int i, Set set, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(serialKind, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? SetsKt.emptySet() : set);
    }

    public final Set<FieldTrait> getTraits() {
        return this.traits;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SdkFieldDescriptor(SerialKind kind, FieldTrait... trait) {
        this(kind, 0, ArraysKt.toSet(trait));
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(trait, "trait");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SdkFieldDescriptor(SerialKind kind, Set<? extends FieldTrait> traits) {
        this(kind, 0, traits);
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(traits, "traits");
    }

    public String toString() {
        return "SdkFieldDescriptor." + this.kind + "(traits=" + CollectionsKt.joinToString$default(this.traits, ",", null, null, 0, null, null, 62, null) + ')';
    }
}
