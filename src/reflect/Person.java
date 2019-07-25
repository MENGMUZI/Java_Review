package reflect;

/**
 * @author : mengmuzi
 * create at:  2019-07-23  17:36
 * @description:
 */
public class Person {

    private String name;
    public int age;
    private String gender;

    public Person() {
        System.out.println("person constructor...");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void work(){

        System.out.println("work....");
    }

    private void play(){
        System.out.println("play....");
    }

    public void work(String location){
        System.out.println("work in China...");

    }

    private void play(String game){

        System.out.println("playing LOL.....");
    }
}
