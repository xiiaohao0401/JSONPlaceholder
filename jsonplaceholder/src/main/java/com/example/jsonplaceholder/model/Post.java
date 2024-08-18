package com.example.jsonplaceholder.model;

public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String body;
    private int titleLength; 

    // Getters and setters
    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }

    public Long getUserId() { 
    	return userId; 
    }
    
    public void setUserId(Long userId) { 
    	this.userId = userId; 
    }

    public String getTitle() { 
    	return title; 
    }
    
    public void setTitle(String title) { 
    	this.title = title; 
    }

    public String getBody() { 
    	return body; 
    }
    
    public void setBody(String body) { 
    	this.body = body; 
    }

    public int getTitleLength() { 
    	return titleLength; 
    }
    
    public void setTitleLength(int titleLength) { 
    	this.titleLength = titleLength; 
    }
}
