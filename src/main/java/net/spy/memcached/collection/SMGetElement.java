/*
 * arcus-java-client : Arcus Java client
 * Copyright 2010-2014 NAVER Corp.
 * Copyright 2014-2022 JaM2in Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.spy.memcached.collection;

public class SMGetElement<T> implements Comparable<SMGetElement<T>> {

  private String key;
  private BKeyObject bKeyObject;
  private T value;

  public SMGetElement(String key, long bkey, T value) {
    this.key = key;
    this.bKeyObject = new BKeyObject(bkey);
    this.value = value;
  }

  public SMGetElement(String key, byte[] bkey, T value) {
    this.key = key;
    this.bKeyObject = new BKeyObject(bkey);
    this.value = value;
  }

  @Override
  public String toString() {
    return "SMGetElement {KEY:" + key + ", BKEY:" + bKeyObject + ", VALUE:" + value + "}";
  }

  @Override
  public int compareTo(SMGetElement<T> param) {
    assert param != null;

    /* compare bkey */
    int comp = bKeyObject.compareTo(param.bKeyObject);

    /* if bkey is equal, then compare key */
    if (comp == 0) {
      comp = key.compareTo(param.getKey());
    }

    return comp;
  }

  public int compareBkeyTo(SMGetElement<T> param) {
    assert param != null;

    /* compare bkey */
    return bKeyObject.compareTo(param.bKeyObject);
  }

  public int compareKeyTo(SMGetElement<T> param) {
    assert param != null;

    /* compare key */
    return key.compareTo(param.getKey());
  }

  public String getKey() {
    return key;
  }

  public long getBkey() {
    return bKeyObject.getLongBKey();
  }

  public byte[] getByteBkey() {
    return bKeyObject.getByteArrayBKeyRaw();
  }

  public BKeyObject getBkeyObject() {
    return bKeyObject;
  }

  public T getValue() {
    return value;
  }
}
