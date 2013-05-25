/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.googlecode.objectify.Ref;
import com.verophyle.core.server.domain.CoreEntity;

public final class Functional {

  public static <T> List<T> deref(List<Ref<T>> list) {
    return Lists.transform(list, new Function<Ref<T>, T>() {
      @Override
      public T apply(Ref<T> ref) {
        return ref == null ? null : ref.get();
      }
    });
  }
  
  public static <T extends CoreEntity> List<Ref<T>> toref(List<T> list) {
    return Lists.transform(list, new Function<T, Ref<T>>() {
      @Override
      public Ref<T> apply(T item) {
        if (item != null) {
          Ref<T> ref = Ref.create(item);
          return ref;
        } else {
          return null;
        }
      }
    });
  }
  
}
