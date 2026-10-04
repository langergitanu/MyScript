package com.revenuecat.purchases.utils.serializers;

import android.Manifest;
import androidx.exifinterface.media.ExifInterface;
import java.lang.Enum;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: EnumDeserializerWithDefault.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\u0010\tB)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bR\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "defaultValue", "typeForValue", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/Enum;Lkotlin/jvm/functions/Function1;)V", "valuesByType", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Enum;)V", "Ljava/lang/Enum;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class EnumDeserializerWithDefault<T extends Enum<T>> implements KSerializer<T> {
    private final T defaultValue;
    private final SerialDescriptor descriptor;
    private final String serialName;
    private final Map<String, T> valuesByType;

    /* JADX WARN: Multi-variable type inference failed */
    public EnumDeserializerWithDefault(String serialName, Map<String, ? extends T> valuesByType, T defaultValue) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(valuesByType, "valuesByType");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.serialName = serialName;
        this.valuesByType = valuesByType;
        this.defaultValue = defaultValue;
        this.descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor(serialName, PrimitiveKind.STRING.INSTANCE);
    }

    public /* synthetic */ EnumDeserializerWithDefault(String str, Enum r2, C83271 c83271, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r2, (Function1<? super Enum, String>) ((i & 4) != 0 ? new Function1<T, String>() { // from class: com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(T value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        } : c83271));
    }

    public EnumDeserializerWithDefault(String serialName, T defaultValue, Function1<? super T, String> typeForValue) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(typeForValue, "typeForValue");
        Object[] enumConstants = defaultValue.getClass().getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "defaultValue::class.java.enumConstants");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(enumConstants.length), 16));
        for (Object obj : enumConstants) {
            Manifest.permission permissionVar = (Object) obj;
            linkedHashMap.put(typeForValue.invoke(permissionVar), permissionVar);
        }
        this(serialName, linkedHashMap, defaultValue);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        T t = this.valuesByType.get(decoder.decodeString());
        return t == null ? this.defaultValue : t;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("Serialization is not implemented because it is not needed.");
    }
}
