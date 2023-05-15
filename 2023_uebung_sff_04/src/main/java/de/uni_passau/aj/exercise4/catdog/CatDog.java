package de.uni_passau.aj.exercise4.catdog;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/* // remove this comment!

interface Animal {
   Logger log = LoggerFactory.getLogger(Animal.class);

    static void run() {
        log.info("(heavy breathing)");
    }

    void makeNoise();

    default String whatAmI() {
        makeNoise();
        return getClass().getSimpleName();
    }
}

interface Cat extends Animal {
    Logger log = LoggerFactory.getLogger(Cat.class);

    default void makeNoise() {
        log.info("Meow!");
    }
}

interface Dog extends Animal {
    Logger log = LoggerFactory.getLogger(Dog.class);
}

interface Baumaschine {
    Logger log = LoggerFactory.getLogger(Baumaschine.class);

    default void makeNoise() {
        log.info("Brrrrrr!");
    }
}

class Corgi implements Dog {
    void run() {
        run(); // this should not be an endless loop, expecting output "(heavy breathing)" here!
    }
}

@Slf4j
abstract class TreppenSteiger implements Baumaschine {
    void run() {
        log.info("(not so heavy breathing)");
    }
}

class Shepard extends TreppenSteiger implements Dog {
    @Override
    public void makeNoise() {
        super.makeNoise();
    }
}

@Slf4j
public class CatDog implements Cat, Dog {
    public static void main(String[] args) {

        Animal animal = new ? (); // this should be an implementation
        animal.makeNoise();
        new Shepard().makeNoise();
        new Corgi().run();
        log.info(animal.whatAmI());

    }
}
*/  // remove this comment!
// ... and get it running...
