package concurrent;

public enum CountryEnum {

    ONE(1,"韩"),
    TWO(2,"赵"),
    THREE(3,"魏"),
    FOUR(4,"楚"),
    FIVE(5,"燕"),
    SIX(6,"齐");
    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode,String retMessage){
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] countryArray = CountryEnum.values();
        for(CountryEnum element : countryArray){
            if(index == element.getRetCode()){
                return element;
            }
        }
        return null;
    }
}
