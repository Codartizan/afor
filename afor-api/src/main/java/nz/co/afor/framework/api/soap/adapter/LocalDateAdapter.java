package nz.co.afor.framework.api.soap.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Created by belcherm on 16/06/2017.
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        if (v != null) {
            return v.toString();
        } else {
            return null;
        }
    }
}