/*
 * Copyright (c) 2014-2016 Jikopster Orglobster.
 *
 * This file is part of Jikopster vk a sync
 *
 * Jikopster vk a sync is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikopster vk a sync is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikopster vk a sync.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.jikopster.vkasync.misc;

public class Lambda
{
    public interface Action {
        void invoke();
    }

    public interface Action1<T> {
        void invoke(T arg);
    }

    public interface Action2<T1, T2> {
        void invoke(T1 arg1, T2 arg2);
    }

    public interface Function<TOut> {
        TOut invoke();
    }

    public interface Function1<TIn, TOut> {
        TOut invoke(TIn arg);
    }

    public interface Function2<T1, T2, TOut> {
        TOut invoke(T1 arg1, T2 arg2);
    }
}
