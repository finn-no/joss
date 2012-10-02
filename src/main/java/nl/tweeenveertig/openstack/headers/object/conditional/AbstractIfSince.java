package nl.tweeenveertig.openstack.headers.object.conditional;

import nl.tweeenveertig.openstack.headers.DateHeader;
import org.apache.http.impl.cookie.DateParseException;

import java.util.Date;

public abstract class AbstractIfSince extends DateHeader {

    public AbstractIfSince(String sinceDate) throws DateParseException {
        super(sinceDate);
    }

    public AbstractIfSince(Date sinceDate) {
        super(sinceDate);
    }

    public Date getSinceDate() {
        return getDate();
    }

    /**
    * Makes a check against the sinceDate and throws an exception (with the proper HTTP status code) if the value
    * means no content should be returned.
    * @param modificationDate the value to match against
    */
    public abstract void sinceAgainst(Date modificationDate);

    @Override
    public String getHeaderValue() {
        return convertDateToString(getSinceDate());
    }

}
