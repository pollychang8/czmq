################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
import utils
from . import destructors
libczmq_destructors = destructors.lib

class Zlist(object):
    """
    simple generic list container
    """

    def __init__(self):
        """
        Create a new list container
        """
        p = utils.lib.zlist_new()
        if p == utils.ffi.NULL:
            raise MemoryError("Could not allocate person")

        # ffi.gc returns a copy of the cdata object which will have the
        # destructor called when the Python object is GC'd:
        # https://cffi.readthedocs.org/en/latest/using.html#ffi-interface
        self._p = utils.ffi.gc(p, libczmq_destructors.zlist_destroy_py)

    def first(self):
        """
        Return the item at the head of list. If the list is empty, returns NULL.
        Leaves cursor pointing at the head item, or NULL if the list is empty.
        """
        return utils.lib.zlist_first(self._p)

    def next(self):
        """
        Return the next item. If the list is empty, returns NULL. To move to
        the start of the list call zlist_first (). Advances the cursor.
        """
        return utils.lib.zlist_next(self._p)

    def last(self):
        """
        Return the item at the tail of list. If the list is empty, returns NULL.
        Leaves cursor pointing at the tail item, or NULL if the list is empty.
        """
        return utils.lib.zlist_last(self._p)

    def head(self):
        """
        Return first item in the list, or null, leaves the cursor
        """
        return utils.lib.zlist_head(self._p)

    def tail(self):
        """
        Return last item in the list, or null, leaves the cursor
        """
        return utils.lib.zlist_tail(self._p)

    def item(self):
        """
        Return the current item of list. If the list is empty, returns NULL.
        Leaves cursor pointing at the current item, or NULL if the list is empty.
        """
        return utils.lib.zlist_item(self._p)

    def append(self, item):
        """
        Append an item to the end of the list, return 0 if OK or -1 if this
        failed for some reason (out of memory). Note that if a duplicator has
        been set, this method will also duplicate the item.
        """
        return utils.lib.zlist_append(self._p, item._p)

    def push(self, item):
        """
        Push an item to the start of the list, return 0 if OK or -1 if this
        failed for some reason (out of memory). Note that if a duplicator has
        been set, this method will also duplicate the item.
        """
        return utils.lib.zlist_push(self._p, item._p)

    def pop(self):
        """
        Pop the item off the start of the list, if any
        """
        return utils.lib.zlist_pop(self._p)

    def exists(self, item):
        """
        Checks if an item already is present. Uses compare method to determine if
        items are equal. If the compare method is NULL the check will only compare
        pointers. Returns true if item is present else false.
        """
        return utils.lib.zlist_exists(self._p, item._p)

    def remove(self, item):
        """
        Remove the specified item from the list if present
        """
        return utils.lib.zlist_remove(self._p, item._p)

    def dup(self):
        """
        Make a copy of list. If the list has autofree set, the copied list will
        duplicate all items, which must be strings. Otherwise, the list will hold
        pointers back to the items in the original list. If list is null, returns
        NULL.
        """
        return utils.lib.zlist_dup(self._p)

    def purge(self):
        """
        Purge all items from list
        """
        return utils.lib.zlist_purge(self._p)

    def size(self):
        """
        Return number of items in the list
        """
        return utils.lib.zlist_size(self._p)

    def sort(self, compare):
        """
        Sort the list. If the compare function is null, sorts the list by
        ascending key value using a straight ASCII comparison. If you specify
        a compare function, this decides how items are sorted. The sort is not
        stable, so may reorder items with the same keys. The algorithm used is
        combsort, a compromise between performance and simplicity.
        """
        return utils.lib.zlist_sort(self._p, compare)

    def autofree(self):
        """
        Set list for automatic item destruction; item values MUST be strings.
        By default a list item refers to a value held elsewhere. When you set
        this, each time you append or push a list item, zlist will take a copy
        of the string value. Then, when you destroy the list, it will free all
        item values automatically. If you use any other technique to allocate
        list values, you must free them explicitly before destroying the list.
        The usual technique is to pop list items and destroy them, until the
        list is empty.
        """
        return utils.lib.zlist_autofree(self._p)

    def comparefn(self, fn):
        """
        Sets a compare function for this list. The function compares two items.
        It returns an integer less than, equal to, or greater than zero if the
        first item is found, respectively, to be less than, to match, or be
        greater than the second item.
        This function is used for sorting, removal and exists checking.
        """
        return utils.lib.zlist_comparefn(self._p, fn)

    def freefn(self, item, fn, at_tail):
        """
        Set a free function for the specified list item. When the item is
        destroyed, the free function, if any, is called on that item.
        Use this when list items are dynamically allocated, to ensure that
        you don't have memory leaks. You can pass 'free' or NULL as a free_fn.
        Returns the item, or NULL if there is no such item.
        """
        return utils.lib.zlist_freefn(self._p, item._p, fn, at_tail)

    def test(verbose):
        """
        Self test of this class.
        """
        return utils.lib.zlist_test(verbose)

################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
