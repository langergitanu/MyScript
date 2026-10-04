package aws.smithy.kotlin.runtime.util;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslBuilderProperty.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B[\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012(\u0010\t\u001a$\u0012\u0004\u0012\u00028\u0001\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u0006¢\u0006\u0002\b\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJN\u0010\u0011\u001a\u00020\u0007\"\b\b\u0002\u0010\r*\u00028\u0000\"\b\b\u0003\u0010\u000e*\u00028\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00042\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R6\u0010\t\u001a$\u0012\u0004\u0012\u00028\u0001\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u0006¢\u0006\u0002\b\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R'\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00198\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR.\u0010\u001f\u001a\u0004\u0018\u00018\u00012\b\u0010\u001a\u001a\u0004\u0018\u00018\u00018\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/DslBuilderProperty;", "SuperBuilder", "SuperBuilt", "", "Laws/smithy/kotlin/runtime/util/DslFactory;", "defaultFactory", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "managedTransform", "<init>", "(Laws/smithy/kotlin/runtime/util/DslFactory;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "SubBuilder", "SubBuilt", "factory", "block", "dsl", "(Laws/smithy/kotlin/runtime/util/DslFactory;Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/util/DslFactory;", "Lkotlin/jvm/functions/Function1;", "configApplicator", "Laws/smithy/kotlin/runtime/util/SupplierState;", "state", "Laws/smithy/kotlin/runtime/util/SupplierState;", "Lkotlin/Function0;", "value", "supply", "Lkotlin/jvm/functions/Function0;", "getSupply", "()Lkotlin/jvm/functions/Function0;", "instance", "Ljava/lang/Object;", "getInstance", "()Ljava/lang/Object;", "setInstance", "(Ljava/lang/Object;)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DslBuilderProperty<SuperBuilder, SuperBuilt> {
    private Function1<? super SuperBuilder, Unit> configApplicator;
    private final DslFactory<SuperBuilder, SuperBuilt> defaultFactory;
    private DslFactory<? extends SuperBuilder, ? extends SuperBuilt> factory;
    private SuperBuilt instance;
    private final Function1<SuperBuilt, SuperBuilt> managedTransform;
    private SupplierState state;
    private Function0<? extends SuperBuilt> supply;
    private final Function1<SuperBuilt, Function1<SuperBuilder, Unit>> toBuilderApplicator;

    /* JADX INFO: compiled from: DslBuilderProperty.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SupplierState.values().length];
            try {
                iArr[SupplierState.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SupplierState.EXPLICIT_INSTANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _init_$lambda$0(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _set_instance_$lambda$1(Object obj) {
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DslBuilderProperty(DslFactory<? extends SuperBuilder, ? extends SuperBuilt> defaultFactory, Function1<? super SuperBuilt, ? extends Function1<? super SuperBuilder, Unit>> toBuilderApplicator, Function1<? super SuperBuilt, ? extends SuperBuilt> managedTransform) {
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        Intrinsics.checkNotNullParameter(toBuilderApplicator, "toBuilderApplicator");
        Intrinsics.checkNotNullParameter(managedTransform, "managedTransform");
        this.defaultFactory = defaultFactory;
        this.toBuilderApplicator = toBuilderApplicator;
        this.managedTransform = managedTransform;
        this.configApplicator = new Function1() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DslBuilderProperty.configApplicator$lambda$0(obj);
            }
        };
        this.factory = defaultFactory;
        this.state = SupplierState.NOT_INITIALIZED;
        this.supply = new Function0() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DslBuilderProperty.supply$lambda$0(this.f$0);
            }
        };
    }

    public /* synthetic */ DslBuilderProperty(DslFactory dslFactory, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dslFactory, function1, (i & 4) != 0 ? new Function1() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DslBuilderProperty._init_$lambda$0(obj);
            }
        } : function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit configApplicator$lambda$0(Object obj) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object supply$lambda$0(DslBuilderProperty dslBuilderProperty) {
        return dslBuilderProperty.managedTransform.invoke(dslBuilderProperty.factory.invoke(new Function1() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DslBuilderProperty.supply$lambda$0$0(obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supply$lambda$0$0(Object obj) {
        return Unit.INSTANCE;
    }

    public final Function0<SuperBuilt> getSupply() {
        return this.supply;
    }

    public final SuperBuilt getInstance() {
        return this.instance;
    }

    public final void setInstance(final SuperBuilt superbuilt) {
        SupplierState supplierState;
        Function0<? extends SuperBuilt> function0;
        Function1<SuperBuilder, Unit> function1Invoke;
        if (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()] == 1) {
            supplierState = SupplierState.INITIALIZED;
        } else {
            supplierState = SupplierState.EXPLICIT_INSTANCE;
        }
        this.state = supplierState;
        this.instance = superbuilt;
        if (superbuilt == null) {
            this.factory = this.defaultFactory;
            function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DslBuilderProperty._set_instance_$lambda$0(this.f$0);
                }
            };
        } else {
            function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DslBuilderProperty._set_instance_$lambda$1(superbuilt);
                }
            };
        }
        this.supply = function0;
        if (superbuilt == null || (function1Invoke = this.toBuilderApplicator.invoke(superbuilt)) == null) {
            function1Invoke = new Function1() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DslBuilderProperty._set_instance_$lambda$2(obj);
                }
            };
        }
        this.configApplicator = function1Invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _set_instance_$lambda$0(DslBuilderProperty dslBuilderProperty) {
        return dslBuilderProperty.managedTransform.invoke(dslBuilderProperty.factory.invoke(new Function1() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DslBuilderProperty._set_instance_$lambda$0$0(obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _set_instance_$lambda$0$0(Object obj) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _set_instance_$lambda$2(Object obj) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <SubBuilder extends SuperBuilder, SubBuilt extends SuperBuilt> void dsl(final DslFactory<? extends SubBuilder, ? extends SubBuilt> factory, final Function1<? super SubBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(block, "block");
        if (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()] == 2) {
            throw new ClientException("An explicit instance is already configured and its configuration cannot be modified");
        }
        this.state = SupplierState.EXPLICIT_CONFIG;
        this.factory = factory;
        final Function1<? super SuperBuilder, Unit> function1 = this.configApplicator;
        this.configApplicator = new Function1() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DslBuilderProperty.dsl$lambda$0(function1, block, obj);
            }
        };
        this.supply = new Function0() { // from class: aws.smithy.kotlin.runtime.util.DslBuilderProperty$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DslBuilderProperty.dsl$lambda$1(this.f$0, factory);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dsl$lambda$0(Function1 function1, Function1 function12, Object obj) {
        function1.invoke(obj);
        function12.invoke(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object dsl$lambda$1(DslBuilderProperty dslBuilderProperty, DslFactory dslFactory) {
        return dslBuilderProperty.managedTransform.invoke((SuperBuilt) dslFactory.invoke(dslBuilderProperty.configApplicator));
    }
}
