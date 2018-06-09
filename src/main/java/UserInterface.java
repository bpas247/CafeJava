import java.util.Scanner;

/**
 * This class handles all interactions with the user.
 *
 * @author Brady Pascoe
 * @version 5/17/18
 * @since 5/17/18
 */
public class UserInterface {
  private Storage storage = new Storage(); //The heart of the program
  private CommandParser parser = new CommandParser(); //Used to parse the user's input
  private Scanner scan = new Scanner(System.in);

  /**
   * Runs the program in its entirety
   */
  public void runProgram() {

    System.out.println("Welcome to CafeJava! Please enter your command.");
    System.out.println("Enter '0' to exit the program");

    String userInput = "0";

    do {
      System.out.println("What is your command?");
      userInput = scan.nextLine();

      if(userInput.equalsIgnoreCase("0")) {
        break; //Finish the loop
      } else if(parser.validate(userInput) != ParserStatus.OK) {
        System.out.println("The command is not valid");
      } else {
        Command parsedCommand = parser.parse(userInput);

        if (parsedCommand == null) {
          System.out.println("The command cannot be parsed");
        } else {
          ParserStatus runReturn = parser.runCommand(userInput, storage);

          if(runReturn != ParserStatus.OK) {
            System.out.println("The command was not successfully ran");
          } else {
            System.out.println("The command was successful");
          }
        }
      }

    } while(!userInput.equalsIgnoreCase("0"));
  }
}
