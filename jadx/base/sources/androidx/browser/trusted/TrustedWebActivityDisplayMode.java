package androidx.browser.trusted;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface TrustedWebActivityDisplayMode {
    public static final String KEY_ID = "androidx.browser.trusted.displaymode.KEY_ID";

    Bundle toBundle();

    static TrustedWebActivityDisplayMode fromBundle(Bundle bundle) {
        int i = bundle.getInt(KEY_ID);
        if (i == 1) {
            return ImmersiveMode.fromBundle(bundle);
        }
        if (i == 2) {
            return new BrowserMode();
        }
        if (i == 3) {
            return new MinimalUiMode();
        }
        if (i == 4) {
            return new TabbedMode();
        }
        if (i == 5) {
            return new WindowControlsOverlayMode();
        }
        return new DefaultMode();
    }

    public static class DefaultMode implements TrustedWebActivityDisplayMode {

        /* JADX INFO: renamed from: ID */
        private static final int f19ID = 0;

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 0);
            return bundle;
        }
    }

    public static class ImmersiveMode implements TrustedWebActivityDisplayMode {

        /* JADX INFO: renamed from: ID */
        private static final int f20ID = 1;
        public static final String KEY_CUTOUT_MODE = "androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE";
        public static final String KEY_STICKY = "androidx.browser.trusted.displaymode.KEY_STICKY";
        private final boolean mIsSticky;
        private final int mLayoutInDisplayCutoutMode;

        public ImmersiveMode(boolean z, int i) {
            this.mIsSticky = z;
            this.mLayoutInDisplayCutoutMode = i;
        }

        static TrustedWebActivityDisplayMode fromBundle(Bundle bundle) {
            return new ImmersiveMode(bundle.getBoolean(KEY_STICKY), bundle.getInt(KEY_CUTOUT_MODE));
        }

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 1);
            bundle.putBoolean(KEY_STICKY, this.mIsSticky);
            bundle.putInt(KEY_CUTOUT_MODE, this.mLayoutInDisplayCutoutMode);
            return bundle;
        }

        public boolean isSticky() {
            return this.mIsSticky;
        }

        public int layoutInDisplayCutoutMode() {
            return this.mLayoutInDisplayCutoutMode;
        }
    }

    public static class BrowserMode implements TrustedWebActivityDisplayMode {

        /* JADX INFO: renamed from: ID */
        private static final int f18ID = 2;

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 2);
            return bundle;
        }
    }

    public static class MinimalUiMode implements TrustedWebActivityDisplayMode {

        /* JADX INFO: renamed from: ID */
        private static final int f21ID = 3;

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 3);
            return bundle;
        }
    }

    public static final class TabbedMode implements TrustedWebActivityDisplayMode {

        /* JADX INFO: renamed from: ID */
        private static final int f22ID = 4;

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 4);
            return bundle;
        }
    }

    public static final class WindowControlsOverlayMode implements TrustedWebActivityDisplayMode {

        /* JADX INFO: renamed from: ID */
        private static final int f23ID = 5;

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 5);
            return bundle;
        }
    }
}
