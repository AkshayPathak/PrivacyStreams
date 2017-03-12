package com.github.privacystreams.core.transformations.group;

import com.github.privacystreams.core.Function;
import com.github.privacystreams.core.MultiItemStream;
import com.github.privacystreams.utils.annotations.PSOperatorWrapper;

/**
 * A helper class to access grouping functions
 */
@PSOperatorWrapper
public class Groupers {

    /**
     * A function that groups together the items with same field value.
     * This function will change the order of items.
     * The stream after grouping is a stream of "group items", which has two fields:
     *   ItemField 1. The field name is @param fieldToGroup, and the value is the field value
     *   ItemField 2. The field name is "group_items", and the value is the grouped items
     * You can use setGroupField value to produce more fields.
     *
     * @param fieldToGroup the field used to group the stream.
     * @return the stream-grouping function.
     */
    public static Function<MultiItemStream, MultiItemStream> groupBy(String fieldToGroup) {
        return new ByFieldGrouper(fieldToGroup);
    }

    /**
     * A function that groups together the contiguous items with same field value.
     * This function will not change the order of items.
     * The stream after grouping is a stream of "group items", which has two fields:
     *   ItemField 1. The field name is @param fieldToGroup, and the value is the field value
     *   ItemField 2. The field name is "group_items", and the value is the grouped items
     * You can use setGroupField value to produce more fields.
     *
     * @param fieldToGroup the field used to group the stream.
     * @return the stream-grouping function.
     */
    public static Function<MultiItemStream, MultiItemStream> localGroupBy(String fieldToGroup) {
        return new ByFieldLocalGrouper(fieldToGroup);
    }

}
