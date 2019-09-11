package com.example.businessdemo.response;

public enum ResultCode implements IResultCode {
    SUCCESS("200","成功"),
    ;
    ResultCode(String code,String description){
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;

//    @Override
    public String code() {
        return this.code;
    }

//    @Override
    public String description() {
        return this.description;
    }

    public static ResultCode formValue(String code){
        ResultCode[] arr$ = values();
        int len$ = arr$.length;

        for(int i$ = 0; i$<len$; ++i$){
            ResultCode c = arr$[i$];
            if(c.code.equals(code)){
                return c;
            }
        }
        throw new RuntimeException("unnkow result"+ code);
    }
}
