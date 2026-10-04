package com.myscript.atk.resourcemanager.internal.manager;

import android.content.res.AssetManager;
import com.myscript.android.utils.AssetManagerExt;
import com.myscript.atk.resourcemanager.internal.Constants;
import com.myscript.atk.resourcemanager.utils.Version;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AssetsLanguagesManager {
    private final AssetManager mAssets;
    private final RepositoryManager mRepositoryManager;
    private final Map<String, Version> mRemoveLanguages = new HashMap();
    private Version currentVer = null;

    public AssetsLanguagesManager(AssetManager assetManager, RepositoryManager repositoryManager) {
        this.mAssets = assetManager;
        this.mRepositoryManager = repositoryManager;
    }

    public void copyAssets(String str, File file, Map<String, Version> map) throws IOException {
        this.mRemoveLanguages.clear();
        this.currentVer = null;
        copyAssetsFolder(str, file, map, true);
    }

    private void copyAssetsFolder(String str, File file, Map<String, Version> map, boolean z) throws IOException {
        Version version;
        Version version2;
        file.mkdirs();
        file.setReadable(true, false);
        file.setWritable(true);
        file.setExecutable(true, false);
        ArrayList<String> arrayList = new ArrayList(Arrays.asList(this.mAssets.list(str)));
        Collections.sort(arrayList);
        for (String str2 : arrayList) {
            String str3 = str + File.separator + str2;
            if (this.mAssets.list(str3).length > 0) {
                if (z) {
                    this.currentVer = new Version(str2);
                } else {
                    Version version3 = this.mRemoveLanguages.get(str2);
                    if (version3 != null && (version = this.currentVer) != null && version.compareTo(version3) == 0) {
                        this.mRemoveLanguages.remove(str2);
                    }
                }
                copyAssetsFolder(str3, new File(file, str2), map, false);
            } else {
                File file2 = new File(file, str2);
                if (file2.isFile()) {
                    file2.delete();
                } else if (str2.endsWith(Constants.CONF_FILENAME_EXT)) {
                    String[] strArrSplit = str2.split("\\.");
                    Version version4 = map != null ? map.get(strArrSplit[0]) : null;
                    if (version4 != null && (version2 = this.currentVer) != null) {
                        if (version2.compareTo(version4) >= 0) {
                            this.mRepositoryManager.remove(strArrSplit[0], version4);
                        } else {
                            this.mRemoveLanguages.put(strArrSplit[0], this.currentVer);
                        }
                    }
                }
                File file3 = new File(file, str2);
                AssetManagerExt.copyAsset(this.mAssets, str3, file3);
                file3.setReadable(true, false);
                file3.setWritable(true);
                file3.setExecutable(true, false);
            }
        }
    }
}
