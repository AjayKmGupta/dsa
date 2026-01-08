package com.interview;

public class DecoratorPattern {
    // The below example is for decorator pattern
}

interface Animal {
    void eat();
}

class Lion implements Animal{

    public void eat(){
        // cant change this
    }
}

class EatCounter implements Animal {

    private int methodCounter;
    Animal animal;

    public EatCounter(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void eat(){
        animal.eat();
        methodCounter++;
    }
}

class Test{
    public static void main(String[] args){
        Animal lion = new Lion();
        EatCounter eatCounter = new EatCounter(lion);
        Test.feedAnimal(eatCounter);
    }

    // cant change this
    public static void feedAnimal(Animal a){
        //..
        a.eat();
        // ...
        a.eat();
        // ...
        a.eat();
        // ...
    }

}

class Transactional {

    /*@Transactional
    public String addUser(UserDto user) {
        validate(user);
        try {
            //....
            //....
            userDao.save(userModel);
            //...
            sendWelcomeEmail(userModel); // threw an exception
        } catch (Exception e) {
            log.error(e);
            return "failed";
        }
        return "success";
    }*/

}
