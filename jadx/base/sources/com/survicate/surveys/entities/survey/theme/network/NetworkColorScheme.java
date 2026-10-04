package com.survicate.surveys.entities.survey.theme.network;

import com.survicate.surveys.infrastructure.serialization.ColorSerializer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: NetworkColorScheme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u00060"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;", "", "question", "", "answer", "button", "background", "progressBar", "<init>", "(IIIII)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQuestion$annotations", "()V", "getQuestion", "()I", "getAnswer$annotations", "getAnswer", "getButton$annotations", "getButton", "getBackground$annotations", "getBackground", "getProgressBar$annotations", "getProgressBar", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkColorScheme {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int answer;
    private final int background;
    private final int button;
    private final int progressBar;
    private final int question;

    public static /* synthetic */ NetworkColorScheme copy$default(NetworkColorScheme networkColorScheme, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = networkColorScheme.question;
        }
        if ((i6 & 2) != 0) {
            i2 = networkColorScheme.answer;
        }
        if ((i6 & 4) != 0) {
            i3 = networkColorScheme.button;
        }
        if ((i6 & 8) != 0) {
            i4 = networkColorScheme.background;
        }
        if ((i6 & 16) != 0) {
            i5 = networkColorScheme.progressBar;
        }
        int i7 = i5;
        int i8 = i3;
        return networkColorScheme.copy(i, i2, i8, i4, i7);
    }

    @SerialName("answer")
    @Serializable(with = ColorSerializer.class)
    public static /* synthetic */ void getAnswer$annotations() {
    }

    @SerialName("background")
    @Serializable(with = ColorSerializer.class)
    public static /* synthetic */ void getBackground$annotations() {
    }

    @SerialName("button")
    @Serializable(with = ColorSerializer.class)
    public static /* synthetic */ void getButton$annotations() {
    }

    @SerialName("progress_bar")
    @Serializable(with = ColorSerializer.class)
    public static /* synthetic */ void getProgressBar$annotations() {
    }

    @SerialName("question")
    @Serializable(with = ColorSerializer.class)
    public static /* synthetic */ void getQuestion$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getQuestion() {
        return this.question;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAnswer() {
        return this.answer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getButton() {
        return this.button;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getProgressBar() {
        return this.progressBar;
    }

    public final NetworkColorScheme copy(int question, int answer, int button, int background, int progressBar) {
        return new NetworkColorScheme(question, answer, button, background, progressBar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkColorScheme)) {
            return false;
        }
        NetworkColorScheme networkColorScheme = (NetworkColorScheme) other;
        return this.question == networkColorScheme.question && this.answer == networkColorScheme.answer && this.button == networkColorScheme.button && this.background == networkColorScheme.background && this.progressBar == networkColorScheme.progressBar;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.question) * 31) + Integer.hashCode(this.answer)) * 31) + Integer.hashCode(this.button)) * 31) + Integer.hashCode(this.background)) * 31) + Integer.hashCode(this.progressBar);
    }

    public String toString() {
        return "NetworkColorScheme(question=" + this.question + ", answer=" + this.answer + ", button=" + this.button + ", background=" + this.background + ", progressBar=" + this.progressBar + ')';
    }

    /* JADX INFO: compiled from: NetworkColorScheme.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkColorScheme> serializer() {
            return NetworkColorScheme$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NetworkColorScheme(int i, int i2, int i3, int i4, int i5, int i6, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, NetworkColorScheme$$serializer.INSTANCE.getDescriptor());
        }
        this.question = i2;
        this.answer = i3;
        this.button = i4;
        this.background = i5;
        this.progressBar = i6;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkColorScheme self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ColorSerializer.INSTANCE, Integer.valueOf(self.question));
        output.encodeSerializableElement(serialDesc, 1, ColorSerializer.INSTANCE, Integer.valueOf(self.answer));
        output.encodeSerializableElement(serialDesc, 2, ColorSerializer.INSTANCE, Integer.valueOf(self.button));
        output.encodeSerializableElement(serialDesc, 3, ColorSerializer.INSTANCE, Integer.valueOf(self.background));
        output.encodeSerializableElement(serialDesc, 4, ColorSerializer.INSTANCE, Integer.valueOf(self.progressBar));
    }

    public NetworkColorScheme(int i, int i2, int i3, int i4, int i5) {
        this.question = i;
        this.answer = i2;
        this.button = i3;
        this.background = i4;
        this.progressBar = i5;
    }

    public final int getQuestion() {
        return this.question;
    }

    public final int getAnswer() {
        return this.answer;
    }

    public final int getButton() {
        return this.button;
    }

    public final int getBackground() {
        return this.background;
    }

    public final int getProgressBar() {
        return this.progressBar;
    }
}
