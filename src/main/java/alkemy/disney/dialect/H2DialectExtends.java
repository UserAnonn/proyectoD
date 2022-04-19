package alkemy.disney.dialect;

import org.hibernate.dialect.H2Dialect;

public class H2DialectExtends extends H2Dialect {

    @Override
    public String toBooleanValueString(boolean bool) {
        return bool ? "TRUE" : "FALSE";
    }
}