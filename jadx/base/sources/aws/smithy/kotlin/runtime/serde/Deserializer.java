package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Deserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0003\u000b\f\rJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\bH&¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/Deserializer;", "", "deserializeStruct", "Laws/smithy/kotlin/runtime/serde/Deserializer$FieldIterator;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "deserializeList", "Laws/smithy/kotlin/runtime/serde/Deserializer$ElementIterator;", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "deserializeMap", "Laws/smithy/kotlin/runtime/serde/Deserializer$EntryIterator;", "ElementIterator", "EntryIterator", "FieldIterator", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Deserializer {

    /* JADX INFO: compiled from: Deserializer.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/Deserializer$ElementIterator;", "Laws/smithy/kotlin/runtime/serde/PrimitiveDeserializer;", "hasNextElement", "", "nextHasValue", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ElementIterator extends PrimitiveDeserializer {
        boolean hasNextElement();

        boolean nextHasValue();
    }

    /* JADX INFO: compiled from: Deserializer.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/Deserializer$EntryIterator;", "Laws/smithy/kotlin/runtime/serde/PrimitiveDeserializer;", "hasNextEntry", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "nextHasValue", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface EntryIterator extends PrimitiveDeserializer {
        boolean hasNextEntry();

        String key();

        boolean nextHasValue();
    }

    ElementIterator deserializeList(SdkFieldDescriptor descriptor);

    EntryIterator deserializeMap(SdkFieldDescriptor descriptor);

    FieldIterator deserializeStruct(SdkObjectDescriptor descriptor);

    /* JADX INFO: compiled from: Deserializer.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/Deserializer$FieldIterator;", "Laws/smithy/kotlin/runtime/serde/PrimitiveDeserializer;", "findNextFieldIndex", "", "()Ljava/lang/Integer;", "skipValue", "", "Companion", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface FieldIterator extends PrimitiveDeserializer {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int UNKNOWN_FIELD = -1;

        Integer findNextFieldIndex();

        void skipValue();

        /* JADX INFO: compiled from: Deserializer.kt */
        @InternalApi
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/Deserializer$FieldIterator$Companion;", "", "<init>", "()V", "UNKNOWN_FIELD", "", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int UNKNOWN_FIELD = -1;

            private Companion() {
            }
        }
    }
}
