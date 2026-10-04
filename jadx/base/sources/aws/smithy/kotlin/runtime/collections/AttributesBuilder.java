package aws.smithy.kotlin.runtime.collections;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0004*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0004\b\b\u0010\tJ&\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0004*\u00020\u0001*\u00020\n2\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0004\b\b\u0010\u000bR \u0010\r\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/AttributesBuilder;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "value", "", TypedValues.TransitionType.S_TO, "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Ljava/lang/Object;)V", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "attributes", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "getAttributes$annotations", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AttributesBuilder {
    private final MutableAttributes attributes = AttributesKt.mutableAttributes();

    public static /* synthetic */ void getAttributes$annotations() {
    }

    public final MutableAttributes getAttributes() {
        return this.attributes;
    }

    /* JADX INFO: renamed from: to */
    public final <T> void m497to(AttributeKey<T> attributeKey, T value) {
        Intrinsics.checkNotNullParameter(attributeKey, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        this.attributes.set(attributeKey, value);
    }

    /* JADX INFO: renamed from: to */
    public final <T> void m498to(String str, T value) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        this.attributes.set(new AttributeKey<>(str), value);
    }
}
