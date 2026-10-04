package com.myscript.nebo.dms.cloud.common.utils;

import com.myscript.snt.dms.CloudFile;
import com.myscript.snt.dms.CloudFileData;
import com.myscript.snt.dms.ICloudDriveInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudDriveInterfaceExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001av\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2>\u0010\u000b\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\r\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\r\u0012\b\b\b\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f¨\u0006\u0010"}, m1599d2 = {"checkAlreadyExists", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/myscript/snt/dms/ICloudDriveInterface;", "actionId", "", "parent", "Lcom/myscript/snt/dms/CloudFile;", "name", "throwAutomatically", "", "list", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "", "Lcom/myscript/snt/dms/CloudFileData;", "dms-cloud-common_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CloudDriveInterfaceExtKt {
    public static /* synthetic */ Exception checkAlreadyExists$default(ICloudDriveInterface iCloudDriveInterface, String str, CloudFile cloudFile, String str2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return checkAlreadyExists(iCloudDriveInterface, str, cloudFile, str2, z, function2);
    }

    public static final Exception checkAlreadyExists(ICloudDriveInterface iCloudDriveInterface, String str, CloudFile parent, String name, boolean z, Function2<? super String, ? super CloudFile, ? extends List<? extends CloudFileData>> list) throws Exception {
        IllegalStateException illegalStateException;
        Intrinsics.checkNotNullParameter(iCloudDriveInterface, "<this>");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "list");
        try {
            List<? extends CloudFileData> listInvoke = list.invoke(str, parent);
            if (!(listInvoke instanceof Collection) || !listInvoke.isEmpty()) {
                Iterator<T> it = listInvoke.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((CloudFileData) it.next()).name(), name)) {
                        illegalStateException = new IllegalStateException(name + " already exists in folder " + parent.getId());
                        break;
                    }
                }
            }
            illegalStateException = null;
            e = illegalStateException;
        } catch (Exception e) {
            e = e;
        }
        if (!z || e == null) {
            return e;
        }
        throw e;
    }
}
