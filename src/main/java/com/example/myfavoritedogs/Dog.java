package com.example.myfavoritedogs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String fileSizeBytes;
    private String url;

    public Dog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(String fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", fileSizeBytes='" + fileSizeBytes + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
