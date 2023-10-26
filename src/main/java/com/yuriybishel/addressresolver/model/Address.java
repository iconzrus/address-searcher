package com.yuriybishel.addressresolver.model;


import com.yuriybishel.addressresolver.util.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    private int id;
    private int objectId;
    private String objectGuid;
    private int changeId;
    private String name;
    private String typeName;
    private int level;
    private int opertypeId;
    private int prevId;
    private int nextId;
    private String updateDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private int isActual;
    private int isActive;

    public boolean isActualBoolean() {
        return this.isActual != 0;
    }

    public boolean isActiveBoolean() {
        return this.isActive != 0;
    }

    public int getId() {
        return id;
    }

    public int getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getTypeName() {
        return typeName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @XmlAttribute(name = "ID")
    public void setID(int id) {
        this.id = id;
    }

    @XmlAttribute(name = "OBJECTID")
    public void setOBJECTID(int objectId) {
        this.objectId = objectId;
    }

    @XmlAttribute(name = "OBJECTGUID")
    public void setOBJECTGUID(String objectGuid) {
        this.objectGuid = objectGuid;
    }

    @XmlAttribute(name = "CHANGEID")
    public void setCHANGEID(int changeId) {
        this.changeId = changeId;
    }

    @XmlAttribute(name = "NAME")
    public void setNAME(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "TYPENAME")
    public void setTYPENAME(String typeName) {
        this.typeName = typeName;
    }

    @XmlAttribute(name = "LEVEL")
    public void setLEVEL(int level) {
        this.level = level;
    }

    @XmlAttribute(name = "OPERTYPEID")
    public void setOPERTYPEID(int opertypeId) {
        this.opertypeId = opertypeId;
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

    @XmlAttribute(name = "ISACTUAL")
    public void setISACTUAL(int isActual) {
        this.isActual = isActual;
    }

    @XmlAttribute(name = "ISACTIVE")
    public void setISACTIVE(int isActive) {
        this.isActive = isActive;
    }
}