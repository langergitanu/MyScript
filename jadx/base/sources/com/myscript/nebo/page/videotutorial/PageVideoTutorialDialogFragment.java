package com.myscript.nebo.page.videotutorial;

import com.myscript.nebo.videotutorial.TutorialData;
import com.myscript.nebo.videotutorial.TutorialFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PageVideoTutorialDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/page/videotutorial/PageVideoTutorialDialogFragment;", "Lcom/myscript/nebo/videotutorial/TutorialFragment;", "<init>", "()V", "title", "", "getTitle", "()I", "data", "", "Lcom/myscript/nebo/videotutorial/TutorialData;", "getData", "()[Lcom/myscript/nebo/videotutorial/TutorialData;", "[Lcom/myscript/nebo/videotutorial/TutorialData;", "isCompleted", "", "()Z", "Companion", "video-tutorial-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageVideoTutorialDialogFragment extends TutorialFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "PageVideoTutorialDialogFragment";
    private final TutorialData[] data = {new TutorialData(C6678R.raw.tutorial_page_write_video, C6678R.string.tutorial_page_write_title, C6678R.string.tutorial_page_write_body, C6678R.string.tutorial_page_aspect_ratio), new TutorialData(C6678R.raw.tutorial_page_edit_video, C6678R.string.tutorial_page_edit_title, C6678R.string.tutorial_page_edit_body, C6678R.string.tutorial_page_aspect_ratio), new TutorialData(C6678R.raw.tutorial_page_finalize_video, C6678R.string.tutorial_page_finalize_title, C6678R.string.tutorial_page_finalize_body, C6678R.string.tutorial_page_aspect_ratio)};
    private final boolean isCompleted = true;

    @JvmStatic
    public static final PageVideoTutorialDialogFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // com.myscript.nebo.videotutorial.TutorialFragment
    public int getTitle() {
        return C6678R.string.tutorial_page_title;
    }

    @Override // com.myscript.nebo.videotutorial.TutorialFragment
    public TutorialData[] getData() {
        return this.data;
    }

    @Override // com.myscript.nebo.videotutorial.TutorialFragment
    /* JADX INFO: renamed from: isCompleted, reason: from getter */
    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    /* JADX INFO: compiled from: PageVideoTutorialDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/page/videotutorial/PageVideoTutorialDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/page/videotutorial/PageVideoTutorialDialogFragment;", "video-tutorial-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PageVideoTutorialDialogFragment newInstance() {
            return new PageVideoTutorialDialogFragment();
        }
    }
}
