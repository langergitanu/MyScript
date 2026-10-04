package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public interface ISearchListener {
    void newSearchMatch(SearchMatch searchMatch);

    void onFirstSearchResultInCollection(CollectionKey collectionKey);

    void onFirstSearchResultInDocument(NotebookKey notebookKey);

    void onTitleMatch(PageKey pageKey);

    void searchEnded(int i);

    void searchEndedCollection(CollectionKey collectionKey, int i);

    void searchEndedDocument(NotebookKey notebookKey, int i);

    void searchEndedPage(PageKey pageKey, int i);

    void searchInterrupted();

    void searchStarted(String str);

    void searchStartedCollection(CollectionKey collectionKey);

    void searchStartedDocument(NotebookKey notebookKey);

    void searchStartedPage(PageKey pageKey);
}
