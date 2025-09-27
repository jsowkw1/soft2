package builder_pattern;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String caseType;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setCase(String caseType) {
        this.caseType = caseType;
    }

    @Override
    public String toString() {
        return "cpu: " + cpu + "\n" +
                "ram: " + ram + "\n" +
                "storage: " + storage + "\n" +
                "gpu: " + gpu + "\n" +
                "caseType: " + caseType;
    }
}
