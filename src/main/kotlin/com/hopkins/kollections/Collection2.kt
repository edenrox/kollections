package com.hopkins.kollections

/** Represents a collection of items. */
interface Collection2<T> : Iterable<T> {
    /** Add an item to the collection. */
    fun add(item: T)

    /** Add the specified items to the collection. */
    fun addAll(items: Collection2<T>)

    /** Remove all items from the collection */
    fun clear()

    /** Returns `true` if the item exists in this collection. */
    fun contains(item: Any?): Boolean

    //fun containsAll(items: Collection2<Any>): Boolean

    /** Returns `true` if the collection is empty. */
    fun isEmpty(): Boolean

    //fun remove(item: T): Boolean

    /** Returns the number of items in the collection. */
    fun size(): Int

    /** Returns a new array containing all of the items in the collection. */
    fun toArray(): Array<Any?>
}