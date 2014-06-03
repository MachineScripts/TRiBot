package scripts.enums.cooker;


public class Foods {
    //this class will be developed to contain the ingredients needed for foods requiring more than one part.
    public static enum FoodInfo {
        TEST_FOOD("test1", "test2", "test3", 1, 2, 3),
        TEST_FOOD2("test1", "test2", 1, 2),
        ;

        private String part1, part2, part3;
        private int amount1, amount2, amount3;

        FoodInfo(String part1, String part2, String part3, int amount1, int amount2, int amount3) {
            this.part1 = part1;
            this.part2 = part2;
            this.part3 = part3;
            this.amount1 = amount1;
            this.amount2 = amount2;
            this.amount3 = amount3;
        }

        FoodInfo(String part1, String part2, int amount1, int amount2) {
            this.part1 = part1;
            this.part2 = part2;
            this.amount1 = amount1;
            this.amount2 = amount2;
        }

    }
}
