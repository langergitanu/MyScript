package aws.smithy.kotlin.runtime.serde;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Deserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a<\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a<\u0010\u000e\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\n0\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, m1599d2 = {"deserializeStruct", "", "Laws/smithy/kotlin/runtime/serde/Deserializer;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/serde/Deserializer$FieldIterator;", "Lkotlin/ExtensionFunctionType;", "deserializeList", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "Laws/smithy/kotlin/runtime/serde/Deserializer$ElementIterator;", "(Laws/smithy/kotlin/runtime/serde/Deserializer;Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "deserializeMap", "Laws/smithy/kotlin/runtime/serde/Deserializer$EntryIterator;", "serde"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeserializerKt {
    @InternalApi
    public static final void deserializeStruct(Deserializer deserializer, SdkObjectDescriptor descriptor, Function1<? super Deserializer.FieldIterator, Unit> block) {
        Intrinsics.checkNotNullParameter(deserializer, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(deserializer.deserializeStruct(descriptor));
    }

    @InternalApi
    public static final <T> T deserializeList(Deserializer deserializer, SdkFieldDescriptor descriptor, Function1<? super Deserializer.ElementIterator, ? extends T> block) {
        Intrinsics.checkNotNullParameter(deserializer, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(deserializer.deserializeList(descriptor));
    }

    @InternalApi
    public static final <T> T deserializeMap(Deserializer deserializer, SdkFieldDescriptor descriptor, Function1<? super Deserializer.EntryIterator, ? extends T> block) {
        Intrinsics.checkNotNullParameter(deserializer, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(deserializer.deserializeMap(descriptor));
    }
}
