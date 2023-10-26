package com.yuriybishel.addressresolver.util;

import com.yuriybishel.addressresolver.model.Address;
import com.yuriybishel.addressresolver.model.Addresses;
import com.yuriybishel.addressresolver.model.Hierarchies;
import com.yuriybishel.addressresolver.model.Hierarchy;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlUtils {
    public static List<Address> readAddressesFromFile(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Addresses.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        File file = new File(filePath);
        Addresses addresses = (Addresses) unmarshaller.unmarshal(file);

        return addresses.getAddressList();
    }

    public static List<Hierarchy> readHierarchiesFromFile(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Hierarchies.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        File file = new File(filePath);
        Hierarchies hierarchies = (Hierarchies) unmarshaller.unmarshal(file);

        return hierarchies.getHierarchyList();
    }
}
