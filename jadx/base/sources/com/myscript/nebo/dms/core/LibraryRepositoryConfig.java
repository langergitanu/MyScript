package com.myscript.nebo.dms.core;

import androidx.media3.exoplayer.RendererCapabilities;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryRepositoryConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepositoryConfig;", "", "rootDirectory", "Ljava/io/File;", "workingDirectory", "databaseDirectory", "versionName", "", "neboExtension", "isFirstTime", "", "isAutoSyncEnabled", "autoSyncInterval", "", "isPageLevelSyncStateEnabled", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;ZZIZ)V", "getRootDirectory", "()Ljava/io/File;", "getWorkingDirectory", "getDatabaseDirectory", "getVersionName", "()Ljava/lang/String;", "getNeboExtension", "()Z", "getAutoSyncInterval", "()I", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LibraryRepositoryConfig {
    public static final int $stable = 8;
    private final int autoSyncInterval;
    private final File databaseDirectory;
    private final boolean isAutoSyncEnabled;
    private final boolean isFirstTime;
    private final boolean isPageLevelSyncStateEnabled;
    private final String neboExtension;
    private final File rootDirectory;
    private final String versionName;
    private final File workingDirectory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LibraryRepositoryConfig(File rootDirectory, File workingDirectory, File databaseDirectory, String versionName, String neboExtension, boolean z) {
        this(rootDirectory, workingDirectory, databaseDirectory, versionName, neboExtension, z, false, 0, false, 448, null);
        Intrinsics.checkNotNullParameter(rootDirectory, "rootDirectory");
        Intrinsics.checkNotNullParameter(workingDirectory, "workingDirectory");
        Intrinsics.checkNotNullParameter(databaseDirectory, "databaseDirectory");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(neboExtension, "neboExtension");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LibraryRepositoryConfig(File rootDirectory, File workingDirectory, File databaseDirectory, String versionName, String neboExtension, boolean z, boolean z2) {
        this(rootDirectory, workingDirectory, databaseDirectory, versionName, neboExtension, z, z2, 0, false, RendererCapabilities.DECODER_SUPPORT_MASK, null);
        Intrinsics.checkNotNullParameter(rootDirectory, "rootDirectory");
        Intrinsics.checkNotNullParameter(workingDirectory, "workingDirectory");
        Intrinsics.checkNotNullParameter(databaseDirectory, "databaseDirectory");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(neboExtension, "neboExtension");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LibraryRepositoryConfig(File rootDirectory, File workingDirectory, File databaseDirectory, String versionName, String neboExtension, boolean z, boolean z2, int i) {
        this(rootDirectory, workingDirectory, databaseDirectory, versionName, neboExtension, z, z2, i, false, 256, null);
        Intrinsics.checkNotNullParameter(rootDirectory, "rootDirectory");
        Intrinsics.checkNotNullParameter(workingDirectory, "workingDirectory");
        Intrinsics.checkNotNullParameter(databaseDirectory, "databaseDirectory");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(neboExtension, "neboExtension");
    }

    public LibraryRepositoryConfig(File rootDirectory, File workingDirectory, File databaseDirectory, String versionName, String neboExtension, boolean z, boolean z2, int i, boolean z3) {
        Intrinsics.checkNotNullParameter(rootDirectory, "rootDirectory");
        Intrinsics.checkNotNullParameter(workingDirectory, "workingDirectory");
        Intrinsics.checkNotNullParameter(databaseDirectory, "databaseDirectory");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(neboExtension, "neboExtension");
        this.rootDirectory = rootDirectory;
        this.workingDirectory = workingDirectory;
        this.databaseDirectory = databaseDirectory;
        this.versionName = versionName;
        this.neboExtension = neboExtension;
        this.isFirstTime = z;
        this.isAutoSyncEnabled = z2;
        this.autoSyncInterval = i;
        this.isPageLevelSyncStateEnabled = z3;
    }

    public /* synthetic */ LibraryRepositoryConfig(File file, File file2, File file3, String str, String str2, boolean z, boolean z2, int i, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, file2, file3, str, str2, z, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? false : z3);
    }

    public final File getRootDirectory() {
        return this.rootDirectory;
    }

    public final File getWorkingDirectory() {
        return this.workingDirectory;
    }

    public final File getDatabaseDirectory() {
        return this.databaseDirectory;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getNeboExtension() {
        return this.neboExtension;
    }

    /* JADX INFO: renamed from: isFirstTime, reason: from getter */
    public final boolean getIsFirstTime() {
        return this.isFirstTime;
    }

    /* JADX INFO: renamed from: isAutoSyncEnabled, reason: from getter */
    public final boolean getIsAutoSyncEnabled() {
        return this.isAutoSyncEnabled;
    }

    public final int getAutoSyncInterval() {
        return this.autoSyncInterval;
    }

    /* JADX INFO: renamed from: isPageLevelSyncStateEnabled, reason: from getter */
    public final boolean getIsPageLevelSyncStateEnabled() {
        return this.isPageLevelSyncStateEnabled;
    }
}
