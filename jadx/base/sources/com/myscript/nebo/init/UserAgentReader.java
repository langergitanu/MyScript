package com.myscript.nebo.init;

import android.app.Application;
import android.os.Build;
import androidx.media3.common.MimeTypes;
import com.myscript.nebo.dms.util.UserAgent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UserAgentReader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/init/UserAgentReader;", "Lcom/myscript/nebo/dms/util/UserAgent;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "description", "", "getDescription", "()Ljava/lang/String;", "description$delegate", "Lkotlin/Lazy;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserAgentReader implements UserAgent {
    private static final String UNKNOWN_ANDROID_VERSION = "Unknown Android version";
    private static final String USER_AGENT_FILE = "user_agent.txt";
    private final Application application;

    /* JADX INFO: renamed from: description$delegate, reason: from kotlin metadata */
    private final Lazy description;
    public static final int $stable = 8;

    public UserAgentReader(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.description = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.init.UserAgentReader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UserAgentReader.description_delegate$lambda$0(this.f$0);
            }
        });
    }

    @Override // com.myscript.nebo.dms.util.UserAgent
    public String getDescription() {
        return (String) this.description.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String description_delegate$lambda$0(UserAgentReader userAgentReader) {
        String string;
        String strReplace$default;
        try {
            InputStream inputStreamOpen = userAgentReader.application.getAssets().open(USER_AGENT_FILE);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String line = bufferedReader.readLine();
                String str = UNKNOWN_ANDROID_VERSION;
                if (line != null && (string = StringsKt.trim((CharSequence) line).toString()) != null) {
                    if (StringsKt.contains$default((CharSequence) string, (CharSequence) "PLATFORM_INFO", false, 2, (Object) null)) {
                        String name = Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
                        String property = Build.CPU_ABI;
                        if (property.length() <= 0) {
                            property = null;
                        }
                        if (property == null) {
                            String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
                            Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
                            property = (String) ArraysKt.firstOrNull(SUPPORTED_ABIS);
                            if (property == null && (property = System.getProperty("os.arch")) == null) {
                                property = "unknown";
                            }
                        }
                        strReplace$default = StringsKt.replace$default(string, "PLATFORM_INFO", "Android " + name + "(" + Build.VERSION.SDK_INT + "); " + property, false, 4, (Object) null);
                    } else {
                        strReplace$default = UNKNOWN_ANDROID_VERSION;
                    }
                    if (strReplace$default != null) {
                        str = strReplace$default;
                    }
                }
                CloseableKt.closeFinally(bufferedReader, null);
                return str;
            } finally {
            }
        } catch (Exception e) {
            throw new IllegalStateException("Unable to retrieve user agent: " + e.getMessage(), e);
        }
    }
}
