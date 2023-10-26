package com.yuriybishel.addressresolver.service;

import com.yuriybishel.addressresolver.model.Address;
import com.yuriybishel.addressresolver.model.Hierarchy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressService {
    private final List<Address> addresses;
    private final List<Hierarchy> hierarchies;


    public AddressService(List<Address> addresses, List<Hierarchy> hierarchies) {
        this.addresses = addresses;
        this.hierarchies = hierarchies;
    }

    public void describeAddresses(LocalDate date, List<Integer> objectIds) {
        for (Integer objectId : objectIds) {
            for (Address address : addresses) {
                if (address.getObjectId() == objectId &&
                        (address.getStartDate() == null || !date.isBefore(address.getStartDate())) &&
                        (address.getEndDate() == null || !date.isAfter(address.getEndDate()))) {
                    System.out.println(objectId + ": " + address.getTypeName() + " " + address.getName());
                }
            }
        }
    }

    public void printActualFullAddresses() {
        addresses.stream()
                .filter(address -> "проезд".equals(address.getTypeName()) && address.isActualBoolean() && address.isActiveBoolean())
                .forEach(address -> {
                    List<String> fullAddress = buildFullAddress(address.getObjectId());
                    if (!fullAddress.isEmpty()) {
                        System.out.println(String.join(", ", fullAddress));
                    }
                });
    }

    private List<String> buildFullAddress(long objectId) {
        List<String> fullAddress = new ArrayList<>();
        Address address = findAddressById(objectId);
        if (address != null) {
            fullAddress.add(address.getTypeName() + " " + address.getName());
            Hierarchy hierarchy = findHierarchyByChildId(objectId);
            while (hierarchy != null && hierarchy.isActiveBoolean()) {
                address = findAddressById(hierarchy.getParentObjId());
                if (address != null && address.isActualBoolean() && address.isActiveBoolean()) {
                    fullAddress.add(0, address.getTypeName() + " " + address.getName());
                    hierarchy = findHierarchyByChildId(hierarchy.getParentObjId());
                } else {
                    break;
                }
            }
        }
        return fullAddress;
    }

    private Address findAddressById(long objectId) {
        return addresses.stream()
                .filter(address -> address.getObjectId() == objectId)
                .findFirst()
                .orElse(null);
    }

    private Hierarchy findHierarchyByChildId(long objectId) {
        return hierarchies.stream()
                .filter(hierarchy -> hierarchy.getObjectId() == objectId)
                .findFirst()
                .orElse(null);
    }
}
