package com.myscript.nebo.videotutorial;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.android.utils.TextViewExt;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;

/* JADX INFO: compiled from: TutorialSlideFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0002J \u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J\u0014\u0010,\u001a\u00020#2\n\u0010-\u001a\u00060.j\u0002`/H\u0002J \u00100\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u000fH\u0002J\u0006\u00106\u001a\u00020#J\b\u00107\u001a\u00020#H\u0003J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006;"}, m1599d2 = {"Lcom/myscript/nebo/videotutorial/TutorialSlideFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/TextureView$SurfaceTextureListener;", "<init>", "()V", "data", "Lcom/myscript/nebo/videotutorial/TutorialData;", "videoView", "Landroid/view/TextureView;", "videoViewMask", "Landroid/view/View;", "videoErrorMessage", "progressBar", "Landroid/widget/ProgressBar;", "mediaPlayer", "Landroid/media/MediaPlayer;", "timer", "Ljava/util/Timer;", "surface", "Landroid/view/Surface;", "value", "Lcom/myscript/nebo/videotutorial/IMediaPlayerConfigurer;", "mediaPlayerConfigurer", "getMediaPlayerConfigurer", "()Lcom/myscript/nebo/videotutorial/IMediaPlayerConfigurer;", "setMediaPlayerConfigurer", "(Lcom/myscript/nebo/videotutorial/IMediaPlayerConfigurer;)V", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onStop", "releaseMediaPlayer", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "handleVideoLoadingError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "", "onSurfaceTextureUpdated", "startVideo", "player", "restartVideo", "updateProgress", "startProgressTask", "stopProgressTask", "Companion", "video-tutorial_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TutorialSlideFragment extends Fragment implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STEP_BODY_RES = "STEP_BODY_RES";
    private static final String STEP_TITLE_RES = "STEP_TITLE_RES";
    private static final String STEP_VIDEO_ASPECT_RATIO_RES = "STEP_VIDEO_ASPECT_RATIO_RES";
    private static final String STEP_VIDEO_RES = "STEP_VIDEO_RES";
    private static final String TAG = "TutorialFragmentTag";
    private TutorialData data;
    private MediaPlayer mediaPlayer;
    private IMediaPlayerConfigurer mediaPlayerConfigurer;
    private ProgressBar progressBar;
    private Surface surface;
    private Timer timer;
    private View videoErrorMessage;
    private TextureView videoView;
    private View videoViewMask;

    @JvmStatic
    public static final TutorialSlideFragment newInstance(int i, int i2, int i3, int i4) {
        return INSTANCE.newInstance(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
    }

    public final IMediaPlayerConfigurer getMediaPlayerConfigurer() {
        return this.mediaPlayerConfigurer;
    }

    public final synchronized void setMediaPlayerConfigurer(IMediaPlayerConfigurer iMediaPlayerConfigurer) {
        this.mediaPlayerConfigurer = iMediaPlayerConfigurer;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle bundleRequireArguments = requireArguments();
        this.data = new TutorialData(bundleRequireArguments.getInt(STEP_VIDEO_RES), bundleRequireArguments.getInt(STEP_TITLE_RES), bundleRequireArguments.getInt(STEP_BODY_RES), bundleRequireArguments.getInt(STEP_VIDEO_ASPECT_RATIO_RES));
        View viewInflate = inflater.inflate(C6903R.layout.tutorial_slide_fragment, container, false);
        TutorialData tutorialData = null;
        if (viewInflate == null) {
            return null;
        }
        this.progressBar = (ProgressBar) viewInflate.findViewById(C6903R.id.tutorial_video_progress);
        this.videoView = (TextureView) viewInflate.findViewById(C6903R.id.tutorial_video);
        if (viewInflate instanceof ConstraintLayout) {
            ConstraintSet constraintSet = new ConstraintSet();
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            constraintSet.clone(constraintLayout);
            TutorialData tutorialData2 = this.data;
            if (tutorialData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                tutorialData2 = null;
            }
            String string = getString(tutorialData2.getVideoAspectRatioStringRes());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            constraintSet.setDimensionRatio(C6903R.id.tutorial_video, string);
            constraintSet.applyTo(constraintLayout);
        }
        this.videoViewMask = viewInflate.findViewById(C6903R.id.tutorial_video_mask);
        this.videoErrorMessage = viewInflate.findViewById(C6903R.id.tutorial_video_error_message);
        TextView textView = (TextView) viewInflate.findViewById(C6903R.id.tutorial_slide_title);
        TutorialData tutorialData3 = this.data;
        if (tutorialData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            tutorialData3 = null;
        }
        textView.setText(tutorialData3.getTitleStringRes());
        View viewFindViewById = viewInflate.findViewById(C6903R.id.tutorial_slide_body);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById;
        TutorialData tutorialData4 = this.data;
        if (tutorialData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        } else {
            tutorialData = tutorialData4;
        }
        TextViewExt.setHtml(textView2, tutorialData.getBodyStringRes());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        TextureView textureView = this.videoView;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this);
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    return;
                }
                mediaPlayer.start();
            } catch (IllegalStateException unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            } catch (IllegalStateException unused) {
            }
        }
        super.onStop();
    }

    private final void releaseMediaPlayer() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(null);
            mediaPlayer.release();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        releaseMediaPlayer();
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        View view = this.videoErrorMessage;
        if (view != null) {
            view.setVisibility(8);
        }
        try {
            Resources resources = getResources();
            TutorialData tutorialData = this.data;
            if (tutorialData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                tutorialData = null;
            }
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(tutorialData.getVideo());
            try {
                AssetFileDescriptor assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                this.surface = new Surface(surfaceTexture);
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    mediaPlayer.setSurface(this.surface);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.myscript.nebo.videotutorial.TutorialSlideFragment$$ExternalSyntheticLambda0
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public final void onPrepared(MediaPlayer mediaPlayer2) {
                            TutorialSlideFragment.onSurfaceTextureAvailable$lambda$0$0$0(this.f$0, mediaPlayer2);
                        }
                    });
                    this.mediaPlayer = mediaPlayer;
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(assetFileDescriptorOpenRawResourceFd, null);
                } catch (Exception e) {
                    handleVideoLoadingError(e);
                    CloseableKt.closeFinally(assetFileDescriptorOpenRawResourceFd, null);
                }
            } finally {
            }
        } catch (Exception e2) {
            handleVideoLoadingError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSurfaceTextureAvailable$lambda$0$0$0(TutorialSlideFragment tutorialSlideFragment, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNull(mediaPlayer);
        tutorialSlideFragment.startVideo(mediaPlayer);
    }

    private final void handleVideoLoadingError(Exception e) {
        TutorialData tutorialData = this.data;
        if (tutorialData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            tutorialData = null;
        }
        Log.e(TAG, "Error during initialization of MediaPlayer for tutorial step '" + getString(tutorialData.getTitleStringRes()) + "'", e);
        this.mediaPlayer = null;
        View view = this.videoErrorMessage;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        stopProgressTask();
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        } catch (IllegalStateException unused) {
        }
        releaseMediaPlayer();
        TextureView textureView = this.videoView;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
        }
        Surface surface = this.surface;
        if (surface == null) {
            return true;
        }
        surface.release();
        return true;
    }

    private final void startVideo(final MediaPlayer player) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setMax(player.getDuration());
        }
        View view = getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.myscript.nebo.videotutorial.TutorialSlideFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    TutorialSlideFragment.startVideo$lambda$0(this.f$0, player);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVideo$lambda$0(TutorialSlideFragment tutorialSlideFragment, MediaPlayer mediaPlayer) {
        try {
            View view = tutorialSlideFragment.videoViewMask;
            if (view != null) {
                view.setVisibility(8);
            }
            if (tutorialSlideFragment.mediaPlayer == mediaPlayer) {
                mediaPlayer.start();
            }
            tutorialSlideFragment.startProgressTask();
        } catch (IllegalStateException unused) {
        }
    }

    public final void restartVideo() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(0);
            }
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProgress() {
        MediaPlayer mediaPlayer;
        ProgressBar progressBar;
        if (!isAdded() || (mediaPlayer = this.mediaPlayer) == null) {
            return;
        }
        try {
            if (!mediaPlayer.isPlaying() || (progressBar = this.progressBar) == null) {
                return;
            }
            progressBar.setProgress(mediaPlayer.getCurrentPosition());
        } catch (IllegalStateException unused) {
        }
    }

    private final void startProgressTask() {
        long progressAnimationTick;
        synchronized (this) {
            IMediaPlayerConfigurer iMediaPlayerConfigurer = this.mediaPlayerConfigurer;
            if (iMediaPlayerConfigurer == null) {
                throw new IllegalStateException("MediaPlayerConfigurer required");
            }
            progressAnimationTick = iMediaPlayerConfigurer.getProgressAnimationTick();
        }
        final WeakReference weakReference = new WeakReference(this);
        Timer timer = new Timer("TutorialProgress", true);
        timer.schedule(new TimerTask() { // from class: com.myscript.nebo.videotutorial.TutorialSlideFragment$startProgressTask$lambda$1$$inlined$schedule$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                FragmentActivity activity;
                final TutorialSlideFragment tutorialSlideFragment = (TutorialSlideFragment) weakReference.get();
                if (tutorialSlideFragment == null || !tutorialSlideFragment.isAdded() || (activity = tutorialSlideFragment.getActivity()) == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.myscript.nebo.videotutorial.TutorialSlideFragment$startProgressTask$1$1$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        tutorialSlideFragment.updateProgress();
                    }
                });
            }
        }, 0L, progressAnimationTick);
        this.timer = timer;
    }

    private final void stopProgressTask() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* JADX INFO: compiled from: TutorialSlideFragment.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/videotutorial/TutorialSlideFragment$Companion;", "", "<init>", "()V", "TAG", "", TutorialSlideFragment.STEP_TITLE_RES, TutorialSlideFragment.STEP_BODY_RES, TutorialSlideFragment.STEP_VIDEO_RES, TutorialSlideFragment.STEP_VIDEO_ASPECT_RATIO_RES, "newInstance", "Lcom/myscript/nebo/videotutorial/TutorialSlideFragment;", "videoRes", "", "titleRes", "bodyRes", "videoAspectRatioRes", "video-tutorial_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TutorialSlideFragment newInstance(int videoRes, int titleRes, int bodyRes, int videoAspectRatioRes) {
            TutorialSlideFragment tutorialSlideFragment = new TutorialSlideFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(TutorialSlideFragment.STEP_VIDEO_RES, videoRes);
            bundle.putInt(TutorialSlideFragment.STEP_TITLE_RES, titleRes);
            bundle.putInt(TutorialSlideFragment.STEP_BODY_RES, bodyRes);
            bundle.putInt(TutorialSlideFragment.STEP_VIDEO_ASPECT_RATIO_RES, videoAspectRatioRes);
            tutorialSlideFragment.setArguments(bundle);
            return tutorialSlideFragment;
        }
    }
}
