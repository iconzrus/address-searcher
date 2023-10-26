package com.yuriybishel.addressresolver.model;

import com.yuriybishel.addressresolver.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Hierarchy {
    private int id;
    private int objectId;
    private int parentObjId;
    private int changeId;
    private int prevId;
    private int nextId;
    private String updateDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private int isActive;

    public boolean isActiveBoolean() {
        return this.isActive != 0;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public int getObjectId() {
        return objectId;
    }

    public int getParentObjId() {
        return parentObjId;
    }

    @XmlAttribute(name = "ID")
    public void setID(int id) {
        this.id = id;
    }

    @XmlAttribute(name = "OBJECTID")
    public void setOBJECTID(int objectId) {
        this.objectId = objectId;
    }

    @XmlAttribute(name = "PARENTOBJID")
    public void setPARENTOBJID(int parentObjId) {
        this.parentObjId = parentObjId;
    }

    @XmlAttribute(name = "CHANGEID")
    public void setCHANGEID(int changeId) {
        this.changeId = changeId;
    }

    @XmlAttribute(name = "PREVID")
    public void setPREVID(int prevId) {
        this.prevId = prevId;
    }

    @XmlAttribute(name = "NEXTID")
    public void setNEXTID(int nextId) {
        this.nextId = nextId;
    }

    @XmlAttribute(name = "UPDATEDATE")
    public void setUPDATEDATE(String updateDate) {
        this.updateDate = updateDate;
    }

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @XmlAttribute(name = "STARTDATE")
    public void setSTARTDATE(LocalDate startDate) {
        this.startDate = startDate;
    }

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @XmlAttribute(name = "ENDDATE")
    public void setENDDATE(LocalDate endDate) {
        this.endDate = endDate;
    }

    @XmlAttribute(name = "ISACTIVE")
    public void setISACTIVE(int isActive) {
        this.isActive = isActive;
    }


}