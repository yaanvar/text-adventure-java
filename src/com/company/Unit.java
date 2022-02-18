package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Unit {
    Unit(){
        this.name = "Unit";
        this.health = 100;
        this.alive = true;
    }
    String name;
    boolean alive = true;
    int health;
    int damage = 10;

    ArrayList<Thing> inventory = new ArrayList<>();

    void get_in(Thing thing){
        inventory.add(thing);
    }

    public Unit(String name, int health){
        this.name = name;
        this.health = health;
    }
    void attack_gun(Unit unit){
        System.out.println("Атака пистолетом (рандомизированный урон)");
        unit.health -= Math.random() * damage + 1;
    }

    void attack_knife(Unit unit){
        System.out.println("Атака ножом (гарантированный урон)");
        unit.health -= damage;
    }

    void get_thing(Unit a, String s){
        System.out.println("Вы получили предмет " + s);
        Thing f = new Thing(s);
        a.inventory.add(f);
    }

    void use(Unit unit){
        Scanner in = new Scanner(System.in);
        if(inventory.size() == 0) {
            System.out.println("Ваш инвентарь пуст");
        } else {
            System.out.println("Ваш инветарь:");
            System.out.println("Что желаете?");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(i + 1 + ". " + inventory.get(i).name);
            }
            int ex = inventory.size() + 1;
            System.out.println(ex + ". Ничего не брать");
            int z = in.nextInt();
            while(z > ex||z < 1){
                z = in.nextInt();
            }
            if (z == ex) {
                System.out.println("Вы слишком долго копались в сумке и не можете атаковать в этом ходу");
            } else {
                System.out.println(inventory.get(z - 1).name);
                if(inventory.get(z - 1).name == "Аптечка"){
                    unit.health += inventory.get(z - 1).use;
                    inventory.remove(z-1);
                } else {
                    unit.damage += inventory.get(z - 1).use;
                    inventory.remove(z-1);
                }
                System.out.println("Вы слишком долго копались в сумке и не можете атаковать в этом ходу");
            }
        }
    }
}

class Player extends Unit {
    public Player(String name, int health) {
        super(name = "Sasha", health);
    }
}

class Enemy extends Unit {
    public Enemy(String name, int health) {
        super(name = "Raider", health= 100);
    }
}
