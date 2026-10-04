package com.survicate.surveys.presentation.nps.micro;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.questions.nps.AnswerLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NpsAnswerStyle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/micro/NpsAnswerStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Horizontal", "Vertical", "PortraitHorizontal", "itemTemplate", "Lcom/survicate/surveys/presentation/nps/micro/NpsAnswerItemTemplate;", "getItemTemplate", "()Lcom/survicate/surveys/presentation/nps/micro/NpsAnswerItemTemplate;", "getLeftDescription", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "settingsText", "getRightDescription", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class NpsAnswerStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NpsAnswerStyle[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final NpsAnswerStyle Horizontal = new NpsAnswerStyle("Horizontal", 0) { // from class: com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle.Horizontal
        private final NpsAnswerItemTemplate itemTemplate = new NpsAnswerItemTemplate(C8369R.layout.item_micro_nps_horizontal, C8369R.id.item_micro_nps_horizontal_label, true);

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public String getLeftDescription(Context context, String settingsText) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(settingsText, "settingsText");
            return settingsText;
        }

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public String getRightDescription(Context context, String settingsText) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(settingsText, "settingsText");
            return settingsText;
        }

        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public NpsAnswerItemTemplate getItemTemplate() {
            return this.itemTemplate;
        }
    };
    public static final NpsAnswerStyle Vertical = new NpsAnswerStyle("Vertical", 1) { // from class: com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle.Vertical
        private final NpsAnswerItemTemplate itemTemplate = new NpsAnswerItemTemplate(C8369R.layout.item_micro_nps_vertical, C8369R.id.item_micro_nps_vertical_label, false);

        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public NpsAnswerItemTemplate getItemTemplate() {
            return this.itemTemplate;
        }

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public String getLeftDescription(Context context, String settingsText) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(settingsText, "settingsText");
            return "";
        }

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public String getRightDescription(Context context, String settingsText) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(settingsText, "settingsText");
            return "";
        }
    };
    public static final NpsAnswerStyle PortraitHorizontal = new NpsAnswerStyle("PortraitHorizontal", 2) { // from class: com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle.PortraitHorizontal
        private final NpsAnswerItemTemplate itemTemplate = new NpsAnswerItemTemplate(C8369R.layout.item_micro_nps_portrait_horizontal, C8369R.id.item_micro_nps_portrait_horizontal_label, true);

        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public NpsAnswerItemTemplate getItemTemplate() {
            return this.itemTemplate;
        }

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public String getLeftDescription(Context context, String settingsText) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(settingsText, "settingsText");
            if (!StringsKt.isBlank(settingsText)) {
                String string = context.getString(C8369R.string.survicate_micro_nps_portrait_horizontal_left_description, settingsText);
                Intrinsics.checkNotNull(string);
                return string;
            }
            return "";
        }

        @Override // com.survicate.surveys.presentation.nps.micro.NpsAnswerStyle
        public String getRightDescription(Context context, String settingsText) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(settingsText, "settingsText");
            if (!StringsKt.isBlank(settingsText)) {
                String string = context.getString(C8369R.string.survicate_micro_nps_portrait_horizontal_right_description, settingsText);
                Intrinsics.checkNotNull(string);
                return string;
            }
            return "";
        }
    };

    private static final /* synthetic */ NpsAnswerStyle[] $values() {
        return new NpsAnswerStyle[]{Horizontal, Vertical, PortraitHorizontal};
    }

    public /* synthetic */ NpsAnswerStyle(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    public static EnumEntries<NpsAnswerStyle> getEntries() {
        return $ENTRIES;
    }

    public abstract NpsAnswerItemTemplate getItemTemplate();

    public abstract String getLeftDescription(Context context, String settingsText);

    public abstract String getRightDescription(Context context, String settingsText);

    private NpsAnswerStyle(String str, int i) {
    }

    static {
        NpsAnswerStyle[] npsAnswerStyleArr$values = $values();
        $VALUES = npsAnswerStyleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(npsAnswerStyleArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: NpsAnswerStyle.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/micro/NpsAnswerStyle$Companion;", "", "<init>", "()V", "fromLayoutAndScreenWidth", "Lcom/survicate/surveys/presentation/nps/micro/NpsAnswerStyle;", "layout", "Lcom/survicate/surveys/entities/survey/questions/nps/AnswerLayout;", "isWideScreen", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: NpsAnswerStyle.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnswerLayout.values().length];
                try {
                    iArr[AnswerLayout.Default.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnswerLayout.Horizontal.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NpsAnswerStyle fromLayoutAndScreenWidth(AnswerLayout layout, boolean isWideScreen) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            int i = WhenMappings.$EnumSwitchMapping$0[layout.ordinal()];
            if (i == 1) {
                return isWideScreen ? NpsAnswerStyle.Horizontal : NpsAnswerStyle.Vertical;
            }
            if (i == 2) {
                return isWideScreen ? NpsAnswerStyle.Horizontal : NpsAnswerStyle.PortraitHorizontal;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static NpsAnswerStyle valueOf(String str) {
        return (NpsAnswerStyle) Enum.valueOf(NpsAnswerStyle.class, str);
    }

    public static NpsAnswerStyle[] values() {
        return (NpsAnswerStyle[]) $VALUES.clone();
    }
}
