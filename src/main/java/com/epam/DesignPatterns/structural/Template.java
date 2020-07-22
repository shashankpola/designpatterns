package com.epam.DesignPatterns.structural;


abstract class Game{
    abstract void initial();
    abstract void start();
    abstract void end();

    public final void play(){
        initial();
        start();
        end();
    }
}

class Cricket extends Game{
    @Override
    void initial(){
        System.out.println("Cricket Initialized");
    }
    @Override
    void start(){
        System.out.println("Started");
    }
    @Override
    void end(){
        System.out.println("Finished");
    }

}


class BasketBall extends Game{
    @Override
    void initial(){
        System.out.println("BasketBall Initialized");
    }
    @Override
    void start(){
        System.out.println("Started");
    }
    @Override
    void end(){
        System.out.println("Finished");
    }

}


public class Template{
    @SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String[] args) throws InstantiationException,IllegalAccessException,ClassNotFoundException {
        Class c = Class.forName("com.epam.DesignPatterns.structural.BasketBall");
        Game game = (Game)c.newInstance();
        game.play();

    }
}