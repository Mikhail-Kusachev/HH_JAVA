package org.example;

class ShapeCalculator {
    public static void main(String[] args) {
       System.out.println(Calc("кРуг 3"));
       System.out.println(Calc("квадрат"));
       System.out.println(Calc("квадрат кк dd"));
       System.out.println(Calc("круг 100.111"));
    }

    public static String Calc(String input) {
        String[] args = input.split(" ");
        if (args.length < 1 || args.length > 2) { return "некорректный ввод"; }

        Double side = 1.00;
        Double perimiter = 0.00;
        Double square = 0.00;

        if (args.length == 2){
            try {
                side = Double.parseDouble(args[1]);
            } catch (NumberFormatException e) { }
        }

        switch (args[0].toLowerCase()) {
            case "круг":
                square = Math.PI * side * side;
                perimiter = 2 * Math.PI * side;
                break;
            case "квадрат":
                square = side * side;
                perimiter = 4 * side;
                break;
            default:
                return "некорректный ввод";
        }
        return String.format("%.2f %.2f", square, perimiter);
    }
}