package androidx.window;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowSdkExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m1599d2 = {"Landroidx/window/EmptyDecoratorWindowSdk;", "Landroidx/window/WindowSdkExtensionsDecorator;", "<init>", "()V", "decorate", "Landroidx/window/WindowSdkExtensions;", "windowSdkExtensions", "window_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
final class EmptyDecoratorWindowSdk implements WindowSdkExtensionsDecorator {
    public static final EmptyDecoratorWindowSdk INSTANCE = new EmptyDecoratorWindowSdk();

    @Override // androidx.window.WindowSdkExtensionsDecorator
    public WindowSdkExtensions decorate(WindowSdkExtensions windowSdkExtensions) {
        Intrinsics.checkNotNullParameter(windowSdkExtensions, "windowSdkExtensions");
        return windowSdkExtensions;
    }

    private EmptyDecoratorWindowSdk() {
    }
}
