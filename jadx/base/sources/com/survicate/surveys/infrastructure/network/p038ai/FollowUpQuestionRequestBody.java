package com.survicate.surveys.infrastructure.network.p038ai;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.myscript.nebo.LaunchActivity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: FollowUpQuestionRequestBody.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002)*B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J/\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0015¨\u0006+"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;", "", "dialogs", "", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpDialog;", LaunchActivity.LaunchRoute.Language, "", "workspaceKey", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDialogs$annotations", "()V", "getDialogs", "()Ljava/util/List;", "getLanguage$annotations", "getLanguage", "()Ljava/lang/String;", "getWorkspaceKey$annotations", "getWorkspaceKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "Companion", "$serializer", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class FollowUpQuestionRequestBody {
    private final List<FollowUpDialog> dialogs;
    private final String language;
    private final String workspaceKey;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.ai.FollowUpQuestionRequestBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return FollowUpQuestionRequestBody._childSerializers$_anonymous_();
        }
    }), null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(FollowUpDialog$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FollowUpQuestionRequestBody copy$default(FollowUpQuestionRequestBody followUpQuestionRequestBody, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = followUpQuestionRequestBody.dialogs;
        }
        if ((i & 2) != 0) {
            str = followUpQuestionRequestBody.language;
        }
        if ((i & 4) != 0) {
            str2 = followUpQuestionRequestBody.workspaceKey;
        }
        return followUpQuestionRequestBody.copy(list, str, str2);
    }

    @SerialName("dialogs")
    public static /* synthetic */ void getDialogs$annotations() {
    }

    @SerialName(LaunchActivity.LaunchRoute.Language)
    public static /* synthetic */ void getLanguage$annotations() {
    }

    @SerialName("workspace_key")
    public static /* synthetic */ void getWorkspaceKey$annotations() {
    }

    public final List<FollowUpDialog> component1() {
        return this.dialogs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWorkspaceKey() {
        return this.workspaceKey;
    }

    public final FollowUpQuestionRequestBody copy(List<FollowUpDialog> dialogs, String language, String workspaceKey) {
        Intrinsics.checkNotNullParameter(dialogs, "dialogs");
        Intrinsics.checkNotNullParameter(workspaceKey, "workspaceKey");
        return new FollowUpQuestionRequestBody(dialogs, language, workspaceKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowUpQuestionRequestBody)) {
            return false;
        }
        FollowUpQuestionRequestBody followUpQuestionRequestBody = (FollowUpQuestionRequestBody) other;
        return Intrinsics.areEqual(this.dialogs, followUpQuestionRequestBody.dialogs) && Intrinsics.areEqual(this.language, followUpQuestionRequestBody.language) && Intrinsics.areEqual(this.workspaceKey, followUpQuestionRequestBody.workspaceKey);
    }

    public int hashCode() {
        int iHashCode = this.dialogs.hashCode() * 31;
        String str = this.language;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.workspaceKey.hashCode();
    }

    public String toString() {
        return "FollowUpQuestionRequestBody(dialogs=" + this.dialogs + ", language=" + this.language + ", workspaceKey=" + this.workspaceKey + ')';
    }

    public /* synthetic */ FollowUpQuestionRequestBody(int i, List list, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, FollowUpQuestionRequestBody$$serializer.INSTANCE.getDescriptor());
        }
        this.dialogs = list;
        this.language = str;
        this.workspaceKey = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(FollowUpQuestionRequestBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0].getValue(), self.dialogs);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.language);
        output.encodeStringElement(serialDesc, 2, self.workspaceKey);
    }

    public FollowUpQuestionRequestBody(List<FollowUpDialog> dialogs, String str, String workspaceKey) {
        Intrinsics.checkNotNullParameter(dialogs, "dialogs");
        Intrinsics.checkNotNullParameter(workspaceKey, "workspaceKey");
        this.dialogs = dialogs;
        this.language = str;
        this.workspaceKey = workspaceKey;
    }

    public final List<FollowUpDialog> getDialogs() {
        return this.dialogs;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getWorkspaceKey() {
        return this.workspaceKey;
    }

    /* JADX INFO: compiled from: FollowUpQuestionRequestBody.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody$Companion;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;", "dialogs", "", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpDialog;", LaunchActivity.LaunchRoute.Language, "", "workspaceKey", "serializer", "Lkotlinx/serialization/KSerializer;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FollowUpQuestionRequestBody> serializer() {
            return FollowUpQuestionRequestBody$$serializer.INSTANCE;
        }

        public final FollowUpQuestionRequestBody from(List<FollowUpDialog> dialogs, String language, String workspaceKey) {
            Intrinsics.checkNotNullParameter(dialogs, "dialogs");
            Intrinsics.checkNotNullParameter(workspaceKey, "workspaceKey");
            return new FollowUpQuestionRequestBody(dialogs, language, workspaceKey);
        }
    }
}
