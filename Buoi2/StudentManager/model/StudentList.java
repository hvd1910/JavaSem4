package model;

import entity.Student;

import java.util.*;

public class StudentList {
    private ArrayList<Student>list;
    private int length;

    public StudentList() {
        list = new ArrayList<Student>();
    }

    public ArrayList<Student> findByName(String name) {
        boolean found = false;
        ArrayList<Student> matches = new ArrayList<>();
        for (Student s:list) {
            String fullName = new String(s.getFirstName() + " " + s.getLastName()).toLowerCase();
            if(fullName.matches("(.*)" +name.toLowerCase() + "(.*)")) {
                matches.add(s);
                found = true;
            }
        }
        if(found == false) {
            System.out.println("Not found");
        }
        return matches;
    }


    public Student findById(int id) {
        for (Student s:list) {
            if(s.getId() == id) {
                return  s;
            }
        }
        return null;
    }


    public void add(Student s) {
        list.add(s);
    }

    public void  remove(int id) {
        List<Student> studentsToRemove = new ArrayList<>();
        list.stream()
                .filter(p ->p !=null && p.getId() == id)
                .forEach(p -> {
                    int choice;
                    System.out.println("Are you sure deleting this student? (1. Yes 2. No)");
                    choice = new Scanner(System.in).nextInt();
                    if (choice == 1) {
                        studentsToRemove.add(p);
                        System.out.println("Xóa student có ID " + id + " thành công.");
                        System.out.println("-------------------------------------------");
                        System.out.println("-------------------------------------------");
                    }
                });
        list.removeAll(studentsToRemove);
    }


    public void sortByMarks() {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMark(), s1.getMark());            }
        });
    }


    public void showList() {
        for (Student s:list) {
            s.printInfo();
        }
    }

    public void showList(ArrayList<Student> slist) {
        for (Student s : slist){
            s.printInfo();
        }
    }

}
