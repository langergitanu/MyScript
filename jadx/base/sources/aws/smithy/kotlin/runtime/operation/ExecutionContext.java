package aws.smithy.kotlin.runtime.operation;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: ExecutionContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0002*+B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J6\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0011\u001a\u00020\u00102\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0096\u0003¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0016\u001a\u00020\u0015\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J0\u0010\u0019\u001a\u00020\u0015\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00108\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001e\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0&8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006,"}, m1599d2 = {"Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "Lkotlinx/coroutines/CoroutineScope;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext$ExecutionContextBuilder;", "builder", "<init>", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext$ExecutionContextBuilder;)V", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/collections/AttributeKey;", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/Function0;", "block", "computeIfAbsent", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "contains", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)Z", "getOrNull", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)Ljava/lang/Object;", "", "remove", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)V", "value", "set", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "attributes", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "isEmpty", "()Z", "", "getKeys", "()Ljava/util/Set;", UserMetadata.KEYDATA_FILENAME, "Companion", "ExecutionContextBuilder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExecutionContext implements MutableAttributes, CoroutineScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final /* synthetic */ MutableAttributes $$delegate_0;
    private final MutableAttributes attributes;
    private final CoroutineContext coroutineContext;

    public /* synthetic */ ExecutionContext(ExecutionContextBuilder executionContextBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(executionContextBuilder);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableAttributes
    public <T> T computeIfAbsent(AttributeKey<T> key, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) this.$$delegate_0.computeIfAbsent(key, block);
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public boolean contains(AttributeKey<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.$$delegate_0.contains(key);
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public Set<AttributeKey<?>> getKeys() {
        return this.$$delegate_0.getKeys();
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public <T> T getOrNull(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.$$delegate_0.getOrNull(key);
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableAttributes
    public <T> void remove(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.$$delegate_0.remove(key);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableAttributes
    public <T> void set(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.$$delegate_0.set(key, value);
    }

    private ExecutionContext(ExecutionContextBuilder executionContextBuilder) {
        this.$$delegate_0 = executionContextBuilder.getAttributes();
        this.coroutineContext = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.attributes = executionContextBuilder.getAttributes();
    }

    public ExecutionContext() {
        this(new ExecutionContextBuilder());
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final MutableAttributes getAttributes() {
        return this.attributes;
    }

    /* JADX INFO: compiled from: ExecutionContext.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/operation/ExecutionContext$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext$ExecutionContextBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "build", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExecutionContext build(Function1<? super ExecutionContextBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            ExecutionContextBuilder executionContextBuilder = new ExecutionContextBuilder();
            block.invoke(executionContextBuilder);
            return executionContextBuilder.build();
        }
    }

    /* JADX INFO: compiled from: ExecutionContext.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/operation/ExecutionContext$ExecutionContextBuilder;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "build", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "attributes", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "setAttributes", "(Laws/smithy/kotlin/runtime/collections/MutableAttributes;)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ExecutionContextBuilder {
        private MutableAttributes attributes = AttributesKt.mutableAttributes();

        public final MutableAttributes getAttributes() {
            return this.attributes;
        }

        public final void setAttributes(MutableAttributes mutableAttributes) {
            Intrinsics.checkNotNullParameter(mutableAttributes, "<set-?>");
            this.attributes = mutableAttributes;
        }

        public final ExecutionContext build() {
            return new ExecutionContext(this, null);
        }
    }
}
