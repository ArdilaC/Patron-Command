package invoker;

import command.Command;
import java.util.Stack;

public class BankSystem {

    private Stack<Command> history;

    public BankSystem() {
        history = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (history.isEmpty()) {
            System.out.println("nothing to change");
            return;
        }

        Command command = history.pop();
        command.undo();

        System.out.println("bring last command");
    }

}
