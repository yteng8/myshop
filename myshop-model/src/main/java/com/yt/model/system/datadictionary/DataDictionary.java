package com.yt.model.system.datadictionary;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DataDictionary
 * @Description 数据字典实体
 * @createTime 2020年02月12日 12:03:00
 */
public class DataDictionary {
    private int id;
    private String typeCode;
    private String typeName;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
