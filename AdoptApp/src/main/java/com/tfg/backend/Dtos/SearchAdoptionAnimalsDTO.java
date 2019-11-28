package com.tfg.backend.Dtos;

public class SearchAdoptionAnimalsDTO {

    private int page;
    private AnimalFilter filter;
    private String userToken;
    
    public SearchAdoptionAnimalsDTO() {
	super();
    }
    
    

    public AnimalFilter getFilter() {
        return filter;
    }



    public void setFilter(AnimalFilter filter) {
        this.filter = filter;
    }



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
    
    
}
