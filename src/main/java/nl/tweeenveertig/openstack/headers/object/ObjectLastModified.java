package nl.tweeenveertig.openstack.headers.object;

import nl.tweeenveertig.openstack.command.core.CommandException;
import nl.tweeenveertig.openstack.headers.DateHeader;
import nl.tweeenveertig.openstack.headers.SimpleHeader;
import org.apache.http.HttpResponse;
import org.apache.http.impl.cookie.DateParseException;

import java.util.Date;

public class ObjectLastModified extends DateHeader {

    public static final String LAST_MODIFIED = "Last-Modified";

    public ObjectLastModified(String value) throws DateParseException {
        super(value);
    }

    public ObjectLastModified(Date value) {
        super(value);
    }

    @Override
    public String getHeaderValue() {
        return convertDateToString(getDate());
    }

    @Override
    public String getHeaderName() {
        return LAST_MODIFIED;
    }

    public static ObjectLastModified fromResponse(HttpResponse response) {
        try {
            return new ObjectLastModified(convertResponseHeader(response, LAST_MODIFIED));
        } catch (DateParseException e) {
            throw new CommandException("Unable to convert date string");
        }
    }
}
