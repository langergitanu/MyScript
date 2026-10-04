package com.survicate.surveys.entities.survey.questions.question.smileyScale;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SmileyScaleStyleType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SmileyScaleStyleType;", "", "<init>", "(Ljava/lang/String;I)V", "EMOJIS", "OUTLINED", "FILLED", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final class SmileyScaleStyleType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SmileyScaleStyleType[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    @SerialName("emojis")
    public static final SmileyScaleStyleType EMOJIS = new SmileyScaleStyleType("EMOJIS", 0);

    @SerialName("outlined")
    public static final SmileyScaleStyleType OUTLINED = new SmileyScaleStyleType("OUTLINED", 1);

    @SerialName(TtmlNode.TEXT_EMPHASIS_MARK_FILLED)
    public static final SmileyScaleStyleType FILLED = new SmileyScaleStyleType("FILLED", 2);

    private static final /* synthetic */ SmileyScaleStyleType[] $values() {
        return new SmileyScaleStyleType[]{EMOJIS, OUTLINED, FILLED};
    }

    public static EnumEntries<SmileyScaleStyleType> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: SmileyScaleStyleType.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SmileyScaleStyleType$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SmileyScaleStyleType;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SmileyScaleStyleType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SmileyScaleStyleType> serializer() {
            return get$cachedSerializer();
        }
    }

    private SmileyScaleStyleType(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.questions.question.smileyScale.SmileyScaleStyleType", values(), new String[]{"emojis", "outlined", TtmlNode.TEXT_EMPHASIS_MARK_FILLED}, new Annotation[][]{null, null, null}, null);
    }

    static {
        SmileyScaleStyleType[] smileyScaleStyleTypeArr$values = $values();
        $VALUES = smileyScaleStyleTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(smileyScaleStyleTypeArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.smileyScale.SmileyScaleStyleType$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SmileyScaleStyleType._init_$_anonymous_();
            }
        });
    }

    public static SmileyScaleStyleType valueOf(String str) {
        return (SmileyScaleStyleType) Enum.valueOf(SmileyScaleStyleType.class, str);
    }

    public static SmileyScaleStyleType[] values() {
        return (SmileyScaleStyleType[]) $VALUES.clone();
    }
}
