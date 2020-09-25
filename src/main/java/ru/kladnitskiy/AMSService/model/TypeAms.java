package ru.kladnitskiy.AMSService.model;

/**
 * Тип антенно-мачтового сооружения.
 */
public enum TypeAms {
    MAST("mast"),
    TOWER("tower"),
    MONOPOLE("monopole"),
    TRIPOD("tripod"),
    PILLAR("pillar");

    private String fieldName;

    TypeAms(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
