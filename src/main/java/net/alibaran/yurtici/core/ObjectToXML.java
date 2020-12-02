package net.alibaran.yurtici.core;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ObjectToXML {
    public static String jaxbObjectToXML(Object obj)
    {
        String result = "";
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(obj, sw);

            result = sw.toString();

            result = result.replace("<request>", "").replace("</request>", "")
                    .replace("<auth>", "").replace("</auth>", "");

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return result.trim();

    }
}



