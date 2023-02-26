package com.hopkins.kollections

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class ArrayList2Test {

    @Test
    fun contains_withEmpty_returnsFalse() {
        val list = ArrayList2<String>()

        assertFalse(list.contains("test"))
    }

    @Test
    fun contains_whenContains_returnsTrue() {
        val list = ArrayList2<String>("anna", "cheryl", "bob")

        assertFalse(list.contains("test"))
        assertTrue(list.contains("cheryl"))
    }

    @Test
    fun set_returnsOldValue() {
        val list = ArrayList2<String>("anna", "cheryl", "bob")
        
        assertEquals("cheryl", list.set(1, "other"))
    }

    @Test
    fun get_afterSet_returnsNewValue() {
        val list = ArrayList2<String>("anna", "cheryl", "bob")
        list[1] = "boomer"

        assertEquals("boomer", list[1])
    }
    
    @Test
    fun size_withNew_returnsZero() {
        val list = ArrayList2<String>()

        assertEquals(0, list.size())
    }

    @Test
    fun size_afterAdd_returnsNumAdded() {
        val list = ArrayList2<String>()
        list.add("test")
        list.add("test2")

        assertEquals(2, list.size())
    }

    @Test
    fun size_afterClear_returnsZero() {
        val list = ArrayList2<String>()
        list.add("test")
        list.add("test2")
        list.clear()
        
        assertEquals(0, list.size())
    }

    @Test
    fun toArray_withEmptyList_returnsEmptyArray() {
        val list = ArrayList2<String>()

        assertTrue(list.toArray() contentEquals emptyArray<String>())
    }

    @Test
    fun toArray_withNonEmptyList_returnsExpectedArray() {
        val list = ArrayList2<String>()
        list.add("a")
        list.add("b")
        list.add("c")

        assertTrue(list.toArray() contentEquals arrayOf("a", "b", "c"))
    }
}