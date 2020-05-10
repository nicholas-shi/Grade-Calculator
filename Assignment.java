public class Assignment {
    protected String name;
    protected double grade;
    protected Category category;

    public Assignment(String name, String grade, String category) throws InvalidInputException {
        this.name = name;
        this.grade = calculateGrade(grade);
        this.category = new Category(category, 10);     // TODO: Change this to work properly later
    }

    protected double calculateGrade(String grade) throws InvalidInputException {
        try {
            String new_grade = "";
            for (int i = 0; i < grade.length(); i++) {
                char letter = grade.charAt(i);
                if (letter == '/' || letter >= '0' && letter <= '9') {
                    new_grade += letter;
                }
            }

            if (new_grade.contains("/")) {
                String[] dividends = new_grade.split("/");

                return Double.parseDouble(dividends[0]) / Double.parseDouble(dividends[1]);
            } else {
                return Double.parseDouble(new_grade);
            }
        } catch (Exception e) {
            throw new InvalidInputException("Error calculating grade");
        }
    }

    public String getName() {
        return this.name;
    }

    public double getGrade() {
        return this.grade;
    }

    public String getCategory() {
        return this.category.name;
    }
}