public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Парк: " + name);
    }

  
    public static class Attraction {
        private String name;
        private int cost;
        private String workTime;

        public Attraction(String name, int cost, String workTime) {
            this.name = name;
            this.cost = cost;
            this.workTime = workTime;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Стоимость: " + cost);
            System.out.println("Время работы: " + workTime);
        }
    }
}
