package builder_pattern;

public class PCAssembler {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void constructComputer() {
        computerBuilder.createNewComputer();
        computerBuilder.buildCpu();
        computerBuilder.buildRam();
        computerBuilder.buildStorage();
        computerBuilder.buildGpu();
        computerBuilder.buildCase();
    }
}