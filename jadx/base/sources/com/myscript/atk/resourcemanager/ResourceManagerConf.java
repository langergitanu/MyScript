package com.myscript.atk.resourcemanager;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResourceManagerConf.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/atk/resourcemanager/ResourceManagerConf;", "", "repoName", "", "assetsPath", "localFolderName", "remoteUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRepoName", "()Ljava/lang/String;", "getAssetsPath", "getLocalFolderName", "getRemoteUri", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "resourcemanager-lib_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ResourceManagerConf {
    private final String assetsPath;
    private final String localFolderName;
    private final String remoteUri;
    private final String repoName;

    public ResourceManagerConf() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResourceManagerConf copy$default(ResourceManagerConf resourceManagerConf, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resourceManagerConf.repoName;
        }
        if ((i & 2) != 0) {
            str2 = resourceManagerConf.assetsPath;
        }
        if ((i & 4) != 0) {
            str3 = resourceManagerConf.localFolderName;
        }
        if ((i & 8) != 0) {
            str4 = resourceManagerConf.remoteUri;
        }
        return resourceManagerConf.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRepoName() {
        return this.repoName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAssetsPath() {
        return this.assetsPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLocalFolderName() {
        return this.localFolderName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRemoteUri() {
        return this.remoteUri;
    }

    public final ResourceManagerConf copy(String repoName, String assetsPath, String localFolderName, String remoteUri) {
        Intrinsics.checkNotNullParameter(repoName, "repoName");
        Intrinsics.checkNotNullParameter(assetsPath, "assetsPath");
        Intrinsics.checkNotNullParameter(localFolderName, "localFolderName");
        Intrinsics.checkNotNullParameter(remoteUri, "remoteUri");
        return new ResourceManagerConf(repoName, assetsPath, localFolderName, remoteUri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResourceManagerConf)) {
            return false;
        }
        ResourceManagerConf resourceManagerConf = (ResourceManagerConf) other;
        return Intrinsics.areEqual(this.repoName, resourceManagerConf.repoName) && Intrinsics.areEqual(this.assetsPath, resourceManagerConf.assetsPath) && Intrinsics.areEqual(this.localFolderName, resourceManagerConf.localFolderName) && Intrinsics.areEqual(this.remoteUri, resourceManagerConf.remoteUri);
    }

    public int hashCode() {
        return (((((this.repoName.hashCode() * 31) + this.assetsPath.hashCode()) * 31) + this.localFolderName.hashCode()) * 31) + this.remoteUri.hashCode();
    }

    public String toString() {
        return "ResourceManagerConf(repoName=" + this.repoName + ", assetsPath=" + this.assetsPath + ", localFolderName=" + this.localFolderName + ", remoteUri=" + this.remoteUri + ")";
    }

    public ResourceManagerConf(String repoName, String assetsPath, String localFolderName, String remoteUri) {
        Intrinsics.checkNotNullParameter(repoName, "repoName");
        Intrinsics.checkNotNullParameter(assetsPath, "assetsPath");
        Intrinsics.checkNotNullParameter(localFolderName, "localFolderName");
        Intrinsics.checkNotNullParameter(remoteUri, "remoteUri");
        this.repoName = repoName;
        this.assetsPath = assetsPath;
        this.localFolderName = localFolderName;
        this.remoteUri = remoteUri;
    }

    public /* synthetic */ ResourceManagerConf(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "VODB" : str, (i & 2) != 0 ? "VODB" : str2, (i & 4) != 0 ? "VODB" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getRepoName() {
        return this.repoName;
    }

    public final String getAssetsPath() {
        return this.assetsPath;
    }

    public final String getLocalFolderName() {
        return this.localFolderName;
    }

    public final String getRemoteUri() {
        return this.remoteUri;
    }
}
