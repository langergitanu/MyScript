package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: JsonFieldTraits.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"serialName", "", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "getSerialName$annotations", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)V", "getSerialName", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)Ljava/lang/String;", "serde-json"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonFieldTraitsKt {
    @InternalApi
    public static /* synthetic */ void getSerialName$annotations(SdkFieldDescriptor sdkFieldDescriptor) {
    }

    public static final String getSerialName(SdkFieldDescriptor sdkFieldDescriptor) {
        Object next;
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Iterator<T> it = sdkFieldDescriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((FieldTrait) next).getClass() == JsonSerialName.class) {
                break;
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (fieldTrait != null) {
            return ((JsonSerialName) fieldTrait).getName();
        }
        throw new IllegalArgumentException(("Expected to find trait " + Reflection.getOrCreateKotlinClass(JsonSerialName.class) + " in " + sdkFieldDescriptor + " but was not present.").toString());
    }
}
