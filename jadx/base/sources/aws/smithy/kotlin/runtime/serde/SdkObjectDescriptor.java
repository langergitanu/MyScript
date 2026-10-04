package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkObjectDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "builder", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor$Builder;", "<init>", "(Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor$Builder;)V", "fields", "", "getFields", "()Ljava/util/List;", "Companion", "Builder", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkObjectDescriptor extends SdkFieldDescriptor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<SdkFieldDescriptor> fields;

    public /* synthetic */ SdkObjectDescriptor(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private SdkObjectDescriptor(Builder builder) {
        super(SerialKind.Struct.INSTANCE, builder.getTraits$serde());
        this.fields = builder.getFields$serde();
    }

    public final List<SdkFieldDescriptor> getFields() {
        return this.fields;
    }

    /* JADX INFO: compiled from: SdkObjectDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor$Companion;", "", "<init>", "()V", "build", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor$Builder;", "", "Lkotlin/ExtensionFunctionType;", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SdkObjectDescriptor build(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    /* JADX INFO: compiled from: SdkObjectDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor$Builder;", "", "<init>", "()V", "fields", "", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "getFields$serde", "()Ljava/util/List;", "traits", "", "Laws/smithy/kotlin/runtime/serde/FieldTrait;", "getTraits$serde", "()Ljava/util/Set;", "field", "", "trait", "build", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private final List<SdkFieldDescriptor> fields = new ArrayList();
        private final Set<FieldTrait> traits = new LinkedHashSet();

        public final List<SdkFieldDescriptor> getFields$serde() {
            return this.fields;
        }

        public final Set<FieldTrait> getTraits$serde() {
            return this.traits;
        }

        public final void field(SdkFieldDescriptor field) {
            Intrinsics.checkNotNullParameter(field, "field");
            field.setIndex(this.fields.size());
            this.fields.add(field);
        }

        public final void trait(FieldTrait trait) {
            Intrinsics.checkNotNullParameter(trait, "trait");
            this.traits.add(trait);
        }

        public final SdkObjectDescriptor build() {
            return new SdkObjectDescriptor(this, null);
        }
    }
}
