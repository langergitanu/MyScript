package com.myscript.nebo.dms.core;

import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.snt.core.NotebookKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CollectionItemsHelper {
    public static final int CHILD_POSITION_INDEX = 1;
    public static final int INFO_POSITION_COUNT = 2;
    public static final int PARENT_POSITION_INDEX = 0;
    public static final int POSITION_WHERE_ADD_HAPPENED = 0;
    public static final int POSITION_WHERE_DELETE_HAPPENED = 1;
    public static final int POSITION_WHERE_UPDATE_HAPPENED = 2;

    public static int[] getChildPosition(List<CollectionModel> list, NotebookKey notebookKey) {
        int[] iArr = new int[2];
        if (notebookKey == null) {
            iArr[0] = -1;
            iArr[1] = -1;
            return iArr;
        }
        Iterator<CollectionModel> it = list.iterator();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Iterator<FolderModel> it2 = it.next().getChildList().iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                if (notebookKey.equals(it2.next().getNotebookKey())) {
                    z = true;
                }
                if (z) {
                    break;
                }
                i3++;
            }
            if (z) {
                i2 = i3;
                break;
            }
            i++;
            i2 = i3;
        }
        if (z) {
            iArr[0] = i;
            iArr[1] = i2;
            return iArr;
        }
        iArr[0] = -1;
        iArr[1] = -1;
        return iArr;
    }

    public static ArrayList<int[]>[] deleteNotebook(List<CollectionModel> list, NotebookKey notebookKey) {
        ArrayList<int[]>[] arrayListArr = new ArrayList[3];
        ArrayList<int[]> arrayList = new ArrayList<>();
        ArrayList<int[]> arrayList2 = new ArrayList<>();
        ArrayList<int[]> arrayList3 = new ArrayList<>();
        int[] childPosition = getChildPosition(list, notebookKey);
        FolderModel folderModel = null;
        CollectionModel collectionModel = null;
        for (CollectionModel collectionModel2 : list) {
            Iterator<FolderModel> it = collectionModel2.getChildList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FolderModel next = it.next();
                if (next.getNotebookKey().equals(notebookKey)) {
                    collectionModel = collectionModel2;
                    folderModel = next;
                    break;
                }
            }
            if (folderModel != null) {
                break;
            }
        }
        if (collectionModel != null) {
            collectionModel.removeFolderItem(folderModel);
            if (collectionModel.isEmpty()) {
                arrayList2.add(new int[]{childPosition[0], 0});
            } else {
                arrayList2.add(new int[]{childPosition[0], childPosition[1]});
            }
        }
        arrayListArr[2] = arrayList3;
        arrayListArr[1] = arrayList2;
        arrayListArr[0] = arrayList;
        return arrayListArr;
    }
}
