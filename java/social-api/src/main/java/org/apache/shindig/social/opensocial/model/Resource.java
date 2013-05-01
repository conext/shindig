package org.apache.shindig.social.opensocial.model;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.inject.ImplementedBy;
import org.apache.shindig.protocol.model.Exportablebean;
import org.apache.shindig.social.core.model.ResourceImpl;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * Maciej Machulak (maciej.machulak@cloudidentity.co.uk)
 */
@ImplementedBy(ResourceImpl.class)
@Exportablebean
public interface Resource {

    public static enum Field {

        /**
         * Raw resource to be processed by the widget.
         */
        RESOURCE("resource");

        /**
         * A Map to convert JSON string to Field representations.
         */
        private static final Map<String,Field> LOOKUP = Maps.uniqueIndex(
                EnumSet.allOf(Field.class), Functions.toStringFunction());

        /**
         * The set of all fields.
         */
        public static final Set<String> ALL_FIELDS = LOOKUP.keySet();

        /**
         * The set of default fields returned fields.
         */
        public static final Set<String> DEFAULT_FIELDS = ImmutableSet.of(RESOURCE.toString());

        /**
         * The JSON field that the instance represents.
         */
        private final String jsonString;

        /**
         * Create a field base on the a JSON element.
         *
         * @param jsonString the name of the element
         */
        private Field(String jsonString) {
            this.jsonString = jsonString;
        }

        /**
         * Emit the field as a JSON element.
         *
         * @return the field name
         */
        @Override
        public String toString() {
            return this.jsonString;
        }

        /**
         * Converts from a url string (usually passed in the fields= parameter) into the
         * corresponding field enum.
         *
         * @param jsonString The string to translate.
         * @return The corresponding group field.
         */
        public static Resource.Field fromUrlString(String jsonString) {
            return LOOKUP.get(jsonString);
        }
    }

    String getResource();

    void setResource(String resource);

}
