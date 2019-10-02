package com.tfg.backend.Dtos;

public class SearchLostAnimalsDTO {
    
    private String userToken;
    private int page;
    
    public SearchLostAnimalsDTO() {
	super();
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
