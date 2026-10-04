package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u001aH&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u001bH&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u001cH&J1\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00030!¢\u0006\u0002\b#H&J1\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001f2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030!¢\u0006\u0002\b#H&J\b\u0010&\u001a\u00020\u0003H&¨\u0006'À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/MapSerializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveSerializer;", "entry", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "", "(Ljava/lang/String;Ljava/lang/Byte;)V", "", "(Ljava/lang/String;Ljava/lang/Short;)V", "", "(Ljava/lang/String;Ljava/lang/Character;)V", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "Laws/smithy/kotlin/runtime/content/Document;", "", "listEntry", "listDescriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "Lkotlin/ExtensionFunctionType;", "mapEntry", "mapDescriptor", "endMap", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MapSerializer extends PrimitiveSerializer {
    void endMap();

    /* JADX INFO: renamed from: entry */
    void mo12256entry(String key, Document value);

    void entry(String key, SdkSerializable value);

    void entry(String key, Instant value, TimestampFormat format);

    void entry(String key, Boolean value);

    void entry(String key, Byte value);

    void entry(String key, Character value);

    void entry(String key, Double value);

    void entry(String key, Float value);

    void entry(String key, Integer value);

    void entry(String key, Long value);

    void entry(String key, Short value);

    void entry(String key, String value);

    void entry(String key, byte[] value);

    void listEntry(String key, SdkFieldDescriptor listDescriptor, Function1<? super ListSerializer, Unit> block);

    void mapEntry(String key, SdkFieldDescriptor mapDescriptor, Function1<? super MapSerializer, Unit> block);
}
