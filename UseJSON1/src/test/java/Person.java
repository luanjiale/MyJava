import java.util.List;

//java bean
class Preson {
    private int age;
    private String name;
    private List<Integer> scores;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
}
