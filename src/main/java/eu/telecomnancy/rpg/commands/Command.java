package eu.telecomnancy.rpg.commands;

public interface Command {
    public void execute();
    public void undo();
}
