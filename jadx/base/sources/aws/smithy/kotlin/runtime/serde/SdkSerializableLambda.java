package aws.smithy.kotlin.runtime.serde;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkSerializable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BQ\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012@\u0010\u0004\u001a<\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00028\u0000HÂ\u0003¢\u0006\u0002\u0010\u0011JC\u0010\u0012\u001a<\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u000bHÂ\u0003Jb\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002B\b\u0002\u0010\u0004\u001a<\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u000bHÆ\u0001¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eRH\u0010\u0004\u001a<\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SdkSerializableLambda;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "input", "serializeFn", "Lkotlin/Function2;", "Laws/smithy/kotlin/runtime/serde/Serializer;", "Lkotlin/ParameterName;", "name", "serializer", "", "Laws/smithy/kotlin/runtime/serde/SerializeFn;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Ljava/lang/Object;", "serialize", "component1", "()Ljava/lang/Object;", "component2", "copy", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Laws/smithy/kotlin/runtime/serde/SdkSerializableLambda;", "equals", "", "other", "", "hashCode", "", "toString", "", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class SdkSerializableLambda<T> implements SdkSerializable {
    private final T input;
    private final Function2<Serializer, T, Unit> serializeFn;

    private final T component1() {
        return this.input;
    }

    private final Function2<Serializer, T, Unit> component2() {
        return this.serializeFn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SdkSerializableLambda copy$default(SdkSerializableLambda sdkSerializableLambda, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = sdkSerializableLambda.input;
        }
        if ((i & 2) != 0) {
            function2 = sdkSerializableLambda.serializeFn;
        }
        return sdkSerializableLambda.copy(obj, function2);
    }

    public final SdkSerializableLambda<T> copy(T input, Function2<? super Serializer, ? super T, Unit> serializeFn) {
        Intrinsics.checkNotNullParameter(serializeFn, "serializeFn");
        return new SdkSerializableLambda<>(input, serializeFn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkSerializableLambda)) {
            return false;
        }
        SdkSerializableLambda sdkSerializableLambda = (SdkSerializableLambda) other;
        return Intrinsics.areEqual(this.input, sdkSerializableLambda.input) && Intrinsics.areEqual(this.serializeFn, sdkSerializableLambda.serializeFn);
    }

    public int hashCode() {
        T t = this.input;
        return ((t == null ? 0 : t.hashCode()) * 31) + this.serializeFn.hashCode();
    }

    public String toString() {
        return "SdkSerializableLambda(input=" + this.input + ", serializeFn=" + this.serializeFn + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SdkSerializableLambda(T t, Function2<? super Serializer, ? super T, Unit> serializeFn) {
        Intrinsics.checkNotNullParameter(serializeFn, "serializeFn");
        this.input = t;
        this.serializeFn = serializeFn;
    }

    @Override // aws.smithy.kotlin.runtime.serde.SdkSerializable
    public void serialize(Serializer serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.serializeFn.invoke(serializer, this.input);
    }
}
