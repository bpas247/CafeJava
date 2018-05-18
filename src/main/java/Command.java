public abstract class Command {
   private String name;
   
   public Command(String n) {
      name = n;
   }

   public String getName() {
      return name;
   }

   public abstract CommandStatus validate(String toValidate);
   
   public abstract CommandStatus parse(String toParse);
   
   public abstract CommandStatus run(String toParse, Storage storage);
}