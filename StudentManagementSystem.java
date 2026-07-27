import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    // throws IOException is their incase bad file
    public static void main(String[] args) throws IOException {

        // Created the student list
        ArrayList<Students> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Reading the file where students will be stored
        BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"));
        // Creates a variable which i will use to cycle through every line in the file
        String line;

        // Reads every line in the file until line gives nothing/null
        while ((line = bufferedReader.readLine()) != null) {
            // splitting the lines
            String[] studentData = line.split(",");
            // Storing the data into variables and converting them to correct type
            int id = Integer.parseInt(studentData[0]);
            String name = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String course = studentData[3];
            String gender = studentData[4];
            students.add(new Students(id, name, age, course, gender));
        }

        bufferedReader.close();

        // Repeats dialogue until option 4 is selected
        while (true) {
            // Beginning Dialogue
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");

            // Inputs
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Student Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Student Course: ");
                    String course = scanner.nextLine();

                    System.out.println("Enter Student Gender: ");
                    String gender = scanner.nextLine();

                    // Creates a new student oject every run through
                    Students student = new Students(id, name, age, course, gender);
                    // Adds the students data or object to the array list created earlier
                    students.add(student);
                    // writes the student data to the text file
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt"));
                    for (Students s : students){
                        bufferedWriter.write(s.toString());
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    break;
                case 2:
                    // gets the id of the student that needs to be removed
                    System.out.println("Enter Student ID: ");
                    int idRemove = scanner.nextInt();
                    scanner.nextLine();

                    //cyc;es through all the student one at a time
                    for (int i =0; i < students.size(); i++){
                        // checks if the the students id is identical or matches the removal id given
                        if (students.get(i).id == idRemove){
                            //removes that students data if it matches
                            students.remove(i);
                        }
                    }

                    // updates the text file after removal
                    BufferedWriter bufferedWriterUpdate = new BufferedWriter(new FileWriter("students.txt"));
                    for (Students s : students){
                        bufferedWriterUpdate.write(s.toString());
                        bufferedWriterUpdate.newLine();
                    }
                    bufferedWriterUpdate.close();
                    break;
                case 3:
                    // just a variable to give students a number for their title
                    int studentnum =  1;

                    // cycles through every student printing their data
                    for (Students s : students){
                        System.out.println("Student " + studentnum + ":");
                        System.out.println("ID: " + s.id);
                        System.out.println("Name: " + s.name);
                        System.out.println("Age: " + s.age);
                        System.out.println("Course: " + s.course);
                        System.out.println("Gender: " + s.gender);
                        // this is just so num in here "student (num):" increases each student
                        studentnum++;
                    }
                    break;
                case 4:
                    //ends loop and closes the code
                    return;
            }
        }
    }
}
