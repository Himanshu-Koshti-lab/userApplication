package com.userApplication.entity.enums;

public enum State {

    ANDHRA_PRADESH(1, "Andhra Pradesh"),
    ARUNACHAL_PRADESH(2, "Arunachal Pradesh"),
    ASSAM(3, "Assam"),
    BIHAR(4, "Bihar"),
    CHHATTISGARH(5, "Chhattisgarh"),
    GOA(6, "Goa"),
    GUJARAT(7, "Gujarat"),
    HARYANA(8, "Haryana"),
    HIMACHAL_PRADESH(9, "Himachal Pradesh"),
    JHARKHAND(10, "Jharkhand"),
    KARNATAKA(11, "Karnataka"),
    KERALA(12, "Kerala"),
    MADHYA_PRADESH(13, "Madhya Pradesh"),
    MAHARASHTRA(14, "Maharashtra"),
    MANIPUR(15, "Manipur"),
    MEGHALAYA(16, "Meghalaya"),
    MIZORAM(17, "Mizoram"),
    NAGALAND(18, "Nagaland"),
    ODISHA(19, "Odisha"),
    PUNJAB(20, "Punjab"),
    RAJASTHAN(21, "Rajasthan"),
    SIKKIM(22, "Sikkim"),
    TAMIL_NADU(23, "Tamil Nadu"),
    TELANGANA(24, "Telangana"),
    TRIPURA(25, "Tripura"),
    UTTAR_PRADESH(26, "Uttar Pradesh"),
    UTTARAKHAND(27, "Uttarakhand"),
    WEST_BENGAL(28, "West Bengal"),
    ANDAMAN_AND_NICOBAR_ISLANDS(29, "Andaman and Nicobar Islands"),
    CHANDIGARH(30, "Chandigarh"),
    DADRA_AND_NAGAR_HAVELI_AND_DAMAN_AND_DIU(31, "Dadra and Nagar Haveli and Daman and Diu"),
    LAKSHADWEEP(32, "Lakshadweep"),
    DELHI(33, "Delhi"),
    PUDUCHERRY(34, "Puducherry"),
    LADAKH(35, "Ladakh"),
    JAMMU_AND_KASHMIR(36, "Jammu and Kashmir");

    private final int value;
    private final String stateName;

    State(int value, String stateName) {
        this.value = value;
        this.stateName = stateName;
    }

    public int getValue() {
        return value;
    }

    public String getStateName() {
        return stateName;
    }

    public static State getByStateName(String stateName) {
        for (State state : State.values()) {
            if (state.getStateName().equalsIgnoreCase(stateName)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Invalid state name: " + stateName);
    }

    public static State getByValue(int value) {
        for (State state : State.values()) {
            if (state.getValue() == value) {
                return state;
            }
        }
        throw new IllegalArgumentException("Invalid state value: " + value);
    }
}
