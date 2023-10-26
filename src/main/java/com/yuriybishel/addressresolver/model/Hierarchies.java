package com.yuriybishel.addressresolver.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ITEMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hierarchies {
    @XmlElement(name = "ITEM")
    private List<Hierarchy> hierarchyList = new ArrayList<>();

    public List<Hierarchy> getHierarchyList() {
        return hierarchyList;
    }

    public void setHierarchyList(List<Hierarchy> hierarchyList) {
        this.hierarchyList = hierarchyList;


    }
}
