    package builder_pattern;

    public class GamingComputerBuilder extends ComputerBuilder {

        @Override
        public void buildCpu() {
            computer.setCpu("Intel Core i9-14900K");
        }

        @Override
        public void buildRam() {
            computer.setRam("32GB DDR5 6000MHz");
        }

        @Override
        public void buildStorage() {
            computer.setStorage("2TB NVMe SSD");
        }

        @Override
        public void buildGpu() {
            computer.setGpu("NVIDIA GeForce RTX 4090");
        }

        @Override
        public void buildCase() {
            computer.setCase("Full Tower Gaming Case with RGB");
        }
    }
