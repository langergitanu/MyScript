package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

/* JADX INFO: compiled from: CodepointTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bá\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m1599d2 = {"Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "", "transform", "", "codepointIndex", "codepoint", "Companion", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface CodepointTransformation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    int transform(int codepointIndex, int codepoint);

    /* JADX INFO: compiled from: CodepointTransformation.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Landroidx/compose/foundation/text/input/internal/CodepointTransformation$Companion;", "", "<init>", "()V", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
