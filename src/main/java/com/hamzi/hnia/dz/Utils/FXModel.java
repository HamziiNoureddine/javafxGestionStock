package com.hamzi.hnia.dz.Utils;

public abstract class FXModel<T> {

   public abstract T toEntity();
   public abstract  void fromEntity(T Entity);
}
