package com.zoo;

class Animal {
    String name;

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Animal() {
    }

    Animal(String animalName) {
        name = animalName;
    }


    public static void main(String[] args) {
        Animal dog = new Animal("Junior");
        System.out.println(dog.getName());

        Animal cat = new Animal();
        cat.setName("Murzik");
        System.out.println(cat.getName());

        Animal it = new Animal();
        cat.name = "Cheburshka";
        System.out.println(it.name);
    }
}
