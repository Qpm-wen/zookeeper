/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zookeeper.server.util;

public class ZxidUtils {

    /**
     *
     * ZXID : 64bit
     * |--- 32bit 任期 ---|-- 32bit 事务计数器 --|
     */

    /**
     * 从 ZxId 获取 任期数
     * @param zxid
     * @return
     */
    public static long getEpochFromZxid(long zxid) {
        return zxid >> 32L;
    }

    /**
     * 从 ZXID 获取 计数值
     * @param zxid
     * @return
     */
    public static long getCounterFromZxid(long zxid) {
        return zxid & 0xffffffffL;
    }

    /**
     * 输入 epoch 和 counter ， 组合获得一个 long 类型的 ZXID
     * @param epoch
     * @param counter
     * @return
     */
    public static long makeZxid(long epoch, long counter) {
        return (epoch << 32L) | (counter & 0xffffffffL);
    }
    public static String zxidToString(long zxid) {
        return Long.toHexString(zxid);
    }

}
