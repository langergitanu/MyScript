package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\fH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000eH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0011H&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0016H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0017H&J)\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u001a¢\u0006\u0002\b\u001bH&J)\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00030\u001a¢\u0006\u0002\b\u001bH&J)\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00030\u001a¢\u0006\u0002\b\u001bH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010!\u001a\u00020\u0003H&¨\u0006\"À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/StructSerializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveSerializer;", "field", "", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "value", "", "", "", "", "", "", "", "", "Laws/smithy/kotlin/runtime/content/BigInteger;", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "Laws/smithy/kotlin/runtime/content/Document;", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "", "structField", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "listField", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "mapField", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "nullField", "endStruct", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface StructSerializer extends PrimitiveSerializer {
    void endStruct();

    void field(SdkFieldDescriptor descriptor, byte value);

    void field(SdkFieldDescriptor descriptor, char value);

    void field(SdkFieldDescriptor descriptor, double value);

    void field(SdkFieldDescriptor descriptor, float value);

    void field(SdkFieldDescriptor descriptor, int value);

    void field(SdkFieldDescriptor descriptor, long value);

    void field(SdkFieldDescriptor descriptor, BigDecimal value);

    void field(SdkFieldDescriptor descriptor, BigInteger value);

    void field(SdkFieldDescriptor descriptor, Document value);

    void field(SdkFieldDescriptor descriptor, SdkSerializable value);

    void field(SdkFieldDescriptor descriptor, Instant value, TimestampFormat format);

    void field(SdkFieldDescriptor descriptor, String value);

    void field(SdkFieldDescriptor descriptor, short value);

    void field(SdkFieldDescriptor descriptor, boolean value);

    void field(SdkFieldDescriptor descriptor, byte[] value);

    void listField(SdkFieldDescriptor descriptor, Function1<? super ListSerializer, Unit> block);

    void mapField(SdkFieldDescriptor descriptor, Function1<? super MapSerializer, Unit> block);

    void nullField(SdkFieldDescriptor descriptor);

    void structField(SdkFieldDescriptor descriptor, Function1<? super StructSerializer, Unit> block);
}
