package aws.smithy.kotlin.runtime.serde;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkSerializable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ai\u0010\n\u001a\u00020\b\"\u0004\b\u0000\u0010\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u0002H\u00012@\u0010\u000e\u001a<\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a]\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0007\u001a\u0002H\u00012@\u0010\u000e\u001a<\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u000fH\u0007¢\u0006\u0002\u0010\u0013*v\b\u0007\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\"2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u000222\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002B\u0002\b\t¨\u0006\u0014"}, m1599d2 = {"SerializeFn", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Laws/smithy/kotlin/runtime/serde/Serializer;", "Lkotlin/ParameterName;", "name", "serializer", "input", "", "Laws/smithy/kotlin/runtime/InternalApi;", "field", "Laws/smithy/kotlin/runtime/serde/StructSerializer;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "serializeFn", "Laws/smithy/kotlin/runtime/serde/SerializeFn;", "(Laws/smithy/kotlin/runtime/serde/StructSerializer;Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "asSdkSerializable", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "serde"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkSerializableKt {
    @InternalApi
    public static /* synthetic */ void SerializeFn$annotations() {
    }

    @InternalApi
    public static final <T> void field(StructSerializer structSerializer, SdkFieldDescriptor descriptor, T t, Function2<? super Serializer, ? super T, Unit> serializeFn) {
        Intrinsics.checkNotNullParameter(structSerializer, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializeFn, "serializeFn");
        structSerializer.field(descriptor, new SdkSerializableLambda(t, serializeFn));
    }

    @InternalApi
    public static final <T> SdkSerializable asSdkSerializable(T t, Function2<? super Serializer, ? super T, Unit> serializeFn) {
        Intrinsics.checkNotNullParameter(serializeFn, "serializeFn");
        return new SdkSerializableLambda(t, serializeFn);
    }
}
