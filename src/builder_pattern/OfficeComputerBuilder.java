package builder_pattern;

public class OfficeComputerBuilder extends ComputerBuilder {

    @Override
    public void buildCpu() {
        computer.setCpu("Intel Core i5-12400");
    }

    @Override
    public void buildRam() {
        computer.setRam("16GB DDR4 3200MHz");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    @Override
    public void buildGpu() {
        computer.setGpu("Integrated Graphics");
    }

    @Override
    public void buildCase() {
        computer.setCase("Mid-Tower Office Case");
    }
}
