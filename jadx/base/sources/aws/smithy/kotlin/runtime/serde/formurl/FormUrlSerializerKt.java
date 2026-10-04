package aws.smithy.kotlin.runtime.serde.formurl;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: FormUrlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a/\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u0001H\bH\u0082\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002\u001a\u0014\u0010\u0012\u001a\u00020\f*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002\u001a\f\u0010\u0014\u001a\u00020\u000f*\u00020\u000fH\u0002\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, m1599d2 = {"FormUrlSerializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "commonWriteNumber", "", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "value", "", "checkNotSparse", ExifInterface.GPS_DIRECTION_TRUE, "", "(Ljava/lang/Object;)Ljava/lang/Object;", "toDescriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "Laws/smithy/kotlin/runtime/serde/formurl/QueryLiteral;", "serialName", "", "getSerialName", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)Ljava/lang/String;", "copyWithNewSerialName", "newName", "encode", "serde-form-url"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FormUrlSerializerKt {
    /* JADX WARN: Multi-variable type inference failed */
    @InternalApi
    public static final Serializer FormUrlSerializer() {
        return new FormUrlSerializer(new SdkBuffer(), null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void commonWriteNumber(SdkBuffer sdkBuffer, Number number) throws IOException {
        SdkBufferedSink.writeUtf8$default(sdkBuffer, number.toString(), 0, 0, 6, null);
    }

    private static final <T> T checkNotSparse(T t) {
        if (t != null) {
            return t;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SdkFieldDescriptor toDescriptor(QueryLiteral queryLiteral) {
        return new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName(queryLiteral.getKey()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SdkFieldDescriptor copyWithNewSerialName(SdkFieldDescriptor sdkFieldDescriptor, String str) {
        Set<FieldTrait> traits = sdkFieldDescriptor.getTraits();
        ArrayList arrayList = new ArrayList();
        for (Object obj : traits) {
            if (!(((FieldTrait) obj) instanceof FormUrlSerialName)) {
                arrayList.add(obj);
            }
        }
        Set mutableSet = CollectionsKt.toMutableSet(arrayList);
        mutableSet.add(new FormUrlSerialName(str));
        return new SdkFieldDescriptor(sdkFieldDescriptor.getKind(), (Set<? extends FieldTrait>) mutableSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encode(String str) {
        return PercentEncoding.INSTANCE.getFormUrl().encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getSerialName(SdkFieldDescriptor sdkFieldDescriptor) {
        Object next;
        Iterator<T> it = sdkFieldDescriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((FieldTrait) next).getClass() == FormUrlSerialName.class) {
                break;
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (fieldTrait != null) {
            return ((FormUrlSerialName) fieldTrait).getName();
        }
        throw new IllegalArgumentException(("Expected to find trait " + Reflection.getOrCreateKotlinClass(FormUrlSerialName.class) + " in " + sdkFieldDescriptor + " but was not present.").toString());
    }
}
