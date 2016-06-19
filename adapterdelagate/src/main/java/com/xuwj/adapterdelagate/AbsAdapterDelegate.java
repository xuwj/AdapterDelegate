package com.xuwj.adapterdelagate;


public abstract class AbsAdapterDelegate<T> implements AdapterDelegate<T> {

  protected int viewType;

  public AbsAdapterDelegate(int viewType) {
    this.viewType = viewType;
  }

  @Override public int getItemViewType() {
    return viewType;
  }
}
