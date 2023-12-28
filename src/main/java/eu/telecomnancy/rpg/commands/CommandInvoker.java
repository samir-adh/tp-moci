package eu.telecomnancy.rpg.commands;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CommandInvoker {
    Queue<Command> commandsQueue;
    Stack<Command> commandHistory;

    public CommandInvoker() {
        this.commandsQueue = new LinkedList<>();
    }

    public void setCommand(Command command){
        this.commandsQueue.add(command);
    }

    public void execute(){
        if (!commandsQueue.isEmpty()) {
            commandsQueue.poll().execute();
        }
    }

    public void undo(){
        if (!commandHistory.isEmpty()){
            commandHistory.pop().undo();
        }
    }

}
