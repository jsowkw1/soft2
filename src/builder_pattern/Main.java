package builder_pattern;

public class Main {
    public static void main(String[] args) {

        PCAssembler assembler = new PCAssembler();

        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();

        assembler.setComputerBuilder(gamingBuilder);

        assembler.constructComputer();

               Computer gamingComputer = assembler.getComputer();

        System.out.println("\n" + "the computer is assembled:\n" + gamingComputer);
    }
}
