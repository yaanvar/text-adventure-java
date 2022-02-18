package com.company;

public class Thing {
    String name;
    int use;
    Thing(String s){
        if(s == "Аптечка") {
            this.name = "Аптечка";
            this.use = 25;
        }
        if(s == "Аугментатор"){
            this.name = "Аугментатор";
            this.use = 5;
        }
    }
}