package com.revenuecat.purchases.paywalls.components;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: ButtonComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 '2\u00020\u0001:\u0002&'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BA\b\u0011\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B1\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0012J\u0006\u0010\u001b\u001a\u00020\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/ActionSurrogate;", "", "action", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;)V", "seen1", "", "type", "Lcom/revenuecat/purchases/paywalls/components/ActionTypeSurrogate;", FirebaseAnalytics.Param.DESTINATION, "Lcom/revenuecat/purchases/paywalls/components/DestinationSurrogate;", ImagesContract.URL, "Lcom/revenuecat/purchases/paywalls/components/UrlSurrogate;", "sheet", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/ActionTypeSurrogate;Lcom/revenuecat/purchases/paywalls/components/DestinationSurrogate;Lcom/revenuecat/purchases/paywalls/components/UrlSurrogate;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/ActionTypeSurrogate;Lcom/revenuecat/purchases/paywalls/components/DestinationSurrogate;Lcom/revenuecat/purchases/paywalls/components/UrlSurrogate;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;)V", "getDestination", "()Lcom/revenuecat/purchases/paywalls/components/DestinationSurrogate;", "getSheet", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "getType", "()Lcom/revenuecat/purchases/paywalls/components/ActionTypeSurrogate;", "getUrl", "()Lcom/revenuecat/purchases/paywalls/components/UrlSurrogate;", "toAction", "toDestination", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
final class ActionSurrogate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DestinationSurrogate destination;
    private final ButtonComponent.Destination.Sheet sheet;
    private final ActionTypeSurrogate type;
    private final UrlSurrogate url;

    /* JADX INFO: compiled from: ButtonComponent.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ActionTypeSurrogate.values().length];
            try {
                iArr[ActionTypeSurrogate.unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActionTypeSurrogate.restore_purchases.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActionTypeSurrogate.navigate_back.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ActionTypeSurrogate.workflow.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ActionTypeSurrogate.close_workflow.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ActionTypeSurrogate.navigate_to.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DestinationSurrogate.values().length];
            try {
                iArr2[DestinationSurrogate.customer_center.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DestinationSurrogate.privacy_policy.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DestinationSurrogate.terms.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[DestinationSurrogate.url.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[DestinationSurrogate.sheet.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[DestinationSurrogate.unknown.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: compiled from: ButtonComponent.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/ActionSurrogate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ActionSurrogate;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ActionSurrogate> serializer() {
            return ActionSurrogate$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ActionSurrogate(int i, ActionTypeSurrogate actionTypeSurrogate, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, ActionSurrogate$$serializer.INSTANCE.getDescriptor());
        }
        this.type = actionTypeSurrogate;
        if ((i & 2) == 0) {
            this.destination = null;
        } else {
            this.destination = destinationSurrogate;
        }
        if ((i & 4) == 0) {
            this.url = null;
        } else {
            this.url = urlSurrogate;
        }
        if ((i & 8) == 0) {
            this.sheet = null;
        } else {
            this.sheet = sheet;
        }
    }

    public ActionSurrogate(ActionTypeSurrogate type, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.destination = destinationSurrogate;
        this.url = urlSurrogate;
        this.sheet = sheet;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(ActionSurrogate self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ActionTypeSurrogateDeserializer.INSTANCE, self.type);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.destination != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, DestinationSurrogateDeserializer.INSTANCE, self.destination);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, UrlSurrogate$$serializer.INSTANCE, self.url);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.sheet == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, self.sheet);
    }

    public /* synthetic */ ActionSurrogate(ActionTypeSurrogate actionTypeSurrogate, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(actionTypeSurrogate, (i & 2) != 0 ? null : destinationSurrogate, (i & 4) != 0 ? null : urlSurrogate, (i & 8) != 0 ? null : sheet);
    }

    public final ActionTypeSurrogate getType() {
        return this.type;
    }

    public final DestinationSurrogate getDestination() {
        return this.destination;
    }

    public final UrlSurrogate getUrl() {
        return this.url;
    }

    public final ButtonComponent.Destination.Sheet getSheet() {
        return this.sheet;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x009a  */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.revenuecat.purchases.paywalls.components.ButtonComponent$Destination$Sheet] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ActionSurrogate(ButtonComponent.Action action) {
        ActionTypeSurrogate actionTypeSurrogate;
        DestinationSurrogate destinationSurrogate;
        UrlSurrogate urlSurrogate;
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z = action instanceof ButtonComponent.Action.Unknown;
        if (z) {
            actionTypeSurrogate = ActionTypeSurrogate.unknown;
        } else if (action instanceof ButtonComponent.Action.NavigateBack) {
            actionTypeSurrogate = ActionTypeSurrogate.navigate_back;
        } else if (action instanceof ButtonComponent.Action.NavigateTo) {
            actionTypeSurrogate = ActionTypeSurrogate.navigate_to;
        } else if (action instanceof ButtonComponent.Action.RestorePurchases) {
            actionTypeSurrogate = ActionTypeSurrogate.restore_purchases;
        } else if (action instanceof ButtonComponent.Action.WorkflowTrigger) {
            actionTypeSurrogate = ActionTypeSurrogate.workflow;
        } else {
            if (!(action instanceof ButtonComponent.Action.CloseWorkflow)) {
                throw new NoWhenBranchMatchedException();
            }
            actionTypeSurrogate = ActionTypeSurrogate.close_workflow;
        }
        ButtonComponent.Destination.Sheet sheet = 0;
        sheet = 0;
        if (z ? true : action instanceof ButtonComponent.Action.NavigateBack ? true : action instanceof ButtonComponent.Action.RestorePurchases ? true : action instanceof ButtonComponent.Action.WorkflowTrigger ? true : action instanceof ButtonComponent.Action.CloseWorkflow) {
            destinationSurrogate = null;
        } else {
            if (!(action instanceof ButtonComponent.Action.NavigateTo)) {
                throw new NoWhenBranchMatchedException();
            }
            ButtonComponent.Destination destination = ((ButtonComponent.Action.NavigateTo) action).getDestination();
            if (destination instanceof ButtonComponent.Destination.CustomerCenter) {
                destinationSurrogate = DestinationSurrogate.customer_center;
            } else if (destination instanceof ButtonComponent.Destination.PrivacyPolicy) {
                destinationSurrogate = DestinationSurrogate.privacy_policy;
            } else if (destination instanceof ButtonComponent.Destination.Terms) {
                destinationSurrogate = DestinationSurrogate.terms;
            } else if (destination instanceof ButtonComponent.Destination.Url) {
                destinationSurrogate = DestinationSurrogate.url;
            } else if (destination instanceof ButtonComponent.Destination.Sheet) {
                destinationSurrogate = DestinationSurrogate.sheet;
            } else {
                if (!(destination instanceof ButtonComponent.Destination.Unknown)) {
                    throw new NoWhenBranchMatchedException();
                }
                destinationSurrogate = DestinationSurrogate.unknown;
            }
        }
        if (!(z ? true : action instanceof ButtonComponent.Action.NavigateBack ? true : action instanceof ButtonComponent.Action.RestorePurchases ? true : action instanceof ButtonComponent.Action.WorkflowTrigger ? true : action instanceof ButtonComponent.Action.CloseWorkflow)) {
            if (!(action instanceof ButtonComponent.Action.NavigateTo)) {
                throw new NoWhenBranchMatchedException();
            }
            ButtonComponent.Action.NavigateTo navigateTo = (ButtonComponent.Action.NavigateTo) action;
            ButtonComponent.Destination destination2 = navigateTo.getDestination();
            if (destination2 instanceof ButtonComponent.Destination.Unknown ? true : destination2 instanceof ButtonComponent.Destination.CustomerCenter ? true : destination2 instanceof ButtonComponent.Destination.Sheet) {
                urlSurrogate = null;
            } else if (destination2 instanceof ButtonComponent.Destination.PrivacyPolicy) {
                urlSurrogate = new UrlSurrogate(((ButtonComponent.Destination.PrivacyPolicy) navigateTo.getDestination()).m13762getUrlLidz7Tp4o(), ((ButtonComponent.Destination.PrivacyPolicy) navigateTo.getDestination()).getMethod(), sheet);
            } else if (destination2 instanceof ButtonComponent.Destination.Terms) {
                urlSurrogate = new UrlSurrogate(((ButtonComponent.Destination.Terms) navigateTo.getDestination()).m13766getUrlLidz7Tp4o(), ((ButtonComponent.Destination.Terms) navigateTo.getDestination()).getMethod(), sheet);
            } else if (destination2 instanceof ButtonComponent.Destination.Url) {
                urlSurrogate = new UrlSurrogate(((ButtonComponent.Destination.Url) navigateTo.getDestination()).m13770getUrlLidz7Tp4o(), ((ButtonComponent.Destination.Url) navigateTo.getDestination()).getMethod(), sheet);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (!(z ? true : action instanceof ButtonComponent.Action.NavigateBack ? true : action instanceof ButtonComponent.Action.RestorePurchases ? true : action instanceof ButtonComponent.Action.WorkflowTrigger ? true : action instanceof ButtonComponent.Action.CloseWorkflow)) {
            if (!(action instanceof ButtonComponent.Action.NavigateTo)) {
                throw new NoWhenBranchMatchedException();
            }
            ButtonComponent.Action.NavigateTo navigateTo2 = (ButtonComponent.Action.NavigateTo) action;
            ButtonComponent.Destination destination3 = navigateTo2.getDestination();
            if (!(destination3 instanceof ButtonComponent.Destination.CustomerCenter ? true : destination3 instanceof ButtonComponent.Destination.PrivacyPolicy ? true : destination3 instanceof ButtonComponent.Destination.Terms ? true : destination3 instanceof ButtonComponent.Destination.Unknown ? true : destination3 instanceof ButtonComponent.Destination.Url)) {
                if (!(destination3 instanceof ButtonComponent.Destination.Sheet)) {
                    throw new NoWhenBranchMatchedException();
                }
                sheet = (ButtonComponent.Destination.Sheet) navigateTo2.getDestination();
            }
        }
        this(actionTypeSurrogate, destinationSurrogate, urlSurrogate, sheet);
    }

    public final ButtonComponent.Action toAction() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                return ButtonComponent.Action.Unknown.INSTANCE;
            case 2:
                return ButtonComponent.Action.RestorePurchases.INSTANCE;
            case 3:
                return ButtonComponent.Action.NavigateBack.INSTANCE;
            case 4:
                return ButtonComponent.Action.WorkflowTrigger.INSTANCE;
            case 5:
                return ButtonComponent.Action.CloseWorkflow.INSTANCE;
            case 6:
                return new ButtonComponent.Action.NavigateTo(toDestination());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final ButtonComponent.Destination toDestination() {
        DestinationSurrogate destinationSurrogate = this.destination;
        switch (destinationSurrogate == null ? -1 : WhenMappings.$EnumSwitchMapping$1[destinationSurrogate.ordinal()]) {
            case -1:
                throw new IllegalStateException("`destination` cannot be null when `action` is `navigate_to`.".toString());
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return ButtonComponent.Destination.CustomerCenter.INSTANCE;
            case 2:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `privacy_policy`.".toString());
                }
                return new ButtonComponent.Destination.PrivacyPolicy(this.url.getUrl_lid(), this.url.getMethod(), null);
            case 3:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `terms`.".toString());
                }
                return new ButtonComponent.Destination.Terms(this.url.getUrl_lid(), this.url.getMethod(), null);
            case 4:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `url`.".toString());
                }
                return new ButtonComponent.Destination.Url(this.url.getUrl_lid(), this.url.getMethod(), null);
            case 5:
                ButtonComponent.Destination.Sheet sheet = this.sheet;
                if (sheet == null) {
                    sheet = new ButtonComponent.Destination.Sheet((String) null, (String) null, (StackComponent) null, false, (Size) null, 31, (DefaultConstructorMarker) null);
                }
                return sheet;
            case 6:
                return ButtonComponent.Destination.Unknown.INSTANCE;
        }
    }
}
