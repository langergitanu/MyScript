package androidx.compose.runtime;

import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: LinkComposer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Landroidx/compose/runtime/ReusableLinkRememberObserverHolder;", "Landroidx/compose/runtime/LinkRememberObserverHolder;", "Landroidx/compose/runtime/ReusableRememberObserverHolder;", "wrapped", "Landroidx/compose/runtime/RememberObserver;", TtmlNode.ANNOTATION_POSITION_AFTER, "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "<init>", "(Landroidx/compose/runtime/RememberObserver;Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;)V", "runtime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ReusableLinkRememberObserverHolder extends LinkRememberObserverHolder implements ReusableRememberObserverHolder {
    public static final int $stable = 8;

    public ReusableLinkRememberObserverHolder(RememberObserver rememberObserver, LinkAnchor linkAnchor) {
        super(rememberObserver, linkAnchor);
    }
}
