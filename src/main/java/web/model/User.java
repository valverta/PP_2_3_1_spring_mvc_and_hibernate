package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "��� �� ������ ���� ������")
    @Size(min=2, max = 20, message = "� ����� ������ ���� �� 2 �� 20 ��������")
    @Pattern(regexp = "[A-Za-z�-��-���]+", message = "��� ������ �������� ������ �� ���� ����������� ��� �������� ��������")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "������� �� ������ ���� ������")
    @Size(min=2, max = 30, message = "� ������� ������ ���� �� 2 �� 30 ��������")
    @Pattern(regexp = "[A-Za-z�-��-���]+", message = "������� ������ �������� ������ �� ���� ����������� ��� �������� ��������")
    private String surname;

    @Column(name = "age")
    @Min(value = 0, message = "������� �� ������ ���� ������ 0")
    @Max(value = 122, message = "������� �� ������ ���� ������ 122")
    private int age;

    public User() {}

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}