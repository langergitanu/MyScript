package com.myscript.nebo.banner;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.window.core.layout.WindowSizeClass;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: Banners.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 ,2\u00020\u0001:\u0006'()*+,Bq\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%\u0082\u0001\u0005-./01¨\u00062"}, m1599d2 = {"Lcom/myscript/nebo/banner/Banner;", "", "id", "", "message", "", "type", "Lcom/myscript/nebo/banner/Type;", "actionText", "action", "Ljava/lang/Runnable;", "secondaryActionText", "secondaryAction", "messageDrawable", "", LogFactory.PRIORITY_KEY, "Lcom/myscript/nebo/banner/Priority;", "blackListOnActionClicked", "", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/myscript/nebo/banner/Type;Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/Runnable;ILcom/myscript/nebo/banner/Priority;Z)V", "getId", "()Ljava/lang/String;", "getMessage", "()Ljava/lang/CharSequence;", "getType", "()Lcom/myscript/nebo/banner/Type;", "getActionText", "getAction", "()Ljava/lang/Runnable;", "getSecondaryActionText", "getSecondaryAction", "getMessageDrawable", "()I", "getPriority", "()Lcom/myscript/nebo/banner/Priority;", "getBlackListOnActionClicked", "()Z", "isCloseable", "WarningBanner", "CorruptedBanner", "ForbiddenBanner", "MarketingBanner", "FeedbackBanner", "Companion", "Lcom/myscript/nebo/banner/Banner$CorruptedBanner;", "Lcom/myscript/nebo/banner/Banner$FeedbackBanner;", "Lcom/myscript/nebo/banner/Banner$ForbiddenBanner;", "Lcom/myscript/nebo/banner/Banner$MarketingBanner;", "Lcom/myscript/nebo/banner/Banner$WarningBanner;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Banner {
    private static final int NO_DRAWABLE = 0;
    private final Runnable action;
    private final String actionText;
    private final boolean blackListOnActionClicked;
    private final String id;
    private final boolean isCloseable;
    private final CharSequence message;
    private final int messageDrawable;
    private final Priority priority;
    private final Runnable secondaryAction;
    private final String secondaryActionText;
    private final Type type;
    public static final int $stable = 8;

    public /* synthetic */ Banner(String str, CharSequence charSequence, Type type, String str2, Runnable runnable, String str3, Runnable runnable2, int i, Priority priority, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, charSequence, type, str2, runnable, str3, runnable2, i, priority, z);
    }

    private Banner(String str, CharSequence charSequence, Type type, String str2, Runnable runnable, String str3, Runnable runnable2, int i, Priority priority, boolean z) {
        this.id = str;
        this.message = charSequence;
        this.type = type;
        this.actionText = str2;
        this.action = runnable;
        this.secondaryActionText = str3;
        this.secondaryAction = runnable2;
        this.messageDrawable = i;
        this.priority = priority;
        this.blackListOnActionClicked = z;
        this.isCloseable = type != Type.PERMANENT_FORCED;
    }

    public final String getId() {
        return this.id;
    }

    public final CharSequence getMessage() {
        return this.message;
    }

    public /* synthetic */ Banner(String str, CharSequence charSequence, Type type, String str2, Runnable runnable, String str3, Runnable runnable2, int i, Priority priority, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, charSequence, (i2 & 4) != 0 ? Type.PERMANENT : type, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : runnable, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : runnable2, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? Priority.FEEDBACK : priority, (i2 & 512) != 0 ? true : z, null);
    }

    public final Type getType() {
        return this.type;
    }

    public final String getActionText() {
        return this.actionText;
    }

    public final Runnable getAction() {
        return this.action;
    }

    public final String getSecondaryActionText() {
        return this.secondaryActionText;
    }

    public final Runnable getSecondaryAction() {
        return this.secondaryAction;
    }

    public final int getMessageDrawable() {
        return this.messageDrawable;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final boolean getBlackListOnActionClicked() {
        return this.blackListOnActionClicked;
    }

    /* JADX INFO: renamed from: isCloseable, reason: from getter */
    public final boolean getIsCloseable() {
        return this.isCloseable;
    }

    /* JADX INFO: compiled from: Banners.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Bg\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/banner/Banner$WarningBanner;", "Lcom/myscript/nebo/banner/Banner;", "id", "", "message", "", "type", "Lcom/myscript/nebo/banner/Type;", "actionText", "action", "Ljava/lang/Runnable;", "secondaryActionText", "secondaryAction", "blackListOnActionClicked", "", "messageDrawable", "", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/myscript/nebo/banner/Type;Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/Runnable;ZI)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class WarningBanner extends Banner {
        public static final int $stable = 8;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public WarningBanner(String id, CharSequence message) {
            this(id, message, null, null, null, null, null, false, 0, TypedValues.PositionType.TYPE_CURVE_FIT, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public WarningBanner(String id, CharSequence message, Type type) {
            this(id, message, type, null, null, null, null, false, 0, 504, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public WarningBanner(String id, CharSequence message, Type type, String str) {
            this(id, message, type, str, null, null, null, false, 0, 496, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public WarningBanner(String id, CharSequence message, Type type, String str, Runnable runnable) {
            this(id, message, type, str, runnable, null, null, false, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public WarningBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2) {
            this(id, message, type, str, runnable, str2, null, false, 0, 448, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public WarningBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2) {
            this(id, message, type, str, runnable, str2, runnable2, false, 0, RendererCapabilities.DECODER_SUPPORT_MASK, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public WarningBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, boolean z) {
            this(id, message, type, str, runnable, str2, runnable2, z, 0, 256, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public /* synthetic */ WarningBanner(String str, CharSequence charSequence, Type type, String str2, Runnable runnable, String str3, Runnable runnable2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, charSequence, (i2 & 4) != 0 ? Type.PERMANENT : type, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : runnable, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : runnable2, (i2 & 128) != 0 ? true : z, (i2 & 256) != 0 ? 0 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WarningBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, boolean z, int i) {
            super(id, message, type, str, runnable, str2, runnable2, i, Priority.WARNING, z, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    /* JADX INFO: compiled from: Banners.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Bg\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/banner/Banner$CorruptedBanner;", "Lcom/myscript/nebo/banner/Banner;", "id", "", "message", "", "type", "Lcom/myscript/nebo/banner/Type;", "actionText", "action", "Ljava/lang/Runnable;", "secondaryActionText", "secondaryAction", "blackListOnActionClicked", "", "messageDrawable", "", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/myscript/nebo/banner/Type;Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/Runnable;ZI)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CorruptedBanner extends Banner {
        public static final int $stable = 8;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CorruptedBanner(String id, CharSequence message) {
            this(id, message, null, null, null, null, null, false, 0, TypedValues.PositionType.TYPE_CURVE_FIT, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CorruptedBanner(String id, CharSequence message, Type type) {
            this(id, message, type, null, null, null, null, false, 0, 504, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CorruptedBanner(String id, CharSequence message, Type type, String str) {
            this(id, message, type, str, null, null, null, false, 0, 496, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CorruptedBanner(String id, CharSequence message, Type type, String str, Runnable runnable) {
            this(id, message, type, str, runnable, null, null, false, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CorruptedBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2) {
            this(id, message, type, str, runnable, str2, null, false, 0, 448, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CorruptedBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2) {
            this(id, message, type, str, runnable, str2, runnable2, false, 0, RendererCapabilities.DECODER_SUPPORT_MASK, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CorruptedBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, boolean z) {
            this(id, message, type, str, runnable, str2, runnable2, z, 0, 256, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public /* synthetic */ CorruptedBanner(String str, CharSequence charSequence, Type type, String str2, Runnable runnable, String str3, Runnable runnable2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, charSequence, (i2 & 4) != 0 ? Type.PERMANENT : type, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : runnable, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : runnable2, (i2 & 128) != 0 ? true : z, (i2 & 256) != 0 ? 0 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CorruptedBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, boolean z, int i) {
            super(id, message, type, str, runnable, str2, runnable2, i, Priority.CORRUPTED, z, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    /* JADX INFO: compiled from: Banners.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B]\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/banner/Banner$ForbiddenBanner;", "Lcom/myscript/nebo/banner/Banner;", "id", "", "message", "", "type", "Lcom/myscript/nebo/banner/Type;", "actionText", "action", "Ljava/lang/Runnable;", "secondaryActionText", "secondaryAction", "messageDrawable", "", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/myscript/nebo/banner/Type;Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/Runnable;I)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ForbiddenBanner extends Banner {
        public static final int $stable = 8;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ForbiddenBanner(String id, CharSequence message) {
            this(id, message, null, null, null, null, null, 0, PDFACompliance.e_PDFA2_5_2, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ForbiddenBanner(String id, CharSequence message, Type type) {
            this(id, message, type, null, null, null, null, 0, 248, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ForbiddenBanner(String id, CharSequence message, Type type, String str) {
            this(id, message, type, str, null, null, null, 0, PsExtractor.VIDEO_STREAM_MASK, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ForbiddenBanner(String id, CharSequence message, Type type, String str, Runnable runnable) {
            this(id, message, type, str, runnable, null, null, 0, 224, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ForbiddenBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2) {
            this(id, message, type, str, runnable, str2, null, 0, PsExtractor.AUDIO_STREAM, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ForbiddenBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2) {
            this(id, message, type, str, runnable, str2, runnable2, 0, 128, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public /* synthetic */ ForbiddenBanner(String str, CharSequence charSequence, Type type, String str2, Runnable runnable, String str3, Runnable runnable2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, charSequence, (i2 & 4) != 0 ? Type.PERMANENT : type, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : runnable, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : runnable2, (i2 & 128) != 0 ? 0 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForbiddenBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, int i) {
            super(id, message, type, str, runnable, str2, runnable2, i, Priority.FORBIDDEN, false, 512, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    /* JADX INFO: compiled from: Banners.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Bg\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/banner/Banner$MarketingBanner;", "Lcom/myscript/nebo/banner/Banner;", "id", "", "message", "", "type", "Lcom/myscript/nebo/banner/Type;", "actionText", "action", "Ljava/lang/Runnable;", "secondaryActionText", "secondaryAction", "blackListOnActionClicked", "", "messageDrawable", "", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/myscript/nebo/banner/Type;Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/Runnable;ZI)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class MarketingBanner extends Banner {
        public static final int $stable = 8;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MarketingBanner(String id, CharSequence message) {
            this(id, message, null, null, null, null, null, false, 0, TypedValues.PositionType.TYPE_CURVE_FIT, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MarketingBanner(String id, CharSequence message, Type type) {
            this(id, message, type, null, null, null, null, false, 0, 504, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MarketingBanner(String id, CharSequence message, Type type, String str) {
            this(id, message, type, str, null, null, null, false, 0, 496, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MarketingBanner(String id, CharSequence message, Type type, String str, Runnable runnable) {
            this(id, message, type, str, runnable, null, null, false, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MarketingBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2) {
            this(id, message, type, str, runnable, str2, null, false, 0, 448, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MarketingBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2) {
            this(id, message, type, str, runnable, str2, runnable2, false, 0, RendererCapabilities.DECODER_SUPPORT_MASK, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MarketingBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, boolean z) {
            this(id, message, type, str, runnable, str2, runnable2, z, 0, 256, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public /* synthetic */ MarketingBanner(String str, CharSequence charSequence, Type type, String str2, Runnable runnable, String str3, Runnable runnable2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, charSequence, (i2 & 4) != 0 ? Type.PERMANENT : type, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : runnable, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : runnable2, (i2 & 128) != 0 ? true : z, (i2 & 256) != 0 ? 0 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MarketingBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, boolean z, int i) {
            super(id, message, type, str, runnable, str2, runnable2, i, Priority.MARKETING, z, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    /* JADX INFO: compiled from: Banners.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Bg\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/banner/Banner$FeedbackBanner;", "Lcom/myscript/nebo/banner/Banner;", "id", "", "message", "", "type", "Lcom/myscript/nebo/banner/Type;", "actionText", "action", "Ljava/lang/Runnable;", "secondaryActionText", "secondaryAction", "blackListOnActionClicked", "", "messageDrawable", "", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/myscript/nebo/banner/Type;Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/Runnable;ZI)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class FeedbackBanner extends Banner {
        public static final int $stable = 8;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackBanner(String id, CharSequence message) {
            this(id, message, null, null, null, null, null, false, 0, TypedValues.PositionType.TYPE_CURVE_FIT, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackBanner(String id, CharSequence message, Type type) {
            this(id, message, type, null, null, null, null, false, 0, 504, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackBanner(String id, CharSequence message, Type type, String str) {
            this(id, message, type, str, null, null, null, false, 0, 496, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackBanner(String id, CharSequence message, Type type, String str, Runnable runnable) {
            this(id, message, type, str, runnable, null, null, false, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2) {
            this(id, message, type, str, runnable, str2, null, false, 0, 448, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2) {
            this(id, message, type, str, runnable, str2, runnable2, false, 0, RendererCapabilities.DECODER_SUPPORT_MASK, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, boolean z) {
            this(id, message, type, str, runnable, str2, runnable2, z, 0, 256, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public /* synthetic */ FeedbackBanner(String str, CharSequence charSequence, Type type, String str2, Runnable runnable, String str3, Runnable runnable2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, charSequence, (i2 & 4) != 0 ? Type.PERMANENT : type, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : runnable, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : runnable2, (i2 & 128) != 0 ? true : z, (i2 & 256) != 0 ? 0 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedbackBanner(String id, CharSequence message, Type type, String str, Runnable runnable, String str2, Runnable runnable2, boolean z, int i) {
            super(id, message, type, str, runnable, str2, runnable2, i, Priority.FEEDBACK, z, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }
}
