package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a3\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a3\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, m1599d2 = {"serializeStruct", "", "Laws/smithy/kotlin/runtime/serde/Serializer;", "sdkFieldDescriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/serde/StructSerializer;", "Lkotlin/ExtensionFunctionType;", "serializeList", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "serializeMap", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "serde"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SerializerKt {
    @InternalApi
    public static final void serializeStruct(Serializer serializer, SdkFieldDescriptor sdkFieldDescriptor, Function1<? super StructSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "sdkFieldDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(sdkFieldDescriptor);
        block.invoke(structSerializerBeginStruct);
        structSerializerBeginStruct.endStruct();
    }

    @InternalApi
    public static final void serializeList(Serializer serializer, SdkFieldDescriptor sdkFieldDescriptor, Function1<? super ListSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "sdkFieldDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        ListSerializer listSerializerBeginList = serializer.beginList(sdkFieldDescriptor);
        block.invoke(listSerializerBeginList);
        listSerializerBeginList.endList();
    }

    @InternalApi
    public static final void serializeMap(Serializer serializer, SdkFieldDescriptor sdkFieldDescriptor, Function1<? super MapSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "sdkFieldDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        MapSerializer mapSerializerBeginMap = serializer.beginMap(sdkFieldDescriptor);
        block.invoke(mapSerializerBeginMap);
        mapSerializerBeginMap.endMap();
    }
}
