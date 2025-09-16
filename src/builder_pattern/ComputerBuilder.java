package builder_pattern;

public abstract class ComputerBuilder {
    protected Computer computer;

    public void createNewComputer() {
        this.computer = new Computer();
    }

    public abstract void buildCpu();
    public abstract void buildRam();
    public abstract void buildStorage();
    public abstract void buildGpu();
    public abstract void buildCase();

    public Computer getComputer() {
        return this.computer;
    }
}
