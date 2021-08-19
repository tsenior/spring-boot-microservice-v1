package com.tinyiko.exploresoweto.domain;

public enum Region {
    Central_Soweto("Central_Soweto"), Southern_Soweto("Nouthern Soweto"), Nouthern_Soweto("Nouthern Soweto"), Varies("Varies");

    private String lable;
    private Region(String label){
        this.lable = label;
    }

    public static Region findByLabel(String byLabel){
        for (Region region: Region.values()){
            if (region.lable.equalsIgnoreCase(byLabel))
                return region;
            }
            return null;
        }
}
